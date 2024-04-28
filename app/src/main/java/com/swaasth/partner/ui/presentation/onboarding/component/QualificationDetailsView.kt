package com.swaasth.partner.ui.presentation.onboarding.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowDropDown
import androidx.compose.material.icons.outlined.ArrowDropUp
import androidx.compose.material.icons.rounded.ArrowBackIosNew
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.swaasth.partner.ui.component.DropdownInput
import com.swaasth.partner.ui.component.InputField
import com.swaasth.partner.ui.theme.Blue80
import com.swaasth.partner.ui.theme.Grey10
import com.swaasth.partner.ui.theme.Grey40
import com.swaasth.partner.ui.theme.White

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun QualificationDetailsView() {
    var prefix by remember { mutableStateOf("+91") }
    var expandedState by remember { mutableStateOf(false) }

    Scaffold {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(it)
        ) {
            TextButton(
                onClick = {  },
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

            Text(text = "Qualification")
            InputField(hint = "MBBS, MD", onValueChange = { })
            InputField(hint = "Enter your specialization", onValueChange = { })

            Text(text = "Clinic information")
            InputField(hint = "Enter your clinic or hospital name", onValueChange = {  })
            InputField(hint = "Search for clinic location", onValueChange = {  })
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                ExposedDropdownMenuBox(
                    expanded = expandedState,
                    onExpandedChange = {
                        expandedState = !expandedState
                    },
                ) {
                    BasicTextField(
                        value = prefix,
                        onValueChange = { value -> prefix = value },
                        readOnly = true,
                        singleLine = true,
                        modifier = Modifier
                            .menuAnchor()
                            .clip(RoundedCornerShape(12.dp))
                            .background(White, RoundedCornerShape(12.dp))
                            .border(1.dp, Grey10, RoundedCornerShape(12.dp))
                            .padding(10.dp),
                        decorationBox = {
                            Row(
                                horizontalArrangement = Arrangement.spacedBy(12.dp)
                            ) {
                                Text(
                                    text = prefix,
                                    color = Grey40,
                                    fontSize = 18.sp,
                                    modifier = Modifier.background(Color.Transparent)
                                )

                                Icon(
                                    imageVector = if (!expandedState) Icons.Outlined.ArrowDropDown else Icons.Outlined.ArrowDropUp,
                                    contentDescription = null
                                )
                            }
                        }
                    )

                    ExposedDropdownMenu(
                        expanded = expandedState,
                        onDismissRequest = { expandedState = false },
                        modifier = Modifier.fillMaxWidth(),
                    ) {
                        listOf("+91", "+92").forEach { v ->
                            DropdownMenuItem(
                                text = {
                                    Text(text = v)
                                },
                                onClick = {
                                    prefix = v
                                    expandedState = false
                                },
                                modifier = Modifier.fillMaxWidth()
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.padding(start = 16.dp))
                Box(
                    modifier = Modifier.weight(7f)
                ) {
                    InputField(
                        hint = "Enter phone number",
                        prefix = prefix,
                        onValueChange = {

                        },
                        outlined = true
                    )
                }
            }
            
            InputField(hint = "₹ Enter your fees", onValueChange = { })
            
            Text(text = "Clinic timing")
            DropdownInput(
                selected = "",
                expanded = false,
                items = listOf(),
                onExpandedChange = {  },
                onValueChange = {},
                onItemClick =  {}
            ) {

            }

            Spacer(modifier = Modifier.weight(1f))

            Button(
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier.fillMaxWidth(),
                onClick = {}
            ) {
                Text(
                    text = "Next",
                    fontWeight = FontWeight.SemiBold,
                    color = White,
                    modifier = Modifier.padding(8.dp)
                )
            }
        }
    }
}