$(document).ready(function(){ 
	checkPageTitle()
	$(".triggerRemove").click(function(e) {
		e.preventDefault();
		$("#modalDelete .deleteBtn").attr("href" , $(this).attr("href"));
		$("#modalDelete").modal();
	});
});

function checkPageTitle() {
	var pageTitle = document.title;
	if (pageTitle === "Users") {
		$(".deleteConfirm").append("<p>Are you really sure to <strong>delete</strong> this user?</p>");
	} else {
		$(".deleteConfirm").append("<p>Are you really sure to <strong>delete</strong> this blog?</p>");
	}
}