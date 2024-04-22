package com.swaasth.partner.ui.presentation.queue

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun LiveQueueScreen() {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        item {
            Text(
                text = "Live Queue"
            )
        }

        item {
            Row {
                Text(text = "")

                Switch(checked = true, onCheckedChange = {})
            }
        }

        item {
            Row {
                Text(text = "")
                Text(text = "")
            }

            LazyColumn(
                modifier = Modifier.heightIn(max = 500.dp)
            ) {

            }
        }

        item {
            Row {
                Text(text = "")
                Text(text = "")
            }

            LazyColumn(
                modifier = Modifier.heightIn(max = 500.dp)
            ) {

            }
        }
    }
}

@Preview
@Composable
private fun LiveQueueScreenPreview() {
    LiveQueueScreen()
}