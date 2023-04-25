package com.app.appstart;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.app.appstart.controller.AppController;
import com.app.appstart.entity.Address;
import com.app.appstart.entity.Users;
import com.app.appstart.repository.UserRepository;
import com.app.appstart.service.Userservice;

@AutoConfigureMockMvc
@SpringBootTest()
class UsersmanageApplicationTests {
	
	 @Autowired
	    private MockMvc mockMvc;
	    
	    @MockBean
	    private Userservice userservice;
	    
	  
	  
	    @Test
	    public void testUpdateUser() throws Exception {
	        // Create a sample user object
	        Users user = new Users();
	        user.setU_id(1L);
	        user.setFirst_name("John");
	        user.setLast_name("Doe");
	        user.setEmail("johndoe@example.com");
	        user.setMobile_number("1234567890");
	        user.setPassword("password");
	        user.setIsactive(true);
	        user.setAdress(Collections.singletonList(new Address("1", "Street", "Line 1", "Line 2", "City", "State", "123456")));
	        
	        // Mock the behavior of the userservice to return the sample user object
	        Mockito.when(userservice.getUserbyID(1L)).thenReturn(user);
	        
	        // Perform a POST request to update the user object
	        mockMvc.perform(MockMvcRequestBuilders.post("/user/1/update")
	                .param("first_name", "Jane")
	                .param("last_name", "Doe")
	                .param("email", "janedoe@example.com")
	                .param("mobile_number", "0987654321")
	                .param("password", "newpassword")
	                .param("isactive", "false")
	                .param("adress[0].street", "New Street")
	                .param("adress[0].line1", "New Line 1")
	                .param("adress[0].line2", "New Line 2")
	                .param("adress[0].city", "New City")
	                .param("adress[0].state", "New State")
	                .param("adress[0].pincode", "654321"))
	                .andExpect(MockMvcResultMatchers.status().is3xxRedirection())
	                .andExpect(MockMvcResultMatchers.redirectedUrl("/"));
	        
	        // Verify that the userservice's saveUser method was called with the updated user object
	        Mockito.verify(userservice).saveUser(Mockito.argThat(updatedUser -> {
	            return updatedUser.getU_id() == 1L &&
	                    updatedUser.getFirst_name().equals("Jane") &&
	                    updatedUser.getLast_name().equals("Doe") &&
	                    updatedUser.getEmail().equals("janedoe@example.com") &&
	                    updatedUser.getMobile_number().equals("0987654321") &&
	                    updatedUser.getPassword().equals("newpassword") &&
	                    !updatedUser.isIsactive() &&
	                    updatedUser.getAdress().get(0).getStreet().equals("New Street") &&
	                    updatedUser.getAdress().get(0).getLine1().equals("New Line 1") &&
	                    updatedUser.getAdress().get(0).getLine2().equals("New Line 2") &&
	                    updatedUser.getAdress().get(0).getCity().equals("New City") &&
	                    updatedUser.getAdress().get(0).getState().equals("New State") &&
	                    updatedUser.getAdress().get(0).getPincode().equals("654321");
	        }));
	    }
	
	    @Test
		public void testAddUser() throws Exception {
			Users user = new Users();
			user.setFirst_name("John");
			user.setLast_name("Doe");

			List<String> permanentAdd = Arrays.asList("123 Main St", "Apt 1", "Anytown", "State", "12345", "USA", "Home");
			List<String> currentAdd = Arrays.asList("456 Park Ave", "Suite 2", "Othertown", "State", "67890", "USA", "Work");

			RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/adduser1")
					.param("permanetAdd", permanentAdd.toArray(new String[permanentAdd.size()]))
					.param("currentAdd", currentAdd.toArray(new String[currentAdd.size()]))
					.flashAttr("user", user);

			MvcResult result = mockMvc.perform(requestBuilder).andReturn();

			verify(userservice, times(1)).saveUser(any(Users.class));
		}
	
	    
	    
	    
//
	    @Test
	    public void testDeleteUserById() throws Exception {
	        // Create a user with ID 1
	        Users user = new Users();
	        user.setU_id(1L);
	        user.setFirst_name("John");
	        user.setLast_name("Doe");
	        user.setEmail("johndoe@example.com");
	        user.setIsactive(true);

	        // Mock the UserService's deleteuserbyid method
	        Mockito.doNothing().when(userservice).deleteuserbyid(1L);

	        // Call the deletebyId method with user ID 1
	        mockMvc.perform(get("/user/1/delete"))
	                .andExpect(status().is3xxRedirection())
	                .andExpect(view().name("redirect:/"));

	        // Verify that the UserService's deleteuserbyid method was called with user ID 1
	        Mockito.verify(userservice, times(1)).deleteuserbyid(1L);
	    }
	    
	    
	    @Test
	    public void testView() throws Exception {
	        // Create a list of users to return from UserService's viewallactiveUser method
	        List<Users> users = new ArrayList<>();
	        Users user1 = new Users();
	        user1.setU_id(1L);
	        user1.setFirst_name("John");
	        user1.setLast_name("Doe");
	        user1.setEmail("johndoe@example.com");
	        user1.setIsactive(true);
	        users.add(user1);

	        Users user2 = new Users();
	        user2.setU_id(2L);
	        user2.setFirst_name("Jane");
	        user2.setLast_name("Doe");
	        user2.setEmail("janedoe@example.com");
	        user2.setIsactive(true);
	        users.add(user2);

	        // Mock the UserService's viewallactiveUser method to return the list of users
	        Mockito.when(userservice.viewallactiveUser()).thenReturn(users);

	        // Call the view method of the UserController
	        mockMvc.perform(get("/"))
	                .andExpect(status().isOk())
	                .andExpect(view().name("user"))
	                .andExpect(model().attributeExists("users"))
	                .andExpect(model().attribute("users", users));

	        // Verify that the UserService's viewallactiveUser method was called
	        Mockito.verify(userservice, times(1)).viewallactiveUser();
	    }


}

