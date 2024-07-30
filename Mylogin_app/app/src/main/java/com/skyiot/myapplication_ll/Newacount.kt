package com.skyiot.myapplication_ll

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.skyiot.myapplication_ll.ui.theme.Shapes

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun Newaccount(text: String = "Continue with Google",
               loadingText: String = "Wait a moment..."
){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        var clicked by remember { mutableStateOf(false) }

        var userYourName = remember { mutableStateOf("") }
        var userEmail = remember { mutableStateOf("") }
        var userPassword = remember { mutableStateOf("") }

        val passwordVisibility = remember { mutableStateOf(false) }

          Text(text = "Create an account",
              fontSize = 24.sp, fontWeight = FontWeight.Bold,
              textAlign = TextAlign.Start, modifier = Modifier
                  .fillMaxWidth()
                  .padding(18.dp))

        //Spacer(modifier = Modifier.height(4.dp))
        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = userEmail.value,
            onValueChange = { userEmail.value = it },
            label = { Text(text = "Your Name",fontWeight= FontWeight.Bold, fontFamily = FontFamily.SansSerif) },
            placeholder = { Text(text = "Type Name") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth(0.9f)
        )

        Spacer(modifier = Modifier.height(30.dp))

        OutlinedTextField(
            value = userEmail.value,
            onValueChange = { userEmail.value = it },
            label = { Text(text = "Email",fontWeight= FontWeight.Bold, fontFamily = FontFamily.SansSerif) },
            placeholder = { Text(text = "email@gmail.com") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth(0.9f)
        )

        Spacer(modifier = Modifier.height(30.dp))

        OutlinedTextField(
            value = userPassword.value,
            onValueChange = { userPassword.value = it },
            label = { Text(text = "Password",fontWeight= FontWeight.Bold, fontFamily = FontFamily.SansSerif) },
            placeholder = { Text(text = "") },
            singleLine = true,
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

        Text(text = "By continue your agee to term & service",
            color = Color.Black,fontSize = 14.sp,fontFamily = FontFamily.SansSerif,textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .padding(14.dp))

        // Spacer(modifier = Modifier.height(8.dp))

        Button(onClick = { }) {
            Text(text = " login", modifier = Modifier.fillMaxWidth(0.8f),
                fontSize = 20.sp, textAlign = TextAlign.Center,fontFamily = FontFamily.SansSerif)
        }

        Spacer(modifier = Modifier.height(10.dp))

        Text(text = "Or sign with",color = Color.Black, fontSize = 14.sp,
            fontWeight= FontWeight.Bold,fontFamily = FontFamily.SansSerif,
            modifier = Modifier.clickable{ })

        Spacer(modifier = Modifier.height(12.dp))

        Surface ( onClick = {clicked = !clicked},
            shape = Shapes.medium,
            border = BorderStroke(width = 1.dp, color = Color.LightGray),
            color = MaterialTheme.colors.surface
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .background(color = Color.LightGray)
                    .fillMaxHeight(0.2f)
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

        Spacer(modifier = Modifier.height(36.dp))

        Row() {
            Text(text = "Already have an account ?", fontSize = 14.sp,
                fontWeight= FontWeight.Bold,fontFamily = FontFamily.SansSerif,
                style = TextStyle(Color.DarkGray),
                modifier = Modifier.clickable{})
            Spacer(modifier =Modifier.width(10.dp))
            Text(text = "Sign in here", fontSize = 14.sp,color = Color.Blue,
                fontWeight= FontWeight.Bold,fontFamily = FontFamily.SansSerif,
                modifier = Modifier.clickable {})
        }
        }

}
