package com.web.service;

import java.util.List;

import com.web.dto.FoodInfoDTO;
import com.web.repository.FoodInfoRepository;

public class FoodInfoService {

	private FoodInfoRepository fiRepo = new FoodInfoRepository();

	public List<FoodInfoDTO> getFoodInfos(FoodInfoDTO foodInfo) {
		return fiRepo.selectFoodInfos(foodInfo);
	}
	public FoodInfoDTO getFoodInfo(int fiNum) {
		return fiRepo.selectFoodInfo(fiNum);
	}
	public int insertFoodInfo(FoodInfoDTO foodInfo) {
		return fiRepo.insertFoodInfo(foodInfo);
	}
	public int updateFoodInfo(FoodInfoDTO foodInfo) {
		return fiRepo.updateFoodInfo(foodInfo);
	}
	public int deleteFoodINfo(int fiNum) {
		return fiRepo.deleteFoodInfo(fiNum);
	}
	
}
