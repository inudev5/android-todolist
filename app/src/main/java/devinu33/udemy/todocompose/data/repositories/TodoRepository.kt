package devinu33.udemy.todocompose.data.repositories

import devinu33.udemy.todocompose.data.TodoDAO
import devinu33.udemy.todocompose.data.models.TodoTask
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TodoRepository @Inject constructor(private val todoDAO: TodoDAO) {
    val getAllTasks: Flow<List<TodoTask>> = todoDAO.getAllTasks()
    val sortByLowPriority: Flow<List<TodoTask>> = todoDAO.sortByLowPriority()
    val sortByHighPriority: Flow<List<TodoTask>> = todoDAO.sortByHighPriority()
    fun selectedTask(taskId: Int): Flow<TodoTask> = todoDAO.getSelectedTask(taskId)
    suspend fun addTask(todoTask: TodoTask) = todoDAO.addTask(todoTask)
    suspend fun updateTask(todoTask: TodoTask) = todoDAO.updateTask(todoTask)
    suspend fun deleteTask(todoTask: TodoTask) = todoDAO.deleteTask(todoTask)
    suspend fun deleteAll() = todoDAO.deleteAllTasks()
    fun searchDatabase(searchQuery: String): Flow<List<TodoTask>> =
        todoDAO.searchDatabase(searchQuery)
}