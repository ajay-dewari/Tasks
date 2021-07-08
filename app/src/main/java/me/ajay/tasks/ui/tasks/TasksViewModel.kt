package me.ajay.tasks.ui.tasks

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import me.ajay.tasks.data.Task
import me.ajay.tasks.data.TasksDao
import javax.inject.Inject

@HiltViewModel
class TasksViewModel @Inject constructor(private val tasksDao : TasksDao) : ViewModel() {

    val tasks = tasksDao.getTasks().asLiveData()
}