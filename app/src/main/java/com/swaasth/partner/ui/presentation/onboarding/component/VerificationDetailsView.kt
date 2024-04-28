package com.swaasth.partner.ui.presentation.onboarding.component

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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBackIosNew
import androidx.compose.material.icons.rounded.CalendarMonth
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.swaasth.partner.ui.component.DropdownInput
import com.swaasth.partner.ui.component.InputField
import com.swaasth.partner.ui.theme.Blue80
import com.swaasth.partner.ui.theme.White

@Composable
fun VerificationDetailsView() {
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

            Text(text = "Verification Details")
            InputField(hint = "Enter Aadhaar card number", onValueChange = { })
            Row {
                Text(text = "Upload your Aadhaar card")
                Icon(imageVector = Icons.Rounded.CalendarMonth, contentDescription = null)
            }
            InputField(hint = "Enter your NMC ID ", onValueChange = { })
            Row {
                Text(text = "Upload your NMC Id")
                Icon(imageVector = Icons.Rounded.CalendarMonth, contentDescription = null)
            }

            Row {
                Divider()
                Text(text = "Or")
                Divider()
            }

            Text(text = "Doctor Name:")
            InputField(hint = "Enter Doctor name", onValueChange = { })

            Text(text = "Browse by Registration No: ")
            InputField(hint = "Enter Registration no", onValueChange = { })

            Text(text = "Browse by Year Of Registration:")
            DropdownInput(
                selected = "Select Year of Admission ",
                expanded = false,
                items = listOf(),
                onExpandedChange = {  },
                onValueChange = {},
                onItemClick = {}
            ) {

            }

            Text(text = "State Medical Council:  ")
            DropdownInput(
                selected = "Select State",
                expanded = false,
                items = listOf(),
                onExpandedChange = {  },
                onValueChange = {},
                onItemClick = {}
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