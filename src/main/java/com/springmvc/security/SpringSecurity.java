package com.springmvc.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;


/*@Configuration
public class SpringSecurity  {
	@Bean
	protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		http.authorizeHttpRequests((auth)->{
			auth.anyRequest().authenticated() ;
		});
		
		return http.build();
		
	}

}*/
