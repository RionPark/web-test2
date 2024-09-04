package com.test.web.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.test.web.common.DBCon;
import com.test.web.vo.MenuVO;

public class MenuRepository {

	public List<MenuVO> selectMenus(){
		List<MenuVO> menus = new ArrayList<>();
		try(Connection con = DBCon.getCon()){
			String sql = "SELECT MI_NUM, MI_NAME, MI_PRICE, MI_DESC\r\n"
					+ "FROM menu_info";
			try(PreparedStatement ps = con.prepareStatement(sql)){
				try(ResultSet rs = ps.executeQuery()){
					while(rs.next()) {
						MenuVO menu = new MenuVO();
						menu.setMiNum(rs.getInt("MI_NUM"));
						menu.setMiName(rs.getString("MI_NAME"));
						menu.setMiPrice(rs.getInt("MI_PRICE"));
						menu.setMiDesc(rs.getString("MI_DESC"));
						menus.add(menu);
					}
				}
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return menus;
	}
	


	public MenuVO selectMenu(int miNum){
		try(Connection con = DBCon.getCon()){
			String sql = "SELECT MI_NUM, MI_NAME, MI_PRICE, MI_DESC\r\n"
					+ "FROM menu_info WHERE MI_NUM=?";
			try(PreparedStatement ps = con.prepareStatement(sql)){
				ps.setInt(1, miNum);
				try(ResultSet rs = ps.executeQuery()){
					if(rs.next()) {
						MenuVO menu = new MenuVO();
						menu.setMiNum(rs.getInt("MI_NUM"));
						menu.setMiName(rs.getString("MI_NAME"));
						menu.setMiPrice(rs.getInt("MI_PRICE"));
						menu.setMiDesc(rs.getString("MI_DESC"));
						return menu;
					}
				}
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public int insertMenu(MenuVO menu) {
		try(Connection con = DBCon.getCon()){
			String sql = "INSERT INTO menu_info(MI_NAME, MI_PRICE, MI_DESC)\r\n"
					+ "VALUES(?,?,?)";
			try(PreparedStatement ps = con.prepareStatement(sql)){
				ps.setString(1,menu.getMiName());
				ps.setInt(2, menu.getMiPrice());
				ps.setString(3, menu.getMiDesc());
				return ps.executeUpdate();
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public int updateMenu(MenuVO menu) {
		try(Connection con = DBCon.getCon()){
			String sql = "UPDATE menu_info\r\n"
					+ "SET MI_NAME=?,\r\n"
					+ "MI_PRICE=?,\r\n"
					+ "MI_DESC=?\r\n"
					+ "WHERE MI_NUM=?";
			try(PreparedStatement ps = con.prepareStatement(sql)){
				ps.setString(1,menu.getMiName());
				ps.setInt(2, menu.getMiPrice());
				ps.setString(3, menu.getMiDesc());
				ps.setInt(4, menu.getMiNum());
				return ps.executeUpdate();
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public int deleteMenu(int miNum) {
		try(Connection con = DBCon.getCon()){
			String sql = "DELETE FROM menu_info WHERE MI_NUM=?";
			try(PreparedStatement ps = con.prepareStatement(sql)){
				ps.setInt(1, miNum);
				return ps.executeUpdate();
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public static void main(String[] args) {
		MenuRepository mr = new MenuRepository();
		List<MenuVO> menus = mr.selectMenus();
		System.out.println(menus);
		MenuVO menu = mr.selectMenu(3);
		System.out.println(menu);
		
		menu.setMiDesc("드럽게 맛없네~~~");
		mr.updateMenu(menu);
		menu = mr.selectMenu(3);
		System.out.println(menu);
		
		mr.deleteMenu(3);

		menu = mr.selectMenu(3);
		System.out.println(menu);
		
	}
}
