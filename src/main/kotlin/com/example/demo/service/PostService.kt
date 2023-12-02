package com.example.demo.service

import org.springframework.stereotype.Service

@Service
class PostService {

    fun getPosts(): Map<String, String> {
        return mapOf(Pair("hello", "im yunho"))
    }
}