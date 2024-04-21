package com.swaasth.partner.ui.presentation.profile.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Edit
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.swaasth.partner.ui.theme.Grey20
import com.swaasth.partner.ui.theme.Transparent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileButton(
    icon: ImageVector,
    title: String,
    onClick: () -> Unit
) {
    Card(
        onClick = { onClick() },
        shape = RoundedCornerShape(12.dp),
        border = BorderStroke(1.dp, Grey20),
        colors = CardDefaults.cardColors(
            containerColor = Transparent
        ),
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxHeight().padding(12.dp, 18.dp)
        ) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = Grey20,
            )

            Text(
                text = title,
                color = Grey20,
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium
            )
        }
    }
}

@Preview
@Composable
private fun ProfileButtonPreview() {
    ProfileButton(
        icon = Icons.Rounded.Edit, title = "Edit Profile"
    ) {

    }
}