<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/taglibs.jsp"%>

<link href='https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css' rel="stylesheet" />
<link href='<spring:url value="/resources/css/custom-form.css" />' rel="stylesheet">

<!-- Client side validation -->
<script type="text/javascript"
	src='<spring:url value="/resources/js/jquery.validate.min.js" />'></script>
<script type="text/javascript"
	src='<spring:url value="/resources/js/validateForm.js" />'></script>

<!-- REGISTRATION FORM -->
<div class="text-center" style="padding:50px 0">
	<div class="logo">register</div>

	<c:if test="${success eq true}">
		<div class = "alert alert-success"> Registration <strong>successful!</strong></div>
	</c:if>
	<!-- Main Form -->
	<div class="login-form-1">
		<form:form commandName="user" id="regform" class="text-left regform"> 
			<div class="login-form-main-message"></div>
			<div class="main-login-form">
				<div class="login-group">

					<div class="form-group">
						<label for="firstname" class="sr-only">First Name</label>
						<form:input path="firstname" type="text" class="form-control" id="firstname" name="firstname" placeholder="first name" />
						<form:errors path="firstname"/>
					</div>
					
					<div class="form-group">
						<label for="lastname" class="sr-only">Last Name</label>
						<form:input path="lastname" type="text" class="form-control" id="lastname" name="lastname" placeholder="last name" />
						<form:errors path="lastname"/>
					</div>
					
					<div class="form-group">
						<label for="email" class="sr-only">Email</label>
						<form:input path="email" type="email" class="form-control" id="email" name="email" placeholder="email" />
						<form:errors path="email"/>
					</div>

					<div class="form-group">
						<label for="password" class="sr-only">Password</label>
						<form:input path="password" type="password" class="form-control" id="password" name="password" placeholder="password" />
						<form:errors path="password"/>
					</div>
					<div class="form-group">
						<label for="password_confirm" class="sr-only">Password Confirm</label>
						<input type="password" class="form-control" id="password_confirm" name="password_confirm" placeholder="confirm password">
					</div>
				</div>
				<button type="submit" class="login-button"><i class="fa fa-chevron-right"></i></button>
			</div>
			<div class="etc-login-form">
				<p>already have an account? <a href="/login.html">login here</a></p>
			</div>
		</form:form>
	</div>
	<!-- end:Main Form -->
	
</div>