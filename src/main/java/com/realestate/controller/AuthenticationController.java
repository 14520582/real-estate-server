package com.realestate.controller;

import com.realestate.util.JWTTokenUtil;
import com.realestate.entity.Account;

import com.realestate.service.imp.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@CrossOrigin
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JWTTokenUtil jwtTokenUtil;

    @Autowired
    private AccountService userService;
    
    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<?> login(@RequestBody Account loginUser) throws AuthenticationException {
//    	Account loginUser = new Account(username,password);
        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginUser.getUsername(),
                        loginUser.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        Account user = userService.findOne(loginUser.getUsername());
        String token = jwtTokenUtil.generateToken(user);
        user.setToken(token);
        userService.update(user);
        return new ResponseEntity<Account>(user, HttpStatus.OK);
    }
    
	@RequestMapping(value="/account/register",method = RequestMethod.POST)
	public ResponseEntity<Void> addAccount(@RequestBody Account account, UriComponentsBuilder builder) {
		account.setRole("ROLE_USER");
		account.setPassword(bCryptPasswordEncoder.encode(account.getPassword()));
		boolean flag = userService.addAccount(account);
        if (flag == false) {
        	return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/account/{id}").buildAndExpand(account.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	@RequestMapping(value="/account/update", method = RequestMethod.PUT )
	public Account updateAccount(@RequestHeader("Token") String token, @RequestBody Account acc) {
		String username = jwtTokenUtil.getUsernameFromToken(token);
		if(username.equals(acc.getUsername())){
			Account user = userService.getAccountById(acc.getId());
			user.setAddress(acc.getAddress());
			user.setName(acc.getName());
			user.setPhone(acc.getPhone());
			user.setEmail(acc.getEmail());
			return userService.updateAccount(user);
		}else
			return null;
	}
	@RequestMapping(value="/account/changepassword", method = RequestMethod.PUT )
	public Account updatePassword(@RequestHeader("Token") String token,@RequestParam("id") int id, @RequestParam("oldpassword") String oldpassword, @RequestParam("newpassword") String newpassword) {
		String username = jwtTokenUtil.getUsernameFromToken(token);
		Account user = userService.getAccountById(id);
		System.out.println(username + " " + user.getUsername() + " " + bCryptPasswordEncoder.encode(oldpassword) + " " + user.getPassword());
		if(username.equals(user.getUsername()) && bCryptPasswordEncoder.matches(oldpassword, user.getPassword())){
			user.setPassword(bCryptPasswordEncoder.encode(newpassword));
			System.out.println(username + "fffffffffffffffffffffffffffffffffffffffff");
			return userService.updateAccount(user);
		}else{
			return null;
		}
	}
    
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(method = RequestMethod.GET)
	public Account getAccountByName(@RequestParam("name") String name) {
		Account user = userService.findByName(name);
		return user;
	}


}