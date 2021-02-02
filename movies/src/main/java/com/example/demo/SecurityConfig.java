package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user = User.withDefaultPasswordEncoder()
                .username("user")
                .password("user")
                .roles("USER")
                .build();

        UserDetails admin = User.withDefaultPasswordEncoder()
                .username("admin")
                .password("admin")
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(user, admin);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic().and().authorizeRequests()
                .antMatchers(HttpMethod.GET, "/api/director/all", "/api/movie/all", "/api/director/id", "/api/movie/all/name", "/api/movie/all/name-asc", "/api/movie/all/year-desc")
                .permitAll()
                .antMatchers(HttpMethod.POST, "/api/movie", "/api/director")
                .hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/api/movie")
                .hasRole("ADMIN")
                //.anyRequest().hasRole("ADMIN")
                .and()
                .formLogin().permitAll()
                .and()
                .logout()
                .permitAll()
                .and()
                .csrf().disable();
    }
}
