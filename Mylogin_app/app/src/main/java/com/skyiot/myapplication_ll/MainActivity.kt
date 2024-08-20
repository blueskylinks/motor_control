package com.skyiot.myapplication_ll

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.R
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.HorizontalAlignmentLine
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.skyiot.myapplication_ll.ui.theme.MyApplication_llTheme
import com.skyiot.myapplication_ll.ui.theme.Purple500

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
                    Loginscreen(this)
           //PinScreen()
                  //MobileNumberScreen()
                  //MobileNumberAndOtpInput()
                    // Newaccount(this)
                   // OTPScreen()
                }
            }
        }

@Composable
fun OTPScreen() {
    val context = LocalContext.current
    val otpVal: String? = null

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .background(Purple500),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "OTP Screen",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(30.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Image(painter = painterResource(id = com.skyiot.myapplication_ll.R.drawable.skyy),
            contentDescription = "login image",
                modifier = Modifier.size(230.dp))

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Enter the OTP",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(10.dp))

            OTPTextFields(
                length = 4
            ) {
                    getOpt -> otpVal
            }

            Spacer(modifier = Modifier.height(30.dp))

            Button(
                onClick = {
                    if (otpVal != null) {
                        Toast.makeText(context, "Please Enter Otp", Toast.LENGTH_SHORT).show()
                    }
                },
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .height(45.dp)
                    .background(Purple500),
                shape = RoundedCornerShape(10.dp)
            ) {
                Text(
                    text = "Get Otp",
                    fontSize = 15.sp,
                    color = Color.White
                )
            }
        }
    }
}
































//@Composable
//fun portfolio() {
//    Column(
//        modifier = Modifier.fillMaxSize(),
//        verticalArrangement = Arrangement.Center,
//        horizontalAlignment = Alignment.CenterHorizontally,
//    ) {
//        Image(painter = painterResource(id = com.skyiot.myapplication_ll.R.drawable.loginimg),
//            contentDescription = "login image",
//            modifier = Modifier.size(180.dp))
//           Text(text = "Welcome Back")
//
//    }
//}


//@Preview(showBackground = true)
//@Composable
//fun DefaultPreview() {
//    MyApplication_llTheme {
//    }
//}