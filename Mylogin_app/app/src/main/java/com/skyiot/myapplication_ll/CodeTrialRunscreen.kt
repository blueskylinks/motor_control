package com.skyiot.myapplication_ll



//@Preview(showBackground = true)
//@Composable
//fun TabRowDefaultsPreview() {
//    MyApplication_llTheme {
//       LoginScreen()
//    }
//}





//import android.content.Context
//import android.widget.Toast
//import androidx.compose.animation.animateContentSize
//import androidx.compose.animation.core.LinearOutSlowInEasing
//import androidx.compose.animation.core.tween
//import androidx.compose.foundation.BorderStroke
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.background
//import androidx.compose.foundation.clickable
//import androidx.compose.foundation.layout.*
//import androidx.compose.material.*
//import androidx.compose.runtime.*
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.text.TextStyle
//import androidx.compose.ui.text.font.FontFamily
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.text.input.PasswordVisualTransformation
//import androidx.compose.ui.text.input.VisualTransformation
//import androidx.compose.ui.text.style.TextAlign
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import com.skyiot.myapplication_ll.ui.theme.Shapes
//
//@OptIn(ExperimentalMaterialApi::class)
//@Composable
//fun Newaccount(context: Context,
//               text: String = "Continue with Google",
//               loadingText: String = "Wait a moment..."
//) {
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .padding(10.dp),
//        verticalArrangement = Arrangement.Top,
//        horizontalAlignment = Alignment.CenterHorizontally,
//    ) {
//        var clicked by remember { mutableStateOf(false) }
//
//        val (checked, onCheckedChange) = remember {
//            mutableStateOf(false)
//        }
//        var userYourName = remember { mutableStateOf("") }
//        var userEmail = remember { mutableStateOf("") }
//        var userPassword = remember { mutableStateOf("") }
//
//        val passwordVisibility = remember { mutableStateOf(false) }
//
//        Text(text = "Create an account",
//            fontSize = 24.sp, fontWeight = FontWeight.Bold,
//            textAlign = TextAlign.Start, modifier = Modifier
//                .fillMaxWidth()
//                .padding(18.dp))
//
//        //Spacer(modifier = Modifier.height(4.dp))
//        Spacer(modifier = Modifier.height(16.dp))
//
//        OutlinedTextField(
//            value = userEmail.value,
//            onValueChange = { userEmail.value = it },
//            label = {
//                Text(text = "Your Name",
//                    fontWeight = FontWeight.Bold,
//                    fontFamily = FontFamily.SansSerif)
//            },
//            placeholder = { Text(text = "Type Name") },
//            singleLine = true,
//            leadingIcon = {
//                Icon(
//                    painter = painterResource(id = R.drawable.ic_baseline_person),
//                    contentDescription = null,
//                )
//            },
//            modifier = Modifier.fillMaxWidth(0.9f)
//        )
//
//        Spacer(modifier = Modifier.height(30.dp))
//
//        OutlinedTextField(
//            value = userEmail.value,
//            onValueChange = { userEmail.value = it },
//            label = {
//                Text(text = "Email",
//                    fontWeight = FontWeight.Bold,
//                    fontFamily = FontFamily.SansSerif)
//            },
//            placeholder = { Text(text = "email@gmail.com") },
//            singleLine = true,
//            leadingIcon = {
//                Icon(
//                    painter = painterResource(id = R.drawable.ic_baseline_email_24),
//                    contentDescription = null,
//                )
//            },
//            modifier = Modifier.fillMaxWidth(0.9f)
//        )
//
//        Spacer(modifier = Modifier.height(30.dp))
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
//
//        Spacer(modifier = Modifier.height(2.dp))
//        Row {
//            Checkbox(checked = checked,
//                onCheckedChange = onCheckedChange)
//            Spacer(modifier = Modifier.size(2.dp))
//            Text(text = "By continue your agree to terms & service",
//                color = Color.Black,
//                fontSize = 14.sp,
//                fontFamily = FontFamily.SansSerif,
//                textAlign = TextAlign.Center,
//                modifier = Modifier
//                    .fillMaxWidth(0.9f)
//                    .padding(14.dp))
//        }
//        Spacer(modifier = Modifier.height(8.dp))
//        Button(
//            onClick = {
//                if (userYourName.value.isEmpty()) {
//                    Toast.makeText(context, " Enter Your Name", Toast.LENGTH_SHORT).show()
//                } else if (userPassword.value.isEmpty()) {
//                    Toast.makeText(context, "Enter Password", Toast.LENGTH_SHORT).show()
//                } else {
//                    Toast.makeText(context, "Validation Successfully Completed", Toast.LENGTH_SHORT)
//                        .show()
//                }
//            },
//        ) {
//            Text(text = " login", modifier = Modifier.fillMaxWidth(0.8f),
//                fontSize = 20.sp, textAlign = TextAlign.Center, fontFamily = FontFamily.SansSerif)
//        }
//
//        Spacer(modifier = Modifier.height(20.dp))
//
//        Text(text = "Or sign with", color = Color.Black, fontSize = 15.sp,
//            fontWeight = FontWeight.Bold, fontFamily = FontFamily.SansSerif,
//            modifier = Modifier.clickable { })
//
//        Spacer(modifier = Modifier.height(12.dp))
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
//                    .fillMaxHeight(0.2f)
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
//            }
//        }
//
//        Spacer(modifier = Modifier.height(26.dp))
//
//        Row(modifier = Modifier
//            .fillMaxSize()
//            .padding(16.dp)
//            .wrapContentSize(align = Alignment.BottomCenter)) {
//
//            Text(text = "Already have an account?",
//                color = Color.Black,
//                fontSize = 18.sp,
//                fontWeight = FontWeight.Bold)
//            Spacer(modifier = Modifier.size(8.dp))
//            Text(
//                text = "Log in here",
//                fontWeight = FontWeight.Bold,
//                fontSize = 18.sp,
//                modifier = Modifier.clickable { },
//                color = MaterialTheme.colors.primary
//            )
//        }
//    }
//
//}
//


