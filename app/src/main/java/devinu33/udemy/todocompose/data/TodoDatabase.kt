package devinu33.udemy.todocompose.data

import androidx.room.Database
import androidx.room.RoomDatabase
import devinu33.udemy.todocompose.data.models.TodoTask

@Database(entities = [TodoTask::class], version = 1, exportSchema = false)
abstract class TodoDatabase:RoomDatabase(){
    abstract fun todoDAO():TodoDAO
}