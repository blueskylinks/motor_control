package com.skyiot.myapplication_ll

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
//import androidx.compose.foundation.layout.ColumnScopeInstance.align
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
//import androidx.navigation.NavController
import com.skyiot.myapplication_ll.ui.theme.Shapes
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun Loginscreen() {
    Column(
        modifier = Modifier.fillMaxSize()
            .padding(10.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        var clicked by remember { mutableStateOf(false) }

        var userEmail = remember { mutableStateOf("") }
        var userPassword = remember { mutableStateOf("") }

        val passwordVisibility = remember { mutableStateOf(false) }

        Image(painter = painterResource(id = R.drawable.loginimg),
            contentDescription = "login image",
            modifier = Modifier.size(250.dp))

        Text(text = "Login", fontSize = 30.sp, fontWeight= FontWeight.Bold,)

        Spacer(modifier = Modifier.height(4.dp))

        Row() {

        Text(text = "Email Address",fontWeight= FontWeight.Bold,fontFamily = FontFamily.SansSerif,
            modifier = Modifier.clickable {})
        Spacer(modifier =Modifier.width(28.dp))
        Text(text = "Mobile Number", fontWeight= FontWeight.Bold,fontFamily = FontFamily.SansSerif,
            style = TextStyle(Color.LightGray),
            modifier = Modifier.clickable{})

    }

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = userEmail.value,
            onValueChange = { userEmail.value = it },
            label = { Text(text = "Email",fontWeight= FontWeight.Bold, fontFamily = FontFamily.SansSerif) },
            placeholder = { Text(text = "email@gmail.com") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth(0.8f)
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = userPassword.value,
            onValueChange = { userPassword.value = it },
            label = { Text(text = "Password",
                fontWeight= FontWeight.Bold, fontFamily = FontFamily.SansSerif) },
            placeholder = { Text(text = "Password") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth(0.8f),
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
            color = Color.Blue,fontSize = 16.sp, textAlign = TextAlign.Start,
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .padding(14.dp))

        // Spacer(modifier = Modifier.height(8.dp))

        Button(onClick = { }
        ) {
            Text(text = " login", modifier = Modifier.fillMaxWidth(0.8f),
                fontSize = 20.sp, textAlign = TextAlign.Center)
        }

        Spacer(modifier = Modifier.height(10.dp))

        Text(text = "Or login with",color = Color.Black, fontSize = 14.sp,
            fontWeight= FontWeight.Bold,
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
                    .fillMaxHeight(0.4f)
                    .clickable { },
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center) {
                Icon(painter = painterResource(id = R.drawable.ggg),
                    contentDescription ="google img", tint = Color.Unspecified )
                Text(text = "Continue with google", color = Color.White)
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Create a new Account",color = Color.Black, fontSize = 20.sp,
            fontWeight= FontWeight.Bold,
            modifier = Modifier.clickable{})
    }
}

