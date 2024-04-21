package com.swaasth.partner.ui.presentation.view_details

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBackIosNew
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.swaasth.partner.R
import com.swaasth.partner.ui.theme.Black
import com.swaasth.partner.ui.theme.Blue80
import com.swaasth.partner.ui.theme.Grey20
import com.swaasth.partner.ui.theme.Orange
import com.swaasth.partner.ui.theme.Red
import com.swaasth.partner.ui.theme.RedTransparent
import com.swaasth.partner.ui.theme.White

@Composable
fun ViewDetailsScreen(
    onBackClick: () -> Unit
) {
    Scaffold {
        Column(
            modifier = Modifier
                .padding(it)
                .fillMaxHeight()
                .fillMaxWidth()
        ) {
            TextButton(
                onClick = onBackClick,
                contentPadding = PaddingValues(0.dp),
                modifier = Modifier
                    .padding(top = 16.dp, start = 16.dp)
                    .align(Alignment.Start)
                    .defaultMinSize(1.dp, 1.dp),
            ) {
                Icon(
                    imageVector = Icons.Rounded.ArrowBackIosNew,
                    contentDescription = null,
                    modifier = Modifier.size(14.dp),
                    tint = Blue80
                )
                Text(text = "Back")
            }

            Text(
                text = "View Details",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )

            AsyncImage(
                model = "",
                contentDescription = null,
                modifier = Modifier
                    .padding(top = 16.dp)
                    .background(Grey20, CircleShape)
                    .size(120.dp)
                    .clip(CircleShape)
                    .align(Alignment.CenterHorizontally)
            )

            Text(
                text = "Ashutosh",
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 8.dp)
            )

            Text(
                text = "18, male",
                fontSize = 18.sp,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )

            Text(
                text = "11:00 AM",
                fontSize = 12.sp,
                color = Red,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .clip(RoundedCornerShape(4.dp))
                    .background(RedTransparent)
                    .padding(horizontal = 4.dp)
            )

            Button(
                onClick = { },
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text(
                    text = "View Prescription",
                    fontSize = 18.sp,
                    modifier = Modifier.padding(vertical = 8.dp)
                )
            }

            OutlinedButton(
                onClick = { },
                shape = RoundedCornerShape(12.dp),
                border = BorderStroke(2.dp, Blue80),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            ) {
                Text(
                    text = "View Report",
                    fontSize = 18.sp,
                    modifier = Modifier.padding(vertical = 8.dp)
                )
            }

            Spacer(modifier = Modifier.weight(1f))
            Card(
                shape = RoundedCornerShape(topStart = 24.dp, topEnd = 18.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Orange
                ),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "₹ 500",
                    color = Black,
                    fontWeight = FontWeight.Black,
                    fontSize = 36.sp,
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(top = 16.dp)
                )
                Text(
                    text = "Payment Pending",
                    color = White,
                    fontWeight = FontWeight.Medium,
                    fontSize = 18.sp,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
                Image(
                    painter = painterResource(id = R.drawable.payment_pending),
                    contentDescription = null,
                    modifier = Modifier.fillMaxWidth()
                        .aspectRatio(3f)
                        .align(Alignment.CenterHorizontally)
                )
            }
        }
    }
}

@Preview
@Composable
private fun ViewDetailsScreenPreview() {
    ViewDetailsScreen {

    }
}