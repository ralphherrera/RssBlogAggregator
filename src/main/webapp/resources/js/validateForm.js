$(document).ready(function() {
	validateRegForm();
});

function validateRegForm() {

	$("#register-form").validate({
		rules: {
			firstname: {
				requred: true,
				minlength: 2
			},
			lastname: {
				requred: true,
				minlength: 2
			},
			email: {
				requred: true,
				email: true
			},
			password: {
				requred: true,
				minlength: 6
			},
		}
	})
}