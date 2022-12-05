package com.bookstore.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.Model.Wallet;
import com.bookstore.Services.WalletService;

@RestController
public class WalletController {

	@Autowired
	public WalletService walletservice;
	
	@PostMapping("/wallet")
	private ResponseEntity<Wallet> addMoney(@RequestBody Wallet wt) {
		return ResponseEntity.ok().body(this.walletservice.addMoney(wt));
		
	}
	
	@PutMapping("/wallet/{userid}")
	private ResponseEntity<Wallet> updateMoney(@PathVariable int userid, @RequestBody Wallet wt){
		wt.setUserid(userid);
		return ResponseEntity.ok().body(this.walletservice.updateMoney(wt));		
	}
	
}
