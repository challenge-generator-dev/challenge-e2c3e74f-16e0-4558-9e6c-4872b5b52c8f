package domain.infrastructure.repository

import domain.model.Task
import domain.repository.TaskRepository
import java.util.concurrent.ConcurrentHashMap

class TaskRepositoryImpl : TaskRepository {
    private val tasks = ConcurrentHashMap<String, Task>()

    override suspend fun findAll(): List<Task> {
        return tasks.values.toList()
    }

    override suspend fun findById(id: String): Task? {
        return tasks[id]
    }

    override suspend fun findByTitle(title: String): Task? {
        return tasks.values.find { it.title == title }
    }

    override suspend fun save(task: Task): Task {
        tasks[task.id] = task
        return task
    }

    override suspend fun update(task: Task): Task {
        tasks[task.id] = task
        return task
    }

    override suspend fun delete(id: String) {
        tasks.remove(id)
    }
}