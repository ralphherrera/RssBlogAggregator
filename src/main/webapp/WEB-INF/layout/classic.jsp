<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@ include file="../layout/taglibs.jsp"%>
<tilesx:useAttribute name="current" />
<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

<!-- Custom styles for this template -->
<link
	href="https://getbootstrap.com/docs/4.0/examples/jumbotron/jumbotron.css"
	rel="stylesheet">

<!-- Sticky Footer -->
<link
	href="https://getbootstrap.com/docs/4.0/examples/sticky-footer/sticky-footer.css"
	rel="stylesheet">

<title><tiles:getAsString name="title"></tiles:getAsString></title>
</head>

<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
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
			<li class="${current == 'users' ? 'active' : 'nav-item' }"><a
				class="nav-link" href='<spring:url value="/users.html" />'>Users</a></li>
			<li class="${current == 'login' ? 'active' : 'nav-item' }"><a
				class="nav-link" href='<spring:url value="/login.html" />'>Login</a></li>
			</li>
		</ul>
	</div>
</nav>

<div class="container">
	<tiles:insertAttribute name="body" />
</div>
<!-- /container -->
</main>

<center>
	<tiles:insertAttribute name="footer" />
</center>

<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
	integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
	integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
	crossorigin="anonymous"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
	crossorigin="anonymous"></script>
</body>


</html>