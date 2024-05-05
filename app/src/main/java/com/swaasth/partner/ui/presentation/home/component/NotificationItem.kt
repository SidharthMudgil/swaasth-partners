package com.swaasth.partner.ui.presentation.home.component

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Circle
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.swaasth.partner.common.datatype.Date
import com.swaasth.partner.domain.model.Notification
import com.swaasth.partner.ui.theme.Blue80
import com.swaasth.partner.ui.theme.Grey20

@Composable
fun NotificationItem(
    notification: Notification
) {
    Surface(
        shadowElevation = 2.dp,
        modifier = Modifier.fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .border(1.dp, Grey20, RoundedCornerShape(12.dp))
                .padding(8.dp)
        ) {
            Column(
                modifier = Modifier
                    .weight(1f)
            ) {
                Text(
                    text = notification.message,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.heightIn(max = 100.dp)
                )

                Text(
                    text = Date(notification.timestamp).getApproximateDifferenceInUnits(Date(System.currentTimeMillis())),
                    fontWeight = FontWeight.SemiBold
                )
            }

            Icon(
                imageVector = Icons.Rounded.Circle,
                contentDescription = null,
                tint = Blue80
            )
        }
    }
}

@Preview
@Composable
private fun NotificationItemPreview() {
    NotificationItem(Notification("5", "Notification 5", System.currentTimeMillis()))
}