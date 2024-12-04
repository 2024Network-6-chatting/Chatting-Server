package com.example.airchat;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SecurityConfig  {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorizeRequests ->
                        authorizeRequests
                                .requestMatchers("/chat/**").permitAll()  // WebSocket 경로에 대한 접근을 허용
                                .requestMatchers("/api/test/**").permitAll()  // /api/test 경로에 대한 접근 허용
                                .anyRequest().authenticated()  // 그 외의 요청은 인증이 필요
                );
        return http.build();
    }
}
