<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
// application, session, request, page
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
request.setAttribute("abc", "1");
request.setAttribute("abc", true);
request.setAttribute("abc", 1.1);
request.setAttribute("abc", new ArrayList<>());

Object obj = request.getAttribute("abc");
List<String> list = (List<String>)obj; 
%>
</body>
</html>