//
//@Composable
//fun MyApp() {
//    MaterialTheme {
//        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.surface) {
//            CreateAccountForm()
//        }
//    }
//}
//@SuppressLint("SuspiciousIndentation")
//@Composable
//fun CreateAccountForm() {
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .padding(10.dp),
//        verticalArrangement = Arrangement.Top,
//        horizontalAlignment = Alignment.CenterHorizontally,
//    ) {
//       // var clicked by remember { mutableStateOf(false) }
//       // var text by remember { mutableStateOf("") }
//      //  val (checked, onCheckedChange) = remember { mutableStateOf(false) }
//        var username by remember { mutableStateOf("") }
//        var lastName by remember { mutableStateOf("") }
//        var email by remember { mutableStateOf("") }
//        var mobileNumber by remember { mutableStateOf("") }
//        var pin by remember { mutableStateOf("") }
//        var gender by remember { mutableStateOf("") }
//        var password by remember { mutableStateOf("") }
//        var confirmPassword by remember { mutableStateOf("") }
//        var isPinRequestVisible by remember { mutableStateOf(false) }
//        var isPinVisible by remember { mutableStateOf(false) }
//
//    // Determine if PIN request button should be visible
//    isPinRequestVisible = mobileNumber.length == 10
//
//    // Determine if additional fields should be visible
//    isPinVisible = pin.length == 4
//
//        Text(text = "Create an account",
//            fontSize = 24.sp, fontWeight = FontWeight.Bold,
//            textAlign = TextAlign.Start, modifier = Modifier
//                .fillMaxWidth()
//                .padding(18.dp))
////        Spacer(modifier = Modifier.height(8.dp))
//
//       OutlinedTextField(
//            value = username,
//            onValueChange = { username = it },
//            label = {
//                Text("First Name",
//                fontWeight = FontWeight.Bold,
//                fontFamily = FontFamily.SansSerif)
//                    },
//            placeholder = { Text(text = "First Name") },
//            singleLine = true,
//           leadingIcon = {
//               Icon(
//                   painter = painterResource(id = R.drawable.ic_baseline_person),
//                   contentDescription = null,
//               )
//           },
//           modifier = Modifier.fillMaxWidth(0.9f)
//       )
//
//        Spacer(modifier = Modifier.height(6.dp))
//
//        OutlinedTextField(
//            value = lastName,
//            onValueChange = { lastName = it },
//            label = {
//                Text("Last Name",
//                    fontWeight = FontWeight.Bold,
//                    fontFamily = FontFamily.SansSerif)
//            },
//            placeholder = { Text(text = "Last Name") },
//            singleLine = true,
//            leadingIcon = {
//                Icon(
//                    painter = painterResource(id = R.drawable.ic_baseline_person),
//                    contentDescription = null,
//                )
//            },
//            modifier = Modifier.fillMaxWidth(0.9f)
//        )
//
//        Spacer(modifier = Modifier.height(6.dp))
//
//        OutlinedTextField(
//            value = email,
//            onValueChange = { email = it },
//            label = {
//                Text(text = "Email",
//                    fontWeight = FontWeight.Bold,
//                    fontFamily = FontFamily.SansSerif)
//            },
//            placeholder = { Text(text = "email@gmail.com") },
//            singleLine = true,
//            leadingIcon = {
//                Icon(
//                    painter = painterResource(id = R.drawable.ic_baseline_email_24),
//                    contentDescription = null,
//                )
//            },
//            modifier = Modifier.fillMaxWidth(0.9f)
//        )
//
//        Spacer(modifier = Modifier.height(6.dp))
//
//        OutlinedTextField(
//            value = mobileNumber,
//            onValueChange = { if (it.length <= 10) mobileNumber = it },
//            label = { Text("Mobile Number",
//                fontWeight = FontWeight.Bold,
//                fontFamily = FontFamily.SansSerif ) },
//            placeholder = { Text(text = "mobile number") },
//            singleLine = true,
//            leadingIcon = {
//                Icon(
//                    painter = painterResource(id = R.drawable.ic_baseline_phone_24),
//                    contentDescription = null,
//                )
//            },
//            modifier = Modifier.fillMaxWidth(0.9f),
//            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone)
//        )
//        Spacer(modifier = Modifier.height(2.dp))
//
//        // Get PIN Button
//        if (isPinRequestVisible) {
//            Button(
//                onClick = { /* Handle PIN request */ },
//                modifier = Modifier.fillMaxWidth(0.6f),
//                shape = MaterialTheme.shapes.medium
//            ) {
//                Text("Send for PIN")
//            }
//        }
//
//        Spacer(modifier = Modifier.height(6.dp))
//
//        // PIN Input
//        if (isPinRequestVisible) {
//            OutlinedTextField(
//                value = pin,
//                onValueChange = { if (it.length <= 4) pin = it },
//                label = { Text("Enter 4-Digit PIN",
//                    fontWeight = FontWeight.Bold,
//                    fontFamily = FontFamily.SansSerif) },
//                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.NumberPassword),
//                visualTransformation = PasswordVisualTransformation(),
//                modifier = Modifier.fillMaxWidth(0.6f),
//                shape = MaterialTheme.shapes.medium
//            )
//        }
//
//        Spacer(modifier = Modifier.height(6.dp))
//
//        // Additional Fields after PIN is entered
//        if (isPinVisible) {
//            // Gender Selection
//            Text("Gender",fontWeight = FontWeight.Bold,
//                fontFamily = FontFamily.SansSerif)
//            Row(
//                modifier = Modifier.fillMaxWidth(),
//                horizontalArrangement = Arrangement.spacedBy(16.dp)
//            ) {
//                RadioButton(
//                    selected = gender == "Male",
//                    onClick = { gender = "Male" }
//                )
//                Text("Male")
//
//                RadioButton(
//                    selected = gender == "Female",
//                    onClick = { gender = "Female" }
//                )
//                Text("Female")
//
//                RadioButton(
//                selected = gender == "Others",
//                onClick = { gender = "Others" }
//              )
//                Text("Others")
//        }
//
//            Spacer(modifier = Modifier.height(6.dp))
//
//            // Password Input
//         OutlinedTextField(
//                value = password,
//                onValueChange = { password = it },
//                label = { Text("Password",
//                    fontWeight = FontWeight.Bold,
//                    fontFamily = FontFamily.SansSerif) },
//                visualTransformation = PasswordVisualTransformation(),
//                keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
//                modifier = Modifier.fillMaxWidth(0.9f),
//                shape = MaterialTheme.shapes.medium
//            )
//
//            Spacer(modifier = Modifier.height(6.dp))
//
//            // Confirm Password Input
//           OutlinedTextField(
//                value = confirmPassword,
//                onValueChange = { confirmPassword = it },
//                label = { Text("Confirm Password",
//                    fontWeight = FontWeight.Bold,
//                    fontFamily = FontFamily.SansSerif) },
//                visualTransformation = PasswordVisualTransformation(),
//                keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
//                modifier = Modifier.fillMaxWidth(0.9f),
//                shape = MaterialTheme.shapes.medium
//            )
//
//            Spacer(modifier = Modifier.height(6.dp))
//
//            // Submit Button
//            Button(
//                onClick = { /* Handle submit */ },
//                enabled = password == confirmPassword,
//                modifier = Modifier.fillMaxWidth(0.6f),
//                shape = MaterialTheme.shapes.medium
//            ) {
//                Text("Submit")
//            }
//        }
//    }
//}


