package com.swaasth.partner.ui.presentation.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.swaasth.partner.ui.presentation.home.component.GreetingsCard
import com.swaasth.partner.ui.presentation.home.component.BannersList
import com.swaasth.partner.ui.presentation.home.component.BookingList
import com.swaasth.partner.ui.presentation.home.component.FiltersList

@Composable
fun HomeScreen(
    onQrClick: () -> Unit,
    onNotificationClick: () -> Unit,
    onDoctorClick: () -> Unit,
) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        item {
            GreetingsCard(onQrClick, onNotificationClick)
        }
        item {
            BannersList()
        }
        item {
            FiltersList()
        }
        item {
            BookingList()
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun HomeScreenPreview() {
    HomeScreen({}, {}, {})
}