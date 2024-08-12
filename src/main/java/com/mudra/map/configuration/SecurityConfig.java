package com.mudra.map.configuration;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

//    @Bean
//    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//            .authorizeHttpRequests(authz -> authz
//                .requestMatchers("/", "/home").permitAll()  // Allow access to home and root URL without authentication
//                .anyRequest().authenticated()               // Require authentication for other requests
//            )
//            .formLogin(form -> form
//                .loginPage("/signin")                      // Custom login page URL
//                .permitAll()                             // Allow all to access login page
//            )
//            .logout(logout -> logout
//                .permitAll()                             // Allow all to access logout
//            );
//        return http.build();
//    }
//
    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
//
//    @Bean
//    UserDetailsService userDetailsService() {
//        return new CustomUserInfoService(); // Use your implementation of UserDetailsService
//    }
//
//  
//
//   
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        // Circular dependency here if CustomUserDetailsService is using SecurityConfig
//        auth.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder());
//    }
}