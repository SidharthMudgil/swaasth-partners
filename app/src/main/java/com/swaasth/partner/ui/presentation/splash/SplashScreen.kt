package com.swaasth.partner.ui.presentation.splash

import android.os.Handler
import android.os.Looper
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.swaasth.partner.R
import com.swaasth.partner.ui.navigation.Graph
import com.swaasth.partner.ui.theme.White

@Composable
fun SplashScreen(
    navController: NavHostController
) {
    Scaffold {
        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
                .padding(it)
        ) {
            Image(
                painter = painterResource(id = R.drawable.splash),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                alignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .background(White)
            )
        }

        DisposableEffect(Unit) {
            val handler = Handler(Looper.getMainLooper())

            val runnable = {
                navController.navigate(Graph.AUTHENTICATION) {
                    popUpTo(Graph.SPLASH) {
                        inclusive = true
                    }
                }
            }

            handler.postDelayed(runnable, 900)

            onDispose {
                handler.removeCallbacks(runnable)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun SplashScreenPreview() {
    SplashScreen(rememberNavController())
}