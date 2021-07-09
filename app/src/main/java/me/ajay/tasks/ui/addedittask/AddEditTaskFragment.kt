package me.ajay.tasks.ui.addedittask

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import me.ajay.tasks.R
import me.ajay.tasks.databinding.FragmentAddEditTaskBinding

class AddEditTaskFragment : Fragment(R.layout.fragment_add_edit_task) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentAddEditTaskBinding.bind(view)

    }
}