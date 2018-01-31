<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/taglibs.jsp"%>

<%-- <style><%@include file="../resources/css/login.css"%></style> --%>
<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
<style><%@include file="../resources/css/custom-form.css"%></style>
<script>
<%@include file="../resources/js/custom-form.js"%>
</script>

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
</div>