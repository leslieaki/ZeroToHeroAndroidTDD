package ru.easycode.zerotoheroandroidtdd.list

import android.os.Bundle
import android.view.View
import androidx.activity.BackEventCompat
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import ru.easycode.zerotoheroandroidtdd.R
import ru.easycode.zerotoheroandroidtdd.core.ClearViewModel
import ru.easycode.zerotoheroandroidtdd.core.ProvideViewModel
import ru.easycode.zerotoheroandroidtdd.create.CreateViewModel
import ru.easycode.zerotoheroandroidtdd.main.Navigation
import ru.easycode.zerotoheroandroidtdd.main.Screen

class ListFragment : Fragment(R.layout.fragment_list) {

    private lateinit var viewModel: ListViewModel
    private val onBackPressedCallback = object : OnBackPressedCallback(true) {
        override fun handleOnBackPressed() = viewModel.comeback()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as ProvideViewModel).viewModel(ListViewModel::class.java)
        val button = requireActivity().findViewById<FloatingActionButton>(R.id.addButton)
        requireActivity().onBackPressedDispatcher.addCallback(object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                requireActivity().finish()
            }
        })
        val adapter = Adapter()
        val recyclerView = requireActivity().findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.adapter = adapter
        button.setOnClickListener {
            viewModel.create()
        }

        viewModel.liveData().observe(viewLifecycleOwner) {
            adapter.update(it)
        }

        savedInstanceState?.let {
            viewModel.restore(BundleWrapper.Base(it))
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        viewModel.save(BundleWrapper.Base(outState))
    }

    override fun onDestroyView() {
        super.onDestroyView()
        onBackPressedCallback.remove()
    }
}