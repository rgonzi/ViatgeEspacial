package com.rgonzi.viatgeespacial.ui

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rgonzi.viatgeespacial.R

@Composable
fun EntryScreen(
    @StringRes label: Int,
    @DrawableRes leadingIcon: Int,
    entryValue: String,
    onValueChange: (String) -> Unit,
    nextScreen: () -> Unit,
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
            modifier = Modifier
                .fillMaxWidth(),
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

            EntryField(
                label = label,
                leadingIcon = leadingIcon,
                entryValue = entryValue,
                onValueChange = onValueChange
            )
        }

        if (entryValue.isNotEmpty()) {
            Button(
                onClick = { nextScreen() }
            ) {
                Text(text = "Següent")
            }
        }
    }
}


@Composable
fun EntryField(
    @StringRes label: Int,
    @DrawableRes leadingIcon: Int,
    entryValue: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    OutlinedTextField(
        value = entryValue,
        label = { Text(stringResource(id = label)) },
        singleLine = true,
        leadingIcon = {
            Icon(painter = painterResource(id = leadingIcon), null)
        },
        onValueChange = onValueChange,
        modifier = modifier
    )
}

@Preview(showSystemUi = true)
@Composable
fun EntryScreenPreview() {
    EntryScreen(
        label = R.string.app_name,
        leadingIcon = R.drawable.numbers_icon,
        entryValue = "Test",
        onValueChange = {},
        nextScreen = {})
}