package com.skyiot.myapplication_ll

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
                    Loginscreen(this)
                   // SignupScreen()
                   // OTPScreen()

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