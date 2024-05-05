package com.swaasth.partner.ui.presentation.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
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
import com.swaasth.partner.domain.model.Patient
import com.swaasth.partner.ui.presentation.home.component.BannersList
import com.swaasth.partner.ui.presentation.home.component.BookingList
import com.swaasth.partner.ui.presentation.home.component.FiltersList
import com.swaasth.partner.ui.presentation.home.component.GreetingsCard
import java.util.Collections

@Composable
fun HomeScreen(
    onNotificationClick: () -> Unit,
    onDetailsClick: () -> Unit,
) {
    var demoPatients by remember {
        mutableStateOf(
            listOf(
                Patient(
                    id = "1",
                    name = "Alyce Molina",
                    age = "23",
                    gender = "Male",
                    status = "debet"
                ),
                Patient(
                    id = "2", name = "Grover Fulton", age = "23", gender = "Male", status = "dicit"
                ),
                Patient(
                    id = "3", name = "Leta Garner", age = "22", gender = "Female", status = "cum"

                ),
                Patient(
                    id = "4",
                    name = "Delores Griffin",
                    age = "25",
                    gender = "Male",
                    status = "accusata"
                ),
                Patient(
                    id = "5", name = "Carmelo McIntyre", age = "34", gender = "Male", status = "mea"
                )
            )
        )
    }

    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
    ) {
        item {
            GreetingsCard(onNotificationClick)
        }
        item {
            BannersList()
        }
        item {
            FiltersList {
                demoPatients = demoPatients.let {
                    Collections.shuffle(it)
                    it.take(3)
                }
            }
        }
        item {
            Text(
                text = "Booking  list",
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold
            )
        }
        item {
            BookingList(demoPatients, onDetailsClick)
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun HomeScreenPreview() {
    HomeScreen({}, {})
}