package domain.infrastructure.routing

import domain.application.dto.TaskRequest
import domain.application.dto.TaskResponse
import domain.application.usecase.TaskUseCase
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import java.util.UUID

fun Route.taskRoutes(taskUseCase: TaskUseCase) {
    route("/api/tasks") {
        get {
            try {
                val tasks = taskUseCase.getAllTasks()
                call.respond(tasks)
            } catch (e: Exception) {
                call.respond(
                    status = io.ktor.http.HttpStatusCode.InternalServerError,
                    message = TaskResponse(
                        id = UUID.randomUUID().toString(),
                        title = "Error",
                        description = e.message ?: "Unknown error occurred",
                        status = domain.model.Task.TaskStatus.PENDING
                    )
                )
            }
        }

        post {
            try {
                val request = call.receive<TaskRequest>()
                val createdTask = taskUseCase.createTask(request)
                call.respond(
                    status = io.ktor.http.HttpStatusCode.Created,
                    message = createdTask
                )
            } catch (e: IllegalArgumentException) {
                call.respond(
                    status = io.ktor.http.HttpStatusCode.BadRequest,
                    message = mapOf(
                        "error" to "Validation Error",
                        "message" to (e.message ?: "Invalid request data")
                    )
                )
            } catch (e: Exception) {
                call.respond(
                    status = io.ktor.http.HttpStatusCode.InternalServerError,
                    message = mapOf(
                        "error" to "Internal Server Error",
                        "message" to (e.message ?: "Unknown error occurred")
                    )
                )
            }
        }

        get("/{id}") {
            try {
                val id = call.parameters["id"] ?: run {
                    call.respond(
                        status = io.ktor.http.HttpStatusCode.BadRequest,
                        message = mapOf("error" to "Missing task ID")
                    )
                    return@get
                }
                
                val task = taskUseCase.getAllTasks().find { it.id == id }
                if (task != null) {
                    call.respond(task)
                } else {
                    call.respond(
                        status = io.ktor.http.HttpStatusCode.NotFound,
                        message = mapOf(
                            "error" to "Not Found",
                            "message" to "Task with id $id not found"
                        )
                    )
                }
            } catch (e: Exception) {
                call.respond(
                    status = io.ktor.http.HttpStatusCode.InternalServerError,
                    message = mapOf(
                        "error" to "Internal Server Error",
                        "message" to (e.message ?: "Unknown error occurred")
                    )
                )
            }
        }

        put("/{id}") {
            try {
                val id = call.parameters["id"] ?: run {
                    call.respond(
                        status = io.ktor.http.HttpStatusCode.BadRequest,
                        message = mapOf("error" to "Missing task ID")
                    )
                    return@put
                }

                val request = call.receive<TaskRequest>()
                val updatedTask = taskUseCase.updateTask(id, request)
                call.respond(
                    status = io.ktor.http.HttpStatusCode.OK,
                    message = updatedTask
                )
            } catch (e: IllegalArgumentException) {
                call.respond(
                    status = io.ktor.http.HttpStatusCode.BadRequest,
                    message = mapOf(
                        "error" to "Validation Error",
                        "message" to (e.message ?: "Invalid request data")
                    )
                )
            } catch (e: NoSuchElementException) {
                call.respond(
                    status = io.ktor.http.HttpStatusCode.NotFound,
                    message = mapOf(
                        "error" to "Not Found",
                        "message" to (e.message ?: "Task not found")
                    )
                )
            } catch (e: Exception) {
                call.respond(
                    status = io.ktor.http.HttpStatusCode.InternalServerError,
                    message = mapOf(
                        "error" to "Internal Server Error",
                        "message" to (e.message ?: "Unknown error occurred")
                    )
                )
            }
        }

        delete("/{id}") {
            try {
                val id = call.parameters["id"] ?: run {
                    call.respond(
                        status = io.ktor.http.HttpStatusCode.BadRequest,
                        message = mapOf("error" to "Missing task ID")
                    )
                    return@delete
                }

                val existingTask = taskUseCase.getAllTasks().find { it.id == id }
                if (existingTask != null) {
                    call.respond(
                        status = io.ktor.http.HttpStatusCode.NoContent,
                        message = ""
                    )
                } else {
                    call.respond(
                        status = io.ktor.http.HttpStatusCode.NotFound,
                        message = mapOf(
                            "error" to "Not Found",
                            "message" to "Task with id $id not found"
                        )
                    )
                }
            } catch (e: Exception) {
                call.respond(
                    status = io.ktor.http.HttpStatusCode.InternalServerError,
                    message = mapOf(
                        "error" to "Internal Server Error",
                        "message" to (e.message ?: "Unknown error occurred")
                    )
                )
            }
        }
    }
}