<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Post Ride</title>
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/css/bootstrap-theme.min.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/blue.css" />" rel="stylesheet">
</head>
<body>
	<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-collapse">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#"><img
					src='<c:url value="/resources/images/logosmall.png"/>' />&nbsp;Locomate</a>
			</div>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="./offer">Offer Ride</a></li>
					<li><a href="./request">Request Ride</a></li>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown">${name}<b class="caret"></b></a>
						<ul class="dropdown-menu">
							<li><a href="#">Edit Account</a></li>
							<li><a href="#">Change Password</a></li>
							<li class="divider"></li>
							<li><a href="./logout">Logout</a></li>
						</ul></li>
				</ul>
			</div>
		</div>
	</nav>
	<br />
	<br />
	<br />
	<div class="container main">
		<div class="col-md-3 ">
			<div class="align-center">
				<img src='<c:url value="/resources/images/profilebig.png"/>'
					class="img-circle frame" /> <br />
				<h4>${name}</h4>
				<hr>
			</div>
		</div>
		<div class="col-md-9">
			<h3>Post Ride</h3>
			<hr>
			<br>
			<ul class="nav nav-tabs">
				<li id="frequency-tab-a" class="active"><a href="#home">Frequency</a></li>
				<li id="route-tab-a"><a href="#profile">Route</a></li>
				<li id="schedule-tab-a"><a href="#messages">Schedule</a></li>
			</ul>
			<div class="tab-content">
				<div class="tab-pane active" id="frequency-tab">
					<br/><br/>
					<ul class="icheck-radio">
						<li> <input type="radio" name="frequency" class="radio"> <label for="frequency">One-Way Trip</label><br></li>
						<li> <input type="radio" name="frequency" class="radio"> <label for="frequency">Routine Trip</label><br></li>
					</ul>
					<button type="button" id="frequency-next-btn" class="btn btn-primary pull-right">Next</button>
				</div>
				<div class="tab-pane" id="route-tab">
					<br/><br/>
					
					<button type="button" id="route-prev-btn" class="btn btn-primary pull-left">previous</button>
					<button type="button" id="route-next-btn" class="btn btn-primary pull-right">Next</button>
				</div>
				<div class="tab-pane" id="schedule-tab">
					<br/><br/>
					
					<button type="button" id="schedule-prev-btn" class="btn btn-primary pull-left">Previous</button>
				</div>
			</div>
		</div>
	</div>
	<footer>
		<div class="container">
			<hr />
			<p>
				Copyrights &copy; ${year} | <cite title="Source Title">Locomate</cite>
			</p>
		</div>
	</footer>
</body>
<script src="https://maps.googleapis.com/maps/api/js?v=3.exp&sensor=false&libraries=places"></script>
<script src="<c:url value="/resources/js/jquery-1.11.0.min.js" />"></script>
<script src="<c:url value="/resources/js/jquery-migrate-1.2.1.min.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
<script src="<c:url value="/resources/js/icheck.min.js" />"></script>
<script src="<c:url value="/resources/js/icheck.script.js" />"></script>
<script src="<c:url value="/resources/js/PostRide.js" />"></script>
<script src="<c:url value="/resources/js/common-maps.js" />"></script>


</html>