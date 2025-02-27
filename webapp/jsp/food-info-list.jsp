<%@page import="com.web.service.FoodInfoService"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.web.dto.FoodInfoDTO"%>
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
<!-- html 주석이지만 소스보기하면 다 나옴! -->
<%
FoodInfoService fiService = new FoodInfoService();

List<FoodInfoDTO> foodInfos = fiService.getFoodInfos(null);
%>
<table border="1">
	<tr>
		<th>번호</th>
		<th>메뉴명</th>
		<th>가격</th>
	</tr>
<%
for(FoodInfoDTO foodInfo : foodInfos){
%>
	<tr>
		<td><%=foodInfo.getFiNum()%></td>
		<td><%=foodInfo.getFiName()%></td>
		<td><%=foodInfo.getFiPrice()%></td>
	</tr>
<%
}
%>
</table>
</body>
</html>





