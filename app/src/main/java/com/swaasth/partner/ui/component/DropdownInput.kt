package com.swaasth.partner.ui.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.swaasth.partner.ui.theme.Grey10

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DropdownInput(
    selected: String,
    expanded: Boolean,
    items: List<String>,
    hint: String = "",
    onExpandedChange: () -> Unit,
    onValueChange: (value: String) -> Unit,
    onItemClick: (value: String) -> Unit,
    onDismissRequest: () -> Unit
) {
    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = {
            onExpandedChange()
        },
        modifier = Modifier
            .fillMaxWidth()
    ) {
        OutlinedTextField(
            value = selected,
            placeholder = {
                Text(
                    text = hint,
                    color = Grey10
                )
            },
            shape = RoundedCornerShape(12.dp),
            onValueChange = { value -> onValueChange(value) },
            readOnly = true,
            trailingIcon = {
                ExposedDropdownMenuDefaults.TrailingIcon(
                    expanded = expanded
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .menuAnchor()
        )

        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = onDismissRequest,
            modifier = Modifier.fillMaxWidth(),
        ) {
            items.forEach { v ->
                DropdownMenuItem(
                    text = {
                        Text(text = v)
                    },
                    onClick = {
                        onItemClick(v)
                    },
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}

@Preview
@Composable
private fun DropdownInputPreview() {
    DropdownInput(
        selected = "orci",
        expanded = false,
        items = listOf(),
        onExpandedChange = {},
        onValueChange = {},
        onItemClick = {},
        onDismissRequest = {}
    )
}