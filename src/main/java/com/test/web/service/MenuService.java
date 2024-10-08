package com.test.web.service;

import java.util.List;

import com.test.web.repository.MenuRepository;
import com.test.web.vo.MenuVO;

public class MenuService {

	private MenuRepository mr = new MenuRepository();
	

	public List<MenuVO> selectMenus(){
		return mr.selectMenus();
	}
	

	public MenuVO selectMenu(int miNum){
		return mr.selectMenu(miNum);
	}

	public int insertMenu(MenuVO menu) {
		return mr.insertMenu(menu);
	}

	public int updateMenu(MenuVO menu) {
		return mr.updateMenu(menu);
	}

	public int deleteMenu(int miNum) {
		return mr.deleteMenu(miNum);
	}
}
