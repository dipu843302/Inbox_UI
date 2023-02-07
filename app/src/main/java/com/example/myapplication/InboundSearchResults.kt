package com.example.myapplication

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun InboundSearchResult(modifier: Modifier) {
    Column(
        modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(start = 16.dp, top = 25.dp, end = 16.dp)
    )
    {
        Search()
        CardLifeTime(modifier)
        Spacer(modifier.padding(top = 23.dp))
        CustomTextView(modifier,text = " Results", fontSize = 16, color = Color(0XFFafb8c5), fontWeight = FontWeight.Normal)
        LazyColumn {
            items(50) {
                InboxListItem(modifier,
                    name = "Dipu Kumar",
                    time = "Yesterday",
                    lastMessage = "Hey ! Nalini how are you are you good asdfasdfasdfsdfasdfasdfasdfa",
                    readUnread = false
                )
            }
        }
    }
}

@Composable
fun CardLifeTime(modifier: Modifier) {
    Card(shape = RoundedCornerShape(18.dp)) {
        Row(
            modifier
                .height(37.dp)
                .fillMaxWidth()
                .background(Color(0XFFf0f2f5)),
            verticalAlignment = Alignment.CenterVertically
        ) {
            AddSpacer(modifier.padding(start = 22.dp))
            CustomTextView(modifier,text = "Lifetime  ", fontSize = 14, color = Color.Black, fontWeight = FontWeight.Normal)
            AddSpacer(modifier.padding(start = 12.dp))
            CustomImage(modifier =  modifier
                .width(14.dp)
                .height(12.dp), image = painterResource(id = R.drawable.telephone_icon), contentDescription ="Telephone" )
            CustomTextView(modifier,text = "  All", fontSize = 14, color = Color.Black, fontWeight = FontWeight.Normal)
        }
    }
}

@Preview
@Composable
fun Test2() {
    InboundSearchResult(modifier = Modifier)
}