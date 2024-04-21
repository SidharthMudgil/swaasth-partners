package com.swaasth.partner.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage

@Composable
fun NoItemView(
    image: String,
    title: String
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
    ) {
        AsyncImage(
            model = image,
            contentDescription = null,
            modifier = Modifier.size(300.dp)
        )

        Spacer(modifier = Modifier.padding(top = 16.dp))
        Text(
            text = title,
            fontSize = 24.sp,
            fontWeight = FontWeight.SemiBold
        )
    }
}

@Preview
@Composable
private fun NoItemViewPreview() {
    NoItemView(image = "", title = "")
}