package com.bookauthor.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {
	// authentication
	@Bean
	public UserDetailsService userDetailsService() {
//		UserDetails user = User.withUsername("Shiva").password(encoder.encode("Jayanth")).roles("USER").build();
//		UserDetails admin = User.withUsername("Soma").password(encoder.encode("Soma123")).roles("ADMIN").build();
//		return new InMemoryUserDetailsManager(user, admin);
		return new UserInfoUserDetailsService();
	}

	// autherization
//	@Bean
//	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
//		return httpSecurity.csrf().disable().authorizeHttpRequests().requestMatchers("/allauthors", "/adduser")
//				.permitAll().and().authorizeHttpRequests().requestMatchers("/**").authenticated().and().formLogin()
//				.and().build();
//	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {

		return httpSecurity.csrf().disable().authorizeHttpRequests().requestMatchers("/allauthors","/addauthor","/update","/delete","usaData").authenticated()
				.anyRequest().permitAll().and().formLogin().loginPage("/login").defaultSuccessUrl("/allauthors")
				.permitAll().and().logout().permitAll().and().build();
//		return httpSecurity.csrf().disable().authorizeHttpRequests().requestMatchers("/logins","/resources/**","/allauthors", "/adduser")
//				.permitAll().and().authorizeHttpRequests().requestMatchers("/**").authenticated().and().formLogin()
//				.and().build();
//		return httpSecurity.authorizeHttpRequests().requestMatchers("/resources/**","webapp/**", "/allauthors", "/adduser")
//				.permitAll().anyRequest("/**").authenticated().and().formLogin().loginPage("/logins").and().csrf().disable().build();
//		return httpSecurity.csrf().disable().authorizeHttpRequests().requestMatchers("/resources/**","webapp/**","/allauthors", "/adduser","/login")
//		.permitAll().and().authorizeHttpRequests().requestMatchers("/**").authenticated().and().formLogin().loginPage("/login").defaultSuccessUrl("/allauthors").failureUrl("/login?error=true").permitAll().and().build();
//		httpSecurity.authorizeHttpRequests().requestMatchers("/resources/**","webapp/**").permitAll().
//		and().
//		authorizeHttpRequests().anyRequest().authenticated().and().formLogin().loginPage("/login").permitAll();
//		return httpSecurity.build();
//		httpSecurity
//        .authorizeRequests(authorizeRequests ->
//            authorizeRequests
////                .requestMatchers("/login").permitAll()
//                .anyRequest().permitAll()
//        )
//        .formLogin(formLogin ->
//            formLogin
//                .loginPage("/login")
//                .permitAll()
//        )
//        .logout(logout ->
//            logout
//                .logoutUrl("/logout")
//                .permitAll()
//        );
//		return httpSecurity.build();
//		 return httpSecurity.authorizeHttpRequests()
//	                .requestMatchers("/resources/**", "/login**", "/signup**", "/about").permitAll()
//	                .anyRequest().authenticated()
//	                .and()
//	            .formLogin()
//	                .loginPage("/logins")
//	                .permitAll()
//	                .and()
//	            .logout()
//	                .permitAll()
//	                .and()
//	            .csrf().disable()
//	            .build();
//		            .authorizeHttpRequests()
//		                .anyRequest().authenticated()
//		                .and()
//		            .formLogin()
//		                .loginPage("/logins")
////		                .defaultSuccessUrl("/allauthors")
//		                .permitAll()
//		                .and()
//		            .logout()
//		                .permitAll()
//		            .and()
//		            .csrf().disable() // disable CSRF protection for simplicity
//		            .build();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider dao = new DaoAuthenticationProvider();
		dao.setUserDetailsService(userDetailsService());
		dao.setPasswordEncoder(passwordEncoder());
		return dao;
	}

}
