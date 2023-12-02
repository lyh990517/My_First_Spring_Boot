package com.example.demo.repository

import com.example.demo.entity.PostEntity
import org.springframework.data.jpa.repository.JpaRepository

interface PostRepository: JpaRepository<PostEntity,Long> {

}