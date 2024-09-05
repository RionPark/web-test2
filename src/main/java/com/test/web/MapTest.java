package com.test.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Test{
	private String name;
	private int age;
	private String address;
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Test [name=" + name + ", age=" + age + ", address=" + address + "]";
	}
	
}
public class MapTest {

	public static void main(String[] args) {
		List<Map<String, String>> strs = new ArrayList<>();

		Map<String, String> param = new HashMap<>();
		param.put("filedName", "name");
		param.put("value", "하하");
		strs.add(param);
		
		param = new HashMap<>();
		param.put("filedName", "age");
		param.put("value", "33");
		strs.add(param);
		
		param = new HashMap<>();
		param.put("filedName", "address");
		param.put("value", "서울 강서구");
		strs.add(param);
		Map<String,String> map = new HashMap<>();
		
		for(Map<String,String>m :strs) {
			map.put(m.get("filedName"), m.get("value"));
		}
		
		System.out.println(map);

		Test t = new Test();
		t.setName(map.get("name"));
		t.setAge(Integer.parseInt(map.get("age")));
		t.setAddress(map.get("address"));
		
	}
}
