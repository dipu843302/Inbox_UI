package com.example.myapplication

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LocalMinimumTouchTargetEnforcement
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun InboundSearchCustom(modifier: Modifier) {
    Card(shape = RoundedCornerShape(8.dp))
    {
        Column(
            modifier
                .fillMaxWidth()
                .height(351.dp)
                .background(Color.White)
                .padding(start = 19.dp, top = 26.dp, end = 18.dp, bottom = 26.dp),
        )
        {
            BusinessLinesSearch(modifier)
            AddSpacer(modifier.padding(top = 20.dp))
            LazyColumn(modifier.height(200.dp)) {
                items(19) {
                    CheckBoxNumber(modifier, "All Numbers", "Anywhere Mobile Team")
                }
            }
            AddSpacer(modifier.padding(top = 16.dp))
            Row(modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                CustomButton(
                    modifier = modifier
                        .width(358.dp)
                        .height(40.dp),
                    shape = RoundedCornerShape(CornerSize(10.dp)),
                    buttonBackground = Color(0XFF6285ff),
                    text = "Apply Filtering",
                    textColor = Color.White,
                    fontSize = 14,
                    brandIcon = 0
                )
            }
        }
    }
}

@Composable
fun BusinessLinesSearch(modifier: Modifier) {
    Row(
        modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        CustomImage(modifier = modifier.size(16.dp), image = painterResource(id = R.drawable.telephone_icon), contentDescription = "Phone")
        AddSpacer(modifier.padding(start = 10.dp))
        CustomTextView(modifier = modifier, text = "Business Lines", fontSize =16 , color = Color.Black, fontWeight = FontWeight.Normal )
        AddSpacer(modifier.padding(start = 7.dp))
        CustomImage(modifier = modifier.size(18.dp), image = painterResource(id = R.drawable.icons_search), contentDescription = "Search icon")
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CheckBoxNumber(modifier: Modifier, number: String, name: String) {
    val checkedState = remember {
        mutableStateOf(true)
    }
    Row(modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
        CompositionLocalProvider(LocalMinimumTouchTargetEnforcement provides false) {
            Checkbox(checked = checkedState.value, onCheckedChange = {
                checkedState.value = it
            }, colors = CheckboxDefaults.colors(Color(0XFF6285ff)))
        }
        CustomTextView(modifier =   modifier.padding(start = 11.dp), text = number, fontSize = 16, color = Color.Black , fontWeight =FontWeight.Normal )
        Text(
            text = name,
            modifier.padding(start = 10.dp),
            fontSize = 13.sp,
            color = Color(0XFF8f99ad),
            textAlign = TextAlign.Center
        )
    }
    AddSpacer(modifier.padding(bottom = 12.dp))
}

@Preview
@Composable
fun TEST() {
    InboundSearchCustom(modifier = Modifier)
}