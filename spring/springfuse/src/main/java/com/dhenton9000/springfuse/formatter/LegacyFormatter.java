/*
 * (c) Copyright 2005-2011 JAXIO, www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to use Celerio within your company? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Template pack-mvc-3:src/main/java/formatter/Formatter.e.vm.java
 */
package com.dhenton9000.springfuse.formatter;

import java.text.ParseException;
import java.util.Locale;

import com.dhenton9000.springfuse.domain.Legacy;
import com.dhenton9000.springfuse.service.LegacyService;
import com.dhenton9000.springfuse.formatter.support.DiscoverableFormatter;
import com.dhenton9000.springfuse.domain.LegacyPk;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * {@link Formatter} for {@link Legacy} that is picked by automatically by {@link CustomFormattingConversionServiceFactory}
 * 
 * @see Formatter
 * @see CustomFormattingConversionServiceFactory
 */
@Component
public class LegacyFormatter implements DiscoverableFormatter<Legacy> {

    @Autowired
    private LegacyService legacyService;

    @Override
    public Class<Legacy> getTarget() {
        return Legacy.class;
    }

    @Override
    public String print(Legacy legacy, Locale locale) {
        if (legacy == null) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        // make a nice display string here...

        if (legacy.getExtraInfo() != null) {
            sb.append(legacy.getExtraInfo()).append(" ");
        }

        if (sb.length() > 0) {
            return sb.toString();
        } else if (legacy.isPrimaryKeySet()) {
            return legacy.getPrimaryKey().toString();
        } else {
            return legacy.toString();
        }
    }

    @Override
    public Legacy parse(String text, Locale locale) throws ParseException {
        if (text == null || text.isEmpty()) {
            return new Legacy();
        }
        Legacy legacy = legacyService.getByPrimaryKey(LegacyPk.fromString(text));
        return legacy != null ? legacy : new Legacy();
    }
}
