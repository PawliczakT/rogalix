package com.rogalix.rogale.services

import com.rogalix.rogale.models.Rogal
import com.rogalix.rogale.models.RogalStats
import com.rogalix.rogale.repositories.RogalRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service


@Service
class RogalService(@Autowired private val rogalRepository: RogalRepository) {

    fun getAllRogaleOrdered(): List<Rogal> {
        val pageable = PageRequest.of(0, Int.MAX_VALUE)
        return rogalRepository.findAllOrdered(pageable)
    }

    fun getTopRatedRogale(): List<Rogal> {
        val pageable = PageRequest.of(0, 3)
        return rogalRepository.findTopRatedRogale(pageable)
    }

    fun findById(id: Long): Rogal? = rogalRepository.findById(id).orElse(null)

    fun save(rogal: Rogal): Rogal = rogalRepository.save(rogal)

    fun findAll(): List<Rogal> = rogalRepository.findAll()

    fun deleteById(id: Long) = rogalRepository.deleteById(id)

    fun getRogalStats(): List<RogalStats> {
        val rogale = rogalRepository.findAll()
        val rogalStats = mutableListOf<RogalStats>()

        for (rogal in rogale) {
            val totalVotes = rogal.ratings.size
            val averageRating = if (totalVotes > 0) {
                rogal.ratings.map { it.score }.average()
            } else {
                0.0
            }
            rogalStats.add(RogalStats(rogal.id, rogal.name, rogal.imageUrl, totalVotes, averageRating))
        }

        return rogalStats
    }
}
