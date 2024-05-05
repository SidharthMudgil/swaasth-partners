package com.swaasth.partner.ui.presentation.onboarding

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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBackIosNew
import androidx.compose.material.icons.rounded.Upload
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.swaasth.partner.ui.component.DropdownInput
import com.swaasth.partner.ui.component.InputField
import com.swaasth.partner.ui.presentation.onboarding.component.PagerIndicator
import com.swaasth.partner.ui.theme.Blue80
import com.swaasth.partner.ui.theme.Grey10
import com.swaasth.partner.ui.theme.White

@Composable
fun VerificationDetailsScreen(
    onClick: () -> Unit,
    onBackClick: () -> Unit
) {
    var expandedState by remember { mutableStateOf(false) }
    var expandedState1 by remember { mutableStateOf(false) }
    var selectedItem by remember { mutableStateOf("2023") }
    var selectedItem1 by remember { mutableStateOf("Haryana") }

    Scaffold {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(it)
                .padding(start = 16.dp, end = 16.dp, bottom = 16.dp)
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

            PagerIndicator(3)
            Text(
                text = "Verification Details",
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(top = 16.dp, bottom = 8.dp)
            )


            InputField(
                hint = "Enter Aadhaar card number", onValueChange = { }, outlined = true
            )
            Row(
                horizontalArrangement = Arrangement.spacedBy(4.dp),
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(top = 8.dp)
            ) {
                Text(text = "Upload your Aadhaar card *", color = Blue80, fontSize = 12.sp)
                Icon(
                    imageVector = Icons.Rounded.Upload, contentDescription = null,
                    modifier = Modifier.size(18.dp),
                    tint = Blue80
                )
            }

            Spacer(modifier = Modifier.padding(8.dp))
            InputField(
                hint = "Enter your NMC ID ", onValueChange = { }, outlined = true
            )
            Row(
                horizontalArrangement = Arrangement.spacedBy(4.dp),
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(top = 8.dp)
            ) {
                Text(text = "Upload your NMC Id *", color = Blue80, fontSize = 12.sp)
                Icon(
                    imageVector = Icons.Rounded.Upload, contentDescription = null,
                    modifier = Modifier.size(18.dp),
                    tint = Blue80
                )
            }

            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(top = 16.dp)
            ) {
                Divider(modifier = Modifier.weight(1f), color = Grey10)
                Text(text = "Or", color = Grey10)
                Divider(modifier = Modifier.weight(1f), color = Grey10)
            }

            Text(
                text = "Doctor Name:",
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(top = 16.dp, bottom = 8.dp)
            )
            InputField(
                hint = "Enter Doctor name", onValueChange = { }, outlined = true
            )

            Text(
                text = "Browse by Registration No: ",
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(top = 16.dp, bottom = 8.dp)
            )
            InputField(
                hint = "Enter Registration no", onValueChange = { }, outlined = true
            )

            Text(
                text = "Browse by Year Of Registration:",
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(top = 16.dp, bottom = 8.dp)
            )
            DropdownInput(
                selected = selectedItem,
                expanded = expandedState,
                items = listOf("2001", "2002", "2003"),
                onExpandedChange = { expandedState = !expandedState },
                onValueChange = { it1 -> selectedItem = it1 },
                onItemClick = { it1 -> selectedItem = it1 }
            ) {
                expandedState = false
            }


            Text(
                text = "State Medical Council:  ",
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(top = 16.dp, bottom = 8.dp)
            )
            DropdownInput(
                selected = selectedItem1,
                expanded = expandedState1,
                items = listOf("Haryana", "Delhi", "Telangana"),
                onExpandedChange = { expandedState1 = !expandedState1 },
                onValueChange = { it1 -> selectedItem1 = it1 },
                onItemClick = { it1 -> selectedItem1 = it1 }
            ) {
                expandedState1 = false
            }

            Button(
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                onClick = onClick,
            ) {
                Text(
                    text = "Submit",
                    fontWeight = FontWeight.SemiBold,
                    color = White,
                    modifier = Modifier.padding(8.dp)
                )
            }
        }
    }
}

@Preview
@Composable
private fun VerificationDetailsScreenPreview() {
    VerificationDetailsScreen(onClick = {}, onBackClick = {})
}