package com.example.nesterenko.lab_1ml

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.nesterenko.lab_1ml.ui.theme.Lab_1MLTheme
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lab_1MLTheme {
                BookTrackerApp()
            }
        }
    }
}


