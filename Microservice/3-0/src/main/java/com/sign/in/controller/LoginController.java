package com.sign.in.controller;


import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sign.in.service.IUserService;



@RestController
@RequestMapping("/loginUser")
public class LoginController {
	
	JSONObject jsonData= new JSONObject();
	
	@Autowired
	IUserService  userService;
	
	
	@RequestMapping(value ="/signUpUser", method=RequestMethod.POST,produces="application/json")
	public String signUpUser(@RequestBody String jsonString) {
		JSONObject jObject = new JSONObject(jsonString);
		return userService.saveUserDetails(jObject);
	}

	@RequestMapping(value ="/signInUser",method=RequestMethod.POST,produces="application/json")
	@ResponseBody
	public String signInUser(@RequestBody String jsonString) {
		JSONObject jObject = new JSONObject(jsonString);

		return userService.userExists(jObject);
	}
	
}
