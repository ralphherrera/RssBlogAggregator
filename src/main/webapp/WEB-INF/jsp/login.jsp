<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<style>
html, body {
	height: 100%;
}

body {
	/* display: -ms-flexbox;
	display: -webkit-box;
	display: flex; */
	-ms-flex-align: center;
	-ms-flex-pack: center;
	-webkit-box-align: center;
	align-items: center;
	-webkit-box-pack: center;
	justify-content: center;
	padding-top: 60px;
	padding-bottom: 40px;
	background-color: #f5f5f5;
}

.form-signin {
	width: 100%;
	max-width: 330px;
	padding: 15px;
	margin: 0 auto;
}

.form-signin .checkbox {
	font-weight: 400;
}

.form-signin .form-control {
	position: relative;
	box-sizing: border-box;
	height: auto;
	padding: 10px;
	font-size: 16px;
}

.form-signin .form-control:focus {
	z-index: 2;
}

.form-signin input[type="email"] {
	margin-bottom: -1px;
	border-bottom-right-radius: 0;
	border-bottom-left-radius: 0;
}

.form-signin input[type="password"] {
	margin-bottom: 10px;
	border-top-left-radius: 0;
	border-top-right-radius: 0;
}
</style>

<body class="text-center">
	<form class="form-signin" name='f' action='/login' method='POST'>
		<h1 class="h3 mb-3 font-weight-normal">Please sign in</h1>
		<label for="inputEmail" class="sr-only">Email address</label> 
		<input type="text" id="inputEmail" name="username" class="form-control"
			placeholder="Email address" required autofocus> 
		<label for="inputPassword" class="sr-only">Password</label> 
		<input type="password" id="inputPassword" name="password" class="form-control" placeholder="Password" required>
		<input name="_csrf" type="hidden"
				value="b57955e0-20ee-4420-99e7-a4e856598f9f" />
		<button class="btn btn-lg btn-primary btn-block" name="submit" type="submit">Login</button>
	</form>
</body>