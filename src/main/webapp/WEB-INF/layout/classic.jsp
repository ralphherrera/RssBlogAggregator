<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@ include file="../layout/taglibs.jsp"%>
<tilesx:useAttribute name="current" />
<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<!-- Bootstrap CSS -->
<link href='<spring:url value="/resources/css/bootstrap.min.css" />'
	rel="stylesheet">
<link href='<spring:url value="/resources/css/jumbotron.css" />'
	rel="stylesheet">

<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script type="text/javascript"
	src='<spring:url value="/resources/js/jquery-3.3.1.min.js" />'></script>
<script type="text/javascript"
	src='<spring:url value="/resources/js/popper.min.js" />'></script>
<script type="text/javascript"
	src='<spring:url value="/resources/js/bootstrap.min.js" />'></script>

<title><tiles:getAsString name="title"></tiles:getAsString></title>
</head>

<nav class="navbar navbar-expand-md navbar-dark fixed-bottom bg-dark">
	<a class="navbar-brand" href='<spring:url value="/index.htm" />'>Blog
		Aggregator</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarsExampleDefault"
		aria-controls="navbarsExampleDefault" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>

	<div class="collapse navbar-collapse" id="navbarsExampleDefault">
		<ul class="navbar-nav mr-auto">
			<security:authorize access="hasRole('ROLE_ADMIN')">
				<li class="${current == 'users' ? 'active' : 'nav-item' }"><a
					class="nav-link" href='<spring:url value="/users.html" />'>Users</a></li>
			</security:authorize>
			<security:authorize access="isAuthenticated() ">
				<li class="${current == 'my-account' ? 'active' : 'nav-item' }"><a
					class="nav-link" href='/mypage.html'>My Account</a></li>
			</security:authorize>
		</ul>
		<ul class="nav navbar-nav navbar-right">
			<security:authorize access="!isAuthenticated()">
				<li class="${current == 'login' ? 'active' : 'nav-item' }"><a
					class="nav-link" href='<spring:url value="/login.html" />'>Login</a></li>
			</security:authorize>
			<security:authorize access="!isAuthenticated()">
				<li class="${current == 'register' ? 'active' : 'nav-item' }"><a
					class="nav-link" href='<spring:url value="/register.html" />'>Register</a></li>
			</security:authorize>
			<security:authorize access="isAuthenticated()">
				<li class="nav-item"><a class="nav-link" href='/logout'>Logout</a></li>
			</security:authorize>
		</ul>
	</div>
</nav>
<div class="container">
	<tiles:insertAttribute name="body" />
</div>
<tiles:insertAttribute name="footer" />
</html>