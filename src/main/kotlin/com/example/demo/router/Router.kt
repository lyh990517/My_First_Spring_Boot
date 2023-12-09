package com.example.demo.router

import com.example.demo.handler.PostHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.server.router


@Configuration
class Router (private val postHandler: PostHandler){

    @Bean
    fun postDataRoute() =
        router {
            ("/posts" and accept(MediaType.APPLICATION_JSON)).nest {
                GET("",postHandler::readPost)
            }
        }

}