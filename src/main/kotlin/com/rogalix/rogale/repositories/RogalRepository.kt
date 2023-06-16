package com.rogalix.rogale.repositories

import com.rogalix.rogale.models.Rogal
import org.springframework.data.domain.Pageable
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.mongodb.repository.Query
import org.springframework.stereotype.Repository


@Repository
interface RogalRepository : MongoRepository<Rogal, Long> {

    @Query(value = "{}", sort = "{'id': 1}")
    fun findAllOrdered(pageable: Pageable): List<Rogal>

    @Query(value = "{}", sort = "{'ratings': -1}")
    fun findTopRatedRogale(pageable: Pageable): List<Rogal>


}