package com.example.demo.handler

import com.example.demo.entity.PostEntity
import com.example.demo.repository.PostRepository
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import reactor.core.publisher.Mono
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.body

@Component
class PostHandler(private val postRepository: PostRepository) {
    fun createPost(serverRequest: ServerRequest): Mono<ServerResponse> {
        val postEntity = serverRequest.bodyToMono(PostEntity::class.java)
                .flatMap { postRepository.save(it) }
        return postEntity.flatMap {
            ServerResponse.status(HttpStatus.CREATED)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body<PostEntity>(it)
        }
    }

    fun readPost(serverRequest: ServerRequest): Mono<ServerResponse> =
            ServerResponse.ok().body(postRepository.findAll())

}