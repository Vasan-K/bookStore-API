package com.bookstore.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookstore.Model.User;

public interface UserRepository extends JpaRepository<User,Integer> {

}
