<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/taglibs.jsp"%>

<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
<style><%@include file="../resources/css/custom-form.css"%></style>
<script>
<%@include file="../resources/js/custom-form.js"%>
</script>

<!-- REGISTRATION FORM -->
<div class="text-center" style="padding:50px 0">
	<div class="logo">register</div>
	<!-- Main Form -->
	<div class="login-form-1">
		<form id="register-form" class="text-left">
			<div class="login-form-main-message"></div>
			<div class="main-login-form">
				<div class="login-group">

					<div class="form-group">
						<label for="reg_firstname" class="sr-only">First Name</label>
						<input type="text" class="form-control" id="reg_firstlname" name="reg_firstname" placeholder="first name" required="required">
					</div>
					
					<div class="form-group">
						<label for="reg_lastname" class="sr-only">Last Name</label>
						<input type="text" class="form-control" id="reg_lastname" name="reg_lastname" placeholder="last name" required="required">
					</div>
					
					<div class="form-group">
						<label for="reg_email" class="sr-only">Email</label>
						<input type="email" class="form-control" id="reg_email" name="reg_email" placeholder="email" required="required">
					</div>

					<div class="form-group">
						<label for="reg_password" class="sr-only">Password</label>
						<input type="password" class="form-control" id="reg_password" name="reg_password" placeholder="password" required="required">
					</div>
					<div class="form-group">
						<label for="reg_password_confirm" class="sr-only">Password Confirm</label>
						<input type="password" class="form-control" id="reg_password_confirm" name="reg_password_confirm" placeholder="confirm password">
					</div>
					
					<div class="form-group login-group-checkbox">
						<input type="checkbox" class="" id="reg_agree" name="reg_agree">
						<label for="reg_agree">i agree with <a href="#">terms</a></label>
					</div>
				</div>
				<button type="submit" class="login-button"><i class="fa fa-chevron-right"></i></button>
			</div>
			<div class="etc-login-form">
				<p>already have an account? <a href="/login.html">login here</a></p>
			</div>
		</form>
	</div>
	<!-- end:Main Form -->
</div>