package com.rogalix.rogale.controllers

import com.rogalix.rogale.services.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import com.rogalix.rogale.models.User

@RestController
@RequestMapping("/profile")
class UserProfileController(@Autowired private val userService: UserService) {

    @GetMapping
    fun getProfile(@AuthenticationPrincipal userDetails: UserDetails): User {
        val username = userDetails.username
        return userService.findByUsername(username)
                ?: throw RuntimeException("User not found with username: $username")
    }
}
