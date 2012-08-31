<?xml version="1.0" encoding="UTF-8" ?>
<%--
 | (c) Copyright 2005-2011 JAXIO, www.jaxio.com
 | Source code generated by Celerio, a Jaxio product
 | Want to use Celerio within your company? email us at info@jaxio.com
 | Follow us on twitter: @springfuse
 | Template pack-mvc-3:src/main/webapp/WEB-INF/sitemesh/default.p.vm.jsp
--%>
<%@ taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator" 
%><%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"
%><%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"
%><%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
%><!DOCTYPE HTML>
<html>
<head>
	<meta http-equiv="content-type" content="text/html; charset=UTF-8">
	<meta name="generator" content="www.springfuse.com" />
	<link rel="shortcut icon" href="${pageContext.request.contextPath}/static/images/favicon.ico">

	<!-- http://www.blueprintcss.org/ -->
	<!-- Need a wider css ? Use http://ianli.com/blueprinter/ -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/static/blueprint-1.0/950px/screen.css" type="text/css" media="screen, projection">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/static/blueprint-1.0/950px/print.css" type="text/css" media="print">
	<!--[if lt IE 8]><link rel="stylesheet" href="${pageContext.request.contextPath}/static/blueprint-1.0/950px/ie.css" type="text/css" media="screen, projection"><![endif]-->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/static/blueprint-1.0/plugins/fancy-type/screen.css" type="text/css" media="screen, projection">

	<!-- http://jquery.org/ -->
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-1.5.2/jquery.min.js"></script>
	
	<!-- http://jqueryui.com/ -->
	<link type="text/css" href="${pageContext.request.contextPath}/static/jquery-ui-1.8.11/themes/base/jquery.ui.all.css" rel="stylesheet" media="all" />
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-ui-1.8.11/js/jquery-ui-1.8.11.custom.min.js"></script>
	 
	<!-- https://github.com/cowboy/jquery-bbq -->
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-bbq-1.3/jquery.ba-bbq.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-bbq-1.3/jquery-tabs-history.js"></script>

	<!-- https://github.com/jzaefferer/jquery-validation -->	
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-validation-1.8.0/jquery.validate.js"></script>


	<!-- get the title from the decorated page, if not found, default to springfuse -->
	<title><decorator:title default="Springfuse" /></title>
	
	<!-- append the header tag (if any) of the decorated page -->
	<decorator:head />

	<script type="text/javascript">
		function setupTabs() {
			// see http://jqueryui.com/demos/tabs/
			$(".tabs").tabs({
				load: function(event, ui) {
					setupPage();
				}
			});
		}
	
		function setupValidation() {
			// see https://github.com/jzaefferer/jquery-validation/
			var validator = $(".form").validate();
		}
	
		function setupDatepickers() {
			// see http://docs.jquery.com/UI/Datepicker/formatDate
			$(".datepicker").datepicker({
				dateFormat : 'yy-mm-dd'
			});
		}
	
		function setupAjaxLinks() {
			// see http://api.jquery.com/jQuery.ajax/
			$(".ajax, .navigation").unbind('click').bind('click', function() {
				if ($(this).parents("div").find("#result").size() > 0) {
					var list = $(this).parents("div").find("#result");
					list.load($(this).attr("href") + " #main #result", function() {
						setupPage();
	 				});
				} else {
					$("#main").load($(this).attr("href") + " #main", function() { 
						setupPage();
					});
				}
				return false;
			});
	
			// see http://jqueryui.com/demos/dialog/#modal
			$(".modal").unbind('click').bind('click', function() {
				$("#modalDialog").load($(this).attr("href") + " #main", function() {
					 setupPage();
				});
				$("#modalDialog").dialog({modal: true});
				return false;
			});
		}
	
		function setupAjaxForms() {
			$("#main form.search").unbind('submit').bind('submit', function(e) {
				var url = $(this).attr("action");
				var serializedForm = $(this).serialize();
				var element ;
				if ($(this).parents("div").find("#result").size() > 0) {
					element = $(this).parents("div").find("#result"); 
				} else {
					element = $("#main #result");
				}
				if (element) {
					$.post(url, serializedForm, function(data) {
						var list = $(data).find("#main #result");
						element.html(list);
						setupPage();
					});
				}
				return false;
			});
	
			$("#main form input[name='sp.searchPattern']").unbind('keyup').bind('keyup', function() {
				var url = $(this).closest("form").attr("action");
				var serializedForm = $(this).closest("form").serialize();
				var element;
				if ($(this).parents("div").find("#result").size() > 0) {
					element = $(this).parents("div").find("#result"); 
				} else {
					element = $("#main #result");
				}
				if (element) {
					$.post(url, serializedForm, function(data) {
						var list = $(data).find("#main #result");
						element.html(list);
						setupPage();
					});
				}
				return true;
			});
		}
	
		function setupButton(name, icon, showText) {
			// configuration at http://jqueryui.com/demos/button/#icons
			$("#main " + name).button({
				icons: {
					primary: "ui-icon-" + icon
				},
				text: showText
			});
		}
	
		function setupButtons() {
			$("button, input:submit, .button", "#main").button();
			// icon list available at http://jqueryui.com/themeroller/
			setupButton(".button-show", "zoomin", true);
			setupButton(".button-edit", "pencil", true);
			setupButton(".button-delete", "trash", true);
			setupButton(".button-link", "link", true);
			setupButton(".button-download", "document", true);
			setupButton(".button-list", "search", true);
			setupButton(".button-search", "search", true);
			setupButton(".button-add", "add", true);
			setupButton(".button-save", "check", true);
			setupButton(".button-create", "plusthick", true);
			setupButton(".button-show", "zoomin", true);
			setupButton(".button-login", "unlocked", true);
			setupButton(".button-show.miniature", "zoomin", false);
			setupButton(".button-edit.miniature", "pencil", false);
			setupButton(".button-delete.miniature", "trash", false);
		}
	
		function setupPage() {
			setupTabs();
			setupButtons();
			setupAjaxLinks();
			setupAjaxForms();
			setupValidation();
			setupDatepickers();
		}
	
		$(document).ready(function() {
			setupPage();
		});
	</script>
	<style type="text/css">
		/* navigation list */ 
		ul#navigation li { margin: 2px; list-style: none; float: left;}
		ul#navigation span.ui-icon { float: left; margin: 5px 4px; }
		/* inline list */ 
		ul.inline { padding-left: 0px;}
		ul.inline li { margin: 2px; list-style: none; float: left;}
		/* skin tables */ 
		table thead tr th a {color: black;}
		table tfoot tr td {text-align: center;}
		table tr th {width:100px;}
		tbody tr:nth-child(even) td, tbody tr.even td { background: #F8F8FF; border: 1px;}
		thead th { background: lightGrey; }
		tfoot tr th {font-weight: normal;}
		table { border-color: lightGrey; border-width: 1px 1px 1px 1px; border-style: solid;}
		/* label */
		label { font-weight: normal;}
		/* markers */
		.error, .alert, .notice, .success, .info { padding: 0.4em;}
	</style>
</head>
<body>
	<div class="container">
		<div class="span-14">
			<a href="${pageContext.request.contextPath}/"><img src="${pageContext.request.contextPath}/static/images/logo_springfuse.png" width="197" height="50"></a>
		</div>
		<div class="span-3 border" align="center">
			<a href="http://www.springfuse.com/quickstart"><fmt:message key="layout.quickstart" /></a>
		</div>
		<div class="span-4 border" align="center">
			<security:authorize ifNotGranted="ROLE_USER">
				<a href="${pageContext.request.contextPath}/login/"><fmt:message key="layout.login" /></a>
			</security:authorize>
			<security:authorize ifAllGranted="ROLE_USER">
				${accountContext.account.username}
				<a href="${pageContext.request.contextPath}/logout"><fmt:message key="layout.logout" /></a>
			</security:authorize>
		</div>
		<div class="span-2 last" align="center">
			<a href="?locale=en" title="English"><img src="${pageContext.request.contextPath}/static/images/lang_english.png" height="18" width="18" /></a>
			<a href="?locale=fr" title="Français"><img src="${pageContext.request.contextPath}/static/images/lang_french.png" height="18" width="18" /></a>
		</div>
		<hr>
		<div id="main">
			<decorator:body />
		</div>
		<hr>
		<h3 align="center"><fmt:message key="homepage.springfuse.footer" /></h3>
		<p style="text-align: center; background: skyblue;">
			Copyright &copy; 2005-2011 <a href="http://www.jaxio.com/">Jaxio</a> | 
			<fmt:message key="layout.all.rights.reserved" /> |
			Twitter <a href="http://www.twitter.com/springfuse">@springfuse</a> |
			<a href="http://www.springfuse.com/privacy-policy"><fmt:message key="layout.privacy.policy" /></a>			
		</p>
	</div>
	<div id="modalDialog"></div>
	<script type="text/javascript">
		// example with asynchronous google analytics
		var _gaq = _gaq || [];
		_gaq.push([ '_setAccount', 'UA-166864-24' ]); // change with your google id
		_gaq.push([ '_setCustomVar', 1, 'rootPackage', 'com.dhenton9000.springfuse', 1 ]); // example of user defined variable
		_gaq.push([ '_trackPageview' ]);

		(function() {
			var ga = document.createElement('script');
			ga.type = 'text/javascript';
			ga.async = true;
			ga.src = ('https:' == document.location.protocol ? 'https://ssl'
					: 'http://www')
					+ '.google-analytics.com/ga.js';
			var s = document.getElementsByTagName('script')[0];
			s.parentNode.insertBefore(ga, s);
		})();
	</script>
</body>
</html>
