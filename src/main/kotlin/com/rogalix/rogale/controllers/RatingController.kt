package com.rogalix.rogale.controllers

import com.rogalix.rogale.models.Rating
import com.rogalix.rogale.services.RatingService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/ratings")
class RatingController(@Autowired private val ratingService: RatingService) {

    @PostMapping
    fun addRating(@RequestBody rating: Rating): Rating {
        return ratingService.save(rating)
    }
}
