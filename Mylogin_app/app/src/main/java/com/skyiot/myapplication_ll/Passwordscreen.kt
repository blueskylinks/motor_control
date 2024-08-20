package com.skyiot.myapplication_ll

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.skyiot.myapplication_ll.ui.theme.MyApplication_llTheme
@Composable
fun PinInputField(
    pin: String,
    onPinChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier
            .padding(16.dp)
    ) {
        for (i in 0 until 4) {
            PinTextField(
                value = pin.getOrNull(i)?.toString() ?: "",
                onValueChange = { char ->
                    val newPin = pin.toCharArray()
                    if (char.isNotEmpty()) {
                        newPin[i] = char[0]
                    } else {
                        newPin[i] = ' '
                    }
                    onPinChange(newPin.concatToString())
                },
                isFocused = i == pin.length
            )
        }
    }
}

@Composable
fun PinTextField(
    value: String,
    onValueChange: (String) -> Unit,
    isFocused: Boolean,
    modifier: Modifier = Modifier
) {
    var text by remember { mutableStateOf(value) }

    OutlinedTextField(
        value = text,
        onValueChange = {
            if (it.length <= 1 && it.all { c -> c.isDigit() }) {
                text = it
                onValueChange(it)
            }
        },
        visualTransformation = PasswordVisualTransformation(), // Mask input with stars
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Number,
            imeAction = ImeAction.Next
        ),
        singleLine = true,
        textStyle = MaterialTheme.typography.h2.copy(fontSize = 24.sp),
        modifier = modifier
            .background(Color.White)
            .border(1.dp, Color.Gray)
            .width(48.dp)
            .height(48.dp)
            .padding(12.dp),
        shape = MaterialTheme.shapes.small
    )
}

@Composable
fun PinScreen() {
    var pin by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Enter PIN",
            style = MaterialTheme.typography.h2.copy(fontSize = 32.sp),
            color = Color.Black,
            modifier = Modifier.padding(bottom = 24.dp)
        )

        PinInputField(
            pin = pin,
            onPinChange = { newPin ->
                if (newPin.length <= 4) {
                    pin = newPin
                }
            }
        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = {
                // Handle PIN verification action here
                println("Entered PIN")
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Verify PIN")
        }
    }
}
@Preview(showBackground = true)
@Composable
fun PasswordScreenDefaultsPreview() {
    MyApplication_llTheme {
     PinScreen()
    }
}