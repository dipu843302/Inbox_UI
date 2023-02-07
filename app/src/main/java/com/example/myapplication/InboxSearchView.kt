package com.example.myapplication

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.*
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
fun SearchInbound(modifier: Modifier) {
    Box(
        modifier
            .background(Color.White)
            .fillMaxSize()
            .padding(start = 16.dp, top = 16.dp, end = 16.dp)
    ) {
        Column {
            Search()
            CustomTextView(modifier =modifier.padding(top = 12.dp) ,  text = "Suggested",
                fontSize = 16, color = Color(0XFFafb8c5), fontWeight = FontWeight.Normal )
            AddSpacer(modifier = Modifier.padding(top = 8.dp))
            SuggestedOption(modifier,
                R.drawable.ic_inbound_search_message_from_yesterday_lastweek_image,
                "Message From Yesterday"
            )

            SuggestedOption(modifier,
                R.drawable.ic_inbound_search_message_from_yesterday_lastweek_image,
                "Message From Last Week"
            )

            SuggestedOption(modifier,
                R.drawable.ic_inbound_search_message_from_yesterday_lastweek_image,
                "Archive"
            )

            SuggestedOption(modifier,
                R.drawable.ic_inbound_search_message_from_yesterday_lastweek_image,
                "Archive"
            )

            SuggestedOption(modifier,
                R.drawable.ic_inbound_search_message_from_yesterday_lastweek_image,
                "Archive"
            )
            AddSpacer(modifier = Modifier.padding(top = 20.dp))
            CustomDivider(modifier = Modifier
                .width(35.dp)
                .height(1.dp), color = Color(0XFFafb8c5))
            AddSpacer(modifier = Modifier.padding(top = 4.dp))

            SuggestedOption(modifier,
                R.drawable.archive_cion,
                "Archive"
            )
            SuggestedOption(modifier,
                R.drawable.trash_icon,
                "Trash"
            )
        }
    }
}

@SuppressLint("SuspiciousIndentation")
@Composable
fun Search() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(36.dp)
    ) {
        Box(modifier = Modifier.fillMaxWidth()) {
            Image(
                painter = painterResource(id = R.drawable.baseline_arrow_back_24),
                contentDescription = "Back",
                modifier = Modifier
                    .align(Alignment.CenterStart)
                    .size(20.dp)
                    .clickable {
                        // go back
                    }
            )
            var value by remember {
                mutableStateOf("")
            }
            BasicTextField(
                value = value,
                onValueChange = { newText ->
                    value = newText
                },
                decorationBox = { innerTextField ->
                    if (value.isBlank())
                        Text(text = "Search Inbox",
                            color = Color(0XFFdbe0e7),
                            fontSize = 20.sp,
                            modifier = Modifier
                                .align(Alignment.CenterStart)
                        )
                    innerTextField()
                },
                modifier = Modifier
                    .wrapContentWidth()
                    .heightIn(24.dp)
                    .padding(start = 29.dp),
                textStyle = TextStyle(fontSize = 16.sp)
            )
            Image(
                painter = painterResource(id = R.drawable.baseline_clear_24),
                contentDescription = "Back",
                alignment = Alignment.CenterEnd,
                modifier = Modifier
                    .align(Alignment.CenterEnd)
                    .size(20.dp)
                    .clickable {
                        // go back
                    }
            )
        }
    }
}

@Composable
fun SuggestedOption(modifier: Modifier,image: Int, text: String) {
    AddSpacer(modifier .padding(top = 16.dp))
    Row(modifier) {
        Image(
            painter = painterResource(image),
            contentDescription = "",
            modifier
                .width(15.dp)
                .heightIn(14.dp)
                .padding(top = 3.dp)
        )
        CustomTextView(modifier =modifier.padding(start = 14.2f.dp) , text = text,
            fontSize = 16, color =Color(0XFF181818), fontWeight =FontWeight.Normal )
    }
}

@Preview
@Composable
fun ShowUI() {
    SearchInbound(Modifier)
}