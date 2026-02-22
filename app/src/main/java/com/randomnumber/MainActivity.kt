package com.randomnumber

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.randomnumber.ui.MainScreen
import com.randomnumber.ui.RandomNumberTheme

class MainActivity : ComponentActivity() {

    private val schemeStore by lazy { SchemeStore(applicationContext) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RandomNumberTheme {
                MainScreen(schemeStore = schemeStore)
            }
        }
    }
}
