package com.example.demo.entity

import jakarta.persistence.*
import lombok.Getter
import lombok.Setter
import org.springframework.data.relational.core.mapping.Table

@Entity
@Table(name = "post")
@Getter
data class PostEntity(
        val id: Long = 0,
        val name: String,
        val age: Int
){
        constructor() : this(0, "", 0)
}
