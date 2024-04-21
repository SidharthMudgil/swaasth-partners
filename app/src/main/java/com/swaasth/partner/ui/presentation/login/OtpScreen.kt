package com.swaasth.partner.ui.presentation.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBackIosNew
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.composeuisuite.ohteepee.OhTeePeeInput
import com.composeuisuite.ohteepee.configuration.OhTeePeeCellConfiguration
import com.composeuisuite.ohteepee.configuration.OhTeePeeConfigurations
import com.swaasth.partner.ui.theme.Blue80
import com.swaasth.partner.ui.theme.Grey20
import com.swaasth.partner.ui.theme.White

@Composable
fun OtpScreen(
    onClick: () -> Unit,
    onBackClick: () -> Unit
) {
    var otpValue by remember { mutableStateOf("") }

    Scaffold {
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier
                .padding(it)
                .padding(16.dp)
                .fillMaxHeight()
                .fillMaxWidth()
                .verticalScroll(rememberScrollState())
        ) {
            TextButton(
                onClick = onBackClick,
                contentPadding = PaddingValues(0.dp),
                modifier = Modifier
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

            Spacer(modifier = Modifier.padding(top = 30.dp))
            Text(
                text = "Enter OTP",
                fontSize = 50.sp,
                color = Blue80,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "OTP sent to +91 9198*****8",
                color = Grey20,
            )
            OhTeePeeInput(
                value = otpValue,
                onValueChange = { newValue, _ ->
                    otpValue = newValue
                },
                configurations = OhTeePeeConfigurations.withDefaults(
                    cellsCount = 4,
                    emptyCellConfig = OhTeePeeCellConfiguration.withDefaults(
                        borderColor = Grey20,
                        borderWidth = 1.dp,
                        shape = RoundedCornerShape(12.dp),
                        textStyle = TextStyle(
                            color = Blue80
                        )
                    ),
                    activeCellConfig = OhTeePeeCellConfiguration.withDefaults(
                        borderColor = Blue80,
                        borderWidth = 2.dp,
                        shape = RoundedCornerShape(12.dp),
                        textStyle = TextStyle(
                            color = Blue80
                        )
                    ),
                    cellModifier = Modifier
                        .padding(horizontal = 4.dp)
                        .size(60.dp)
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentWidth(Alignment.Start)
            )

            Spacer(modifier = Modifier.padding(top = 30.dp))
            Text(
                text = "Didn't receive the OTP?"
            )
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                TextButton(
                    onClick = {

                    },
                    contentPadding = PaddingValues(0.dp),
                    modifier = Modifier
                        .defaultMinSize(1.dp, 1.dp),
                ) {
                    Text(
                        text = "Resend in",
                        fontSize = 16.sp
                    )
                }

                Text(
                    text = "00:30",
                    fontSize = 16.sp
                )
            }

            Spacer(modifier = Modifier.weight(1f))
            Button(
                onClick = onClick,
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Submit",
                    fontSize = 18.sp,
                    color = White,
                    modifier = Modifier.padding(12.dp, 8.dp)
                )
            }
            Text(
                text = "T&C applied",
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentWidth(Alignment.CenterHorizontally)
            )
        }
    }
}

@Preview
@Composable
private fun OtpScreenPreview() {
    OtpScreen({}) {

    }
}