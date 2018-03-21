package com.kamontat.controllers

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloController {

    @RequestMapping("/greet")
    fun index(): String {
        return "Greetings from Spring Boot!"
    }
}