package domain.application.dto

import domain.model.Task
import io.ktor.server.application.*
import io.ktor.server.plugins.requestvalidation.*
import io.ktor.server.request.*
import kotlinx.serialization.Serializable

@Serializable
data class TaskRequest(
    val title: String,
    val description: String,
    val status: Task.TaskStatus
) {
    init {
        require(title.isNotBlank()) { "Title cannot be blank" }
        require(description.isNotBlank()) { "Description cannot be blank" }
    }

    companion object {
        suspend fun fromApplicationCall(call: ApplicationCall): TaskRequest {
            return call.receive<TaskRequest>()
        }

        fun toValidationRequest(): RequestValidationConfig.() -> Unit = {
            validate<TaskRequest> { request ->
                if (request.title.isBlank()) {
                    ValidationResult.Invalid("Title cannot be blank")
                } else if (request.description.isBlank()) {
                    ValidationResult.Invalid("Description cannot be blank")
                } else if (request.title.length < 3) {
                    ValidationResult.Invalid("Title must be at least 3 characters long")
                } else if (request.description.length < 10) {
                    ValidationResult.Invalid("Description must be at least 10 characters long")
                } else {
                    ValidationResult.Valid
                }
            }
        }

        fun validateTitleUniqueness(title: String, existingTitles: Set<String>): ValidationResult {
            return if (existingTitles.contains(title.lowercase())) {
                ValidationResult.Invalid("A task with this title already exists")
            } else {
                ValidationResult.Valid
            }
        }

        fun validateStatusTransition(currentStatus: Task.TaskStatus?, newStatus: Task.TaskStatus): ValidationResult {
            if (currentStatus == null) {
                return ValidationResult.Valid
            }
            
            return when {
                currentStatus == Task.TaskStatus.COMPLETED && newStatus != Task.TaskStatus.COMPLETED -> {
                    ValidationResult.Invalid("Cannot reopen a completed task")
                }
                else -> ValidationResult.Valid
            }
        }
    }

    fun toTask(): Task {
        return Task(
            id = java.util.UUID.randomUUID().toString(),
            title = this.title,
            description = this.description,
            status = this.status
        )
    }

    fun validate(): List<String> {
        val errors = mutableListOf<String>()
        
        if (title.isBlank()) {
            errors.add("Title cannot be blank")
        } else if (title.length < 3) {
            errors.add("Title must be at least 3 characters long")
        } else if (title.length > 100) {
            errors.add("Title cannot exceed 100 characters")
        }
        
        if (description.isBlank()) {
            errors.add("Description cannot be blank")
        } else if (description.length < 10) {
            errors.add("Description must be at least 10 characters long")
        } else if (description.length > 500) {
            errors.add("Description cannot exceed 500 characters")
        }
        
        if (status == null) {
            errors.add("Status is required")
        }
        
        return errors
    }

    fun isValid(): Boolean {
        return validate().isEmpty()
    }
}