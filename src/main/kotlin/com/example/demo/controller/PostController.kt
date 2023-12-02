package com.example.demo.controller

import com.example.demo.service.PostService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/")
class PostController {

    @Autowired
    private lateinit var postService : PostService
    @GetMapping("posts")
    fun getPosts() = postService.getPosts()


}