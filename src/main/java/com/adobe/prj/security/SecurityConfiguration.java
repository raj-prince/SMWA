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
		http.authorizeRequests().antMatchers("/login").permitAll()
		.antMatchers("/").access("hasAuthority('0') or hasAuthority('1') or hasAuthority(0) or hasAuthority(1)").and()
				/*.antMatchers("/*.do/**").access("hasRole('1')").and()*/
				.formLogin().and().exceptionHandling()
				.accessDeniedPage("/access-denied");
	}
	
}