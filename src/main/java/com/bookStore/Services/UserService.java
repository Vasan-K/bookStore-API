package com.bookstore.Services;

import java.util.List;

import com.bookstore.Model.User;

public interface UserService {
	
	  User createUser(User usr);
	  User updateUser(User usr);
	  
	  List<User> getUsers();
	  
	  User findUserById(int usrID);
	  User suspendUser(User usr);
	  

}
