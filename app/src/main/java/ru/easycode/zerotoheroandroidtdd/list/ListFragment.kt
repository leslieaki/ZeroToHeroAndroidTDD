package ru.easycode.zerotoheroandroidtdd.list

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.google.android.material.floatingactionbutton.FloatingActionButton
import ru.easycode.zerotoheroandroidtdd.R
import ru.easycode.zerotoheroandroidtdd.core.ProvideViewModel

class ListFragment : Fragment(R.layout.fragment_list) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewModel = (activity as ProvideViewModel).viewModel(ListViewModel::class.java)
        val button = requireActivity().findViewById<FloatingActionButton>(R.id.addButton)
        button.setOnClickListener {
            viewModel.create()
        }
    }
}