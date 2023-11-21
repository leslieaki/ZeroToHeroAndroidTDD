package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import java.util.TimerTask

class MainActivity : AppCompatActivity() {
    private val viewModel = MainViewModel(LiveDataWrapper.Base(), Repository.Base())
    private lateinit var state: UiState
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.actionButton)
        val textView = findViewById<TextView>(R.id.titleTextView)
        val progressBar = findViewById<ProgressBar>(R.id.progressBar)

        button.setOnClickListener {
            viewModel.load()
        }

        viewModel.liveData().observe(this) {
            it.apply(button, progressBar, textView)
        }
    }
}