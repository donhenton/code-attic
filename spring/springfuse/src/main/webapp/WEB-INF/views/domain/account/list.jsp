<%--
 | (c) Copyright 2005-2011 JAXIO, www.jaxio.com
 | Source code generated by Celerio, a Jaxio product
 | Want to use Celerio within your company? email us at info@jaxio.com
 | Follow us on twitter: @springfuse
 | Template pack-mvc-3:src/main/webapp/WEB-INF/views/domain/list.e.vm.jsp
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"
%><%@ taglib prefix="tags" tagdir="/WEB-INF/tags"
%><%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"
%><%@ taglib prefix="spring" uri="http://www.springframework.org/tags"
%><%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
%><head>
	<title><fmt:message key="account" />: <fmt:message key="crud.functionalities.list" /></title>
</head>
<body>
	<h2><fmt:message key="account" />: <fmt:message key="crud.functionalities.list" /></h2>
	<div id="result">
	<c:choose>
		<c:when test="${accountsCount == 0}">
			<fmt:message key="crud.search.empty.result" />
		</c:when>
		<c:otherwise>
			<table class="list">
				<thead>
					<tr>
						<th><tags:sort-header model="account" attribute="username" url="list"/></th>
						<th><tags:sort-header model="account" attribute="email" url="list"/></th>
						<th><tags:sort-header model="account" attribute="isEnabled" url="list"/></th>
						<th><tags:sort-header model="account" attribute="addressId" url="list"/></th>
						<th>&nbsp;</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${accounts}" var="account" varStatus="_st">
						<tr>
							<td><spring:eval expression="account.username"/></td>
							<td><spring:eval expression="account.email"/></td>
							<td><spring:eval expression="account.isEnabled"/></td>
							<td>
								<c:if test="${account.homeAddress != null}">
									<a href="${pageContext.request.contextPath}/domain/address/show/${account.homeAddress.primaryKey}"  class="button button-show miniature"><fmt:message key="crud.show.button" /></a>
									<spring:eval expression="account.homeAddress" />
								</c:if>
							</td>
							<td>
								<a href="${pageContext.request.contextPath}/domain/account/show/${account.primaryKey}" class="button button-show miniature"><fmt:message key="crud.show.button"/></a>
								<a href="${pageContext.request.contextPath}/domain/account/update/${account.primaryKey}" class="button button-edit miniature"><fmt:message key="crud.edit.button"/></a>
								<a href="${pageContext.request.contextPath}/domain/account/delete/${account.primaryKey}" class="button button-delete modal miniature"><fmt:message key="crud.delete.button"/></a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
				<tfoot>
					<tr>
						<th colspan="4">
							<tags:navigation totalSize="${accountsCount}" search="${accountSearchForm.sp}" url="list"/>
						</th>
						<th><fmt:message key="search.total"><fmt:param value="${accountsCount}"/></fmt:message></th>
					</tr>
				</tfoot>
			</table>
		</c:otherwise>
	</c:choose>
	</div>
</body>