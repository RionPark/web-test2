package com.test.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.web.service.CarService;
import com.test.web.util.CmdUtil;
import com.test.web.vo.CarVO;

public class CarServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private CarService cs = new CarService();


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * car-list, car-view
		 * /car/car-list
		 */
		String uri = request.getRequestURI();
		String cmd = CmdUtil.getCmd(uri);
		if("car-list".equals(cmd)) {
			List<CarVO> cars = cs.selectCars();
			request.setAttribute("cars", cars);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views" + uri + ".jsp");
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * insert, update, delete
		 */
	}

}
