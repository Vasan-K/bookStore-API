package com.bookstore.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.Model.User;
import com.bookstore.Services.UserService;

@RestController
public class UserController {
	
	@Autowired
	public UserService userservice;
	
	@GetMapping("/user")
	private ResponseEntity<List<User>> getAllUsers() {
		return ResponseEntity.ok().body(this.userservice.getUsers());
	}
	
	@GetMapping("/user/{usrID}")
	private User findUserById(@PathVariable int usrID) {
		return this.userservice.findUserById(usrID);
	}
	
	@PostMapping("/user")
    private ResponseEntity<User> createUser(@RequestBody User usr) {
		return ResponseEntity.ok().body(this.userservice.createUser(usr));
		
	}
	
	@PutMapping("/user/{usrId}")
	private ResponseEntity<User> updateUser(@PathVariable int usrId, @RequestBody User usr){
		usr.setUserid(usrId);
		return ResponseEntity.ok().body(this.userservice.updateUser(usr));		
	}
	
	@PutMapping("/user/{usrId}/suspend")
	private ResponseEntity<User> suspendUser(@PathVariable int usrId, @RequestBody User usr){
		usr.setUserid(usrId);
		return ResponseEntity.ok().body(this.userservice.suspendUser(usr));		
	}

}
