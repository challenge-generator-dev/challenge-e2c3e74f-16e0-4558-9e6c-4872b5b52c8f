package com.example

import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.routing.*
import domain.infrastructure.routing.taskRoutes
import domain.application.usecase.TaskUseCase
import domain.infrastructure.repository.TaskRepositoryImpl
import domain.infrastructure.plugins.configureStatusPages

fun main() {
    embeddedServer(Netty, port = 8080, module = Application::module).start(wait = true)
}

fun Application.module() {
    val taskRepository = TaskRepositoryImpl()
    val taskUseCase = TaskUseCase(taskRepository)

    configureStatusPages()

    routing {
        taskRoutes(taskUseCase)
    }
}