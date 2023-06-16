package com.rogalix.rogale.repositories

import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository
import com.rogalix.rogale.models.User

@Repository
interface UserRepository : MongoRepository<User, Long> {
    fun findByUsername(username: String): User?
    fun findByEmail(email: String): User?
}