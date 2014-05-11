<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

 <head>
 <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

 <title>Spring MVC Multiple File Upload</title>

 </head>

 <body>

 <h1>Spring Multiple File Upload example</h1>

   <hr width=600 >

<p align="center">
<c:out value="${filepath}"></c:out>
<img src="${filepath}" alt="Upload Image" />

<br>

<c:out value="FileName :: "></c:out>

<c:out value="${fileName}"></c:out>

<c:out value="-Uploaded Successfully."></c:out>

</p>
 </body>

</html>
