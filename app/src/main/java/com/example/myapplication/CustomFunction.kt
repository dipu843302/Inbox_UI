package com.example.myapplication

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CustomTextView(
    modifier: Modifier,
    text: String,
    fontSize: Int,
    color: Color,
    fontWeight: FontWeight
) {
    Text(text = text, modifier, fontSize = fontSize.sp, color = color, fontWeight = fontWeight)
}

@Composable
fun CustomButton(
    modifier: Modifier,
    shape: RoundedCornerShape,
    buttonBackground: Color,
    text: String,
    textColor: Color,
    fontSize: Int,
    brandIcon: Int
) {
    Card(modifier, shape)
    {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .background(buttonBackground), horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (brandIcon != 0) {
                Image(
                    painter = painterResource(id = brandIcon),
                    contentDescription = "Sign in with Google", modifier = Modifier.size(20.dp)
                )
                Spacer(modifier = Modifier.padding(start = 13.dp))
            }
            Text(text = text, color = textColor, fontSize = fontSize.sp)
        }
    }
}

@Composable
fun AddSpacer(modifier: Modifier) {
    Spacer(modifier = modifier)
}

@Composable
fun CustomDivider(modifier: Modifier,color: Color) {
    Divider(modifier,color=color)
}

@Composable
fun CustomImage(modifier: Modifier, image: Painter, contentDescription:String) {
    Image(painter = image, contentDescription = contentDescription,modifier)
}