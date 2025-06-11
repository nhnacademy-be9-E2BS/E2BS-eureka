package com.nhnacademy.eureka.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfig {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

		// CSRF is disabled because this is a stateless REST API using JWT authentication.
		http.csrf(AbstractHttpConfigurer::disable);
		http.authorizeHttpRequests(authorizeRequests -> authorizeRequests
			.anyRequest().permitAll()
		);

		http.httpBasic(Customizer.withDefaults());
		return http.build();
	}
}
