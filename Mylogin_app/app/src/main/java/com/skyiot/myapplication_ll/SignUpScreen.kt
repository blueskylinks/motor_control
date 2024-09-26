package com.skyiot.myapplication_ll

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun SignupScreen() {
    var firstName by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var mobileNumber by remember { mutableStateOf("") }
    var otp by remember { mutableStateOf("") }
    var gender by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var otpVerified by remember { mutableStateOf(false) }
    val passwordVisibility = remember { mutableStateOf(false) }


    Column( modifier = Modifier
        .fillMaxSize()
        .padding(18.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(text = "Create an account",
            fontSize = 24.sp, fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Start, modifier = Modifier
                .fillMaxWidth()
                .padding(1.dp))

        Spacer(modifier = Modifier.height(16.dp))

        // First Name and Last Name Fields
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            OutlinedTextField(
                value = firstName,
                onValueChange = { firstName = it },
                label = { Text("First Name",
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.SansSerif)
                },
                placeholder = { Text(text = "Type Name") },
                singleLine = true,
                leadingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_baseline_person),
                        contentDescription = null,
                    )
                },
                modifier = Modifier
                    .weight(1f)
                    .padding(end = 8.dp)
            )
            OutlinedTextField(
                value = lastName,
                onValueChange = { lastName = it },
                label = { Text("Last Name",
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.SansSerif) },
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 8.dp)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Email Field
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email",
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.SansSerif)
            },
            placeholder = { Text(text = "email@gmail.com") },
            singleLine = true,
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_baseline_email_24),
                    contentDescription = null,
                )
            },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Mobile Number and OTP
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            OutlinedTextField(
                value = mobileNumber,
                onValueChange = { mobileNumber = it },
                label = { Text("Enter Mobile Number",
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.SansSerif)
                },
                placeholder = { Text(text = "mobile number") },
                singleLine = true,
                leadingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_baseline_phone_24),
                        contentDescription = null,
                    )
                },
                modifier = Modifier
                    .weight(1f)
                    .padding(end = 8.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )

            Button(
                onClick = {
                    if (mobileNumber.length == 10) {
                        // Show OTP field only if the mobile number is 10 digits and Indian code (+91)
                    }
                },
                modifier = Modifier.align(Alignment.CenterVertically),
                enabled = mobileNumber.length == 10
            ) {
                Text("Send OTP")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // OTP and Verify Button
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            OutlinedTextField(
                value = otp,
                onValueChange = { otp = it },
                label = { Text("OTP",
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.SansSerif) },
                modifier = Modifier
                    .weight(1f)
                    .padding(end = 8.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )

            Button(
                onClick = {
                    if (otp == "1234") { // Assuming OTP is "1234" for this example
                        otpVerified = true
                    }
                },
                modifier = Modifier.align(Alignment.CenterVertically)
            ) {
                Text("Verify OTP")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Gender Dropdown Field
        DropdownMenu(
            options = listOf("Male", "Female", "Other"),
            selectedOption = gender,
            onOptionSelected = { gender = it },
            enabled = otpVerified
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Password Field
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password",
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.SansSerif)
            },
            placeholder = { Text(text = "") },
            singleLine = true,
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_baseline_lock_24),
                    contentDescription = null,
                )
            },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            trailingIcon = {
                IconButton(onClick = {
                    passwordVisibility.value = !passwordVisibility.value
                }) {
                    // Icon(
                    //   imageVector = vectorResource(id = R.drawable.password_eye),
                    // tint = if (passwordVisibility.value) primaryColor else Color.Gray
                    //)
                }
            },
            visualTransformation = if (passwordVisibility.value) VisualTransformation.None
            else PasswordVisualTransformation(),
            enabled = otpVerified
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Confirm Password Field
        OutlinedTextField(
            value = confirmPassword,
            onValueChange = { confirmPassword = it },
            label = { Text("Confirm Password",
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.SansSerif)
            },
            placeholder = { Text(text = "") },
            singleLine = true,
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_baseline_lock_24),
                    contentDescription = null,
                )
            },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            trailingIcon = {
                IconButton(onClick = {
                    passwordVisibility.value = !passwordVisibility.value
                }) {
                    // Icon(
                    //   imageVector = vectorResource(id = R.drawable.password_eye),
                    // tint = if (passwordVisibility.value) primaryColor else Color.Gray
                    //)
                }
            },
            visualTransformation = if (passwordVisibility.value) VisualTransformation.None
            else PasswordVisualTransformation(),
            enabled = otpVerified
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Submit Button
        Button(
            onClick = {
                // Handle form submission
            },
            modifier = Modifier.fillMaxWidth(),
            enabled = otpVerified
        ) {
            Text("Submit",fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.SansSerif)
        }
    }
}

@Composable
fun DropdownMenu(options: List<String>, selectedOption: String, onOptionSelected: (String) -> Unit, enabled: Boolean) {
    var expanded by remember { mutableStateOf(false) }

    Box {
        OutlinedTextField(
            value = selectedOption,
            onValueChange = { },
            label = { Text("Gender",
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.SansSerif) },
            modifier = Modifier.fillMaxWidth(),
            readOnly = true,
            enabled = enabled,
            trailingIcon = {
                IconButton(onClick = { expanded = true }, enabled = enabled) {
                    Icon(Icons.Default.ArrowDropDown, contentDescription = null)
                }
            }
        )

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier.fillMaxWidth()
        ) {
            options.forEach { option ->
                DropdownMenuItem(onClick = {
                    onOptionSelected(option)
                    expanded = false
                }) {
                    Text(text = option)
                }
            }
        }
    }
}
