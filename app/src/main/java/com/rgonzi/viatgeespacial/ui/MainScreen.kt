package com.rgonzi.viatgeespacial.ui

import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.rgonzi.viatgeespacial.R
import com.rgonzi.viatgeespacial.data.DataSource

@Composable
fun MainScreen(
    modifier: Modifier = Modifier
        .verticalScroll(rememberScrollState())
) {
    var currentStep by rememberSaveable { mutableStateOf(1) }
    var name by rememberSaveable { mutableStateOf("") }
    var age by rememberSaveable { mutableStateOf("") }
    var destination by rememberSaveable { mutableStateOf("") }

    when (currentStep) {
        1 -> EntryScreen(
            entryValue = name,
            onValueChange = { name = it },
            label = R.string.name_entry,
            leadingIcon = R.drawable.letters_icon,
            nextScreen = { if (name.isNotEmpty()) currentStep = 2 },
            modifier = modifier
        )

        2 -> EntryScreen(
            entryValue = age,
            onValueChange = { age = it },
            label = R.string.age_entry,
            leadingIcon = R.drawable.numbers_icon,
            nextScreen = { if (age.isNotEmpty()) currentStep = 3 },
            modifier = modifier
        )

        3 -> DestinationScreen(
            onDestinationSelect = { destination = it },
            options = DataSource.destinationOptions,
            nextScreen = { currentStep = 4 },
            destination = destination,
            modifier = modifier
        )

        4 -> SummaryScreen(
            name = name,
            age = age,
            destination = destination,
            onRestart = {
                name = ""
                age = ""
                destination = ""
                currentStep = 1
            },
            modifier = modifier
        )
    }
}

