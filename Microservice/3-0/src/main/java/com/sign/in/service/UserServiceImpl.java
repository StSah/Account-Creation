package com.sign.in.service;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sign.in.entity.User;
import com.sign.in.repository.IUserRepository;


@Service
public class UserServiceImpl implements IUserService {



	@Autowired
	IUserRepository userRepository;
	User user= null;
	int userId = 0;

	@Override
	public String saveUserDetails(JSONObject jsonObject) {
		user= new User();
		List<String> emailId =null;
		String jsonEmailId  =null;
		String jsonPassword=jsonObject.getString("password");
		String jsonConfirmPassword=jsonObject.getString("confirmPassword");
		jsonEmailId=jsonObject.getString("emailid");


		try {
			// TODO Auto-generated method stub	
			if(!jsonEmailId.isEmpty() && emailValidation(jsonEmailId)) {

				emailId = userRepository.getEmailidList();

				if(!emailId.isEmpty()) {	
					for(String email:emailId) {
						if(email.equals(jsonEmailId))
							return "This user already exists";
						else 
							user.setEmailId(jsonEmailId);	
					}
				}
				else {
					user.setEmailId(jsonEmailId);
				}
				if(!jsonPassword.isEmpty() &&!jsonConfirmPassword.isEmpty()) {
					user.setPassword(jsonPassword);
				if(jsonPassword.equals(jsonConfirmPassword)) {
					user.setConfirmPassword(jsonConfirmPassword);
					userRepository.save(user);
					userId=user.getUserId();
				}
				else 
					return "Password not matched";
				}else 
					return "Choose a password for your account";
			}
			else {
				return "Enter a valid email address";
			}

		}
		catch (JSONException e) {
			// TODO Auto-generated catch block
			return e.getMessage();
		}


		return "Your account has been created successfully";
	}

	@Override
	public String userExists(JSONObject jsonObject) {
		String result=null;
		try {
			
			String emailId= jsonObject.getString("email");
			String password= jsonObject.getString("password");
			if(!emailId.isEmpty() && emailValidation(emailId)) {
				String checkPassword= userRepository.getEmailId(emailId);
				if(!password.isEmpty()) {
					if(checkPassword!=null) {
						if(password.equals(checkPassword))
							result= "You are logged in successfully";
						//else if(password.isEmpty())
						//	result="All fields are mandatory"; 
						else 
							result= "Please enter your correct password";
					}
					else 
						result= "This user does not exists";
				}
				else 
					result="Enter your password";		
			}
			else
				result="Enter a valid Email.";
		}
		catch(Exception e) {
			result= e.getMessage();
		}
		return result;
	}

public boolean emailValidation(String email) {
	String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
	 
	Pattern pattern = Pattern.compile(regex);
	 
	    Matcher matcher = pattern.matcher(email);
	    if(matcher.matches())
	    	return true;
	    else
	    	return false;
}
}
