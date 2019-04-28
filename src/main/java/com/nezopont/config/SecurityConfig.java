package com.nezopont.config;

import com.nezopont.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {



    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

  

  @Override
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/db/**").permitAll()
                .antMatchers("/login", "/manifest.json", "/icons/**", "/images/**",
              // (development mode) static resources
              "/frontend/**",
              // (development mode) webjars
              "/webjars/**",
              // (development mode) H2 debugging console
              "/h2-console/**",
              // (production mode) static resources
              "/frontend-es5/**", "/frontend-es6/**").permitAll();

        http.csrf().disable();
        http.headers().frameOptions().disable();
    }
}