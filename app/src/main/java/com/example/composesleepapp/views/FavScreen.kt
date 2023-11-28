package com.example.composesleepapp.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.composesleepapp.composeshapes.LineGraph
import com.example.composesleepapp.R
import com.example.composesleepapp.ui.theme.SleepBlue
import com.example.composesleepapp.ui.theme.SleepDarkGreen
import com.example.composesleepapp.ui.theme.SleepDarkRed
import com.example.composesleepapp.ui.theme.SleepLightBlack
import com.example.composesleepapp.ui.theme.SleepLightGreen
import com.example.composesleepapp.ui.theme.SleepLightGrey
import com.example.composesleepapp.ui.theme.SleepOrange
import com.example.composesleepapp.ui.theme.SleepPurple
import com.example.composesleepapp.ui.theme.SleepYellow

@Composable
fun FavScreen(padding : PaddingValues) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(SleepLightBlack)
            .verticalScroll(rememberScrollState())

    )

    {
        Row(){
            Text("Sleep Session", color = Color.White, modifier = Modifier.padding(16.dp).weight(5f))
            Image(
                painter = painterResource(id = R.drawable.baseline_add_alarm_24),
                contentDescription = "",
                modifier = Modifier.padding(16.dp).weight(1f) ,
                colorFilter = ColorFilter.tint(SleepLightGrey)
            )
            Image(
                painter = painterResource(id = R.drawable.baseline_note_alt_24),
                contentDescription = "",
                modifier = Modifier.padding(16.dp).weight(1f) ,
                colorFilter = ColorFilter.tint(Color.White)
            )
        }
        LineGraph()
        Row {
            InfoVerticalCard("Time Asleep","Today","7h 49m", SleepYellow, SleepYellow,-60f,-60f)
            InfoVerticalCard("Sleep Rating","7h 49m","2h 51m", SleepDarkGreen, SleepLightGreen,30f,-90f)
        }
        Row {
            InfoVerticalCard("Latest Bedtime","BED TIME","9:00 PM", SleepBlue, SleepPurple,30f,-90f)
            InfoVerticalCard("Rediness","WAKING","52 bpm", SleepDarkRed, SleepOrange,30f,30f)
        }
        Spacer(modifier = Modifier.padding(vertical = padding.calculateBottomPadding()))
    }
}