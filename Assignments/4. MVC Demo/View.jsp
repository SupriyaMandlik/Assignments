<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1>Form View.jsp page</h1>

	<h3><%=request.getAttribute("userName")%></h3>
	<h3><%=request.getAttribute("password")%></h3>

	<a href="Logout.jsp">Logout</a>

</body>
</html>
tml>
