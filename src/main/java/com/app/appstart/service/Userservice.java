package com.app.appstart.service;

import java.util.List;

import com.app.appstart.entity.Users;

public interface Userservice {

	
void saveUser(Users user);
	
	Users getUserbyID(Long id);
	
	List<Users> viewall();
	
	Users savUser(Users user);
	
     void deleteuserbyid(long id);
     void deleteinactiveuserbyid(long id);
     List<Users> viewallactiveUser();
		
	String validateuser(String email);
	String validateusermobile(String mobile);

	List<Users> viewallInactiveUser();
}
