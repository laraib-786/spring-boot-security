package com.example.demo
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class DemoApiController {

    @GetMapping("/api/info")
    fun getInfo() = "sample REST api"

    @GetMapping("/info")
    fun getDetails(): String {
        println("before reaching controller")
        return "return details"
    }

    @GetMapping("/hello")
    fun hello(@RequestParam user: String): String {
        return "Hello, world!"
    }

}