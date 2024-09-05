<%@page import="com.test.web.vo.MenuVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
MenuVO menu = (MenuVO) request.getAttribute("menu");
%>
	<table border ="1">
	   <tr>
	      <th>메뉴명</th>
	      <td><%=menu.getMiName()%></td>
	   </tr>
	   
	   <tr>
	      <th>가격</th>
	      <td><%=menu.getMiPrice()%>원</td>
	   </tr>
	   
	   <tr>
	      <th>메뉴 소개</th>
	      <td><%=menu.getMiDesc()%></td>
	   </tr>
	   <tr>
	   	<th>메뉴 사진</th>
	   	<td><img src="<%=menu.getMiPath()%>"></td>
	   </tr>
	</table>
</body>
</html>