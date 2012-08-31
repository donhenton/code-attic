/*
 * (c) Copyright 2005-2011 JAXIO, www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to use Celerio within your company? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Template pack-backend:src/main/java/project/hibernate/support/HibernateUtil.p.vm.java
 */
package com.dhenton9000.jpa.dao.hibernate;

import static java.lang.reflect.Modifier.isPublic;
import static org.apache.commons.lang.WordUtils.uncapitalize;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EmbeddedId;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.apache.commons.lang.Validate;
import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Junction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.type.Type;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.dhenton9000.jpa.dao.support.DateRange;
import com.dhenton9000.jpa.dao.support.OrderBy;
import com.dhenton9000.jpa.dao.support.SearchMode;
import com.dhenton9000.jpa.dao.support.SearchTemplate;
 

/**
 * Provide utility methods to create {@link MatchMode}, {@link Example} or {@link Criteria}.
 */
public abstract class HibernateUtil {
    public static final Example.PropertySelector NOT_NULL_OR_EMPTY = new HibernateUtil.NotNullOrEmptyPropertySelector();
    private static final String IS_METHOD_PREFIX = "is";
    private static final String GET_METHOD_PREFIX = "get";
    private static Logger logger = LoggerFactory.getLogger(HibernateUtil.class);
    
    
    static final class NotNullOrEmptyPropertySelector implements Example.PropertySelector {
        private static final long serialVersionUID = 1L;

        public boolean include(Object object, String propertyName, Type type) {
            if (object != null) {
                if ((object instanceof String) && "".equals((String) object)) {
                    return false;
                }
                return true;
            }
            return false;
        }
    }

    /**
     * Convert a local SearchMode to an Hibernate MatchMode.
     * 
     * @return the corresponding hibernate match mode
 */    
    public static MatchMode convertSearchModeToMatchMode(SearchMode searchMode) {
        switch (searchMode) {
        case ANYWHERE:
            return MatchMode.ANYWHERE;
        case STARTING_LIKE:
            return MatchMode.START;
        case ENDING_LIKE:
            return MatchMode.END;
        case LIKE: // fall through
        case EQUALS: // fall through
        default:
            return MatchMode.EXACT;
        }
    }

    /**
     * Create an example from the passed object and configure it using the passed searchTemplate.
     * 
     * @return the configured example.
 */    
    public static Example constructExample(Object object, SearchTemplate searchTemplate) {
        Validate.notNull(object, "The passed sample cannot be null");

        Example example = Example.create(object);
        // do not use example.excludeZeroes()
        // we prefer to use our own property selector to exclude empty string since oracle treat them as null!
        // also since our number properties are object and not primary types, it is better to keep them,
        // as 0 value are intentional
        example.setPropertySelector(NOT_NULL_OR_EMPTY);

        if (searchTemplate != null) {
            MatchMode matchMode = convertSearchModeToMatchMode(searchTemplate.getSearchMode());

            if (searchTemplate.isCaseInsensitive()) {
                // lower case comparison is done only when 'like' is activated. Is it an hibernate bug ?
                example.enableLike(matchMode);
                example.ignoreCase();
            } else if (searchTemplate.getSearchMode() != SearchMode.EQUALS) {
                example.enableLike(matchMode);
            }
        }

        return example;
    }

    public static boolean isEntityIdManuallyAssigned(Class<?> type) {
        logger.debug("isEntityIdManuallyAssigned");
        for (Method method : type.getMethods()) {
            if (isPrimaryKey(method)) {
                 logger.debug("primary key is "+method.getName()+" going to manually assigned check");
                return isManuallyAssigned(method);
            }
        }
        return false; // no pk found, should not happen
    }

    private static boolean isPrimaryKey(Method method) {
        return isPublic(method.getModifiers())
                && (method.getAnnotation(Id.class) != null || method.getAnnotation(EmbeddedId.class) != null);
    }

    private static boolean isManuallyAssigned(Method method) {
        if (method.getAnnotation(Id.class) != null) {
            boolean notExists = method.getAnnotation(GeneratedValue.class) == null;
            logger.debug("in isManuallyAssigned checking id generated annotation is null returns "+notExists);
            return notExists;
        } else if (method.getAnnotation(EmbeddedId.class) != null) {
            return true;
        } else {
            return true;
        }
    }
 
    public static Criterion constructPattern(Class<?> type, SearchTemplate searchTemplate) {
        if (!searchTemplate.hasSearchPattern()) {
            return null;
        }
        List<String> columns = getAttributesForPatternSearch(type, "");
        for (Method method : type.getMethods()) {
            if (method.getAnnotation(EmbeddedId.class) != null) {
                columns.addAll(getAttributesForPatternSearch(method.getReturnType(), fieldFromMethod(method) + "."));
            }
        }
        return constructPattern(columns, searchTemplate);
    }
 
