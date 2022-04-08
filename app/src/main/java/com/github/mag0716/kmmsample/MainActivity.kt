package com.github.mag0716.kmmsample

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.github.mag0716.kmmsample.repository.GitHubRepositoryRepository

class MainActivity : AppCompatActivity() {

    private lateinit var textView: TextView
    private val repository: GitHubRepositoryRepository by lazy {
        (application as App).repository
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.text)

        findViewById<Button>(R.id.button).setOnClickListener {
            lifecycleScope.launchWhenStarted {
                val repositoryList = repository.getRepositoryList("mag0716")
                textView.text = repositoryList.toString()
            }
        }
    }
}