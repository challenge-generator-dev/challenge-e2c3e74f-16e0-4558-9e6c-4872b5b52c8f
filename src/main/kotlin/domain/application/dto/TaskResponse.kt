package domain.application.dto

import domain.model.Task
import java.time.Instant

data class TaskResponse(
    val id: String,
    val title: String,
    val description: String,
    val status: Task.TaskStatus,
    val createdAt: Instant = Instant.now(),
    val updatedAt: Instant = Instant.now()
) {
    companion object {
        fun fromTask(task: Task): TaskResponse {
            return TaskResponse(
                id = task.id,
                title = task.title,
                description = task.description,
                status = task.status
            )
        }

        fun fromTaskList(tasks: List<Task>): List<TaskResponse> {
            return tasks.map { fromTask(it) }
        }
    }
}

data class ErrorResponse(
    val error: String,
    val message: String,
    val timestamp: Instant = Instant.now()
)