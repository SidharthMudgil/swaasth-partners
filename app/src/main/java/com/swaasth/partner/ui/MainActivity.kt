package com.swaasth.partner.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.swaasth.partner.ui.component.NoItemView
import com.swaasth.partner.ui.presentation.MainScreen
import com.swaasth.partner.ui.presentation.SwaasthApp
import com.swaasth.partner.ui.presentation.add_patient.AddPatientScreen
import com.swaasth.partner.ui.presentation.home.HomeScreen
import com.swaasth.partner.ui.presentation.login.LoginScreen
import com.swaasth.partner.ui.presentation.login.OtpScreen
import com.swaasth.partner.ui.presentation.onboarding.OnboardingScreen
import com.swaasth.partner.ui.presentation.profile.BookingHistoryScreen
import com.swaasth.partner.ui.presentation.profile.EditProfileScreen
import com.swaasth.partner.ui.presentation.profile.ProfileScreen
import com.swaasth.partner.ui.presentation.splash.SplashScreen
import com.swaasth.partner.ui.presentation.view_details.ViewDetailsScreen
import com.swaasth.partner.ui.theme.SwaasthTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SwaasthTheme {
                BookingHistoryScreen({})
//                SwaasthApp(rememberNavController())
            }
        }
    }
}