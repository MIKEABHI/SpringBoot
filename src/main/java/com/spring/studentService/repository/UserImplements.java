package com.spring.studentService.repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.spring.studentService.model.User;

public class UserImplements implements UserDetails {

	private User user;
	private String username;
	private String password;
	private String roles;
	private List<GrantedAuthority> list;
	
	
	
	public UserImplements(User user) {
		this.username =user.getUsername();
		this.password =user.getPassword();
		this.roles=user.getRoles();
		String rolss[]=roles.split(",");
		
		List<GrantedAuthority> list=new ArrayList<>();
		for(String s:rolss)
		{
			list.add(new SimpleGrantedAuthority(s));
		}
		this.list=list;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
	
		return list;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
