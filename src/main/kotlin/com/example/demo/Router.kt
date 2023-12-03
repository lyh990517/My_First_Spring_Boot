package com.example.demo

import com.example.demo.handler.PostHandler
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import
import org.springframework.data.jpa.repository.config.EnableJpaAuditing
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.http.MediaType
import org.springframework.transaction.annotation.EnableTransactionManagement
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