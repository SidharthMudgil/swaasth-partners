package com.swaasth.partner.ui.presentation.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.swaasth.partner.domain.model.Notification
import com.swaasth.partner.ui.component.NoItemView
import com.swaasth.partner.ui.presentation.home.component.NotificationItem

@Composable
fun NotificationsScreen() {
    val notifications = listOf(
        Notification("1", "Notification 1", System.currentTimeMillis()),
        Notification("2", "Notification 2", System.currentTimeMillis()),
        Notification("3", "Notification 3", System.currentTimeMillis()),
        Notification("4", "Notification 4", System.currentTimeMillis()),
        Notification("5", "Notification 5", System.currentTimeMillis())
    )

    Column(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(
            text = "Notifications",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.padding(top = 16.dp))

        if (notifications.isEmpty()) {
            NoItemView(image = "", title = "No Notification here")
        } else {
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(12.dp),
                modifier = Modifier.heightIn(max = 1000.dp)
            ) {
                items(notifications) {
                    NotificationItem(it)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun NotificationsScreenPreview() {
    NotificationsScreen()
}