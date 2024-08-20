package com.skyiot.myapplication_ll

import android.content.Context
import android.widget.Toast
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.Placeholder
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.skyiot.myapplication_ll.ui.theme.MyApplication_llTheme
import com.skyiot.myapplication_ll.ui.theme.Purple500
import com.skyiot.myapplication_ll.ui.theme.Shapes


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun EmailInput(context: Context,
               text: String = "Continue with Google",
               loadingText: String = "Wait a moment..."
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        var clicked by remember { mutableStateOf(false) }

        var userEmail = remember { mutableStateOf("") }
        //var userAddress = remember { mutableStateOf("") }
        var userPassword = remember { mutableStateOf("") }

        val passwordVisibility = remember { mutableStateOf(false) }

        Spacer(modifier = Modifier.height(6.dp))

        OutlinedTextField(
            value = userEmail.value,
            onValueChange = { userEmail.value = it },
            label = { Text(text = "Email",fontWeight= FontWeight.Bold, fontFamily = FontFamily.SansSerif) },
            placeholder = { Text(text = "email@gmail.com") },
            singleLine = true,
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_baseline_email_24),
                    contentDescription = null,
                )
            },
            modifier = Modifier.fillMaxWidth(0.9f)
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = userPassword.value,
            onValueChange = { userPassword.value = it },
            label = { Text(text = "Password",
                fontWeight= FontWeight.Bold, fontFamily = FontFamily.SansSerif) },
            placeholder = { Text(text = "Password") },
            singleLine = true,
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_baseline_lock_24),
                    contentDescription = null,
                )
            },
            modifier = Modifier.fillMaxWidth(0.9f),
            trailingIcon = {
                IconButton(onClick = {
                    passwordVisibility.value = !passwordVisibility.value }) {
                    // Icon(
                    //   imageVector = vectorResource(id = R.drawable.password_eye),
                    // tint = if (passwordVisibility.value) primaryColor else Color.Gray
                    //)
                }
            },
            visualTransformation = if (passwordVisibility.value) VisualTransformation.None
            else PasswordVisualTransformation()
        )

        Spacer(modifier = Modifier.height(2.dp))

        Text(text = "Forgot password !",
            color = Color.Blue,fontSize = 16.sp,
            textAlign = TextAlign.Start,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .padding(14.dp))

        // Spacer(modifier = Modifier.height(8.dp))

        Button(
            onClick = {
                if (userEmail.value.isEmpty()) {
                    Toast.makeText(context, " Please Enter Email", Toast.LENGTH_SHORT).show()
                } else if (userPassword.value.isEmpty()) {
                    Toast.makeText(context, "Enter Password", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(context, "Validation Successfully Completed", Toast.LENGTH_SHORT)
                        .show()
                }
            },
            shape = Shapes.medium,
        ) {
            Text(text = " login",
                modifier = Modifier.fillMaxWidth(0.9f),
                fontSize = 20.sp, textAlign = TextAlign.Center)
        }
        Spacer(modifier = Modifier.height(12.dp))
        //This is a google text
        Text(text = "Or login with",color = Color.Black, fontSize = 15.sp,
            fontWeight= FontWeight.Bold,
            )

        Spacer(modifier = Modifier.height(8.dp))

        Surface ( onClick = {clicked = !clicked},
            shape = Shapes.medium,
            border = BorderStroke(width = 1.dp, color = Color.LightGray),
            color = MaterialTheme.colors.surface
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .background(color = Color.LightGray)
                    .fillMaxHeight(0.4f)
                    .clickable { }
                    .animateContentSize(animationSpec = tween(
                        durationMillis = 300,
                        easing = LinearOutSlowInEasing
                    )
                    ),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center) {
                Icon(painter = painterResource(id = R.drawable.ggg),
                    contentDescription = "google img",
                    tint = Color.Unspecified
                )
                Text(text = if (clicked) loadingText else text, color = Color.White)
                if (clicked) {
                    Spacer(modifier = Modifier.height(16.dp))
                    CircularProgressIndicator(
                        modifier = Modifier
                            .height(16.dp)
                            .width(16.dp),
                        strokeWidth = 2.dp,
                        color = MaterialTheme.colors.primary
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(2.dp))

        Row(modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .wrapContentSize(align = Alignment.BottomCenter)) {

            Text(text = "Don't have an account?",
                color = Color.Black,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.size(8.dp))
            Text(
                text = "Sign Up",
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                modifier = Modifier.clickable { },
                color = MaterialTheme.colors.primary
            )
        }
    }

}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MobileInput(
    modifier: Modifier = Modifier,
    countryCode: String = "+91 "
) {
    val context = LocalContext.current
    val otpVal: String? = null
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        var text by remember { mutableStateOf("") }
        var userPhone = remember { mutableStateOf("") }
        var pin by remember { mutableStateOf("") }
        var otpGenerated by remember { mutableStateOf(false) }

        Spacer(modifier = Modifier.height(2.dp))

        OutlinedTextField(
            value = text,
            onValueChange = { newText ->
                // Remove the country code part to validate the mobile number
                val numberWithoutCode = if (newText.startsWith(countryCode)) {
                    newText.substring(countryCode.length)
                } else {
                    newText
                }

                // Check if the newText is valid
                if (numberWithoutCode.length <= 10 && numberWithoutCode.all { it.isDigit() }) {
                    text = if (numberWithoutCode.length == 10) {
                        "$countryCode$numberWithoutCode"
                    } else {
                        newText
                    }
                   // onNumberChanged(text)
                }
             },
            label = {
                Text(text = "Enter Number",
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
            modifier = Modifier.fillMaxWidth(0.8f),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone)
        )
        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "Enter your 4 Digit  PIN",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Start
        )

        Spacer(modifier = Modifier.height(10.dp))

        OTPTextFields(
            length = 4
        ) {
                getOpt -> otpVal
        }

        Spacer(modifier = Modifier.height(12.dp))
//
//        Button(
//            onClick = {
//                if (otpVal != null) {
//                    Toast.makeText(context, "Please Enter Otp", Toast.LENGTH_SHORT).show()
//                }
//            },
//            modifier = Modifier
//                .fillMaxWidth(0.8f)
//                .height(45.dp)
//                .background(Purple500),
//            shape = RoundedCornerShape(10.dp)
//        ) {
//            Text(
//                text = "Get Otp",
//                fontSize = 15.sp,
//                color = Color.White
//            )
//        }

//        Button(
//            onClick = {
//                otpGenerated = true
//                // Here you would normally trigger the OTP generation process.
//            },
//            shape = Shapes.medium,
//            modifier = Modifier
//                .fillMaxWidth(0.9f)
//                .padding(bottom = 12.dp),
//            colors = ButtonDefaults.buttonColors(contentColor = Color.Black)
//        ) {
//            Text("Generate PIN",fontSize = 20.sp, color = Color.White)
//        }
//        Spacer(modifier = Modifier.height(0.1.dp))
//
//        if (otpGenerated) {
//            OutlinedTextField(
//                value = pin,
//                onValueChange = { pin = it },
//                label = { Text("Enter PIN") },
//                placeholder = { Text(text = "Enter your PIN number") },
//                keyboardOptions = KeyboardOptions.Default.copy(
//                    keyboardType = KeyboardType.Number,
//                    imeAction = ImeAction.Done
//                ),
//                modifier = Modifier
//                    .fillMaxWidth(0.9f)
//                    .padding(bottom = 12.dp),
//                visualTransformation = PasswordVisualTransformation() // Hide PIN input for security
//            )
//        }
        Button(
            onClick = { },
            shape = Shapes.medium,
        ) {
            Text(text = " login",
                modifier = Modifier.fillMaxWidth(0.8f),
                fontSize = 20.sp, textAlign = TextAlign.Center)
        }
        Spacer(modifier = Modifier.height(2.dp))
        Text(text = "Forgot PIN !",
            color = Color.Blue,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.End,
            modifier = Modifier
                .fillMaxWidth()
                .padding(18.dp))
        Spacer(modifier = Modifier.height(1.dp))

        Button(
            onClick = { },
            shape = Shapes.medium,
        ) {
            Text(text = " For login using OTP ",
                color = Color.Cyan,
                modifier = Modifier.fillMaxWidth(0.8f),
                fontSize = 20.sp, textAlign = TextAlign.Center)
        }
         Spacer(modifier = Modifier.height(1.dp))

        Row(modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .wrapContentSize(align = Alignment.BottomCenter)) {

            Text(text = "Don't have an account?",
                color = Color.Black,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.size(8.dp))
            Text(
                text = "Sign Up",
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                modifier = Modifier.clickable {
                },
                color = MaterialTheme.colors.primary
            )
        }
    }
}

























