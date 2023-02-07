package com.example.myapplication.ui.theme


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.AddSpacer
import com.example.myapplication.CustomButton
import com.example.myapplication.CustomDivider
import com.example.myapplication.CustomImage
import com.example.myapplication.CustomTextView
import com.example.myapplication.InboxHeader
import com.example.myapplication.R

@Composable
fun InboxFilter(modifier: Modifier) {
    Column(
        modifier
            .fillMaxWidth()
            .height(545.dp)
            .background(Color.White)
    ) {
        InboxHeader(modifier)
        AllUnread(modifier)
        CustomTextView(
            modifier.padding(start = 16.dp),
            text = "Business Lines",
            fontSize = 16,
            color = Color.Black,
            fontWeight = FontWeight.Normal
        )
        AddSpacer(modifier.padding(top = 6.dp))
        LazyColumn(
            modifier
                .height(195.dp)
                .fillMaxWidth()
                .padding(start = 15.dp, end = 15.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            items(10) {
                BusinessLinesItem(
                    modifier,
                    "All Lines",
                    "1400-556-665",
                    isSelected = true

                )
            }
        }
        AddSpacer(modifier.padding(top = 10.dp))
        Row(
            modifier
                .fillMaxWidth()
                .padding(start = 15.dp, end = 15.dp), horizontalArrangement = Arrangement.Center
        )
        {
            CustomButton(
                modifier
                    .width(358.dp)
                    .height(40.dp),
                shape = RoundedCornerShape(CornerSize(10.dp)),
                buttonBackground = Color(0XFF6285ff),
                text = "Apply Filter",
                textColor = Color.White,
                fontSize = 14,
                brandIcon = 0
            )
            AddSpacer(modifier.padding(bottom = 20.dp))
        }
    }
}

@Composable
fun AllUnread(modifier: Modifier) {
    Box(
        modifier
            .padding(start = 16.dp, top = 8.dp, end = 9.dp)
    ) {
        Column {
            CheckAllUnread(modifier, "All", fontWeight = FontWeight.Bold, check = true)
            AddSpacer(modifier.padding(top = 9.dp))
            CheckAllUnread(modifier, "Unread", fontWeight = FontWeight.Normal, check = false)
            AddSpacer(modifier.padding(top = 15.dp))
            CustomDivider(modifier.width(35.dp), color = Color(0XFF8495B1))
        }
    }
    CheckUncheck(modifier)
    AddSpacer(modifier.padding(top = 42.dp))
}

@Composable
fun CheckUncheck(modifier: Modifier) {
    val checkedState = remember { mutableStateOf(true) }
    Row(
        modifier
            .background(Color.White)
            .padding(top = 5.dp)
    ) {
        Checkbox(
            checked = checkedState.value,
            onCheckedChange = { checkedState.value = it },
            colors = CheckboxDefaults.colors(Color(0XFF6285ff))
        )
        CustomTextView(
            modifier = modifier.padding(start = 10.dp, top = 15.dp), text = "Show call conclusions",
            fontSize = 14, color = Color.Black, fontWeight = FontWeight.Normal
        )
    }
}

@Composable
fun CheckAllUnread(modifier: Modifier, text: String, fontWeight: FontWeight, check: Boolean) {
    Row {
        Box(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = text,
                fontWeight = fontWeight,
                modifier = Modifier.align(Alignment.CenterStart)
            )
            if (check)
                CustomImage(
                    modifier = modifier
                        .size(18.dp)
                        .align(Alignment.CenterEnd),
                    image = painterResource(id = R.drawable.check),
                    contentDescription = ""
                )
        }
    }
}

@Composable
fun BusinessLinesItem(
    modifier: Modifier,
    p1Text: String,
    p2Text: String,
    isSelected: Boolean
) {
    AddSpacer(modifier = Modifier.padding(top = 8.dp))
    Card(
        modifier = Modifier
            .width(358.dp)
            .height(40.dp),
        shape = RoundedCornerShape(CornerSize(10.dp))
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0XFFebecec)),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Box(Modifier.fillMaxWidth()) {
                CustomTextView(
                    modifier = modifier
                        .align(Alignment.CenterStart)
                        .padding(start = 19.1.dp),
                    text = p1Text,
                    fontSize = 14,
                    color = if (isSelected) {
                        Color(0XFF6285ff)
                    } else {
                        Color.Black
                    },
                    fontWeight = FontWeight.Normal
                )

                CustomTextView(
                    modifier = modifier
                        .align(Alignment.CenterEnd)
                        .padding(end = 16.9.dp),
                    text = p2Text,
                    fontSize = 14,
                    color = Color.Gray,
                    fontWeight = FontWeight.Normal
                )
            }
        }
    }
}


@Preview
@Composable
fun PreViewUI() {
    InboxFilter(Modifier)
}