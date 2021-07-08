package me.ajay.tasks.ui

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import me.ajay.tasks.R

@AndroidEntryPoint
class TasksFragment : Fragment(R.layout.fragment_tasks) {
    private val tasksViewModel : TasksViewModel by viewModels()
}