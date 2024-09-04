package com.test.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapTest2 {

	public static void main(String[] args) {
		List<Map<String,String>> maps = new ArrayList<>();
		
		for(int i=1;i<=5;i++) {
			Map<String,String> map = new HashMap<>();
			map.put("name", "이름" + i);
			maps.add(map);
		}
		
		for(Map<String,String> m: maps) {
			System.out.println(m);
		}
		
	}
}
