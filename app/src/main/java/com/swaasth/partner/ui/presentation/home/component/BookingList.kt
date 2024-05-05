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
fun BookingList(
    demoPatients: List<Patient> = emptyList(),
    onDetailsClick: () -> Unit,
) {
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
            PatientItemCard(it, onClick = onDetailsClick)
        }
    }
}

@Preview
@Composable
private fun BookingListPreview() {
    BookingList {

    }
}