<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>From Third.jsp page</h1>

	<%
		response.setIntHeader("Refresh", 9);
	%>

	<!-- com.cts.bean.LoginBean ref = new LoginBean() -->
	<jsp:useBean id="ref" class="com.cts.bean.LoginBean" scope="session" />

	<!--ref.getUserName(request.getParameter("userName"))  -->
	<jsp:getProperty property="userName" name="ref" />
	<jsp:getProperty property="password" name="ref" />
</body>
</html>