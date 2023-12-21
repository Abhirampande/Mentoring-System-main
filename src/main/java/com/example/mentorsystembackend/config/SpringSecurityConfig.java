package com.example.mentorsystembackend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfig {

    @Bean
    public static PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{

        http.csrf().disable()
                .authorizeHttpRequests((authorize) -> {
                    authorize.antMatchers(HttpMethod.POST, "/api/v1/**").hasRole("Admin");
                    authorize.antMatchers(HttpMethod.PUT,"/api/v1/**").hasRole("Admin");
                    authorize.antMatchers(HttpMethod.DELETE,"/api/v1/**").hasRole("Admin");
                    authorize.antMatchers(HttpMethod.POST,"/api/v1/student/**").hasRole("User");
                    authorize.antMatchers(HttpMethod.GET,"/api/v1/**").hasAnyRole("Admin","User");
            authorize.anyRequest().authenticated();

        }).httpBasic(Customizer.withDefaults());
        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService(){
        UserDetails Abhiram = User.builder()
                .username("Abhiram")
                .password(passwordEncoder().encode("Abhiram@123"))
                .roles("User")
                .build();

        UserDetails Mentor = User.builder()
                .username("admin")
                .password(passwordEncoder().encode("admin"))
                .roles("Admin")
                .build();

        return new InMemoryUserDetailsManager(Abhiram, Mentor);
    }
}
