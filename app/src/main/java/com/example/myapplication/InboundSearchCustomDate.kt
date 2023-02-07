package com.example.myapplication

import android.app.DatePickerDialog
import android.widget.DatePicker
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

import java.util.Calendar
import java.util.Date

@Composable
fun InboundSearchCustomDate(modifier: Modifier) {
    Card(
        shape = RoundedCornerShape(8.dp)
    ) {
        Column(
            modifier = Modifier
                .height(235.dp)
                .fillMaxWidth()
                .background(Color.White)
                .padding(start = 20.dp, top = 28.dp, end = 18.dp, bottom = 26.dp)
        )
        {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(id = R.drawable.back_headerarrow),
                    contentDescription = "Back arrow",
                    modifier
                        .width(9.dp)
                        .height(18.dp)
                )
                AddSpacer(modifier.padding(start = 19.dp))
                CustomTextView(
                    modifier = modifier,
                    text = "Custom range",
                    fontSize = 16,
                    color = Color.Black,
                    fontWeight = FontWeight.Normal
                )
            }
            AddSpacer(modifier.padding(top = 31.dp))
            Row(modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                DatePicker(modifier = Modifier, "2 May 2023")
                AddSpacer(modifier.padding(start = 14.dp))
                DatePicker(modifier = Modifier, "4 May 2023")
            }
            AddSpacer(modifier.padding(top = 34.dp))
            CustomButton(
                modifier = modifier
                    .width(358.dp)
                    .height(40.dp),
                shape = RoundedCornerShape(CornerSize(10.dp)),
                buttonBackground = Color(0XFF6285ff),
                text = "Set Range",
                textColor = Color.White,
                fontSize = 14,
                brandIcon = 0
            )
        }
    }
}

@Composable
fun DatePicker(modifier: Modifier, currentDate: String) {
    val mYear: Int
    val mMonth: Int
    val mDay: Int
    val mContext = LocalContext.current
    val mCalendar = Calendar.getInstance()

    mYear = mCalendar.get(Calendar.YEAR)
    mMonth = mCalendar.get(Calendar.MONTH)
    mDay = mCalendar.get(Calendar.DAY_OF_MONTH)

    mCalendar.time = Date()
    val mDate = remember { mutableStateOf(currentDate) }

    val mDatePickerDialog = DatePickerDialog(
        mContext,
        { _: DatePicker, mYear: Int, mMonth: Int, mDayOfMonth: Int ->
            mDate.value = "$mDayOfMonth/${mMonth + 1}/$mYear"
        }, mYear, mMonth, mDay
    )
    Card(
        shape = RectangleShape,
        border = BorderStroke(1.dp, Color(0xFF6699ff))
    ) {
        Column(
            modifier
                .width(165.dp)
                .height(36.dp)
                .background(Color.White),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CustomTextView(
                modifier = modifier.clickable { mDatePickerDialog.show() },
                text = mDate.value,
                fontSize = 14,
                color = Color.Black,
                fontWeight = FontWeight.Normal
            )
        }
    }
}

@Preview
@Composable
fun Show() {
    InboundSearchCustomDate(modifier = Modifier)
}