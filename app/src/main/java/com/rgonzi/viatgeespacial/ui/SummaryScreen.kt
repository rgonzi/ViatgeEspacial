package com.rgonzi.viatgeespacial.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rgonzi.viatgeespacial.R

@Composable
fun SummaryScreen(
    name: String,
    age: String,
    destination: String,
    onRestart: () -> Unit,
    modifier: Modifier = Modifier
) {
    val userEntries = listOf(
        Pair("Nom", name),
        Pair("Edat", age),
        Pair("Destinació", destination)
    )

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
            Column(
                modifier = Modifier.padding(horizontal = 32.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                userEntries.forEach { entry ->
                    Text(entry.first.uppercase())
                    Text(text = entry.second, fontWeight = FontWeight.Bold)
                    HorizontalDivider(thickness = 1.dp)
                }
            }
        }

        Button(
            onClick = { onRestart() }
        ) {
            Text(text = "Reiniciar")
        }
    }
}


@Preview(showSystemUi = true)
@Composable
fun SummaryScreenPreview() {
    SummaryScreen(
        name = "Roger",
        age = "31",
        destination = "Lluna",
        onRestart = {}
    )
}