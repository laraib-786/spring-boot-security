package com.example.demo

import org.springframework.security.authentication.AuthenticationProvider
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.stereotype.Component

@Component
class MyAuthenticationProvider:AuthenticationProvider {
    override fun authenticate(authentication: Authentication?): Authentication? {
        val username = authentication?.name
        val password = authentication?.credentials.toString()
        return if ("Neha" == username && "Sharma" == password) {
            UsernamePasswordAuthenticationToken(username, password, listOf())
        } else null
    }

//Returns true if this AuthenticationProvider supports the indicated Authentication object.
    override fun supports(authentication: Class<*>?): Boolean {
        return authentication == UsernamePasswordAuthenticationToken::class.java
    }
}
