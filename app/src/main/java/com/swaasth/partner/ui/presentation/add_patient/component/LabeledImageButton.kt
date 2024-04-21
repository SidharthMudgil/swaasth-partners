package com.swaasth.partner.ui.presentation.add_patient.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.PostAdd
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.swaasth.partner.ui.theme.Grey20
import com.swaasth.partner.ui.theme.White

@Composable
fun LabeledImageButton(
    imageVector: ImageVector,
    label: String,
    onClick: () -> Unit
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            imageVector = imageVector,
            contentDescription = null,
            colorFilter = ColorFilter.tint(Grey20),
            modifier = Modifier
                .shadow(2.dp, CircleShape)
                .clickable { onClick() }
                .background(White, CircleShape)
                .padding(16.dp)
                .size(48.dp)
                .clip(CircleShape)
        )
        Text(
            text = label,
            fontWeight = FontWeight.ExtraBold
        )
    }
}

@Preview
@Composable
private fun LabeledImageButtonPreview() {
    LabeledImageButton(
        Icons.Rounded.PostAdd,
        "Add Report"
    ) {}
}