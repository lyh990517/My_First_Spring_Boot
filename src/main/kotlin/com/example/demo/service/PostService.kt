package com.example.demo.service

import com.example.demo.entity.PostEntity
import com.example.demo.repository.PostRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class PostService(private val repository: PostRepository) {

    fun getAllPosts() : List<PostEntity> = repository.findAll()
    fun createPost(name: String, age: Int) : PostEntity{
        val post = PostEntity(name = name, age = age)
        return repository.save(post)
    }

    fun getPostById(id:Long) : PostEntity? {
        return repository.findByIdOrNull(id)
    }

    fun updatePost(id: Long, name: String, age: Int) : PostEntity? {
        val exist = repository.findByIdOrNull(id)
        exist?.let {
            return repository.save(PostEntity(name = name, age = age))
        }
        return null
    }

    fun deletePost(id: Long) = if (repository.findByIdOrNull(id) != null){
        repository.deleteById(id)
        true
    }else {
        false
    }
}