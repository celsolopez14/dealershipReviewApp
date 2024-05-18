package com.dealershipreviewapp.dealershipreviewapp.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

import com.dealershipreviewapp.dealershipreviewapp.security.filter.AuthenticationFilter;
import com.dealershipreviewapp.dealershipreviewapp.security.filter.ExceptionHandlerFilter;
import com.dealershipreviewapp.dealershipreviewapp.security.filter.JWTAuthorizationFilter;

import lombok.AllArgsConstructor;

@Configuration
@AllArgsConstructor
public class SecurityConfig {

    private AuthenticationManager authenticationManager;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        AuthenticationFilter authenticationFilter = new AuthenticationFilter(authenticationManager);
        authenticationFilter.setFilterProcessesUrl(SecurityConstants.AUTH_ROUTE);

        http
                .headers((headers) -> headers.frameOptions((frameOptions) -> frameOptions.disable()))
                .csrf((csrf) -> csrf.disable())
                .authorizeHttpRequests(
                        (requests) -> requests
                                .requestMatchers("/h2/**").permitAll()
                                .requestMatchers(HttpMethod.POST, "/user/register").permitAll()
                                .anyRequest().authenticated())
                .addFilterBefore(new ExceptionHandlerFilter(), AuthenticationFilter.class)
                .addFilter(authenticationFilter)
                .addFilterAfter(new JWTAuthorizationFilter(), AuthenticationFilter.class)
                .sessionManagement((session) -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        return http.build();
    }

}
