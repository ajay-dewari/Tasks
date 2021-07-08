package me.ajay.tasks.di

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import me.ajay.tasks.data.TaskDatabase

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideTaskDB(app :Application) =
        Room.databaseBuilder(app, TaskDatabase::class.java, "task_db")
            .fallbackToDestructiveMigration()
            .build()

    @Provides
    fun provideTaskDao(taskDB: TaskDatabase) = taskDB.taskDao()

}