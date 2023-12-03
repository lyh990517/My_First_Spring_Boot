package com.example.demo.repository

import com.example.demo.entity.PostEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.r2dbc.repository.R2dbcRepository
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Repository

@Repository
interface PostRepository: R2dbcRepository<PostEntity,Long> {

}