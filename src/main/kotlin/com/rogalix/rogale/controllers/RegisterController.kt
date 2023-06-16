package com.rogalix.rogale.controllers

import com.rogalix.rogale.models.User
import com.rogalix.rogale.services.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/register")
class RegisterController(@Autowired private val userService: UserService, @Autowired private val passwordEncoder: BCryptPasswordEncoder) {

    @PostMapping
    fun register(@RequestBody user: User): User {
        user.password = passwordEncoder.encode(user.password)
        return userService.save(user)
    }

//    @GetMapping
//    fun getAllUsers(): List<User> = userService.findAll()

    @GetMapping
    fun getRegisterForm(): String {
        // Return some data for the register form
        return "Register form data"
    }
}
