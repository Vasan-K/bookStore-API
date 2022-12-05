package com.bookstore.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookstore.Model.Wallet;

public interface WalletRepository extends JpaRepository<Wallet,Double>{

}
