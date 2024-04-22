package com.swaasth.partner.ui.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.swaasth.partner.domain.model.Patient
import com.swaasth.partner.ui.theme.Blue80
import com.swaasth.partner.ui.theme.Grey20
import com.swaasth.partner.ui.theme.Transparent
import com.swaasth.partner.ui.theme.White

@Composable
fun PatientItemCard(
    patient: Patient,
    showButton: Boolean = true,
    negativeColor: Boolean = false,
    onClick: () -> Unit = {}
) {
    val border = if (negativeColor) Transparent else Grey20
    val background = if (negativeColor) Blue80 else White
    val foreground = if (negativeColor) White else Blue80

    Card(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 2.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = background,
            disabledContainerColor = background,
            contentColor = background
        ),
        border = BorderStroke(
            1.dp, border
        ),
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Text(
                text = "${patient.id}. ${patient.name}",
                fontSize = 18.sp,
                fontWeight = FontWeight.ExtraBold,
                color = foreground
            )

            Text(
                text = "${patient.age}, ${patient.gender}",
                fontSize = 18.sp,
                color = foreground
            )

            if (showButton) {
                Button(
                    shape = RoundedCornerShape(12.dp),
                    onClick = onClick,
                    modifier = Modifier.width(90.dp)
                ) {
                    Text(
                        text = "View Details",
                        fontSize = 12.sp,
                        textAlign = TextAlign.Center
                    )
                }
            } else {
                Text(
                    text = patient.status,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = foreground
                )
            }
        }
    }
}

@Preview
@Composable
private fun PatientItemCardPreview() {
    PatientItemCard(
        Patient(
            id = "vocibus",
            name = "Abdul Warren",
            age = "est",
            gender = "lacinia",
            status = "dolor"
        )
    )
}