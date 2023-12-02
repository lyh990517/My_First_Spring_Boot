package com.example.demo.controller

import com.example.demo.service.PostService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/posts")
class PostController {

    @Autowired
    private lateinit var postService: PostService

    @GetMapping("")
    fun readPosts() = postService.getAllPosts()

    @PostMapping("/create")
    fun createPost(
            @RequestParam name: String,
            @RequestParam age: Int
    ): String {
        postService.createPost(name, age)
        return ""
    }

    @GetMapping("/edit")
    fun editPage() = "post/edit"

    @GetMapping("/delete")
    fun deletePage() = "post/delete"
}