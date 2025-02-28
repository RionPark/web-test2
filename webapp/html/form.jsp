<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- form.jsp -->
<!-- 
HTML METHOD
 1. GET
 2. POST
 3. PUT
 4. DELETE
 
FORM TAG METHOD
 1. GET : SELECT LIST, SELECT ONE
 2. POST : INSERT, UPDATE, DELETE
 -->
<form>
	<p>
	<input type="button" value="버튼">
	<input type="reset">
	<input type="submit">
	</p>
	<p>
	<input type="checkbox" name="hobby" value="등산">등산
	<input type="checkbox" name="hobby" value="드라이브">드라이브
	<input type="checkbox" name="hobby" value="영화">영화
	<br>
	<input type="radio" name="trans" value="남">남
	<input type="radio" name="trans" value="여">여
	</p>
	<p>
	<input type="text">
	<input type="password">
	<input type="number">
	<input type="search">
	<input type="tel">
	<input type="url">
	</p>
	<p>
	<input type="date">
	<input type="datetime-local">
	<input type="month">
	<input type="week">
	<input type="time">
	</p>
	<p>
	 히든<input type="hidden" value="1">히든
	<input type="color">
	<input type="email">
	<input type="file">  
	<input type="image">
	<input type="range">
	</p>
	<button type="button">전송</button>
	<input type="submit" value="전송">
</form>
</body>
</html>