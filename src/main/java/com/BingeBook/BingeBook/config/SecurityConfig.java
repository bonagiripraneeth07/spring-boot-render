package com.BingeBook.BingeBook.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.proxy.NoOp;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception
    {
        http.csrf(customizer->customizer.disable())

                //.authorizeHttpRequests(request->request.anyRequest().authenticated())
                .authorizeHttpRequests(requests -> requests
                        .requestMatchers( "login","users","register","watchbucket/watched/{id}","watchbucket/watchlater/{id}","addwatchlater","addwatched").permitAll() // Allow unauthenticated access to /public/**
                        //.requestMatchers("/admin/**").authenticated() // Restrict access to /admin/** to authenticated users
                        .anyRequest().authenticated() // All other requests require authentication
                )
                .httpBasic(Customizer.withDefaults())
                .sessionManagement(session ->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        return http.build();
    }
    @Autowired
    private UserDetailsService userDetailsService;
    @Bean
    public AuthenticationProvider authProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
         provider.setPasswordEncoder(new BCryptPasswordEncoder(12) );
       // provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
        return provider;
    }
//    @Bean
//    public BCryptPasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }
}
