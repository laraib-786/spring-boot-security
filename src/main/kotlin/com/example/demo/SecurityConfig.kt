package com.example.demo

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.provisioning.InMemoryUserDetailsManager
import org.springframework.security.web.SecurityFilterChain

@Configuration
class SecurityConfig {

//    @Bean
//    fun userDetailsService(): UserDetailsService{
//        val userService = InMemoryUserDetailsManager()
//        val user = User.withUsername("Sneha").password(passwordEncoder().encode("Sharma")).authorities("read").build()
//        userService.createUser(user)
//        return userService
//    }
//
//    @Bean
//    fun passwordEncoder():BCryptPasswordEncoder{
//        return BCryptPasswordEncoder()
//    }

    // Overriding default security in spring boot
    @Bean
    fun filterChain(http : HttpSecurity):SecurityFilterChain{
        http.httpBasic()
        http.authorizeHttpRequests().anyRequest().authenticated()    // how you want to authorize your request
        //http.authorizeHttpRequests().antMatchers("/hello").authenticated().anyRequest().denyAll()

        http.csrf().disable()
        http.headers().frameOptions().disable()
        return http.build()  // returns default security chain
    }
}