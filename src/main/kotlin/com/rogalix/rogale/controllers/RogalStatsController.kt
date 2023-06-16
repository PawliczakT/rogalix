package com.rogalix.rogale.controllers

import com.rogalix.rogale.models.RogalStats
import com.rogalix.rogale.services.RogalService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/stats")
class RogalStatsController(@Autowired private val rogalService: RogalService) {

    @GetMapping
    fun getRogalStats(): List<RogalStats> {
        return rogalService.getRogalStats()
    }
}
