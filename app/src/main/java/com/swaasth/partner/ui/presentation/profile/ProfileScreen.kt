package com.swaasth.partner.ui.presentation.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.Logout
import androidx.compose.material.icons.rounded.Edit
import androidx.compose.material.icons.rounded.History
import androidx.compose.material.icons.rounded.Lock
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.swaasth.partner.common.datatype.Date
import com.swaasth.partner.common.enums.Gender
import com.swaasth.partner.domain.model.User
import com.swaasth.partner.ui.presentation.profile.component.ProfileButton
import com.swaasth.partner.ui.theme.White

@Composable
fun ProfileScreen(
    onMediaClick: () -> Unit,
    onEditClick: () -> Unit,
    onHistoryClick: () -> Unit,
) {
    val user = User(
        id = "ceteros",
        name = "Susanna Townsend",
        phone = "(236) 505-1479",
        email = "liz.frank@example.com",
        sex = Gender.FEMALE,
        dob = 5129,
        image = "https://i.pinimg.com/originals/89/8d/b9/898db9d3675b46db2f2f822683eb4ec6.jpg"
    )

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Text(
            text = "Profile",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.padding(bottom = 16.dp))
        AsyncImage(
            model = user.image,
            contentDescription = null,
            clipToBounds = false,
            contentScale = ContentScale.Crop,

            modifier = Modifier
                .background(White)
                .size(250.dp, 200.dp)
                .clip(RoundedCornerShape(12.dp))
                .clickable { onMediaClick() }
        )

        Spacer(modifier = Modifier.padding(bottom = 8.dp))
        Text(
            text = user.name,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
        )

        Text(
            text = "Age-${
                Date(user.dob).yearDifference(Date(System.currentTimeMillis()))
            }, ${user.sex.name}",
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium,
        )

        Spacer(modifier = Modifier.padding(bottom = 16.dp))
        ProfileButton(
            icon = Icons.Rounded.Edit,
            title = "Edit profile"
        ) {
            onEditClick()
        }

        Spacer(modifier = Modifier.padding(bottom = 8.dp))
        ProfileButton(
            icon = Icons.Rounded.History,
            title = "Your History"
        ) {
            onHistoryClick()
        }

        Spacer(modifier = Modifier.padding(bottom = 8.dp))
        ProfileButton(
            icon = Icons.Rounded.Lock,
            title = "Terms & Condition"
        ) {

        }

        Spacer(modifier = Modifier.padding(bottom = 8.dp))
        ProfileButton(
            icon = Icons.AutoMirrored.Rounded.Logout,
            title = "Log out"
        ) {

        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ProfileScreenPreview() {
    ProfileScreen({}, {}, {})
}
