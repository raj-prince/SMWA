package com.adobe.prj.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	
	@Autowired
	 DataSource dataSource;

	@Autowired
	public void configureGlobalSecurity(AuthenticationManagerBuilder auth)
			throws Exception {
		/*auth.inMemoryAuthentication().withUser("hello").password("world")
				.roles("USER", "ADMIN");*/
		
		auth.jdbcAuthentication().dataSource(dataSource)
		  .usersByUsernameQuery(
		   "select user_name,password,1 from user where user_name=?")
		  .authoritiesByUsernameQuery(
		   "select user_name, user_type from user where user_name=?");
		 } 
	

	@Override
	protected void configure(HttpSecurity http) throws Exception {
<<<<<<< HEAD
		http.authorizeRequests().antMatchers("/login","/").permitAll()
				.antMatchers("/").access("hasRole('0')").and()
=======
		http.authorizeRequests().antMatchers("/login").permitAll()
			.antMatchers("/").access("hasRole('0')").and()
				/*.antMatchers("/*.do/**").access("hasRole('1')").and()*/
>>>>>>> a7d34299747991e6ce79dbd836a8860a2b1cccf0
				.formLogin().and().exceptionHandling()
				.accessDeniedPage("/access-denied");
	}
	
}