package com.skyiot.myapplication_ll

import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.skyiot.myapplication_ll.ui.theme.Shapes

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun Mobilescreen(context: Context,
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

        var userPhone = remember { mutableStateOf("") }
        //var userAddress = remember { mutableStateOf("") }
        var userPassword = remember { mutableStateOf("") }

        val passwordVisibility = remember { mutableStateOf(false) }

        Image(painter = painterResource(id = R.drawable.skyy),
            contentDescription = "login image",
            modifier = Modifier.size(230.dp))

        Text(text = "Login", fontSize = 30.sp, fontWeight = FontWeight.Bold, )

        Spacer(modifier = Modifier.height(4.dp))

        Row() {
            Text(text = "Email Address",
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.SansSerif,
                style = TextStyle(Color.LightGray),
                modifier = Modifier.clickable {})
            Spacer(modifier = Modifier.width(48.dp))
            Text(text = "Mobile Number",
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.SansSerif,
                modifier = Modifier.clickable {})
        }

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = userPhone.value,
            onValueChange = { userPhone.value = it },
            label = {
                Text(text = "Phone",
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.SansSerif)
            },
            placeholder = { Text(text = "1234567890") },
            singleLine = true,
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_baseline_phone_24),
                    contentDescription = null,
                )
            },
            modifier = Modifier.fillMaxWidth(0.9f),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone)
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = userPassword.value,
            onValueChange = { userPassword.value = it },
            label = {
                Text(text = "Password",
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
            modifier = Modifier.fillMaxWidth(0.9f),
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
            else PasswordVisualTransformation()
        )
        Spacer(modifier = Modifier.height(2.dp))

        Text(text = "Forgot password !",
            color = Color.Blue,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Start,
            modifier = Modifier
                .fillMaxWidth()
                .padding(18.dp))

         Spacer(modifier = Modifier.height(8.dp))
        Button(
            onClick = {
                if (userPhone.value.isEmpty()) {
                    Toast.makeText(context, " Please Enter Number", Toast.LENGTH_SHORT).show()
                } else if (userPassword.value.isEmpty()) {
                    Toast.makeText(context, "Enter Password", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(context, "Validation Successfully Completed", Toast.LENGTH_SHORT)
                        .show()
                }
            },
            shape = Shapes.medium,
        ) {
            Text(text = " login", modifier = Modifier.fillMaxWidth(0.8f),
                fontSize = 20.sp, textAlign = TextAlign.Center)
        }

        Spacer(modifier = Modifier.height(22.dp))

        Text(text = "Or login with", color = Color.Black, fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.clickable { })

        Spacer(modifier = Modifier.height(8.dp))

        Surface(onClick = { clicked = !clicked },
            shape = Shapes.medium,
            border = BorderStroke(width = 1.dp, color = Color.LightGray),
            color = MaterialTheme.colors.surface
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(0.8f)
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

        Spacer(modifier = Modifier.height(3.dp))

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