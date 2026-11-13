package domain.application.usecase

import domain.application.dto.TaskRequest
import domain.application.dto.TaskResponse
import domain.repository.TaskRepository
import io.ktor.server.plugins.*

class TaskUseCase(private val taskRepository: TaskRepository) {
    suspend fun createTask(request: TaskRequest): TaskResponse {
        // TODO(reto): Implementar la lógica para crear una tarea
        // - Validar que el título sea único
        // - Convertir TaskRequest a Task
        // - Guardar la tarea usando el repositorio
        // - Retornar TaskResponse
        throw NotImplementedError("Implementación pendiente")
    }

    suspend fun getAllTasks(): List<TaskResponse> {
        // TODO(reto): Implementar la lógica para listar todas las tareas
        // - Obtener todas las tareas del repositorio
        // - Convertir la lista de Task a lista de TaskResponse
        throw NotImplementedError("Implementación pendiente")
    }

    suspend fun updateTask(id: String, request: TaskRequest): TaskResponse {
        // TODO(reto): Implementar la lógica para actualizar una tarea
        // - Validar que la tarea exista
        // - Validar que el título sea único (excepto para la misma tarea)
        // - Actualizar la tarea usando el repositorio
        // - Retornar TaskResponse
        throw NotImplementedError("Implementación pendiente")
    }
}