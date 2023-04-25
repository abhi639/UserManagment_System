package com.app.appstart.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.appstart.entity.Address;
import com.app.appstart.entity.Users;
import com.app.appstart.service.Userservice;

@Controller
public class AppController {

	@Autowired
	private Userservice userservice;
	//retrieves a user object
	@GetMapping("/")
	public String view(Model model) {
		
		List<Users>users=userservice.viewallactiveUser();
			
		model.addAttribute("users", users);
		
		return "user";
	}
	//this method to handle isactive method
	@GetMapping("/inactiveUser")
	public String viewinactiveuser(Model model) {
		
		List<Users>users=userservice.viewallInactiveUser();
			
		model.addAttribute("users", users);
		
		return "incativuser";
	}
/*    
 @Getmapping(/user/{id})
 * */
	
	//modelattribute is user for bind the user object with html
	//save updated user object 
	@PostMapping("/user/{U_id}/update")
	public String UpdateUser(@PathVariable("U_id") Long id,@ModelAttribute("user") Users Updateuser,BindingResult result) {
		
		if(result.hasErrors()) {
			
			
			return"updateuser";
		}
		Users user=userservice.getUserbyID(id);
		user.setFirst_name(Updateuser.getFirst_name());
		user.setLast_name(Updateuser.getLast_name());
		user.setDateof_birth(Updateuser.getDateof_birth());
		user.setEmail(Updateuser.getEmail());
		user.setIsactive(Updateuser.isIsactive());
		user.setMobile_number(Updateuser.getMobile_number());
		Updateuser.getPassword();
		
		//user.setAdress();
		List<Address> list1 = new ArrayList<>();
		for (Address a : Updateuser.getAdress()) {
		    Address newAddress = new Address(a.getAdd_id(), a.getStreet(), a.getLine1(), a.getLine2(), a.getCity(), a.getState(), a.getPincode());
		    newAddress.setAdress_type(a.getAdress_type());
		    list1.add(newAddress);
		}
		user.setAdress(list1);
	//	System.out.println("id---------"+add1.getAdd_id());
		
		for(Address add:Updateuser.getAdress()) {
			
			System.out.println(add.getAdd_id());
			System.out.println(add.getCity());
		}
		
		
		
//		user.setAdress(Updateuser.getAdress());
//	     
       userservice.saveUser(user);
		
	return "redirect:/";
	}
	
//	
@GetMapping("/user/{U_id}/edit")
public String showedietForm(@PathVariable("U_id") Long U_id, Model model) {
	Users user=userservice.getUserbyID(U_id);
	
	model.addAttribute("user", user);
    return "updateuser";	
	
}
//adduser form is return
	@GetMapping("/adduser")
	public String adduser(ModelMap model) {
		Users user=new Users();
		List<Address>address=new ArrayList<>();
		address.add(new Address());
		
		user.setAdress(address);
		model.addAttribute("user", user);
		return "adduser";
	}
	
	//saves te user object 
	@PostMapping("/adduser1")
	public String addUser(@ModelAttribute("user") Users user, 
	                       @RequestParam("permanetAdd") List<String> permanentAdd, 
	                       @RequestParam("currentAdd") List<String> currentAdd) {
		
		
		user.setAdress(Arrays.asList(
	        new Address(permanentAdd.get(0), permanentAdd.get(1), permanentAdd.get(2), permanentAdd.get(3), permanentAdd.get(4), permanentAdd.get(5), permanentAdd.get(6)),
	        new Address(currentAdd.get(0), currentAdd.get(1), currentAdd.get(2), currentAdd.get(3), currentAdd.get(4), currentAdd.get(5), currentAdd.get(6))
	    ));
	    userservice.saveUser(user);
	    return "redirect:/";
	}
	//user will be  soft deleted
	@GetMapping("/user/{u_id}/delete")
	public String deletebyId(@PathVariable Long u_id, Model model) {
		userservice.deleteuserbyid(u_id);
		
		
		return "redirect:/";
	}
	@GetMapping("/inactiveuser/{u_id}/delete")
	public String deletebyId1(@PathVariable Long u_id, Model model) {
		userservice.deleteinactiveuserbyid(u_id);
		
		
		return "redirect:/inactiveUser";
	}
}