//        Spacer(modifier = Modifier.height(8.dp))

//        Spacer(modifier = Modifier.height(16.dp))
//
//        OutlinedTextField(
//            value = userPassword.value,
//            onValueChange = { userPassword.value = it },
//            label = {
//                Text(text = "Password",
//                    fontWeight = FontWeight.Bold,
//                    fontFamily = FontFamily.SansSerif)
//            },
//            placeholder = { Text(text = "") },
//            singleLine = true,
//            leadingIcon = {
//                Icon(
//                    painter = painterResource(id = R.drawable.ic_baseline_lock_24),
//                    contentDescription = null,
//                )
//            },
//            modifier = Modifier.fillMaxWidth(0.9f),
//            trailingIcon = {
//                IconButton(onClick = {
//                    passwordVisibility.value = !passwordVisibility.value
//                }) {
//                    // Icon(
//                    //   imageVector = vectorResource(id = R.drawable.password_eye),
//                    // tint = if (passwordVisibility.value) primaryColor else Color.Gray
//                    //)
//                }
//            },
//            visualTransformation = if (passwordVisibility.value) VisualTransformation.None
//            else PasswordVisualTransformation()
//        )
//        Spacer(modifier = Modifier.height(2.dp))
//
//        Text(text = "Forgot password !",
//            color = Color.Blue,
//            fontSize = 16.sp,
//            fontWeight = FontWeight.Bold,
//            textAlign = TextAlign.Start,
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(18.dp))
//
//        Spacer(modifier = Modifier.height(8.dp))
//        Button(
//            onClick = {
//                if (userPhone.value.isEmpty()) {
//                    Toast.makeText(context, " Please Enter Number", Toast.LENGTH_SHORT).show()
//                } else if (userPassword.value.isEmpty()) {
//                    Toast.makeText(context, "Enter Password", Toast.LENGTH_SHORT).show()
//                } else {
//                    Toast.makeText(context, "Validation Successfully Completed", Toast.LENGTH_SHORT)
//                        .show()
//                }
//            },
//            shape = Shapes.medium,
//        )

        // Spacer(modifier = Modifier.height(2.dp))

