package me.ajay.tasks.ui.deletecompletedtasks

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import me.ajay.tasks.data.TasksDao
import me.ajay.tasks.di.ApplicationScope
import javax.inject.Inject

@HiltViewModel
class DeleteCompletedTasksViewModel @Inject constructor(
    private val taskDao: TasksDao,
    @ApplicationScope private val applicationScope: CoroutineScope
): ViewModel() {
    fun onConfirmClick() = applicationScope.launch {
        taskDao.deleteCompletedTasks()
    }
}