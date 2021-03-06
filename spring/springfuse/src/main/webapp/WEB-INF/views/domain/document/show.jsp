<%--
 | (c) Copyright 2005-2011 JAXIO, www.jaxio.com
 | Source code generated by Celerio, a Jaxio product
 | Want to use Celerio within your company? email us at info@jaxio.com
 | Follow us on twitter: @springfuse
 | Template pack-mvc-3:src/main/webapp/WEB-INF/views/domain/show.e.vm.jsp
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"
%><%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"
%><%@ taglib prefix="spring" uri="http://www.springframework.org/tags"
%><%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"
%><%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
%><head>
	<title><fmt:message key="document" />: <fmt:message key="crud.functionalities.show" /></title>
</head>
<body>

	<a href="${pageContext.request.contextPath}/domain/document/search" class="ajaxy button button-search"><fmt:message key="document" /></a>
	<span class="ui-state-highlight button button-show"><fmt:message key="crud.show.button" /></span>
	<a href="${pageContext.request.contextPath}/domain/document/update/${document.primaryKey}" class="ajaxy button button-edit"><fmt:message key="crud.edit.button" /></a>
	<a href="${pageContext.request.contextPath}/domain/document/delete/${document.primaryKey}" class="modal button button-delete"><fmt:message key="crud.delete.button" /></a>

	<table class="show">
		<tbody>
			<tr>
				<th><fmt:message key="document_accountId" /></th>
				<td>
					<spring:eval expression="document.account" />
					<a href="${pageContext.request.contextPath}/domain/account/show/${document.account.primaryKey}" class="button button-show miniature"><fmt:message key="crud.show.button" /></a>
				</td>
			</tr>
			<tr>
				<th><fmt:message key="document_documentContentType" /></th>
				<td><spring:eval expression="document.documentContentType"/></td>
			</tr>
			<tr>
				<th><fmt:message key="document_documentSize" /></th>
				<td><spring:eval expression="document.documentSize"/></td>
			</tr>
			<tr>
				<th><fmt:message key="document_documentFileName" /></th>
				<td><spring:eval expression="document.documentFileName"/></td>
			</tr>
			<tr>
				<th><fmt:message key="document_documentBinary" /></th>
				<td><a href="${pageContext.request.contextPath}/domain/document/download/documentBinary/${document.primaryKey}/${document.documentFileName}" class="button button-download"><fmt:message key="crud.download.button" /></a></td>
			</tr>
		</tbody>
	</table>
</body>