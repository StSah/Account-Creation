package com.sign.in.service;



import org.json.JSONObject;

public interface IUserService {
	
	public String saveUserDetails(JSONObject jsonObject);
	public String userExists(JSONObject jsonObject);	

}
