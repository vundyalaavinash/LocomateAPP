var rendererOptions = {
	draggable : true
};

var directionsDisplay;
var directionsService = new google.maps.DirectionsService();
var map;

function initialize() {
	directionsDisplay = new google.maps.DirectionsRenderer(rendererOptions);
	var mapOptions = {
		zoom : 5,
		mapTypeId : google.maps.MapTypeId.ROADMAP,
		center : new google.maps.LatLng(21.7679, 78.8718)
	};
	map = new google.maps.Map(document.getElementById('mapdiv'), mapOptions);
	directionsDisplay.setMap(map);
	
}
function calcRoute() {
	var start = document.getElementById('fromPlace').value;
	var end = document.getElementById('toPlace').value;
	var request = {
		origin : start,
		destination : end,
		travelMode : google.maps.DirectionsTravelMode.DRIVING
	};
	directionsService.route(request, function(response, status) {
		if (status === google.maps.DirectionsStatus.OK) {
			directionsDisplay.setDirections(response);
		}
	});
}

$("#fromPlace").change(function(){
	calcRoute();
});
$("#toPlace").change(function(){
	calcRoute();
});

function loadmap() {
	var input = /** @type {HTMLInputElement} */
	(document.getElementById('fromPlace'));
	var autocomplete = new google.maps.places.Autocomplete(input);
	var input1 = /** @type {HTMLInputElement} */
	(document.getElementById('toPlace'));
	var autocomplete1 = new google.maps.places.Autocomplete(input1);

	google.maps.event.addListener(autocomplete, 'place_changed', function() {
		input.className = '';
		var place = autocomplete.getPlace();
		if (!place.geometry) {
			input.className = 'notfound';
			return;
		}
		calcRoute();
	});
	google.maps.event.addListener(autocomplete1, 'place_changed', function() {
		input1.className = '';
		var place1 = autocomplete.getPlace();
		if (!place1.geometry) {
			input1.className = 'notfound';
			return;
		}
		calcRoute();
	});
}

google.maps.event.addDomListener(window, 'load', initialize);

$(document).ready(function() {
	initialize();
	loadmap();
});