package com.rgonzi.viatgeespacial.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rgonzi.viatgeespacial.R
import com.rgonzi.viatgeespacial.data.DataSource

@Composable
fun DestinationScreen(
    onDestinationSelect: (String) -> Unit,
    options: List<String>,
    nextScreen: () -> Unit,
    destination: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = stringResource(id = R.string.app_name),
                fontSize = 28.sp
            )
            Spacer(modifier = Modifier.height(16.dp))
            Image(
                painter = painterResource(id = R.drawable.rocket_image),
                contentDescription = stringResource(R.string.rocket_img_description),
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Spacer(modifier = Modifier.height(16.dp))

            PlanetOptions(onDestinationSelect = onDestinationSelect, options = options)
        }

        if (destination.isNotEmpty()) {
            Button(
                onClick = { nextScreen() }
            ) {
                Text(text = "Següent")
            }
        }
    }
}


@Composable
fun PlanetOptions(
    onDestinationSelect: (String) -> Unit,
    options: List<String>
) {
    var selectedValue by remember { mutableStateOf("") }
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(text = "Escull un planeta:", fontSize = 20.sp)
        options.forEach { item ->
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .selectable(
                        selected = selectedValue == item,
                        onClick = {
                            selectedValue = item
                            onDestinationSelect(selectedValue)
                        }
                    )
            ) {
                RadioButton(
                    selected = selectedValue == item,
                    onClick = {
                        selectedValue = item
                        onDestinationSelect(selectedValue)
                    }
                )
                Text(text = item)
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun DestinationScreenPreview() {
    DestinationScreen(
        onDestinationSelect = {},
        options = listOf("Lluna", "Terra", "Mart", "Plutó"),
        nextScreen = { },
        destination = "Test"
    )
}