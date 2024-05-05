package com.swaasth.partner.ui.presentation.add_patient

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.rounded.AccessTime
import androidx.compose.material.icons.rounded.Description
import androidx.compose.material.icons.rounded.PostAdd
import androidx.compose.material3.Button
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TimeInput
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import androidx.core.content.FileProvider
import com.swaasth.partner.BuildConfig
import com.swaasth.partner.common.utils.createImageFile
import com.swaasth.partner.ui.component.DropdownInput
import com.swaasth.partner.ui.component.InputField
import com.swaasth.partner.ui.component.TimePickerDialog
import com.swaasth.partner.ui.presentation.add_patient.component.LabeledImageButton
import java.util.Objects

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddPatientScreen() {
    val datePickerState = rememberDatePickerState()
    var showDatePicker by remember { mutableStateOf(false) }
    val timePickerState = rememberTimePickerState()
    var showTimePicker by remember { mutableStateOf(false) }
    var expandedState by remember { mutableStateOf(false) }
    var selectedItem by remember { mutableStateOf("") }

    val context = LocalContext.current
    val file = context.createImageFile()
    val uri = FileProvider.getUriForFile(
        Objects.requireNonNull(context),
        BuildConfig.APPLICATION_ID + ".provider", file
    )

    var capturedImageUri by remember {
        mutableStateOf<Uri>(Uri.EMPTY)
    }

    val cameraLauncher =
        rememberLauncherForActivityResult(ActivityResultContracts.TakePicture()) {
            capturedImageUri = uri
        }

    val permissionLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) {
        if (it) {
            Toast.makeText(context, "Permission Granted", Toast.LENGTH_SHORT).show()
            cameraLauncher.launch(uri)
        } else {
            Toast.makeText(context, "Permission Denied", Toast.LENGTH_SHORT).show()
        }
    }

    val galleryLauncher =
        rememberLauncherForActivityResult(
            contract = ActivityResultContracts.StartActivityForResult()
        ) {
            if (it.resultCode == Activity.RESULT_OK) {
                val data: Intent? = it.data
                if (data != null) {
                    capturedImageUri = Uri.parse(data.data.toString())
                }
            }
        }

    val permissionLauncher1 = rememberLauncherForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) {
        if (it) {
            Toast.makeText(context, "Permission Granted", Toast.LENGTH_SHORT).show()
            galleryLauncher.launch(Intent(Intent.ACTION_PICK))
        } else {
            Toast.makeText(context, "Permission Denied", Toast.LENGTH_SHORT).show()
        }
    }

    Scaffold {
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier
                .padding(it)
                .padding(16.dp)
                .fillMaxHeight()
                .fillMaxWidth()
        ) {
            Text(
                text = "Add Patient",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )

            Spacer(modifier = Modifier.padding(top = 8.dp))
            InputField(
                hint = "Enter Patient name",
                onValueChange = {},
                outlined = true
            )

            InputField(
                hint = "Enter Age",
                onValueChange = {},
                outlined = true
            )

            DropdownInput(
                selected = selectedItem,
                expanded = expandedState,
                items = listOf("Male", "Female", "Other"),
                onExpandedChange = {
                    expandedState = !expandedState
                },
                hint = "Select a Gender",
                onValueChange = { value ->
                    selectedItem = value
                },
                onItemClick = { value ->
                    selectedItem = value
                    expandedState = false
                },
                onDismissRequest = {
                    expandedState = false
                }
            )

            InputField(
                hint = "Select Date",
                onValueChange = {},
                trailingIcon = Icons.Filled.CalendarMonth,
                outlined = true,
                readOnly = true,
                enabled = false,
                onClick = {
                    showDatePicker = true
                }
            )

            InputField(
                hint = "Select Time",
                onValueChange = {},
                trailingIcon = Icons.Rounded.AccessTime,
                outlined = true,
                enabled = false,
                readOnly = true,
                onClick = {
                    showTimePicker = true
                }
            )

            Row(
                horizontalArrangement = Arrangement.SpaceAround,
                modifier = Modifier.fillMaxWidth().padding(top = 16.dp)
            ) {
                LabeledImageButton(
                    imageVector = Icons.Rounded.Description,
                    label = "Add Prescription"
                ) {
                    val permissionCheckResult = ContextCompat.checkSelfPermission(
                        context, Manifest.permission.CAMERA
                    )
                    if (permissionCheckResult == PackageManager.PERMISSION_GRANTED) {
                        cameraLauncher.launch(uri)
                    } else {
                        permissionLauncher.launch(Manifest.permission.CAMERA)
                    }
                }
                LabeledImageButton(
                    imageVector = Icons.Rounded.PostAdd,
                    label = "Add Report"
                ) {
                    val permissionCheckResult = ContextCompat.checkSelfPermission(
                        context, Manifest.permission.READ_EXTERNAL_STORAGE
                    )
                    if (permissionCheckResult == PackageManager.PERMISSION_GRANTED) {
                        galleryLauncher.launch(Intent(Intent.ACTION_PICK))
                    } else {
                        permissionLauncher1.launch(Manifest.permission.READ_EXTERNAL_STORAGE)
                    }
                }
            }

            Spacer(modifier = Modifier.weight(1f))
            Button(
                shape = RoundedCornerShape(12.dp),
                onClick = { },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Submit",
                    fontSize = 18.sp,
                    modifier = Modifier.padding(8.dp)
                )
            }

            if (showDatePicker) {
                DatePickerDialog(
                    onDismissRequest = { showDatePicker = false },
                    confirmButton = {
                        TextButton(
                            onClick = {
                                showDatePicker = false
                            }
                        ) { Text("OK") }
                    },
                    dismissButton = {
                        TextButton(
                            onClick = {
                                showDatePicker = false
                            }
                        ) { Text("Cancel") }
                    }
                )
                {
                    DatePicker(state = datePickerState)
                }
            }

            if (showTimePicker) {
                TimePickerDialog(
                    onCancel = { showTimePicker = false },
                    onConfirm = { showTimePicker = false }
                ) {
                    TimeInput(state = timePickerState)
                }
            }
        }
    }
}

@Preview
@Composable
private fun AddPatientScreenPreview() {
    AddPatientScreen()
}