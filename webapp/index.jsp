<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HTML수업</title>
</head>
<body>
<h3>메뉴</h3>
<ul>
	<li><a href="/foods">음식리스트</a></li>
	<li><a href="/users">유저리스트</a></li>
	<li><a href="/games">게임리스트</a></li>
</ul>
<%
if(session.getAttribute("uiName")!=null){
	String uiName = (String)session.getAttribute("uiName");
	out.println(uiName + "님 반갑습니다.");
}else{
%>
	<a href="/jsp/login.jsp">로그인</a>
<%
}
%>
</body>
</html>