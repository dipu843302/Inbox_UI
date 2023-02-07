package com.example.myapplication

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun InboxListItem(
    modifier: Modifier,
    name: String,
    time: String,
    lastMessage: String,
    readUnread: Boolean
) {
    Row(
        modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(top = 15.dp)
    ) {
        CustomImage(
            modifier = modifier
                .size(52.dp)
                .clip(CircleShape),
            image = painterResource(id =R.drawable.ic_call_read),
            contentDescription = ""
        )
        Column {
            Row(
                modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
            ) {
                CustomTextView(
                    modifier = modifier.padding(start = 16.1f.dp),
                    text = name,
                    fontSize = 18,
                    color = Color.Black,
                    fontWeight = if (readUnread) {
                        FontWeight.Normal
                    } else {
                        FontWeight.Bold
                    },
                )
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.CenterEnd
                ) {
                    Text(
                        text = time,
                        fontSize = 12.sp,
                        fontWeight = if (readUnread) {
                            FontWeight.Normal
                        } else {
                            FontWeight.Bold
                        },
                        color = Color(0XFFafb8c5),
                        textAlign = TextAlign.End,
                    )
                }
            }
            Text(
                text = lastMessage,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                fontSize = 15.sp,
                fontWeight = if (readUnread) {
                    FontWeight.Normal
                } else {
                    FontWeight.Bold
                },
                color = if (readUnread) {
                    Color(0XFFafb8c5)
                } else {
                    Color(0XFF3e4545)
                },
                modifier = Modifier.padding(start = 16.1f.dp)
            )
        }
    }
}

@Composable
fun InboxHeader(modifier: Modifier) {
    Box(
        modifier
            .fillMaxWidth()
            .height(89.dp)
            .background(Color.White)
            .padding(16.dp)
    ) {
        Column(modifier.wrapContentSize()) {
            CustomTextView(
                modifier = modifier,
                text = "Inbox",
                fontSize = 28,
                color = Color.Black,
                fontWeight = FontWeight.Bold
            )
            Row {
                CustomTextView(
                    modifier = modifier,
                    text = "All",
                    fontSize = 16,
                    color = Color(0XFF8495B1),
                    fontWeight = FontWeight.Bold
                )
                AddSpacer(modifier = Modifier.padding(3.dp))
                Image(
                    painter = painterResource(id = com.example.myapplication.R.drawable.ic_bottom_arrow),
                    //   painter = painterResource(id = R.drawable.ic_toggle_up_arrow),
                    contentDescription = "Down arrow",
                    modifier = Modifier
                        .width(10.7f.dp)
                        .height(6.1f.dp)
                        .align(Alignment.CenterVertically)
                )
            }
        }
        Image(
            painter = painterResource(id = com.example.myapplication.R.drawable.more_icon),
            contentDescription = "More option",
            modifier = Modifier
                .width(34.dp)
                .height(34.dp)
                .align(Alignment.CenterEnd)
                .clickable {
                    // open more option UI
                }
        )
    }
}


@Composable
fun MoreOptionUI(modifier: Modifier) {
    Box(
        modifier = Modifier
            .background(Color.White)
            .fillMaxWidth()
            .height(295.dp)
            .padding(16.dp, 18.dp, 16.dp)
    ) {
        Column {
            Row {
                CustomTextView(
                    modifier = modifier,
                    text = "Inbox",
                    fontSize = 28,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold
                )
                Box(
                    contentAlignment = Alignment.CenterEnd,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(end = 10.dp, top = 15.dp),
                ) {
                    Image(
                        painter = painterResource(id = com.example.myapplication.R.drawable.more_icon),
                        contentDescription = "More Option",
                        alignment = Alignment.TopEnd,
                        modifier = Modifier
                            .width(34.dp)
                            .height(34.dp),
                    )
                }
            }
            SearchArchiveTrash(
                modifier,
                image = painterResource(id = com.example.myapplication.R.drawable.search_icon),
                text = "Search"
            )
            SearchArchiveTrash(
                modifier,
                image = painterResource(id = com.example.myapplication.R.drawable.archive_icon),
                text = "Archive"
            )
            SearchArchiveTrash(
                modifier,
                image = painterResource(id = com.example.myapplication.R.drawable.ic_trash_icon),
                text = "Trash"
            )
        }
    }
}

@Composable
fun SearchArchiveTrash(modifier: Modifier, image: Painter, text: String) {
    Row(
        modifier
            .wrapContentSize()
            .padding(top = 15.dp)
    ) {
        CustomImage(
            image = image,
            contentDescription = "Trash inbox",
            modifier = modifier.size(50.dp)
        )
        CustomTextView(
            modifier = modifier.padding(start = 17.dp, top = 14.dp),
            text = text,
            fontSize = 18,
            color = Color.Black,
            fontWeight = FontWeight.Normal
        )
    }
}

@Composable
fun AddMethod(modifier: Modifier) {
    Column {
        InboxHeader(modifier)
        Divider(color = Color(android.graphics.Color.rgb(238, 240, 241)), thickness = 1.dp)
        LazyColumn(
            modifier
                .background(Color.White)
                .padding(10.dp)
        ) {
            items(50) {
                InboxListItem(
                    modifier,
                    name = "Dipu Kumar",
                    time = "Yesterday",
                    lastMessage = "Hey ! Nalini how are you are you good asdfasdfasdfsdfasdfasdfasdfa",
                    readUnread = false
                )
            }
        }
    }
}

@Preview
@Composable
fun Test1() {
  //  MoreOptionUI(Modifier)
    //  InboxHeader(modifier = Modifier)
      AddMethod(Modifier)
//    InboxList(
//        name = "Nalinikanta",
//        fontWeightName = FontWeight.Normal,
//        time = "Yesterday",
//        timeColor = Color.Black,
//        lastMessage = "Hey , How are you",
//        lastMessageColor = Color.Gray
//    )
}