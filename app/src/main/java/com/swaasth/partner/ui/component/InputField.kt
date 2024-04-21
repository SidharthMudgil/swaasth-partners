package com.swaasth.partner.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.swaasth.partner.ui.theme.Black
import com.swaasth.partner.ui.theme.Blue80
import com.swaasth.partner.ui.theme.Grey10
import com.swaasth.partner.ui.theme.Grey20
import com.swaasth.partner.ui.theme.Grey80
import com.swaasth.partner.ui.theme.White

@Composable
fun InputField(
    hint: String,
    onValueChange: () -> Unit,
    elevation: Dp = 0.dp,
    prefix: String? = null,
    outlined: Boolean = false,
    readOnly: Boolean = false,
    leadingIcon: ImageVector? = null,
    trailingIcon: ImageVector? = null,
    onClick: () -> Unit = {},
    enabled: Boolean = true
) {
    var query by remember { mutableStateOf("") }
    var focused by remember { mutableStateOf(false) }

    Surface(
        shadowElevation = elevation,
        shape = RoundedCornerShape(12.dp),
        onClick = onClick,
        modifier = Modifier
            .wrapContentHeight()
    ) {
        BasicTextField(
            value = query,
            onValueChange = {
                query = it
                onValueChange()
            },
            enabled = enabled,
            readOnly = readOnly,
            maxLines = 1,
            singleLine = true,
            textStyle = TextStyle(
                color = Black,
                fontSize = 18.sp
            ),

            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .clip(RoundedCornerShape(12.dp))
                .then(
                    if (outlined) {
                        if (focused) {
                            Modifier.border(2.dp, Blue80, RoundedCornerShape(12.dp))
                        } else {
                            Modifier.border(1.dp, Grey20, RoundedCornerShape(12.dp))
                        }
                    } else {
                        Modifier
                    }
                )
                .onFocusChanged { state -> focused = state.isFocused }
                .background(White)
                .padding(12.dp),
            decorationBox = {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    leadingIcon?.let {
                        Icon(imageVector = it, contentDescription = null)
                    }
                    prefix?.let {
                        Text(
                            text = prefix,
                            color = Grey80,
                            modifier = Modifier.background(Color.Transparent)
                        )
                    }
                    Box(modifier = Modifier.weight(1f)) {
                        if (query.isEmpty()) {
                            Text(
                                text = hint,
                                color = Grey10,
                                modifier = Modifier.background(Color.Transparent)
                            )
                        }
                        it()
                    }
                    trailingIcon?.let {
                        Icon(imageVector = it, contentDescription = null)
                    }
                }
            }
        )
    }
}

@Preview
@Composable
private fun InputFieldPreview() {
    InputField(
        hint = "Search Doctor",
        onValueChange = {

        }
    )
}

@Preview
@Composable
private fun LeadingIconInputFieldPreview() {
    InputField(
        hint = "Search Doctor",
        leadingIcon = Icons.Rounded.Search,
        onValueChange = {

        }
    )
}

@Preview
@Composable
private fun TrailingIconInputFieldPreview() {
    InputField(
        hint = "Search Doctor",
        trailingIcon = Icons.Rounded.Search,
        onValueChange = {

        }
    )
}

@Preview(showBackground = true)
@Composable
private fun ElevatedInputFieldPreview() {
    InputField(
        hint = "Search Doctor",
        elevation = 2.dp,
        onValueChange = {

        }
    )
}

@Preview(showBackground = true)
@Composable
private fun OutlinedInputFieldPreview() {
    InputField(
        hint = "Search Doctor",
        outlined = true,
        onValueChange = {

        }
    )
}

@Preview(showBackground = true)
@Composable
private fun PrefixInputFieldPreview() {
    InputField(
        hint = "Search Doctor",
        outlined = true,
        prefix = "+91",
        onValueChange = {

        }
    )
}