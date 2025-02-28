<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
pageContext.setAttribute("이름", "홍길동");
request.setAttribute("이름", "request");
session.setAttribute("이름","session");
application.setAttribute("이름","application");
%>

<%
String name =(String) pageContext.getAttribute("이름");
%>

<%=name%>
<%
RequestDispatcher rd = request.getRequestDispatcher("/jsp/scope/request.jsp");
rd.forward(request, response);
%>