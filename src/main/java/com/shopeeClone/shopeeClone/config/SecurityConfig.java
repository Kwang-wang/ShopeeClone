package com.shopeeClone.shopeeClone.config;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.RememberMeServices;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.authentication.rememberme.TokenBasedRememberMeServices;
import org.springframework.security.web.authentication.rememberme.TokenBasedRememberMeServices.RememberMeTokenAlgorithm;

import com.shopeeClone.shopeeClone.exeption.ApplicationException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Configuration
public class SecurityConfig {

	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}

	@Autowired
	private UserDetailsService userDetailsService;

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
		return httpSecurity
				.csrf(csrf -> csrf.disable())
				.cors(cors -> cors.disable())
				.authorizeHttpRequests(http -> http
				.requestMatchers("/admin**").hasAnyAuthority("ADMIN") // Controller
				.requestMatchers("/admin/**").hasAnyAuthority("ADMIN") // Api
				.requestMatchers("/login", "/images/**").permitAll()
				.requestMatchers("/").permitAll()
				.anyRequest().authenticated())
					.logout(httpLogout -> httpLogout
						.logoutUrl("/logout")
						.logoutSuccessUrl("/login"))
				.formLogin(httpLogin ->
				httpLogin.loginPage("/login")
					.usernameParameter("email")
					.failureHandler(authenticationFailureHandler())
						.permitAll())
				.rememberMe(
						rememberMe -> rememberMe.rememberMeServices(rememberMeServices(userDetailsService)
						))
				.userDetailsService(userDetailsService)
				.httpBasic()
				.and()
				.build();
	}

	@Bean
	RememberMeServices rememberMeServices(UserDetailsService userDetailsService) {
		RememberMeTokenAlgorithm encodingAlgorithm = RememberMeTokenAlgorithm.SHA256;
		TokenBasedRememberMeServices rememberMe = new TokenBasedRememberMeServices("myKey", userDetailsService,
				encodingAlgorithm);
		rememberMe.setMatchingAlgorithm(RememberMeTokenAlgorithm.MD5);
		return rememberMe;
	}

	@Bean
	public AuthenticationFailureHandler authenticationFailureHandler() {
		return new SimpleUrlAuthenticationFailureHandler() {

			@Override
			public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
					AuthenticationException exception) throws IOException, ServletException {
				// http://localhost:8080/login?error=true&message=User%20not%20found
				response.sendRedirect("/login?error=true&message=" + exception.getMessage());
			}

		};
	}

//	@Bean
//	public AuthenticationFailureHandler loginFailureHandler() {
//		return new SimpleUrlAuthenticationFailureHandler() {
//			@Override
//			public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
//					AuthenticationException exception) throws IOException, ServletException {
//				String errorMessage = exception.getMessage();
//				if (exception.getMessage().contains("Bad credentials")) {
//					errorMessage = "Unauthorize";
//				}
//				response.sendRedirect("/login?error=true&message=" + errorMessage);
//			}
//		};
//	}

}
