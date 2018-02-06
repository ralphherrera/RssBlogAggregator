<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/taglibs.jsp"%>

<link href='https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css' rel="stylesheet" />
<link href='<spring:url value="/resources/css/login.css" />' rel="stylesheet">
<link href='<spring:url value="/resources/css/custom-form.css" />' rel="stylesheet">

<!-- LOGIN FORM -->
<div class="text-center" style="padding:50px 0">
	<div class="logo">login</div>
	<!-- Main Form -->
	<div class="login-form-1">
		<form id="login-form" class="text-left" name='f' action='/login' method='POST'>
			<div class="login-form-main-message"></div>
			<div class="main-login-form">
				<div class="login-group">
					<div class="form-group">
						<label for="lg_username" class="sr-only">Username</label>
						<input type="email" class="form-control" id="lg_username" name="username" placeholder="Email address" required autofocus> 
					</div>
					<div class="form-group">
						<label for="lg_password" class="sr-only">Password</label>
						<input type="password" class="form-control" id="lg_password" name="password" placeholder="Password" required>
					</div>
				</div>
				<button type="submit" class="login-button" name="submit"><i class="fa fa-chevron-right"></i></button>
			</div>
			<div class="etc-login-form">
				<p>new user? <a href="/register.html">create new account</a></p>
			</div>
		</form>
	</div>
	<!-- end:Main Form -->
<script type="text/javascript" src='<spring:url value="/resources/js/custom-form.js" />' ></script>
</div>