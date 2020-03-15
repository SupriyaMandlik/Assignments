<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="pd" uri="/WEB-INF/tlds/tagLibraryDescriptor.tld"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>From Date.jsp page</h1>
	<pd:printDate>
		<h1>Inside printDate tag</h1>
	</pd:printDate>

	<h1>Outside printDate tag</h1>
	<h1>End of page</h1>
</body>
</html>