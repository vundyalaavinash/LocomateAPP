<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page session="false"%>
<html>
<head>
<title>Registration</title>
<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/bootstrap-theme.min.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
<script src="<c:url value="/resources/js/jquery-1.11.0.min.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
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
			          	<form:form  commandName="registerpo" action="./submitLogin" method="post">
							<%-- <form:errors path="*" cssClass="errorblock" element="div" /> --%>
							<div class="form-group">
								<label for="exampleInputEmail1">Username</label> 
								<form:input path="userName" id="userName" cssClass="form-control"></form:input>
							</div>
							<form:errors path="userName" cssStyle="color:red"/>	
							<div class="form-group">
								<label for="exampleInputPassword1">Password</label> 
								<form:password path="password" cssClass="form-control"/>
							</div>
							<form:errors path="password" cssStyle="color:red"/>	
															
                   <a href="./forgotPassword">Forgot Password?</a>
							<br/>
							<br/>
							<button id="" class="btn btn-primary pull-left" type="submit">Login</button>
							<button value="Register" class="btn btn-primary pull-right" formaction="./register">Register</button>										
						</form:form>
			          </div>
			        </li>
				</ul>
			</div>
		</div>
	</nav>
	<br /><br /><br />
	<div class="container main">
		<div class="row">
			<div class="col-md-4"></div>
			<div class="col-md-4">
			<br/>
			<h3>Sign Up</h3>
			<hr>
				<form:form commandName="registerpo" action="./submitForm?referrer=fromRegister" id="" method="post" onsubmit="return ValidateForm(this);" role="form">
					<form:errors path="" cssClass="color:red"/>
					<input id="SnapHostID" name="SnapHostID" type="hidden" value="YN7YBJ7YDWGH" />
					<script type="text/javascript">
						function ValidateForm(frm) {
						if (frm.FirstName.value == "") {
							alert('First Name is required.');
							frm.FirstName.focus();
							return false;
							}
						if (frm.LastName.value == "") {alert('Last Name is required.');frm.LastName.focus();return false;}
						if (frm.Organization.value == "") {alert('Organization is required.');frm.Organization.focus();return false;}
						if (frm.FromEmailAddress.value == "") {alert('Email address is required.');frm.FromEmailAddress.focus();return false;}
						if (frm.FromEmailAddress.value.indexOf("@") < 1 || frm.FromEmailAddress.value.indexOf(".") < 1) {alert('Please enter a valid email address.');frm.FromEmailAddress.focus();return false;}
						if (frm.StreetAddress1.value == "") {alert('Address is required.');frm.StreetAddress1.focus();return false;}
						if (frm.City.value == "") {alert('City is required.');frm.City.focus();return false;}
						if (frm.Country.value == "") {alert('Country is required.');frm.Country.focus();return false;}
						if (frm.CaptchaCode.value == "") {alert('Enter web form code.');frm.CaptchaCode.focus();return false;}
						return true; }
						function ReloadCaptchaImage(captchaImageId) {
						var obj = document.getElementById(captchaImageId);
						var src = obj.src;
						var date = new Date();
						var pos = src.indexOf('&rad=');
						if (pos >= 0) { src = src.substr(0, pos); }
						obj.src = src + '&rad=' + date.getTime();
						return false; }
					</script>
					
					<div id="errormsg" style="color:red">${ registerpo.errormsg}</div>	
					
					<div class="form-group">
						<label for="UserName">UserName*:</label>
						<!-- <input type="text" class="form-control" id="userName"
							name="userName" placeholder="Enter "> -->
						<%-- <form:input path="userName" cssClass="form-control" />  --%>
						<form:input path="userName" id="userName" cssClass="form-control"></form:input>  
                        
					</div>
					<form:errors path="userName" cssClass="warning"/>	
					
					<div class="form-group">
						<label for="exampleInputPassword1">Password:</label> 
						<%-- <input type="password" class="form-control" id="password"
							name="password" placeholder="Enter Password">
							<form:input path="password" cssClass="form-control" /> --%>
							<form:password path="password" cssClass="form-control"/>
					</div>
					<form:errors path="password" cssClass="warning"/>	
					<div class="form-group">
								<label for="exampleInputPassword1">Confirm Password</label> 
								<form:password path="confirmpassword" cssClass="form-control"/>
							</div>
                   <div id="errormsg" style="color:red">${ registerpo.errormsg}</div>
					<div class="form-group">
						<label for="FirstName">FirstName*:</label> 
					<!-- 	<input type="text" class="form-control" id="FirstName"
							name="firstName" placeholder="Enter First Name"> -->
							<form:input path="firstName" id="firstName" cssClass="form-control"></form:input>  
					</div>
					<form:errors path="firstName" cssClass="warning"/>	
					<div class="form-group">
						<label for="LastName">LastName*:</label> 
						<!-- <input type="text" class="form-control" id="LastName"
							name="lastName" placeholder="Enter Last Name"> -->
							<form:input path="lastName" id="lastName" cssClass="form-control"></form:input>  
					</div>
						<form:errors path="lastName" cssClass="warning"/>	
					<div class="form-group">
						<label for="occupation" id="">Occupation*:</label> 
              <!--  <select id="occupationdropsid" name="occupationdropsname">
            <option value="general" id="">Student</option>
            <option value="sales" id="empid">Employee</option>
        </select> -->
						<!-- <input type="text" class="form-control" id="Occupation"
							name="Occupation" placeholder="Enter Occupation"> -->
							<form:input path="occupation" id="Occupation" cssClass="form-control"></form:input> 
					</div>
					<form:errors path="lastName" cssClass="warning"/>	
					
					<div class="form-group">
						<label for="email">Email address*:</label> 
						<!-- <input type="text" class="form-control" id="email"
							name="email" placeholder="Enter Email Address"> -->
							<form:input path="email" cssClass="form-control"/>
					</div>
					<form:errors path="email" cssClass="warning"></form:errors>
					<div class="form-group">
						<label for="mobileNumber">Cell Phone*:</label> 
						
							<form:input path="mobileNumber" cssClass="form-control"/>
					</div>
					<form:errors path="mobileNumber" cssClass="warning"></form:errors>
					<br/>
					 <input id="skip_Submit" name="skip_Submit" type="submit"  class="btn btn-primary pull-right" value="Submit" />
					<br />
				</form:form>
			</div>
			<div class="col-md-4"></div>
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
</html>