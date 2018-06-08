package com.realestate.service.imp;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.realestate.dao.AccountDAO;
import com.realestate.entity.Account;
import com.realestate.service.*;
@Service(value = "accountService")
public class AccountService implements IAccountService{
	@Autowired
	private AccountDAO accountDAO;
	@Override
	public Account getAccountById(int id) {
		Account obj = accountDAO.findOne(id);
		return obj;
	}

	@Override
	public Account findByName(String name) {
		// TODO Auto-generated method stub
		return accountDAO.findByName(name);
	}

	
	@Override
	public synchronized boolean addAccount(Account account) {
	       if (accountDAO.existsByUsername(account.getUsername())) {
	    	   return false;
	       } else {
	    	   accountDAO.save(account);
	    	   return true;
	       }
	}
	@Override
	public Account findOne(String username) {
		return accountDAO.findByUserName(username);
	}
	@Override
	public Account getAccountByUsername(String username) {
		Account obj = accountDAO.findByUserName(username);
		return obj; 
	}
	@Override
	public void update(Account acc) {
		accountDAO.save(acc);
	}

	@Override
	public Account updateAccount(Account acc) {
		// TODO Auto-generated method stub
		return accountDAO.save(acc);
	}

}
