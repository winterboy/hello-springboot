package com.hehe.demo.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

//import com.hehe.demo.service.UserService;

import io.swagger.v3.oas.annotations.headers.Header;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
//	@Autowired
//	private UserService userService;

	/**
	 * Configures authorization rules for different URL patterns.
	 * @param httpSecurity
	 * @return
	 * @throws Exception
	 */
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
		return httpSecurity.authorizeHttpRequests(authorize -> authorize
								.requestMatchers("/admin/**").hasAuthority("ADMIN")
//								.requestMatchers("/country/**").hasAnyRole("USER", "ADMIN")
								.requestMatchers("/h2-console/**").permitAll()
								.anyRequest().hasAnyAuthority("USER", "ADMIN"))
								.csrf(csrf -> csrf.ignoringRequestMatchers("/h2-console/**"))
								.headers(header -> header.frameOptions(frameOptions -> frameOptions.sameOrigin()))
//								.anyRequest().authenticated())
								.formLogin(form -> form.permitAll())
								.logout(logout -> logout.permitAll())
								.build();
	}
	
	/**
	 * Defines in-memory users and their roles. 
	 * In a real application, this would typically interact with a database or other user store.
	 * @return
	 */
	/*
	@Bean
	public UserDetailsService userDetailsService() {
		UserDetails userRole = User.builder()
								.username("hehe")
								.password(passwordEncoder().encode("hehe"))
								.roles("USER")
								.build();
		UserDetails adminRole = User.builder()
								.username("admin")
								.password(passwordEncoder().encode("hehe"))
								.roles("ADMIN")
								.build();
		return new InMemoryUserDetailsManager(userRole, adminRole);
	}*/
	
	@Bean
	public DataSource dataSourceUser() {
		return new EmbeddedDatabaseBuilder()
					.setType(EmbeddedDatabaseType.H2)
					.addScript(JdbcDaoImpl.DEFAULT_USER_SCHEMA_DDL_LOCATION)
					.build();
	}
	
	/**
	 * Authenticate users using usernames and passwords stored in a database
	 * @return
	 */
	@Bean
	public UserDetailsService userDetailsService() {
		
		 // Uses the default Spring Security schema for users and authorities
		JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSourceUser());
		
        // You can customize table and column names if your schema differs
        // userDetailsManager.setUsersByUsernameQuery("SELECT username, password, enabled FROM my_users WHERE username = ?");
        // userDetailsManager.setAuthoritiesByUsernameQuery("SELECT username, authority FROM my_authorities WHERE username = ?");
		return jdbcUserDetailsManager;
	}
	
	@Bean
	public DaoAuthenticationProvider daoAuthenticationProvider() {
		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider(userDetailsService());
		daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
		return daoAuthenticationProvider;
	}
	
	/**
	 * Specifies the password encoding mechanism (here, BCryptPasswordEncoder).
	 * @return
	 */
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
