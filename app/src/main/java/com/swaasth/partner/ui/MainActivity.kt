package com.swaasth.partner.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.swaasth.partner.ui.presentation.onboarding.component.VerificationDetailsView
import com.swaasth.partner.ui.theme.SwaasthTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SwaasthTheme {
                VerificationDetailsView(    )
//                SwaasthApp(rememberNavController())
            }
        }
    }
}