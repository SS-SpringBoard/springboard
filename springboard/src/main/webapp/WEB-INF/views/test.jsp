<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page import="java.util.ArrayList"%>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. ${test}</P><br/>
<%=request.getAttribute("test") %>
<%
	ArrayList arr = (ArrayList) request.getAttribute("arr");
%>
<%=arr.size() %>

count=<%=request.getAttribute("count") %>
</body>
</html>
