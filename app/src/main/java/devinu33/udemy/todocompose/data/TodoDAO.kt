package devinu33.udemy.todocompose.data

import androidx.room.*
import devinu33.udemy.todocompose.data.models.TodoTask
import kotlinx.coroutines.flow.Flow

@Dao //data-access-object
interface TodoDAO {
    @Query("SELECT * FROM todo_table ORDER BY id ASC")
    fun getAllTasks():Flow<List<TodoTask>>
    @Query("SELECT * FROM todo_table where id=:taskId") //can pass params(
    fun getSelectedTask(taskId:Int):Flow<TodoTask> //Flow는 코루틴 라이브러리로 suspend 키워드가 필요없음

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addTask(todoTask: TodoTask)

    @Update
    suspend fun updateTask(todoTask: TodoTask)

    @Delete
    suspend fun deleteTask(todoTask: TodoTask)

    @Query("DELETE FROM todo_table")
    suspend fun deleteAllTasks()

    @Query("SELECT * FROM todo_table where title LIKE :searchQuery OR description LIKE :searchQuery")
    fun searchDatabase(searchQuery:String):Flow<List<TodoTask>>

    @Query("SELECT * FROM todo_table ORDER BY CASE WHEN priority LIKE 'L%' THEN 1 WHEN priority LIKE 'M%' THEN 2 WHEN priority LIKE 'H%' THEN 3 END")
    fun  sortByLowPriority():Flow<List<TodoTask>>

    @Query("SELECT * FROM todo_table ORDER BY CASE WHEN priority LIKE 'H%' THEN 1 WHEN priority LIKE 'M%' THEN 2 WHEN priority LIKE 'L%' THEN 3 END")
    fun  sortByHighPriority():Flow<List<TodoTask>>
}