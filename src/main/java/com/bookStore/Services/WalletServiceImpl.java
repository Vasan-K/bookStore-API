package com.bookstore.Services;


import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.Model.Wallet;
import com.bookstore.Repository.WalletRepository;

@Service
@Transactional
public class WalletServiceImpl implements WalletService {
	
	@Autowired
	private WalletRepository walletRepository;

	@Override
	public Wallet addMoney(Wallet wt) {
		
		if(wt.getUserAmt()%500==0) {
			return this.walletRepository.save(wt);
		}else {
			throw new NullPointerException();
		}
		
	}

	@Override
	public Wallet updateMoney(Wallet wt) {
        Optional<Wallet> wObj = this.walletRepository.findById(wt.getUserid());
		
		if(wObj.isPresent()) {
			 Wallet wlt = wObj.get();
			 if(wt.getUserAmt()%500==0) {
				 wlt.setUserAmt(wt.getUserAmt());
				 return walletRepository.save(wt);
			 }else { 
				 throw new NullPointerException();
			 }
		}else
		{
			throw new NullPointerException();
		}
	}

}
