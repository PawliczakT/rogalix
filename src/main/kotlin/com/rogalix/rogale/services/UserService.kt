package com.rogalix.rogale.services

import com.rogalix.rogale.repositories.UserRepository
import com.rogalix.rogale.models.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException

@Service
class UserService(@Autowired private val userRepository: UserRepository) : UserDetailsService {

    fun findAll(): List<User> = userRepository.findAll()

    fun findByUsername(username: String): User? = userRepository.findByUsername(username)

    fun findByEmail(email: String): User? = userRepository.findByEmail(email)

    fun findById(id: Long): User? = userRepository.findById(id).orElse(null)

    fun save(user: User): User = userRepository.save(user)

    fun deleteById(id: Long) = userRepository.deleteById(id)

    @Throws(UsernameNotFoundException::class)
    override fun loadUserByUsername(username: String): UserDetails {
        val user = userRepository.findByUsername(username)
                ?: throw UsernameNotFoundException("User not found with username: $username")
        return org.springframework.security.core.userdetails.User
                .withUsername(username)
                .password(user.password)
                .authorities(emptyList())
                .accountExpired(false)
                .accountLocked(false)
                .credentialsExpired(false)
                .disabled(false)
                .build()
    }
}