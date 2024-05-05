package com.swaasth.partner.ui.presentation.onboarding.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.CalendarMonth
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.swaasth.partner.ui.theme.Grey10
import com.swaasth.partner.ui.theme.Grey20
import com.swaasth.partner.ui.theme.White

@Composable
fun GenderCard(
    image: ImageVector,
    title: String,
    selected: Boolean,
    onClick: () -> Unit
) {
    Card(
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 12.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = White,
        ),
        modifier = Modifier
            .padding(horizontal = 6.dp)
            .border(1.dp, Grey10, RoundedCornerShape(12.dp))
            .shadow(
                spotColor = Grey20,
                ambientColor = Grey20,
                elevation = 15.dp,
                clip = true,
                shape = RoundedCornerShape(12.dp)
            )
            .clickable {
                onClick()
            }
    ) {
        RadioButton(
            selected = selected,
            onClick = {
                onClick()
            },
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(align = Alignment.End)
                .defaultMinSize(1.dp, 1.dp)
        )

        Image(
            imageVector = image,
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(align = Alignment.CenterHorizontally)
                .size(60.dp)
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .wrapContentWidth(align = Alignment.CenterHorizontally)
        ) {
            Text(
                text = title,
                fontSize = 18.sp,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun SelectedGenderCardPreview() {
    GenderCard(
        image = Icons.Rounded.CalendarMonth, title = "Online", selected = true
    ) {

    }
}

@Preview(showBackground = true)
@Composable
private fun UnselectedGenderCardPreview() {
    GenderCard(
        image = Icons.Rounded.CalendarMonth, title = "Offline", selected = false
    ) {

    }
}