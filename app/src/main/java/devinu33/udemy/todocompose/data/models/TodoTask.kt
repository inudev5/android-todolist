package devinu33.udemy.todocompose.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import devinu33.udemy.todocompose.util.Constants.DATABASE_TABLE

@Entity(tableName = DATABASE_TABLE)
data class TodoTask(
    @PrimaryKey(autoGenerate = true)
    val id:Int=0,
    val title:String,
    val description:String,
    val priority: Priority,
)
