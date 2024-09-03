<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!--  req2.jsp  -->

<%=pageContext.getAttribute("name")%><br>
<%=request.getAttribute("name")%><br>
<%=session.getAttribute("name")%><br>
<%=application.getAttribute("name")%><br>