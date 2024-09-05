package com.test.web.servlet;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.test.web.service.MenuService;
import com.test.web.util.CmdUtil;
import com.test.web.vo.MenuVO;

public class MenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MenuService ms = new MenuService();
	
	private static final String UPLOAD_PATH = "C:\\dev\\workspace\\web-test2\\src\\main\\webapp\\upload\\";
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 *  menu-list, menu-view, menu-update
		 */
		String uri = request.getRequestURI();
		String cmd = CmdUtil.getCmd(uri);
		if("menu-list".equals(cmd)) {
			List<MenuVO> menus = ms.selectMenus();
			request.setAttribute("menus", menus);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views" + uri + ".jsp");
			rd.forward(request, response);
		}
	}

	static Map<String,String> getMap(List<FileItem> items){
		Map<String,String> param = new HashMap<>();
		try {
			for(FileItem item : items) {
				if(item.isFormField()) {
					param.put(item.getFieldName(), item.getString("UTF-8"));
				}else {
					String fileName = item.getName();
					int idx = fileName.lastIndexOf(".");
					fileName = System.nanoTime() + fileName.substring(idx);
					File f = new File(UPLOAD_PATH + fileName);
					item.write(f);
					param.put(item.getFieldName(), "/upload/" + fileName);
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return param;
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		System.out.println(isMultipart);
		if(isMultipart) {
			DiskFileItemFactory factory = new DiskFileItemFactory();
			factory.setSizeThreshold(1024*1024*1024);
			factory.setRepository(new File(UPLOAD_PATH));
			
			ServletFileUpload sfu = new ServletFileUpload(factory);
			try {
				List<FileItem> items = sfu.parseRequest(request);
				Map<String,String> param = getMap(items);
				
				MenuVO menu = new MenuVO();
				menu.setMiName(param.get("miName"));
				menu.setMiPrice(Integer.parseInt(param.get("miPrice")));
				menu.setMiDesc(param.get("miDesc"));
				menu.setMiPath(param.get("miImg"));
				ms.insertMenu(menu);
			} catch (FileUploadException e) {
				e.printStackTrace();
			}
		}else {
			
		}
		
	}

}
