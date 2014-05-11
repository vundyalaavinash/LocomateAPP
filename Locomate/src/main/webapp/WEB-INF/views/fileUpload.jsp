<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	<form:form method="post" action="save" modelAttribute="uploadForm"
		enctype="multipart/form-data">

		<p>Select files to upload. Press Add button to add more file
			inputs.</p>

		<input id="addFile" type="button" value="Add File" />
		<table id="fileTable">
			<tr>
				<td><input name="files[0]" type="file" /></td>
			</tr>
		</table>
		<br />
		<input type="submit" value="Upload" />
	</form:form>
</body>
</html>