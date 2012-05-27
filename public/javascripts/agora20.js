function newAlert (type, message) {
	$("#alert-area").empty();
    $("#alert-area").append(
    		$("<div class='alert alert-" + type + " alert-block'>" +
    	      "<button class=\"close\" data-dismiss=\"alert\" href=\"#\">x</button>" + 
    	      "<p align=\"center\">" + message + "</p></div>")
    );
    //$(".alert").alert();
    $(".alert").delay(2000).fadeOut("slow", function () { $(this).remove(); });
}

function staticAlert (type, message) {
	$("#alert-area").empty();
    $("#alert-area").append(
    		$("<div class='alert alert-" + type + " alert-block'>" +
    		  "<button class=\"close\" data-dismiss=\"alert\" href=\"#\">x</button>" + 
    		  "<p align=\"center\">" + message + "</p></div>")
    );
    $(".alert").alert();
}

$(document).ready(function() {
	$('#buttonVoteUp').click(function() {
		staticAlert('info', 'Registering your vote, please wait');
		var  jqxhr = $.post(
							"/ideas/voteUp", 
							function(data, textStatus, jqXHR) {
								newAlert('success', data);
								$('#ideaContainer').load('/ideas/update');
							});
		jqxhr.error(function(){ newAlert('error', data.responseText); });
	 });
	$('#buttonVoteDown').click(function() {
		staticAlert('info', 'Registering your vote, please wait');
		var  jqxhr = $.post(
				"/ideas/voteDown", 
				function(data, textStatus, jqXHR) {
					newAlert('success', data);
					$('#ideaContainer').load('/ideas/update');
				});
		jqxhr.error(function(){ newAlert('error', data.responseText); });
	 });
	$('#buttonChange').click(function() {
		staticAlert('info', 'Retriving an idea, please wait');
		$('#ideaContainer').load(
				'/ideas/update', 
				function(response, status, xhr) {
					if (status == "success") {
						newAlert('success', "New Idea retrieved");
					}
				}
		);
	 });
});

