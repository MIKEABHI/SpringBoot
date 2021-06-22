package com.spring.studentService.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;


@Configuration
@EnableWebSecurity
//@EnableOAuth2Sso
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired UserDetailsService userDetailsService;
	@Bean
	public AuthenticationProvider authenticationProvider() {
		
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(userDetailsService);
		provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
		return provider;
	}
	

//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//
//		PasswordEncoder passwordEncoder = encoder();
//		auth.inMemoryAuthentication().withUser("admin").password(passwordEncoder.encode("admin")).roles("ADMIN");
//		auth.inMemoryAuthentication().withUser("user").password(passwordEncoder.encode("user")).roles("USER");	
//	}
//
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.csrf().disable()
		.authorizeRequests()
//		.antMatchers("/service/delete").hasRole("USER")
//		.antMatchers("/service/updatestudent").hasRole("USER")
//		.antMatchers("/service*").hasAnyRole("USER","ADMIN")
		.antMatchers("/*").permitAll()
		.and().httpBasic();
	}
//
//	@Bean
//	PasswordEncoder encoder() {
//		return NoOpPasswordEncoder.getInstance();
//	}
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//	    return new BCryptPasswordEncoder();
//	}


}
