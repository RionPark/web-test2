package com.web.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.web.config.SessionFactory;
import com.web.dto.FoodInfoDTO;

public class FoodInfoRepository {
	public List<FoodInfoDTO> selectFoodInfos(FoodInfoDTO foodInfo){
		try(SqlSession session = SessionFactory.getSSF().openSession()){
			return session.selectList("mvc.FoodInfoMapper.selectFoodInfos");
		}
	}
	
	public FoodInfoDTO selectFoodInfo(int fiNum) {
		try(SqlSession session = SessionFactory.getSSF().openSession()){
			return session.selectOne("mvc.FoodInfoMapper.selectFoodInfo", fiNum);
		}
	}
	
	public int insertFoodInfo(FoodInfoDTO foodInfo) {
		try(SqlSession session = SessionFactory.getSSF().openSession(true)){
			return session.insert("mvc.FoodInfoMapper.insertFoodInfo", foodInfo);
		}
	}
	
	public int updateFoodInfo(FoodInfoDTO foodInfo) {
		try(SqlSession session = SessionFactory.getSSF().openSession(true)){
			return session.update("mvc.FoodInfoMapper.updateFoodInfo", foodInfo);
		}
	}

	public int deleteFoodInfo(int fiNum) {
		try(SqlSession session = SessionFactory.getSSF().openSession(true)){
			return session.delete("mvc.FoodInfoMapper.deleteFoodInfo", fiNum);
		}
	}
}