//@Composable
//fun MyApp() {
//    MaterialTheme {
//        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
//            CreateAccountForm()
//        }
//    }
//}
//
//@Composable
//fun CreateAccountForm() {
//    var name by remember { mutableStateOf("") }
//    var lastName by remember { mutableStateOf("") }
//    var email by remember { mutableStateOf("") }
//    var mobileNumber by remember { mutableStateOf("") }
//    var pin by remember { mutableStateOf("") }
//    var gender by remember { mutableStateOf("") }
//    var password by remember { mutableStateOf("") }
//    var confirmPassword by remember { mutableStateOf("") }
//    var stage by remember { mutableStateOf(1) } // 1: Initial, 2: Pin, 3: Gender & Password
//
//    Column(modifier = Modifier.padding(16.dp)) {
//        when (stage) {
//            1 -> {
//                NameInput(name) { name = it }
//                LastNameInput(lastName) { lastName = it }
//                EmailInput(email) { email = it }
//                MobileNumberInput(mobileNumber) { mobileNumber = it }
//                if (mobileNumber.length == 10) {
//                    Button(onClick = { stage = 2 }) {
//                        Text("Continue")
//                    }
//                }
//            }
//            2 -> {
//                PinInput(pin) { pin = it }
//                Button(onClick = { stage = 3 }) {
//                    Text("Continue")
//                }
//            }
//            3 -> {
//                GenderInput(gender) { gender = it }
//                PasswordInput(password) { password = it }
//                ConfirmPasswordInput(confirmPassword) { confirmPassword = it }
//                Button(onClick = { /* Handle submit */ }) {
//                    Text("Submit")
//                }
//            }
//        }
//    }
//}
//
//@Composable
//fun NameInput(name: String, onNameChange: (String) -> Unit) {
//    TextField(
//        value = name,
//        onValueChange = onNameChange,
//        label = { Text("First Name") },
//        modifier = Modifier.fillMaxWidth()
//    )
//}
//
//@Composable
//fun LastNameInput(lastName: String, onLastNameChange: (String) -> Unit) {
//    TextField(
//        value = lastName,
//        onValueChange = onLastNameChange,
//        label = { Text("Last Name") },
//        modifier = Modifier.fillMaxWidth()
//    )
//}
//
//@Composable
//fun EmailInput(email: String, onEmailChange: (String) -> Unit) {
//    TextField(
//        value = email,
//        onValueChange = onEmailChange,
//        label = { Text("Email") },
//        keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Email),
//        modifier = Modifier.fillMaxWidth()
//    )
//}
//
//@Composable
//fun MobileNumberInput(mobileNumber: String, onMobileNumberChange: (String) -> Unit) {
//    TextField(
//        value = mobileNumber,
//        onValueChange = onMobileNumberChange,
//        label = { Text("Mobile Number") },
//        keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Phone),
//        modifier = Modifier.fillMaxWidth()
//    )
//}
//
//@Composable
//fun PinInput(pin: String, onPinChange: (String) -> Unit) {
//    TextField(
//        value = pin,
//        onValueChange = onPinChange,
//        label = { Text("Enter 4-Digit PIN") },
//        keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.NumberPassword),
//        visualTransformation = PasswordVisualTransformation(),
//        maxLines = 1,
//        modifier = Modifier.fillMaxWidth()
//    )
//}
//
//@Composable
//fun GenderInput(gender: String, onGenderChange: (String) -> Unit) {
//    TextField(
//        value = gender,
//        onValueChange = onGenderChange,
//        label = { Text("Gender") },
//        modifier = Modifier.fillMaxWidth()
//    )
//}
//
//@Composable
//fun PasswordInput(password: String, onPasswordChange: (String) -> Unit) {
//    TextField(
//        value = password,
//        onValueChange = onPasswordChange,
//        label = { Text("Password") },
//        visualTransformation = PasswordVisualTransformation(),
//        keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
//        modifier = Modifier.fillMaxWidth()
//    )
//}
//
//@Composable
//fun ConfirmPasswordInput(confirmPassword: String, onConfirmPasswordChange: (String) -> Unit) {
//    TextField(
//        value = confirmPassword,
//        onValueChange = onConfirmPasswordChange,
//        label = { Text("Confirm Password") },
//        visualTransformation = PasswordVisualTransformation(),
//        keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
//        modifier = Modifier.fillMaxWidth()
//    )
//}
















