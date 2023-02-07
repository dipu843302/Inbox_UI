package com.example.myapplication

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LoginPage(modifier: Modifier, pBackGroundColor: Color, brandIcon: Int) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(pBackGroundColor),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AddSpacer(modifier.padding(top = 80.dp))

        CustomImage(modifier =  modifier
            .width(216.dp)
            .height(29.dp), image =  painterResource(brandIcon), contentDescription ="AC Logo" )
        AddSpacer(modifier.padding(top = 50.dp))
        CustomTextField(modifier,"Email")
        AddSpacer(modifier.padding(top = 10.dp))
        CustomTextField(modifier,"Password")
        AddSpacer(modifier.padding(top = 30.dp))
        CustomButton(
            modifier
                .width(96.dp)
                .height(40.dp),
            RoundedCornerShape(CornerSize(54.dp)),
            Color(0XFF2dccd2),
            "Login",
            Color.White,
            14, 0
        )
        AddSpacer(modifier.padding(top = 47.dp))
        CustomTextView(
            modifier,
            text = "Forgot Password",
            14,
            Color.White,
            fontWeight = FontWeight.Normal
        )
        AddSpacer(modifier.padding(top = 28.dp))
        Row(
            modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            CustomDivider(
                modifier
                    .width(31.dp)
                    .height(1.dp),
                color = Color(0XFF3effffff)
            )
            CustomTextView(
                modifier,
                text = "  OR  ",
                14,
                Color.White,
                fontWeight = FontWeight.Normal
            )
            CustomDivider(
                modifier
                    .width(31.dp)
                    .height(1.dp),
                color = Color(0XFF3effffff)
            )

        }
        AddSpacer(modifier.padding(top = 28.dp))
        CustomButton(
            modifier
                .width(220.dp)
                .height(50.dp),
            shape = RoundedCornerShape(CornerSize(54.dp)),
            buttonBackground = Color.White,
            text = "Sign in with Google",
            textColor = Color.Black,
            fontSize = 14,
            brandIcon = R.drawable.google_icon
        )
        AddSpacer(modifier.padding(top = 52.dp))
        Row {
            CustomTextView(
                modifier,
                text = "Need help? ",
                14,
                Color.White,
                fontWeight = FontWeight.Normal
            )
            CustomTextView(
                modifier,
                text = "Call Us",
                14,
                Color.White,
                fontWeight = FontWeight.Bold
            )
        }
        AddSpacer(modifier.padding(top = 14.dp))

        Row {
            CustomTextView(
                modifier,
                text = "By logging in you agree to  ",
                14,
                Color.White,
                fontWeight = FontWeight.Normal
            )
            CustomTextView(
                modifier,
                text = "Terms & Privacy",
                14,
                Color.White,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
private fun CustomTextField(modifier: Modifier,hint: String) {
    var text by remember { mutableStateOf("") }
    Card(shape = RoundedCornerShape(CornerSize(4.dp))) {
        Row(
            modifier
                .width(300.dp)
                .height(40.dp)
                .background(Color.White)
                .padding(start = 15.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            BasicTextField(
                value = text,
                onValueChange = {
                    text = it
                },
                singleLine = true,
                decorationBox = { innerTextField ->
                    Row(
                        modifier
                            .background(Color.White),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        if (text.isEmpty())
                            Text(
                                text = hint,
                                color = Color(0XFF455c64),
                                fontSize = 16.sp
                            )
                    }
                    innerTextField()
                },
            )
        }
    }
}

@Preview
@Composable
fun Test() {
    LoginPage(Modifier, Color(0XFF455c64), R.drawable.ac_logo)
}

