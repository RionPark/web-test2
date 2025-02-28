<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>회원가입</h3>
<form method="GET" action="/jsp/join-ok.jsp">
	<input type="text" name="uiName" placeholder="이름"><br>
	<input type="text" name="uiAge" placeholder="나이"><br>
	<input type="text" name="uiId" placeholder="아이디"><br>
	<input type="password" name="uiPwd" placeholder="비밀번호"><br>
	<input type="text" name="uiPhone" placeholder="전화번호"><br>
	<input type="text" name="uiAddress" placeholder="주소"><br>
	<input type="radio" name="uiTrans" id="men" value="1"><label for="men">남</label>
	<input type="radio" name="uiTrans" id="woman" value="2"><label for="woman">여</label>
	<button>회원가입</button> 
</form>
</body>
</html>