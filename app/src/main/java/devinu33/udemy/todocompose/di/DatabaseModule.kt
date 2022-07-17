package devinu33.udemy.todocompose.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import devinu33.udemy.todocompose.data.TodoDatabase

import devinu33.udemy.todocompose.util.Constants.DATABASE_NAME
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context) = Room.databaseBuilder(context, TodoDatabase::class.java, DATABASE_NAME).build()

    @Singleton
    @Provides
    fun provideDAO(database: TodoDatabase) = database.todoDAO()
}