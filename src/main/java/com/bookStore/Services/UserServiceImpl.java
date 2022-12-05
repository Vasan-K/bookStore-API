package com.bookstore.Services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.Model.User;
import com.bookstore.Repository.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public User createUser(User usr) {	
		return userRepository.save(usr);
	}

	@Override
	public User updateUser(User usr) {
		Optional<User> uObj = this.userRepository.findById(usr.getUserid());
		if(uObj.isPresent()) {
			  User uUpdate = uObj.get();
			  uUpdate.setUserid(usr.getUserid());
			  uUpdate.setUserName(usr.getUserName());
			  uUpdate.setUserMail(usr.getUserMail());
			  uUpdate.setUserContact(usr.getUserContact());
			  uUpdate.setCanBorrow(usr.isCanBorrow());
			  return userRepository.save(uUpdate);
		}else {
			throw new NullPointerException();
		}
		
	}

	@Override
	public List<User> getUsers() {
		
		return this.userRepository.findAll();
	}

	@Override
	public User findUserById(int usrID) {
		
		Optional<User> uObj = this.userRepository.findById(usrID);
		
		if(uObj.isPresent()) {
			return uObj.get();
		}else
		{
			throw new NullPointerException();
		}
	}

	@Override
	public User suspendUser(User usr) {
		Optional<User> uObj =this.userRepository.findById(usr.getUserid());
		
		if(uObj.isPresent())
		{
			User uUpdate = uObj.get();
            uUpdate.setUserid(usr.getUserid());
            uUpdate.setUserName(usr.getUserName());
            uUpdate.setUserMail(usr.getUserMail());
            uUpdate.setUserContact(usr.getUserContact());
            uUpdate.setCanBorrow(1);
            return this.userRepository.save(uUpdate);
        }
        else {
            throw new NullPointerException();
        }
    }

}
