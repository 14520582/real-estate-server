package com.realestate;

import java.util.Date;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


public class Main {
	public static void main(String[] args) {
		//get hash password
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		System.out.println(encoder.encode("m123"));
//		Date a = new Date();
//		System.out.println(a.getTime());
	}
}
