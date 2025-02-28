
<%@page import="java.sql.PreparedStatement"%>
<%@page import="org.apache.ibatis.reflection.SystemMetaObject"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String uiName = request.getParameter("uiName");
String uiAgeStr = request.getParameter("uiAge");
int uiAge = 0;
try{
	uiAge = Integer.parseInt(uiAgeStr);
}catch(NumberFormatException nfe){
	out.println("나이를 잘못입력하셨습니다. 확인해주세요.");
	out.println("<button onclick='history.back()'>돌아가기</button>");
	return;
}

String uiId = request.getParameter("uiId");
String uiPwd = request.getParameter("uiPwd");
String uiPhone = request.getParameter("uiPhone");
String uiAddress = request.getParameter("uiAddress");
String uiTrans = request.getParameter("uiTrans");

String driverName = "com.mysql.cj.jdbc.Driver";
Class.forName(driverName);

String url = "jdbc:mysql://localhost:3306/ezen";
String username = "root";
String password="r1r2r3";
Connection con = DriverManager.getConnection(url,username, password);

String sql = "insert into USER_INFO(UI_NAME, UI_AGE, UI_ID, UI_PWD,\r\n"
		+ "UI_PHONE, UI_ADDRESS, UI_TRANS)\r\n"
		+ "VALUES(?,?,?,?,\r\n"
		+ "?,?,?)";
PreparedStatement ps = con.prepareStatement(sql);
ps.setString(1,uiName);
ps.setInt(2,uiAge);
ps.setString(3,uiId);
ps.setString(4,uiPwd);
ps.setString(5,uiPhone);
ps.setString(6,uiAddress);
ps.setString(7,uiTrans);
int result = ps.executeUpdate();
if(result==1){
%>
<%=uiName%>님 회원가입에 성공하였습니다.
<%
}else{
%>
	회원가입에 실패하였습니다.<br>
	값을 확인하시기 바랍니다.
<%
}
%>


