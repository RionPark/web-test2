package com.test.web.servlet;

import java.util.ArrayList;
import java.util.List;

import com.test.web.vo.UserVO;

class UserInfo{
	private String name;
	private String id;
	private String pwd;
	private String birth;
	private String desc;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
}
public class Test {

	public static int insertUserInfo(UserInfo userInfo) {
		String sql =" insert into user_info.... values(?,?,?,?)";
		return 1;
	}
	
	public static void main(String[] args) {
		UserVO userInfo = new UserVO();
		userInfo.setUiName("동동");
		userInfo.setUiId("id");
		userInfo.setUiPwd("123");
		userInfo.setUiBirth("20211022");
		userInfo.setUiDesc("안녕, 난 동동이야");
		
		List<UserVO> users = new ArrayList<>();
		users.add(userInfo);
		users.add(userInfo);
		users.add(userInfo);
		users.add(userInfo);
		
	}
}












