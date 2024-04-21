package com.swaasth.partner.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.swaasth.partner.ui.presentation.SwaasthApp
import com.swaasth.partner.ui.presentation.splash.SplashScreen
import com.swaasth.partner.ui.theme.SwaasthTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SwaasthTheme {
                SplashScreen()
//                SwaasthApp(rememberNavController())
            }
        }
    }
}