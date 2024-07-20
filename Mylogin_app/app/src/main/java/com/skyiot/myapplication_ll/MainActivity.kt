package com.skyiot.myapplication_ll

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.R
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.HorizontalAlignmentLine
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.skyiot.myapplication_ll.ui.theme.MyApplication_llTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
                    Loginscreen()
                    //Mobilescreen()
                     //Newaccount()
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