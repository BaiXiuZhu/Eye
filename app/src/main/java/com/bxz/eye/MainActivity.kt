package com.bxz.eye

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.bxz.eye.ui.page.Main
import com.bxz.eye.ui.theme.EyeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EyeTheme {
                val navController = rememberNavController()
                Main(navHostController = navController)
            }
        }
    }
}