function newAlert (type, message) {
	$("#alert-area").empty();
    $("#alert-area").append(
    		$("<div class='alert alert-" + type + " alert-block'>" +
    	      "<button class=\"close\" data-dismiss=\"alert\" href=\"#\">x</button>" + 
    	      "<p align=\"center\">" + message + "</p></div>")
    );
    $(".alert").delay(1500).fadeOut("slow", function () { $(this).remove(); });
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

function modalWindow(message) {
	$("#modalMessage").html("<h3 align=\"center\">"+ message +"</h3><br>");
	//$("#modalMessage").html("<div class=\"label label-info\"><h4 align=\"center\">Score </h4><h3 align=\"center\">@ideaVotes</h3></div>");
	$('#modalWindow').modal('show');
	$('#modalWindow').delay(1500).fadeOut("slow", function () { $(this).modal('hide'); changeIdea(false); });
}

function updateIdeaContent(data) {
	/*if (data["score"] == 0) {
		$("#ideaScore").attr("class", "label label-info");
	}
	else {
		if (data["score"] > 0) {
			$("#ideaScore").attr("class", "label label-success");
		}
		else {
			$("#ideaScore").attr("class", "label label-important");
		}
	}*/
	$("#ideaTitle").html("<h1 align=\"center\">"+data["title"]+"</h1>");
	$("#ideaText").html("<h2 align=\"center\">"+data["content"]+"</h2>");
	//$("#ideaAuthor").html("<h4 align=\"left\"> Disclaimer: " + data["author"] + "</h4>");
	$("#ideaScore").html("<h3> Punteggio: " + data["score"]  + "</h3>");
	$("#extraInfoTitle").html("<h3 align=\"center\">"+ data["eiTitle"] +"</h3>");
	$("#extraInfoContent").html("<p>"+ data["eiContent"] +"</p>");
}

function voteUp() {
	var  jqxhr = $.post(
			"/ideas/voteUp", 
			function(data, textStatus, jqXHR) {
				modalWindow(data);
				var  jqxhr = $.get(
						"/ideas/show", 
						function(data, textStatus, jqXHR) {
							updateIdeaContent(data);
						});
				jqxhr.error(function(){ newAlert('error', data.responseText); });
			});
	jqxhr.error(function(data){ newAlert('error', data.responseText); });
}

function voteDown() {
	var  jqxhr = $.post(
			"/ideas/voteDown", 
			function(data, textStatus, jqXHR) {
				modalWindow(data);
				var  jqxhr = $.get(
						"/ideas/show", 
						function(data, textStatus, jqXHR) {
							updateIdeaContent(data);
						});
				jqxhr.error(function(data){ newAlert('error', data.responseText); });
			});
	jqxhr.error(function(data){ newAlert('error', data.responseText); });
}

function changeIdea(e) {
	var  jqxhr = $.get(
			"/ideas/change/",
			{event:e},
			function(data, textStatus, jqXHR) {
				updateIdeaContent(data);
			});
	jqxhr.error(function(data){ staticAlert('error', data.responseText); });
}

$(document).ready(function() {
	// Disable the browser context menu that normally open with right clicks //
	$(document).bind('contextmenu', function(e){
	    e.preventDefault();
	    return false;
	});
	// Disable the mouse cursor //
	$('#ideaContainer').css({cursor:'none'});
	$('#ideaContainer').mousedown(function(e) {
		if (e.which == 3) {
			voteDown();
		}
		else if(e.which == 1) {
			voteUp();
		}
		else {
			staticAlert('info', 'Retriving an idea, please wait');
			changeIdea(true);
			$("#alert-area").empty();
		}
	});
	/* Set a timer to change the ideas every 5 minutes */
	window.setInterval(function() {changeIdea(false);}, 300000);
});
