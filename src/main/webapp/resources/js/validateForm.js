$(document).ready(function() {
	validateRegForm();
	validateBlogForm();
});

function validateRegForm() {
	$("#regform").validate({
		rules : {
			firstname : {
				required : true,
				minlength : 2
			},
			lastname : {
				required : true,
				minlength : 2
			},
			email : {
				required : true,
				email : true,
				remote : {
					url: "/register/available.html",
					type: "get",
					data: {
						email: function() {
							return $("#email").val();
						}
					}
				}
			},
			password : {
				required : true,
				minlength : 6
			},
			password_confirm : {
				required : true,
				equalTo : "#password"
			}
		},
		highlight: function(element){
			$(element).closest('.form-control').removeClass('is-valid').addClass('is-invalid');
		},
		unhighlight: function(element){
			$(element).closest('.form-control').removeClass('is-invalid').addClass('is-valid');
		},
		messages:{
			email:{
				remote: "This email is already registered"
			}
		}
	})
}

function validateBlogForm() {
	$("#blogForm").validate({
		rules : {
			name : {
				required : true,
				minlength : 2
			},
			url : {
				required : true,
				url : true
			}
		},
		highlight: function(element){
			$(element).closest('.form-control').removeClass('is-valid').addClass('is-invalid');
		},
		unhighlight: function(element){
			$(element).closest('.form-control').removeClass('is-invalid').addClass('is-valid');
		}
	})
}