<%--
 | (c) Copyright 2005-2011 JAXIO, www.jaxio.com
 | Source code generated by Celerio, a Jaxio product
 | Want to use Celerio within your company? email us at info@jaxio.com
 | Follow us on twitter: @springfuse
 | Template pack-mvc-3:src/main/webapp/WEB-INF/views/domain/delete.e.vm.jsp
--%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"
%><%@ taglib prefix="spring" uri="http://www.springframework.org/tags"
%><%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"
%><%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
%><head>
	<title><fmt:message key="contactInfo" />: <fmt:message key="crud.functionalities.delete" /></title>
</head>
<body>
	<form:form action="${pageContext.request.contextPath}/domain/contactinfo/delete/${contactInfo.primaryKey}" method="POST">
		<p>
			<fmt:message key="crud.deletion.request.confirmation"/>
			<br/>
			<span class="alt"><spring:eval expression="contactInfo" /></span>
		</p>
		<input type="submit" value="<fmt:message key="crud.deletion.confirmation"/>" class="button button-delete"/>
	</form:form>
</body>