    private static List<String> getAttributesForPatternSearch(Class<?> type, String prefix) {
        List<String> columns = new ArrayList<String>();
        for (Method method : type.getMethods()) {
            if (isPublic(method.getModifiers()) //
                    && method.getParameterTypes().length == 0 //
                    && method.getReturnType() == String.class //
                    && (method.getName().startsWith(GET_METHOD_PREFIX) || method.getName().startsWith(IS_METHOD_PREFIX))
                    && method.getAnnotation(Transient.class) == null //
                    && isManuallyAssigned(method)) {
                columns.add(prefix + fieldFromMethod(method));
            }
        }
        return columns;
    }

    private static String fieldFromMethod(Method method) {
        String methodName = method.getName();
        if (methodName.startsWith(IS_METHOD_PREFIX)) {
            return uncapitalize(methodName.substring(IS_METHOD_PREFIX.length()));
        } else {
            return uncapitalize(methodName.substring(GET_METHOD_PREFIX.length()));
        }
    }

    /**
     * Construct a OR criterion.
     * 
     * @param stringColumns
     * @param searchTemplate
     * @return the criterion
     */
    private static Criterion constructPattern(List<String> stringColumns, SearchTemplate searchTemplate) {
        if (stringColumns.size() == 0 || searchTemplate == null || !searchTemplate.hasSearchPattern()) {
            return null;
        }

        MatchMode matchMode = convertSearchModeToMatchMode(searchTemplate.getSearchMode());
        Disjunction disjunction = Restrictions.disjunction();

        for (String stringColumn : stringColumns) {
            Criterion criterion = constructPatternCriterion(stringColumn, searchTemplate.getSearchPattern(), matchMode,
                    searchTemplate.isCaseSensitive());
            disjunction.add(criterion);
        }

        return disjunction;
    }

    
    public static Criterion constructDate(SearchTemplate searchTemplate) {
        if (searchTemplate == null || !searchTemplate.hasDatePattern()) {
            return null;
        }
        Junction junction = Restrictions.conjunction();

        for (DateRange dateRange : searchTemplate.getDateRanges()) {
            if (dateRange != null && dateRange.isSet()) {
                Criterion criterion = constructDateCriterion(dateRange);
                if (criterion != null) {
                    junction.add(criterion);
                }
            }
        }

        return junction;
    }

    public static Criterion constructDateCriterion(DateRange dateRange) {
        Criterion rangeCriterion = null;

        if (dateRange.isBetween()) {
            rangeCriterion = Restrictions.between(dateRange.getField(), dateRange.getFrom(), dateRange.getTo());
        } else if (dateRange.isFromSet()) {
            rangeCriterion = Restrictions.ge(dateRange.getField(), dateRange.getFrom());
        } else if (dateRange.isToSet()) {
            rangeCriterion = Restrictions.le(dateRange.getField(), dateRange.getTo());
        }

        if (rangeCriterion != null) {
            if (!dateRange.isIncludeNullSet() || dateRange.getIncludeNull() == Boolean.FALSE) {
                return rangeCriterion;
            } else {
                return Restrictions.or(rangeCriterion, Restrictions.isNull(dateRange.getField()));
            }
        }

        // no range at all
        // take the opportunity to keep only null date...
        if (dateRange.getIncludeNull() == Boolean.TRUE) {
            return Restrictions.isNull(dateRange.getField());
        }

        // ... or non-null only...
        if (dateRange.getIncludeNull() == Boolean.FALSE) {
            return Restrictions.isNotNull(dateRange.getField());
        }

        // or both, null and non null, by just ignoring.
        return null;
    }

    public static Criterion constructPatternCriterion(String columnName, String columnValue,
            SearchTemplate searchTemplate) {
        return constructPatternCriterion(columnName, columnValue, convertSearchModeToMatchMode(searchTemplate
                .getSearchMode()), searchTemplate.isCaseSensitive());
    }

    public static Criterion constructPatternCriterion(String columnName, String columnValue, MatchMode matchMode,
            boolean isCaseSensitive) {
        // apply same policy as with search by example
        if (!isCaseSensitive) {
            return Restrictions.ilike(columnName, columnValue, matchMode);
        } else if (matchMode != MatchMode.EXACT) {
            return Restrictions.like(columnName, columnValue, matchMode);
        } else {
            return Restrictions.eq(columnName, columnValue);
        }
    }

    /**
     * Helper method to apply on the passed Criteria the pagination and order by parameters found in the passed SearchTemplate.
     * 
     * @return the same hibernate criteria with first, max results and order by properties set.
     */
    public static Criteria applyPaginationAndOrderOnCriteria(Criteria criteria, SearchTemplate searchTemplate) {
        if (searchTemplate == null) {
            return criteria;
        }

        // set pagination if needed
        criteria.setFirstResult(searchTemplate.getFirstResult());
        criteria.setMaxResults(searchTemplate.getMaxResults());

        // set order criteria if available
        for (OrderBy orderBy : searchTemplate.getOrderBys()) {
            if (orderBy.isOrderDesc()) {
                criteria.addOrder(Order.desc(orderBy.getColumn()));
            } else {
                criteria.addOrder(Order.asc(orderBy.getColumn()));
            }
        }
        return criteria;
    }
    
}