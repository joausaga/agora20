function newAlert (type, message) {
	$("#alert-area").empty();
    $("#alert-area").append(
    		$("<div class='alert alert-" + type + " alert-block'>" +
    	      "<button class=\"close\" data-dismiss=\"alert\" href=\"#\">x</button>" + 
    	      "<p align=\"center\">" + message + "</p></div>")
    );
    //$(".alert").alert();
    $(".alert").delay(500).fadeOut("slow", function () { $(this).remove(); });
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

function voteUp() {
	var  jqxhr = $.post(
			"/ideas/voteUp", 
			function(data, textStatus, jqXHR) {
				newAlert('success', data);
				$('#ideaContainer').load('/ideas/show');
			});
	jqxhr.error(function(){ newAlert('error', data.responseText); });
}

function voteDown() {
	var  jqxhr = $.post(
			"/ideas/voteDown", 
			function(data, textStatus, jqXHR) {
				newAlert('success', data);
				$('#ideaContainer').load('/ideas/show');
			});
	jqxhr.error(function(){ newAlert('error', data.responseText); });
}

function changeIdea() {
	$('#ideaContainer').load(
			'/ideas/change', 
			function(response, status, xhr) {
				if (status == "success") {
					newAlert('success', "New Idea retrieved");
				}
			}
	);
}

function feedIdeas() {
	staticAlert('info', 'Retriving new ideas from IdeaScale.com');
	 var  jqxhr = $.get(
				"/ideas/feedIdeas", 
				function(data, textStatus, jqXHR) {
					newAlert('success', data);
				});
	jqxhr.error(function(){ newAlert('error', data.responseText); });
}

function feedVotes() {
	staticAlert('info', 'Retriving votes from IdeaScale.com');
	 var  jqxhr = $.get(
				"/ideas/feedVotes", 
				function(data, textStatus, jqXHR) {
					newAlert('success', data);
					$('#ideaContainer').load('/ideas/show');
				});
	jqxhr.error(function(){ newAlert('error', data.responseText); });;
}

$(document).ready(function() {
	// Disable the browser context menu that normally open with right clicks //
	$(document).bind('contextmenu', function(e){
	    e.preventDefault();
	    return false;
	});
	$('#interactionZone').mousedown(function(e) {
		if (e.which == 3) {
			staticAlert('info', 'Registering your vote, please wait');
			voteDown();
		}
		else if(e.which == 1) {
			staticAlert('info', 'Registering your vote, please wait');
			voteUp();
		}
		else {
			staticAlert('info', 'Retriving an idea, please wait');
			changeIdea();
		}
	});
	$('#buttonVoteUp').click(function() {
		staticAlert('info', 'Registering your vote, please wait');
		voteUp();
	 });
	$('#buttonVoteDown').click(function() {
		staticAlert('info', 'Registering your vote, please wait');
		voteDown();
	 });
	$('#buttonChange').click(function() {
		staticAlert('info', 'Retriving an idea, please wait');
		changeIdea();
	 });
	 $('ul.nav li').click(function(e) {
		 var text = $(this).children('a').html();
		 if (text == "Feed Ideas") {
			 feedIdeas();
		 }
		 else if (text == "Feed Votes"){
			 feedVotes();
		 }
		 else {
			 staticAlert('error', 'Do not understand the option selected');
		 }
	 });
});

