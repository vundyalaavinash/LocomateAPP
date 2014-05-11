<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title></title>
<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/bootstrap-theme.min.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/jquery.gridster.min.css" />" rel="stylesheet">
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
					<li><a href="./displayPostRide">Post Ride</a></li>
					<li><a href="./offer">Dashboard</a></li>
					<li><a href="./offer"></a></li>
					<li class="dropdown">
			          <a href="#" class="dropdown-toggle" data-toggle="dropdown">${name}<b class="caret"></b></a>
			          <ul class="dropdown-menu">
			            <li><a href="#">Edit Account</a></li>
			            <li><a href="#">DashBoard</a></li>
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
		<div class="row well blackbg">
	  		<div class="gridster">
			    <ul>
			    	<!-- Row 1 -->
			        <li data-row="1" data-col="1" data-sizex="2" data-sizey="3">
                       	<img src='<c:url value="/resources/images/profilebig.png"/>' class="img-circle frame" />
                       	<br/>
                       	<h4>${name}</h4>
                       	<a href="./displayUploadPicture" >Upload Picture</a>
			        </li>			        			        			 	
			 		<li data-row="1" data-col="3" data-sizex="2" data-sizey="1">
			 			<br/>
			 			<h1 class="blue"><span class="glyphicon glyphicon-road"></span><br><span class="spanwhite">Upcoming Trips</span></h1>
			 		</li>	        				 
			        <li data-row="1" data-col="5" data-sizex="2" data-sizey="1">
			        	<br>
			        	<h1 class="blue"><span class="glyphicon glyphicon-map-marker"></span>&nbsp;5<span class="spanwhite"> &nbsp;Messages</span></h1>
			        </li>
			        <li data-row="1" data-col="3" data-sizex="1" data-sizey="1" class="btn skybluebg">
			        	<br>
			        	<p class="search">
			        		<span class="glyphicon glyphicon-info-sign"></span>
				        	<br>
				        	My Profile
			        	</p>					        			        
			        </li>
			        
			        <!-- Row 2 -->
			        <li data-row="2" data-col="3" data-sizex="2" data-sizey="1">
			 			<br>
			        	<h1 class="blue"><span class="glyphicon glyphicon-map-marker"></span>&nbsp;<br><span class="spanwhite">Request Received</span></h1>
			 		</li>	
			        <li data-row="2" data-col="3" data-sizex="2" data-sizey="1">
			 			<br>
			        	<h1 class="blue"><span class="glyphicon glyphicon-map-marker"></span>&nbsp;<br><span class="spanwhite">Request Sent</span></h1>
			 		</li>			
					<li data-row="2" data-col="7" data-sizex="1" data-sizey="1" class="btn greenbg">
			        	<br>
			        	<p class="search">
			        		<span class="glyphicon glyphicon-comment"></span>
				        	<br>
				        	<a href="displayPostRide">Offer Ride</a>
				        	
			        	</p>   			        
			        </li>					
					<!-- Row 3  -->
					<%-- <li data-row="3" data-col="1" data-sizex="2" data-sizey="1">
			        	<br>
			 			<img src='<c:url value="/resources/images/friend.png" />' width='32px;'><span style='font-size:35px; color: #3276b1;'>Thousands</span><br>of Friendships made <br>on the road
			 		</li> --%>
					<li data-row="3" data-col="3" data-sizex="2" data-sizey="1">
			 			<br>
			        	<img src='<c:url value="" />'><span style='font-size:35px; color: #3276b1;'>Total Trips</span>
			        </li>	
					<li data-row="3" data-col="5" data-sizex="2" data-sizey="1">
			        	<br>
			        	<img src='<c:url value=""/>'><span style='font-size:35px; color: #3276b1;'> Cancelled Trips</span> 
			        </li>	
			        <li data-row="3" data-col="7" data-sizex="1" data-sizey="1" class="btn bluebg">
			        	<br>
			        	<p class="search">
			        		<span class="glyphicon glyphicon-search"></span>
				        	<br>
				        	Search Ride
			        	</p>					        			        
			        </li>
			    </ul>
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
<script src="<c:url value="/resources/js/jquery-1.11.0.min.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
<script src="<c:url value="/resources/js/jquery.gridster.min.js" />"></script>

<script src="<c:url value="/resources/js/commons.js" />"></script>
</html>