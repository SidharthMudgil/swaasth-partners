package com.swaasth.partner.ui.presentation.queue

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.swaasth.partner.domain.model.Patient
import com.swaasth.partner.ui.component.PatientItemCard
import com.swaasth.partner.ui.theme.Blue80
import com.swaasth.partner.ui.theme.Green10
import com.swaasth.partner.ui.theme.Green80
import com.swaasth.partner.ui.theme.Grey20
import com.swaasth.partner.ui.theme.Grey80
import com.swaasth.partner.ui.theme.White

@Composable
fun LiveQueueScreen(
    onClick: () -> Unit
) {
    val nextInPatients = listOf(
        Patient(
            id = "1", name = "Mayank", age = "21", gender = "Male", status = ""
        ),
        Patient(
            id = "2", name = "Rosy", age = "21", gender = "Female", status = ""
        ),
        Patient(
            id = "3", name = "Prakhar", age = "24", gender = "Male", status = ""
        ),
    )
    val travellingPatients = listOf(
        Patient(
            id = "1", name = "Soumya", age = "21", gender = "Female", status = "ETA 7min"
        ),
        Patient(
            id = "2", name = "Karan", age = "27", gender = "Male", status = "ETA 8min"
        ),
        Patient(
            id = "3", name = "Abhijeet", age = "19", gender = "Male", status = "ETA 9min"
        ),
    )

    var ready by remember {
        mutableStateOf(false)
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        item {
            Text(
                text = "Live Queue",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                color = Grey80,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
        }

        item {
            Spacer(modifier = Modifier.padding(top = 16.dp))
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "On going",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    color = Grey80,
                    textAlign = TextAlign.Center,
                )

                if (ready) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(4.dp),
                        modifier = Modifier
                            .clip(RoundedCornerShape(50.dp))
                            .background(Green80, RoundedCornerShape(50.dp))
                            .padding(4.dp)
                    ) {
                        Text(
                            text = "Start Treatment",
                            color = White,
                            fontWeight = FontWeight.SemiBold
                        )
                        Box (
                            modifier = Modifier
                                .clickable {
                                    ready = false
                                }
                                .size(24.dp)
                                .background(White, CircleShape)
                                .clip(CircleShape)
                        ) {}
                    }
                } else {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(4.dp),
                        modifier = Modifier
                            .clip(RoundedCornerShape(50.dp))
                            .background(Grey20, RoundedCornerShape(50.dp))
                            .padding(4.dp)
                    ) {
                        Box (
                            modifier = Modifier
                                .clickable {
                                    ready = true
                                }
                                .size(24.dp)
                                .background(White, CircleShape)
                                .clip(CircleShape)
                        ) {}
                        Text(
                            text = "Stop Treatment",
                            color = Grey80,
                            fontWeight = FontWeight.SemiBold,
                        )
                    }
                }
            }
        }

        item {
            Spacer(modifier = Modifier.padding(top = 16.dp))
            Card(
                shape = RoundedCornerShape(12.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Blue80
                ),
                elevation = CardDefaults.elevatedCardElevation(
                    defaultElevation = 2.dp
                ),
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(White)
                        .clip(RoundedCornerShape(12.dp))
                        .padding(8.dp)
                ) {
                    AsyncImage(
                        model = "https://pixahive.com/wp-content/uploads/2021/02/An-Indian-boy-375075-pixahive.jpg",
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .clip(RoundedCornerShape(12.dp))
                            .size(100.dp, 120.dp)
                    )

                    Column(
                        verticalArrangement = Arrangement.spacedBy(4.dp),
                        modifier = Modifier.weight(1f)
                    ) {
                        Text(
                            text = "Ashutosh",
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp,
                            color = Grey80
                        )
                        Text(
                            text = "18, male",
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 20.sp,
                            color = Grey80
                        )
                        Text(
                            text = "Paid",
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp,
                            color = Green80,
                            modifier = Modifier
                                .background(Green10, RoundedCornerShape(12.dp))
                                .padding(12.dp, 8.dp)
                        )
                    }
                }

                Text(
                    text = "View Details",
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                        .clickable {
                            onClick()
                        }
                )
            }
        }

        item {
            Spacer(modifier = Modifier.padding(top = 16.dp))
            Row {
                Text(
                    text = "Next in Patients",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    color = Grey80,
                )

                Text(
                    text = "[3]",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    color = Blue80,
                    modifier = Modifier.padding(start = 4.dp)
                )
            }

            Spacer(modifier = Modifier.padding(top = 8.dp))
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.heightIn(max = 500.dp)
            ) {
                items(nextInPatients) {
                    PatientItemCard(patient = it, onClick = onClick)
                }
            }
        }

        item {
            Spacer(modifier = Modifier.padding(top = 16.dp))
            Row {
                Text(
                    text = "Travelling Patients",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    color = Grey80,
                )

                Text(
                    text = "[3]",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    color = Blue80,
                    modifier = Modifier.padding(start = 4.dp)
                )
            }

            Spacer(modifier = Modifier.padding(top = 8.dp))
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.heightIn(max = 500.dp)
            ) {
                items(travellingPatients) {
                    PatientItemCard(
                        patient = it,
                        negativeColor = true,
                        showButton = false
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun LiveQueueScreenPreview() {
    LiveQueueScreen {}
}