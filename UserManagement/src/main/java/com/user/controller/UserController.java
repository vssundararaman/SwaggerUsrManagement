/**
 * 
 */
package com.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.model.User;
import com.user.repository.UserRepository;

import io.swagger.annotations.Api;

/**
 * @author vssundararaman
 *
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("user")
@Api(value="User Management", description="User Management Api Operations")
public class UserController {

	@Autowired
	private UserRepository userRepository;
	
	
	@GetMapping("/getAllUsers")
	public List<User> getUsers(){
		return userRepository.findAll();
	}
	
	/**
	 * This method helps to get the User based on the id
	 * 
	 * @param id
	 * @return user
	 */
	@GetMapping("/getUser/{id}")
	public User getUser(@PathVariable("id") Long id){
		User user = userRepository.findOne(id);
		return user;		
	}
	
	/**
	 * This method helps to save the user
	 * 
	 * @param user
	 * @return all Users
	 */
	@PostMapping("/saveUser")
	public List<User> saveUser(@RequestBody User user){
		userRepository.save(user);
		return userRepository.findAll();
	}
	
	/**
	 * This method helps to update user based on the Id
	 * 
	 * @param user
	 * @return all Users
	 */
	@PostMapping("/updateUser")
	public List<User> updateUser(@RequestBody User user){
		userRepository.save(user);
		return userRepository.findAll();
	}
	
	/**
	 * This method helps to delete the User based on the Id
	 * 
	 * @param id
	 * @return all Users
	 */
	@GetMapping("/deleteUser/{id}")
	public List<User> deleteUser(@PathVariable("id") Long id){
		userRepository.delete(id);
		return userRepository.findAll();
	}
}
