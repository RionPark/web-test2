<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!--  req1.jsp  -->
    
<%
pageContext.setAttribute("name", "박경훈");
request.setAttribute("name","동동이");
session.setAttribute("name","선풍기");
application.setAttribute("name","ezen컴퓨터학원");
RequestDispatcher rd = request.getRequestDispatcher("/scope/req2.jsp");
rd.forward(request, response);
%>