//@Composable
//fun OTPScreenF() {
//
//    val context = LocalContext.current
//    val otpVal: String? = null
//    var phoneNumber by remember { mutableStateOf("") }
//    var otp by remember { mutableStateOf("") }
//    var otpSent by remember { mutableStateOf(false) }
//    val otpLength = 4
//
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .padding(16.dp),
//        horizontalAlignment = Alignment.CenterHorizontally,
//        verticalArrangement = Arrangement.Center
//    ) {
//        Text(
//            text = "Enter your phone number",
//            style = MaterialTheme.typography.h3.copy(fontSize = 24.sp),
//            color = Color.Black,
//            modifier = Modifier.padding(bottom = 16.dp)
//        )
//
//        TextField(
//            value = phoneNumber,
//            onValueChange = { newValue ->
//                if (newValue.length <= 10 && newValue.all { it.isDigit() }) {
//                    phoneNumber = newValue
//                }
//            },
//            label = { Text("Phone Number") },
//            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Phone),
//            modifier = Modifier.fillMaxWidth()
//        )
//
//        Spacer(modifier = Modifier.height(16.dp))
//
//        Button(
//            onClick = {
//                otp = {}.toString()
//                otpSent = true
//                // generateOtp() // In a real app, you would send this OTP to the user's phone
//
//            },
//            enabled = phoneNumber.length == 10,
//            modifier = Modifier.fillMaxWidth()
//        ) {
//            Text("Send OTP")
//        }
//
//        Spacer(modifier = Modifier.height(24.dp))
//
//        if (otpSent) {
//            Text(
//                text = "Enter OTP",
//                style = MaterialTheme.typography.h3.copy(fontSize = 24.sp),
//                color = Color.Black,
//                modifier = Modifier.padding(bottom = 16.dp)
//            )
//
//            Row(
//                horizontalArrangement = Arrangement.spacedBy(8.dp),
//                modifier = Modifier.fillMaxWidth()
//            ) {
//                for (i in 0 until otpLength) {
//                    OTPTextFields(
//                        length = 4
//                    ) { getOpt ->
//                        otpVal
//                    }
//                }
//            }
//        }
//                    Spacer(modifier = Modifier.height(30.dp))
//
////                    Button(
////                        onClick = {
////                            if (otpVal != null) {
////                                Toast.makeText(context, "Please Enter Otp", Toast.LENGTH_SHORT)
////                                    .show()
////                            }
//////                        },
////                        modifier = Modifier
////                            .fillMaxWidth(0.8f)
////                            .height(45.dp)
////                            .background(Purple500),
////                        shape = RoundedCornerShape(10.dp)) {
////                    }
////                }
////            }
//                    Button(
//                        onClick = { },
//                        shape = Shapes.medium,
//                    ) {
//                        Text(text = " login",
//                            modifier = Modifier.fillMaxWidth(0.8f),
//                            fontSize = 20.sp, textAlign = TextAlign.Center)
//                    }
//
//
////            Spacer(modifier = Modifier.height(24.dp))
////
////            Button(
////                onClick = {
////                    // Handle OTP verification logic here
////                    println("Entered OTP: $otp")
////                },
////                enabled = otp.length == otpLength,
////                modifier = Modifier.fillMaxWidth()
////            ) {
////                Text("Verify OTP")
////            }
//
//        }
//    }
//
//
//@Composable
//fun OtpTextField(
//    value: String,
//    onValueChange: (String) -> Unit,
//    isFocused: Boolean,
//    modifier: Modifier = Modifier
//) {
//    var text by remember { mutableStateOf(value) }
//
//    OutlinedTextField(
//        value = text,
//        onValueChange = {
//            if (it.length <= 1 && it.all { c -> c.isDigit() }) {
//                text = it
//                onValueChange(it)
//            }
//        },
//        visualTransformation = PasswordVisualTransformation(), // Mask input with stars
//        keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
//        singleLine = true,
//        textStyle = MaterialTheme.typography.h3.copy(fontSize = 24.sp),
//        modifier = modifier
//            .background(Color.White)
//            .border(1.dp, Color.Gray)
//            .width(48.dp)
//            .height(48.dp)
//            .padding(12.dp),
//        shape = MaterialTheme.shapes.small
//    )
//}
//
//@Composable
//fun generateOtp(): String {
//    return Random.nextInt(1000, 9999).toString()
//}
