package com.github.mag0716.kmmsample

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope

class MainActivity : AppCompatActivity() {

    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.text)

        findViewById<Button>(R.id.button).setOnClickListener {
            lifecycleScope.launchWhenStarted {
                val getGitHubRepositoryList =
                    (application as App).provideGetGitHubRepositoryUseCase()
                val repositoryList = getGitHubRepositoryList("mag0716")
                textView.text = repositoryList.toString()
            }
        }
    }
}