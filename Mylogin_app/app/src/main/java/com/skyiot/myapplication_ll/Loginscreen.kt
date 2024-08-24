package com.skyiot.myapplication_ll

import android.content.Context
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.TabRowDefaults.tabIndicatorOffset
import androidx.compose.runtime.*
//import androidx.compose.foundation.layout.ColumnScopeInstance.align
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Loginscreen(context: Context,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        var selectedTabIndex by remember { mutableStateOf(0) }


        Image(painter = painterResource(id = R.drawable.skyy),
            contentDescription = "login image",
            modifier = Modifier.size(220.dp))

        Text(text = "Login", fontSize = 30.sp, fontWeight = FontWeight.Bold, )

        Spacer(modifier = Modifier.height(4.dp))

        Column {
            TabRow(
                selectedTabIndex = selectedTabIndex,
                backgroundColor = MaterialTheme.colors.background,
                contentColor = MaterialTheme.colors.secondaryVariant,
                divider = {},
                indicator = { tabPositions ->
                    TabRowDefaults.Indicator(
                        Modifier.tabIndicatorOffset(tabPositions[selectedTabIndex])
                    )
                }
            )
            {
                Tab(selected = selectedTabIndex == 0, onClick = { selectedTabIndex = 0 }) {
                    Text("Mobile Number", modifier = Modifier.padding(16.dp), color = Color.Black,fontWeight = FontWeight.Bold)
                }
                Tab(selected = selectedTabIndex == 1, onClick = { selectedTabIndex = 1 }) {
                    Text("Email Address", modifier = Modifier.padding(16.dp), color = Color.Black,fontWeight = FontWeight.Bold)
                }
            }

            when (selectedTabIndex) {
                0 -> MobileInput()
                1 -> EmailInput(context)
            }
        }
    }
}
