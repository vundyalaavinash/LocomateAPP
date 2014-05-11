<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title></title>
<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/bootstrap-theme.min.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
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
				<a class="navbar-brand" href="#"><img src='<c:url value="/resources/images/logosmall.png"/>'/>&nbsp;Locomate</a>
			</div>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="./offer">Offer Ride</a></li>
					<li><a href="./request">Request Ride</a></li>
					<li class="dropdown">
			          <a href="#" class="dropdown-toggle" data-toggle="dropdown">${name}<b class="caret"></b></a>
			          <ul class="dropdown-menu">
			            <li><a href="#">Edit Account</a></li>
			            <li><a href="#">Change Password</a></li>
			            <li class="divider"></li>
			            <li><a href="./logout">Logout</a></li>
			          </ul>
			        </li>				
				</ul>
			</div>
		</div>
	</nav><br/><br/><br/>
	<div class="container main">		
		<div class="col-md-3 ">
			<div class="align-center">
				<img src='<c:url value="/resources/images/profilebig.png"/>' class="img-circle frame" />
	          	<br/>
	          	<h4>${name}</h4>
	          	<hr>
        	</div>
		</div>
  		<div class="col-md-9">
			<h3>Offer Ride</h3>
			<hr>
			<div class="row">
				<div class="col-md-6 placeauto">
					<div class="form-group">
					</div>
					<div class="form-group">
						<label for="toPlace">To:</label> 
						<input type="text" class="form-control" id="toPlace"
							name="toPlace" placeholder="Enter Destination">
					</div>
					<div class="btn-group">
					  <button type="button" class="btn btn-default">Left</button>
					</div>
				</div>
				<div class="col-md-6">
					<div id="mapdiv"></div>
				</div>	
			</div>			
		</div>
	</div>
	<footer>
		<div class="container">
			<hr/>
			<p>Copyrights &copy; ${year} | <cite title="Source Title">Locomate</cite>
			</p>
		</div>
	</footer>
</body>
<script src="https://maps.googleapis.com/maps/api/js?v=3.exp&sensor=false&libraries=places"></script>
<script src="<c:url value="/resources/js/jquery-1.11.0.min.js" />"></script>
<script src="<c:url value="/resources/js/jquery-migrate-1.2.1.min.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
<script src="<c:url value="/resources/js/common-maps.js" />"></script>
</html>