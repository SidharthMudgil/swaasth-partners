package com.swaasth.partner.ui.presentation.home.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.swaasth.partner.domain.model.Patient
import com.swaasth.partner.ui.component.PatientItemCard

@Composable
fun BookingList() {
    val demoPatients = listOf(
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
            id = "4", name = "Delores Griffin", age = "25", gender = "Male", status = "accusata"
        ),
        Patient(
            id = "5", name = "Carmelo McIntyre", age = "34", gender = "Male", status = "mea"
        )
    )

    LazyColumn(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(max = 1000.dp)
            .padding(horizontal = 16.dp)
            .padding(bottom = 16.dp)
    ) {
        items(demoPatients) {
            PatientItemCard(it)
        }
    }
}

@Preview
@Composable
private fun BookingListPreview() {
    BookingList()
}