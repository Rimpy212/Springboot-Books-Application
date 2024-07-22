package com.books.Books.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class JWTSecurityConfigs {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
        return httpSecurity.csrf(csrf->csrf.disable())
                .cors(cors->cors.disable())
                .authorizeHttpRequests(auth -> auth.requestMatchers(HttpMethod.GET,"/*").permitAll())
                .authorizeHttpRequests(auth-> auth.requestMatchers(HttpMethod.POST,"/*").permitAll())
                .authorizeHttpRequests(auth-> auth.anyRequest().permitAll())
                //.headers(headers -> headers.frameOptions(frameOptions -> frameOptions.sameOrigin()))
                .build();
    }
}
