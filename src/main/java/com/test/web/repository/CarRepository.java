package com.test.web.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.test.web.common.DBCon;
import com.test.web.vo.CarVO;

public class CarRepository {

	public int insertCar(CarVO car) {
		try(Connection con = DBCon.getCon();){
			String sql = "INSERT INTO CAR_INFO(CI_NAME, CI_YEAR)\r\n"
					+ "VALUES(?,?)";
			try(PreparedStatement ps = con.prepareStatement(sql)){
				ps.setString(1, car.getCiName());
				ps.setString(2, car.getCiYear());
				return ps.executeUpdate();
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public int updateCar(CarVO car) {
		try(Connection con = DBCon.getCon()){
			String sql = "UPDATE CAR_INFO\r\n"
					+ "SET CI_NAME=?,\r\n"
					+ "CI_YEAR=?\r\n"
					+ "WHERE CI_NUM=?";
			try(PreparedStatement ps = con.prepareStatement(sql)){
				ps.setString(1, car.getCiName());
				ps.setString(2, car.getCiYear());
				ps.setInt(3, car.getCiNum());
				return ps.executeUpdate();
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public int deleteCar(int ciNum) {
		try(Connection con = DBCon.getCon()){
			String sql = "DELETE FROM CAR_INFO WHERE CI_NUM=?";
			try(PreparedStatement ps = con.prepareStatement(sql)){
				ps.setInt(1, ciNum);
				return ps.executeUpdate();
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public List<CarVO> selectCars(){
		List<CarVO> cars = new ArrayList<>();
		try(Connection con = DBCon.getCon()){
			String sql = "SELECT CI_NUM, CI_NAME, CI_YEAR FROM CAR_INFO";
			try(PreparedStatement ps = con.prepareStatement(sql)){
				try(ResultSet rs = ps.executeQuery()){
					while(rs.next()) {
						CarVO car = new CarVO();
						car.setCiNum(rs.getInt("CI_NUM"));
						car.setCiName(rs.getString("CI_NAME"));
						car.setCiYear(rs.getString("CI_YEAR"));
						cars.add(car);
					}
				}
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return cars;
	}
	
	public CarVO selectCar(int ciNum) {
		try(Connection con = DBCon.getCon()){
			String sql = "SELECT CI_NUM, CI_NAME, CI_YEAR FROM CAR_INFO WHERE CI_NUM=?";
			try(PreparedStatement ps = con.prepareStatement(sql)){
				ps.setInt(1, ciNum);
				try(ResultSet rs = ps.executeQuery()){
					if(rs.next()) {
						CarVO car = new CarVO();
						car.setCiNum(rs.getInt("CI_NUM"));
						car.setCiName(rs.getString("CI_NAME"));
						car.setCiYear(rs.getString("CI_YEAR"));
						return car;
					}
				}
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public static void main(String[] args) {
		CarRepository cr = new CarRepository();
		CarVO car = new CarVO();
		car.setCiName("제네시스");
		car.setCiYear("2010");
		car.setCiNum(2);
	
		List<CarVO> cars = cr.selectCars();
		for(CarVO c : cars) {
			System.out.println(c);
		}
		
		CarVO c = cr.selectCar(2);
		System.out.println(c);
		
	}
}
