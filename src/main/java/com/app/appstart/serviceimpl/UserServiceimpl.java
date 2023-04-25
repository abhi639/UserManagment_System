package com.app.appstart.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.appstart.entity.Users;
import com.app.appstart.repository.UserRepository;
import com.app.appstart.service.Userservice;
@Service
public class UserServiceimpl implements Userservice{

	
	@Autowired
	private UserRepository userrepo;
	
	@Override
	public void saveUser(Users user) {
		
		userrepo.save(user);
		
	}

	@Override
	public Users getUserbyID(Long id) {
		// TODO Auto-generated method stub
		Users user=userrepo.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid parent ID: " + id));
		
		
			return user;	
	}
	public List<Users> viewall() {
		// TODO Auto-generated method stub
		
		List<Users>user=userrepo.findAll();

		return user;
	}

	@Override
	public Users savUser(Users user) {
		// TODO Auto-generated method stub
		Users use=userrepo.save(user);
		return use;
	}

	@Override
	public void deleteuserbyid(long id) {
		// TODO Auto-generated method stub
		
		
		
		Optional<Users> list=userrepo.findById(id);
		list.ifPresent(user -> {
			Boolean isactive = user.isIsactive();
			if(isactive) {
				
				 user.setIsactive(false);
		  	       this.userrepo.save(user);
				
			}
			
			
			
		});
	
	}

	@Override
	public List<Users> viewallactiveUser() {
		// TODO Auto-generated method stub
		List<Users>user=userrepo.findAllActiveUsers();
		
		
		return user;
	}
	
	@Override
	public List<Users> viewallInactiveUser() {
		// TODO Auto-generated method stub
		List<Users>user=userrepo.findAllInActiveUsers();
		
		
		return user;
	}

	

	@Override
	public String validateuser(String email) {
		
		
	List <Object[]>users=userrepo.findDuplicat(email);
	if(users.isEmpty()) {
		
		
		return "true";
	}	else {
		
		return "false";
		
	}
	
	}

	@Override
	public String validateusermobile(String mobile) {
		// TODO Auto-generated method stub
		List <Object[]>users=userrepo.findDuplicatMobile(mobile);
		if(users.isEmpty()) {
			
			
			return "true";
		}	else {
			
			return "false";
			
		}
	}

	@Override
	public void deleteinactiveuserbyid(long id) {
		// TODO Auto-generated method stub
		
		userrepo.deleteById(id);
		
	}
}
	

	
	
	

