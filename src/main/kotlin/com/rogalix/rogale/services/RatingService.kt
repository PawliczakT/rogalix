package com.rogalix.rogale.services

import com.rogalix.rogale.repositories.RatingRepository
import com.rogalix.rogale.models.Rating
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class RatingService(@Autowired private val ratingRepository: RatingRepository) {

    fun findAll(): List<Rating> = ratingRepository.findAll()

    fun findById(id: Long): Rating? = ratingRepository.findById(id).orElse(null)

    fun save(rating: Rating): Rating = ratingRepository.save(rating)

    fun deleteById(id: Long) = ratingRepository.deleteById(id)
}
