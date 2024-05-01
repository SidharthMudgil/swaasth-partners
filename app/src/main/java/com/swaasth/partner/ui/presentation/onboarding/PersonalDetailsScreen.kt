package com.swaasth.partner.ui.presentation.onboarding

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.swaasth.partner.ui.component.InputField
import com.swaasth.partner.ui.presentation.onboarding.component.GenderCard
import com.swaasth.partner.ui.presentation.onboarding.component.PagerIndicator
import com.swaasth.partner.ui.theme.White

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PersonalDetailsScreen(
    onClick: () -> Unit
) {
    val datePickerState = rememberDatePickerState()
    var showDatePicker by remember { mutableStateOf(false) }
    var gender by remember { mutableIntStateOf(0) }

    Scaffold {
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(it)
                .padding(16.dp)
        ) {
            PagerIndicator(1)
            Text(
                text = "Personal Details",
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(top = 16.dp)
            )

            InputField(
                hint = "First name", onValueChange = { }, outlined = true
            )

            InputField(
                hint = "Last name", onValueChange = { }, outlined = true
            )

            InputField(
                hint = "Phone number", onValueChange = { }, outlined = true
            )

            InputField(
                hint = "Date of birth",
                enabled = false,
                readOnly = false,
                outlined = true,
                onClick = { showDatePicker = true },
                onValueChange = {}
            )

            Text(
                text = "Gender",
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(top = 8.dp)
            )
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                Box(
                    modifier = Modifier.weight(1f)
                ) {
                    GenderCard(title = "Male", selected = gender == 0) {
                        gender = 0
                    }
                }

                Box(
                    modifier = Modifier.weight(1f)
                ) {
                    GenderCard(title = "Female", selected = gender == 1) {
                        gender = 1
                    }
                }

                Box(
                    modifier = Modifier.weight(1f)
                ) {
                    GenderCard(title = "Others", selected = gender == 2) {
                        gender = 2
                    }
                }
            }

            Spacer(modifier = Modifier.weight(1f))
            
            Button(
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier.fillMaxWidth(),
                onClick = onClick
            ) {
                Text(
                    text = "Next",
                    fontWeight = FontWeight.SemiBold,
                    color = White,
                    modifier = Modifier.padding(8.dp)
                )
            }

            if (showDatePicker) {
                DatePickerDialog(
                    onDismissRequest = { showDatePicker = false },
                    confirmButton = {
                        TextButton(
                            onClick = {
                                showDatePicker = false
                            }
                        ) { Text("OK") }
                    },
                    dismissButton = {
                        TextButton(
                            onClick = {
                                showDatePicker = false
                            }
                        ) { Text("Cancel") }
                    }
                )
                {
                    DatePicker(state = datePickerState)
                }
            }
        }
    }
}

@Preview
@Composable
private fun PersonalDetailsScreenPreview() {
    PersonalDetailsScreen{}
}