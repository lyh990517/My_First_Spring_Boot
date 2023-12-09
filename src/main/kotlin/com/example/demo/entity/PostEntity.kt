package com.example.demo.entity

import org.springframework.data.relational.core.mapping.Table

@Table(name = "post")
data class PostEntity(
        val id: Long = 0,
        val name: String,
        val age: Int
){
        constructor() : this(0, "", 0)
}
