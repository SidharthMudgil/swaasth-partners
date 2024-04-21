package com.swaasth.partner.ui.presentation.home.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material.icons.rounded.QrCodeScanner
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.swaasth.partner.ui.theme.Blue80
import com.swaasth.partner.ui.theme.RedBlue
import com.swaasth.partner.ui.theme.White

@Composable
fun GreetingsCard(
    onQrClick: () -> Unit,
    onNotificationClick: () -> Unit,
) {
    Card(
        shape = RoundedCornerShape(bottomEnd = 40.dp, bottomStart = 40.dp),
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .background(
                    Brush.linearGradient(
                        start = Offset(0f, Float.POSITIVE_INFINITY),
                        end = Offset(Float.POSITIVE_INFINITY, 0f),
                        colors = listOf(
                            RedBlue, Blue80
                        ),
                    )
                )
                .padding(bottom = 8.dp)
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Image(
                        imageVector = Icons.Rounded.QrCodeScanner,
                        contentDescription = "QR Scanner",
                        colorFilter = ColorFilter.tint(White),
                        modifier = Modifier.size(36.dp).clickable {
                            onQrClick()
                        }
                    )

                    Image(
                        imageVector = Icons.Rounded.Notifications,
                        contentDescription = "Notifications",
                        colorFilter = ColorFilter.tint(White),
                        modifier = Modifier.size(36.dp).clickable {
                            onNotificationClick()
                        }
                    )
                }

                Text(
                    text = "Hello,\nDr. Jenny",
                    fontSize = 48.sp,
                    color = White,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@Preview
@Composable
private fun GreetingsCardPreview() {
    GreetingsCard({}, {})
}