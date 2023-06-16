package com.rogalix.rogale.repositories

import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository
import com.rogalix.rogale.models.Rating

@Repository
interface RatingRepository : MongoRepository<Rating, Long> {
}