//        Text(text = "Or login with", color = Color.Black, fontSize = 14.sp,
//            fontWeight = FontWeight.Bold,
//            modifier = Modifier.clickable { })
//
//        Spacer(modifier = Modifier.height(8.dp))
//
//        Surface(onClick = { clicked = !clicked },
//            shape = Shapes.medium,
//            border = BorderStroke(width = 1.dp, color = Color.LightGray),
//            color = MaterialTheme.colors.surface
//        ) {
//            Row(
//                modifier = Modifier
//                    .fillMaxWidth(0.8f)
//                    .background(color = Color.LightGray)
//                    .fillMaxHeight(0.4f)
//                    .clickable { }
//                    .animateContentSize(animationSpec = tween(
//                        durationMillis = 300,
//                        easing = LinearOutSlowInEasing
//                    )
//                    ),
//                verticalAlignment = Alignment.CenterVertically,
//                horizontalArrangement = Arrangement.Center) {
//                Icon(painter = painterResource(id = R.drawable.ggg),
//                    contentDescription = "google img",
//                    tint = Color.Unspecified
//                )
//                Text(text = if (clicked) loadingText else text, color = Color.White)
//                if (clicked) {
//                    Spacer(modifier = Modifier.height(16.dp))
//                    CircularProgressIndicator(
//                        modifier = Modifier
//                            .height(16.dp)
//                            .width(16.dp),
//                        strokeWidth = 2.dp,
//                        color = MaterialTheme.colors.primary
//                    )
//                }


//        Spacer(modifier = Modifier.height(3.dp))
//
//        Row(modifier = Modifier
//            .fillMaxSize()
//            .padding(16.dp)
//            .wrapContentSize(align = Alignment.BottomCenter)) {
//
//            Text(text = "Don't have an account?",
//                color = Color.Black,
//                fontSize = 18.sp,
//                fontWeight = FontWeight.Bold)
//            Spacer(modifier = Modifier.size(8.dp))
//            Text(
//                text = "Sign Up",
//                fontWeight = FontWeight.Bold,
//                fontSize = 18.sp,
//                modifier = Modifier.clickable {
//                },
//                color = MaterialTheme.colors.primary
//            )
//        }
//    }
//}

//@Preview(showBackground = true)
//@Composable
//fun TabRowDefaultsPreview() {
//    MyApplication_llTheme {
//       TabRowExample()
//    }
//}
