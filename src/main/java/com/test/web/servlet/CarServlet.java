package com.test.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
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
		 *  /car/car-view
		 */
		String uri = request.getRequestURI();
		String cmd = CmdUtil.getCmd(uri);
		if("car-list".equals(cmd)) {
			List<CarVO> cars = cs.selectCars();
			request.setAttribute("cars", cars);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views" + uri + ".jsp");
			rd.forward(request, response);
		}else if("car-view".equals(cmd) || "car-update".equals(cmd)) {
			int ciNum = Integer.parseInt(request.getParameter("ciNum"));
			CarVO car = cs.selectCar(ciNum);
			request.setAttribute("car", car);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views" + uri + ".jsp");
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 *  car-insert, car-update, car-delete
		 */
		request.setCharacterEncoding("UTF-8");
		String uri = request.getRequestURI();
		String cmd = CmdUtil.getCmd(uri);
		CarVO car = new CarVO();
		car.setCiName(request.getParameter("ciName"));
		car.setCiYear(request.getParameter("ciYear"));
		if("car-insert".equals(cmd)) {
			int result = cs.insertCar(car);
			String msg = "차량등록이 실패하였습니다.";
			String url = "/views/car/car-insert";
			if(result == 1) {
				msg = "차량등록이 성공하였습니다.";
				url = "/car/car-list";
			}
			request.setAttribute("msg", msg);
			request.setAttribute("url", url);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
			rd.forward(request, response);
			return;
		}else if("car-update".equals(cmd)) {
			int ciNum = Integer.parseInt(request.getParameter("ciNum"));
			car.setCiNum(ciNum);
			int result = cs.updateCar(car);
			String msg = "차량수정이 실패하였습니다.";
			String url = "/car/car-update?ciNum=" + ciNum;
			if(result == 1) {
				msg = "차량수정이 성공하였습니다.";
				url = "/car/car-view?ciNum=" + ciNum;
			}
			request.setAttribute("msg", msg);
			request.setAttribute("url", url);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
			rd.forward(request, response);
			return;
			
		}else if("car-delete".equals(cmd)) {
			int ciNum = Integer.parseInt(request.getParameter("ciNum"));
			int result = cs.deleteCar(ciNum);
			String msg = "차량삭제가 실패하였습니다.";
			String url = "/car/car-view?ciNum=" + ciNum;
			if(result == 1) {
				msg = "차량삭제가 성공하였습니다.";
				url = "/car/car-list";
			}
			request.setAttribute("msg", msg);
			request.setAttribute("url", url);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
			rd.forward(request, response);
			return;
			
		}
	}

}
