package me.ajay.tasks.ui.tasks

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import me.ajay.tasks.R
import me.ajay.tasks.databinding.FragmentTasksBinding

@AndroidEntryPoint
class TasksFragment : Fragment(R.layout.fragment_tasks) {
    private val tasksViewModel : TasksViewModel by viewModels()
    private val tasksAdapter = TasksAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentTasksBinding.bind(view)

        tasksViewModel.tasks.observe(viewLifecycleOwner) {
            tasksAdapter.submitList(it)
        }
        binding.apply {
            recyclerViewTasks.apply {
                adapter = tasksAdapter
                layoutManager = LinearLayoutManager(requireContext())
                setHasFixedSize(true)
            }
        }
    }
}