package com.greatlearning.employee_management.security;

import static org.springframework.http.HttpMethod.GET;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.greatlearning.employee_management.serviceImpl.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Bean
	public UserDetailsService userDetailsService() {
		return new UserDetailsServiceImpl();
	}

	@Bean
	public BCryptPasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public DaoAuthenticationProvider customAuthenticationProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();

		authProvider.setUserDetailsService(userDetailsService());
		authProvider.setPasswordEncoder(getPasswordEncoder());

		return authProvider;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(customAuthenticationProvider());
	}

	//ignoring authentication for h2 as it has built-in authentication
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/h2-console/**");
	}

	/*
	 * USER can only access GET mappings. All other mappings to be accessed by ADMIN
	 * home "/" url can be accessed by even unauthenticated users
	 */
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.cors().disable();
		
		http.authorizeRequests()
		.antMatchers(GET, "/api/employee").hasAnyRole("USER", "ADMIN")
		.antMatchers(GET, "/api/user/**").hasAnyRole("USER", "ADMIN")
		.antMatchers(GET, "/api/role/**").hasAnyRole("USER", "ADMIN")
		.and().authorizeRequests()
		.antMatchers(HttpMethod.POST, "/api/employee/**").hasRole("ADMIN")
		.antMatchers(HttpMethod.PUT, "/api/employee/**").hasRole("ADMIN")
		.antMatchers(HttpMethod.DELETE, "/api/employee/**").hasRole("ADMIN")
		.antMatchers(HttpMethod.POST, "/api/user/**").hasRole("ADMIN")
		.antMatchers(HttpMethod.PUT, "/api/user/**").hasRole("ADMIN")
		.antMatchers(HttpMethod.DELETE, "/api/user/**").hasRole("ADMIN")
		.antMatchers(HttpMethod.POST, "/api/role/**").hasRole("ADMIN")
		.antMatchers(HttpMethod.PUT, "/api/role/**").hasRole("ADMIN")
		.antMatchers(HttpMethod.DELETE, "/api/role/**").hasRole("ADMIN")
		.and().authorizeRequests()
		.antMatchers("/").permitAll()
		.anyRequest().authenticated()
		.and()
		.formLogin().defaultSuccessUrl("/api/employee", true).permitAll()
		.and().httpBasic();
	}
}
