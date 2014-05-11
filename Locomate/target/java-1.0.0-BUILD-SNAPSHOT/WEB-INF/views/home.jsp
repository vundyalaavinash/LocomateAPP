<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Locomate</title>
<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/bootstrap-theme.min.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/jquery.gridster.min.css" />" rel="stylesheet">
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
					<li><a href="./register">Registration</a></li>
					<li class="dropdown">
			          <a href="#" class="dropdown-toggle" data-toggle="dropdown">Login <b class="caret"></b></a>
			          <div class="dropdown-menu login">			            
			          	<form action="./loginform" method="post" name="" role="form">
							<%-- <form:errors path="*" cssClass="errorblock" element="div" /> --%>
							<div class="form-group">
								<label for="exampleInputEmail1">Username</label> 
								<input type="text" class="form-control" id="userName" name="userName"
									placeholder="Enter Username">
							</div>
							<div class="form-group">
								<label for="exampleInputPassword1">Password</label> 
								<input type="password" class="form-control" id="password"
									name="password" placeholder="Enter Password">
							</div>
							<a href="./forgotPassword">Forgot Password?</a>
							<br/>
							<br/>
							<button id="" class="btn btn-primary pull-left" formaction="./submitLogin">Login</button>
							<button value="Register" class="btn btn-primary pull-right" formaction="./register">Register</button>										
						</form>
			          </div>
			        </li>
				</ul>
			</div>
		</div>
	</nav>
	<br/>
	<br/>
	<br/>
	<div class="container main">
		<div class="row well blackbg">
	  		<div class="gridster">
			    <ul>
			    	<!-- Row 1 -->
			        <li data-row="1" data-col="1" data-sizex="2" data-sizey="2">
				        <br/><br/><br/><br/>
                       	<img src='<c:url value="/resources/images/fordon-selected.png"/>' />
                       	<br/>
                       	<h1>Locomate</h1>
                       	<h6>Make your Journey Exceptionally Good</h6>
			        </li>			        			        			 	
			 		<li data-row="1" data-col="3" data-sizex="2" data-sizey="1">
			 			<br/>
			 			<h1 class="blue"><span class="glyphicon glyphicon-road"></span>&nbsp;4800<br><span class="spanwhite">Kilometers</span></h1>
			 		</li>	        				 
			        <li data-row="1" data-col="5" data-sizex="2" data-sizey="1">
			        	<br>
			        	<h1 class="blue"><span class="glyphicon glyphicon-map-marker"></span>&nbsp;5<span class="spanwhite"> &nbsp;Cities</span></h1>
			        </li>
			        <li data-row="1" data-col="7" data-sizex="1" data-sizey="1" class="btn skybluebg">
			        	<br>
			        	<p class="search">
			        		<span class="glyphicon glyphicon-info-sign"></span>
				        	<br>
				        	Know More
			        	</p>					        			        
			        </li>
			        
			        <!-- Row 2 -->
			        <li data-row="2" data-col="3" data-sizex="2" data-sizey="1">
			 			<br>
			        	<h1 class="blue"><span class="glyphicon glyphicon-map-marker"></span>&nbsp;31<br><span class="spanwhite">Destinations</span></h1>
			 		</li>	
			        <li data-row="2" data-col="5" data-sizex="2" data-sizey="1"></li>			
					<li data-row="2" data-col="7" data-sizex="1" data-sizey="1" class="btn greenbg">
			        	<br>
			        	<p class="search">
			        		<span class="glyphicon glyphicon-comment"></span>
				        	<br>
				        	Offer Ride
			        	</p>					        			        
			        </li>					
					<!-- Row 3  -->
					<li data-row="3" data-col="1" data-sizex="2" data-sizey="1">
			        	<br>
			 			<img src='<c:url value="/resources/images/friend.png" />' width='32px;'><span style='font-size:35px; color: #3276b1;'>Thousands</span><br>of Friendships made <br>on the road
			 		</li>
					<li data-row="3" data-col="3" data-sizex="2" data-sizey="1">
			 			<br>
			        	<img src='<c:url value="/resources/images/gas.png" />'><span style='font-size:35px; color: #3276b1;'>Millions</span> <br>of liters gas saved
			        </li>	
					<li data-row="3" data-col="5" data-sizex="2" data-sizey="1">
			        	<br>
			        	<img src='<c:url value="/resources/images/co2.png"/>'><span style='font-size:35px; color: #3276b1;'>Million</span> <br>of Tons of Carbon <br>Emissions saved
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
				<span class="pull-right">
					<a href="adout.jsp" target="_blank">About US</a>&nbsp;
					<a href="terms.jsp" target="_blank">Terms of Use</a> &nbsp;
					<a href="privacy.jsp" target="_blank">Privacy Policy</a> &nbsp;								
					<a href="team.jsp" target="_blank">Team</a> &nbsp;
					<a href="Careers.jsp" target="_blank">Careers</a>					
				</span>
			</p>
		</div>
	</footer>
</body>
<script src="<c:url value="/resources/js/jquery-1.11.0.min.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
<script src="<c:url value="/resources/js/jquery.gridster.min.js" />"></script>

<script src="<c:url value="/resources/js/commons.js" />"></script>
</html>