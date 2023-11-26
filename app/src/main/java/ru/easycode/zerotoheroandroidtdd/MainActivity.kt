package ru.easycode.zerotoheroandroidtdd

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.easycode.zerotoheroandroidtdd.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var list = ArrayList<String>()
    private val adapter = RecyclerViewAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerView.adapter = adapter
        binding.actionButton.setOnClickListener {
            val text = binding.inputEditText.text.toString()
            adapter.add(text)
            list.add(text)
            binding.inputEditText.text?.clear()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putStringArrayList(KEY, list)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        list = savedInstanceState.getStringArrayList(KEY)!!
        list.forEach {
            adapter.add(it)
        }
    }

    companion object {
        private const val KEY = "key"
    }
}