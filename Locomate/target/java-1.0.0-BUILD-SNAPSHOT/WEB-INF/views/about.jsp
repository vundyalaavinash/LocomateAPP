<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<title>About Us</title>
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

	</div>
	<footer>
		<div class="container">
			<hr/>
			<p>Copyrights &copy; ${year} | <cite title="Source Title">Locomate</cite>
				<span class="pull-right">
					<a href="adout.jsp">About US</a>&nbsp;
					<a href="terms.jsp">Terms of Use</a> &nbsp;
					<a href="privacy.jsp">Privacy Policy</a> &nbsp;								
					<a href="team.jsp">Team</a> &nbsp;
					<a href="Careers.jsp">Careers</a>					
				</span>
			</p>
		</div>
	</footer>
</body>
</html>