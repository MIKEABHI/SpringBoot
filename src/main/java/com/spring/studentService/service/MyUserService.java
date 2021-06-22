package com.spring.studentService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.spring.studentService.model.User;
import com.spring.studentService.repository.UserImplements;
import com.spring.studentService.repository.UserRepo;

@Service
public class MyUserService implements UserDetailsService {

	
	@Autowired UserRepo uRepo;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = uRepo.findByUsername(username);
		if (user==null) {
			throw new UsernameNotFoundException("USER NOT FOUND");
		}
		return new UserImplements(user);
	}

}
