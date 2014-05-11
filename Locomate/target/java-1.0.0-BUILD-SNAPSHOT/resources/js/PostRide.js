$(document).ready(function(){
	$('#frequency-next-btn').click(function (e) {
		  e.preventDefault();		  
		  $("#frequency-tab").hide();
		  $("#route-tab").show();
		  $("#frequency-tab-a").removeClass("active");
		  $("#route-tab-a").addClass("active");
	});
	
	$('#route-prev-btn').click(function (e) {
		  e.preventDefault();
		  $("#frequency-tab").show();
		  $("#route-tab").hide();
		  $("#frequency-tab-a").addClass("active");
		  $("#route-tab-a").removeClass("active");
	});	
	$('#route-next-btn').click(function (e) {
		  e.preventDefault();		 
		  $("#route-tab").hide();
		  $("#schedule-tab").show();		  
		  $("#schedule-tab-a").addClass("active");
		  $("#route-tab-a").removeClass("active");
	});
	
	$('#schedule-prev-btn').click(function (e) {
		  e.preventDefault();
		  $("#route-tab").show();
		  $("#schedule-tab").hide();
		  $("#schedule-tab-a").removeClass("active");
		  $("#route-tab-a").addClass("active");
	});
});
