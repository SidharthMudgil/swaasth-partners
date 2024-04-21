package com.swaasth.partner.ui.presentation.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.ArrowDropDown
import androidx.compose.material.icons.outlined.ArrowDropUp
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.swaasth.partner.R
import com.swaasth.partner.ui.component.InputField
import com.swaasth.partner.ui.theme.Grey10
import com.swaasth.partner.ui.theme.Grey20
import com.swaasth.partner.ui.theme.Grey40
import com.swaasth.partner.ui.theme.White

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(onClick: () -> Unit) {
    var prefix by remember { mutableStateOf("+91") }
    var expandedState by remember { mutableStateOf(false) }

    Scaffold {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(it)
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(16.dp)
                .verticalScroll(rememberScrollState())
        ) {
            Image(
                painter = painterResource(id = R.drawable.doctor),
                contentDescription = null,
                modifier = Modifier
                    .height(300.dp)
                    .fillMaxWidth()
            )

            Spacer(modifier = Modifier.padding(top = 30.dp))
            Text(
                text = "Ready to revolutionize your practice? Let's get started with Swaasth today!",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Grey40,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.padding(top = 16.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Divider(modifier = Modifier.weight(1f))

                Text(
                    text = "Login in or sign up",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Grey20
                )

                Divider(modifier = Modifier.weight(1f))
            }

            Spacer(modifier = Modifier.padding(top = 16.dp))
            InputField(
                hint = "Full name",
                onValueChange = {

                },
                outlined = true,
                leadingIcon = Icons.Filled.Person
            )

            Spacer(modifier = Modifier.padding(top = 16.dp))
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

            Spacer(modifier = Modifier.padding(top = 16.dp))
            Button(
                onClick = onClick,
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Continue",
                    modifier = Modifier.padding(12.dp, 8.dp),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium
                )
            }

            Spacer(modifier = Modifier.padding(top = 16.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Divider(modifier = Modifier.weight(1f))

                Text(
                    text = "Or",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Grey20
                )

                Divider(modifier = Modifier.weight(1f))
            }

            Spacer(modifier = Modifier.padding(top = 16.dp))
            Image(
                painter = painterResource(id = R.drawable.google),
                contentDescription = null,
                modifier = Modifier
                    .border(1.dp, Grey10, CircleShape)
                    .size(48.dp)
            )

            Spacer(modifier = Modifier.padding(top = 16.dp))
            Text(
                text = "By continuing, you are agree to our",
                fontSize = 14.sp
            )
            Row(
                horizontalArrangement = Arrangement.spacedBy(6.dp),
                modifier = Modifier.padding(top = 4.dp)
            ) {
                ClickableText(
                    text = buildAnnotatedString {
                        append("Terms and condition")
                    },
                    onClick = {

                    },
                    style = TextStyle(
                        fontSize = 12.sp,
                        color = Grey20
                    )
                )

                ClickableText(
                    text = buildAnnotatedString {
                        append("Privacy policy")
                    },
                    onClick = {

                    },
                    style = TextStyle(
                        fontSize = 12.sp,
                        color = Grey20
                    )
                )

                ClickableText(
                    text = buildAnnotatedString {
                        append("Content policy")
                    },
                    onClick = {

                    },
                    style = TextStyle(
                        fontSize = 12.sp,
                        color = Grey20
                    )
                )
            }
        }
    }
}

@Preview
@Composable
private fun LoginScreenPreview() {
    LoginScreen {

    }
}