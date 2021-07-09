package me.ajay.tasks.ui.tasks

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.launch
import me.ajay.tasks.data.Task
import me.ajay.tasks.data.TasksDao
import javax.inject.Inject

@HiltViewModel
class TasksViewModel @Inject constructor(private val tasksDao : TasksDao) : ViewModel() {

    val searchQuery = MutableStateFlow("")
    val sortOrder = MutableStateFlow(SortOrder.BY_DATE)
    val hideCompleted = MutableStateFlow(false)

    private val tasksFlow = combine(
        searchQuery,
        sortOrder,
        hideCompleted
    ) { query, sortOrder, hideCompleted ->
        Triple(query, sortOrder, hideCompleted)
    }.flatMapLatest { (query, sortOrder, hideCompleted) ->
        tasksDao.getTasks(query, sortOrder, hideCompleted)
    }

    val tasks = tasksFlow.asLiveData()

    fun onSortOrderSelected(sortOrder: SortOrder) = viewModelScope.launch {
        this@TasksViewModel.sortOrder.value = sortOrder
    }

    fun onHideCompletedClick(hideCompleted: Boolean) = viewModelScope.launch {
        this@TasksViewModel.hideCompleted.value = hideCompleted
    }

    fun onTaskSelected(task: Task) {

    }

    fun onTaskCheckedChanged(task: Task, isChecked: Boolean) = viewModelScope.launch {
        tasksDao.update(task.copy(completed = isChecked))
    }

}

enum class SortOrder { BY_NAME, BY_DATE }