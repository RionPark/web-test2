<%@page import="com.test.web.vo.CarVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1">
	<tr>
		<th>번호</th>
		<th>모델명</th>
		<th>년식</th>
	</tr>
<%
List<CarVO> cars = (List<CarVO>) request.getAttribute("cars");
for(CarVO car : cars){
%>
	<tr>
		<td><%=car.getCiNum()%></td>
		<td><%=car.getCiName()%></td>
		<td><%=car.getCiYear()%></td>
	</tr>
<%
}
%>
</table>
</body>
</html>