package com.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.dto.FoodInfoDTO;
import com.web.service.FoodInfoService;

public class FoodInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private FoodInfoService fiService = new FoodInfoService();
	protected void proceed() {
		String str ="insert into USER_INFO(UI_NAME, UI_AGE, UI_ID, UI_PWD,\r\n"
				+ "UI_PHONE, UI_ADDRESS, UI_TRANS)\r\n"
				+ "VALUES('홍길동',33,'HONG','HONG1234',\r\n"
				+ "'01000000000','서울시강서구','1')";
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		List<FoodInfoDTO> foodInfos = fiService.getFoodInfos(null);
		out.print("<table border='1'>");
		out.print("<tr>");
		out.print("<th>번호</th>");
		out.print("<th>이름</th>");
		out.print("<th>가격</th>");
		out.print("</tr>");
		for(FoodInfoDTO foodInfo : foodInfos) {
			out.print("<tr>");
			out.println("<td>" + foodInfo.getFiNum() + "</td>");
			out.println("<td>" + foodInfo.getFiName() + "</td>");
			out.println("<td>" + foodInfo.getFiPrice() + "</td>");
			out.print("</tr>");
		}
		out.print("</table>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
