package com.example.composesleepapp.views

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import com.example.composesleepapp.composeshapes.DoubleArcs
import com.example.composesleepapp.ui.theme.SleepDarkGrey

@Composable
fun InfoVerticalCard(
    title: String,
    title2: String,
    title3: String,
    innerColour: Color,
    outerColour: Color,
    innerStartAngle: Float,
    outerStartAngle: Float,
) {

    val screenWidth = LocalConfiguration.current.screenWidthDp.dp

    Card(
    colors = CardDefaults.cardColors(
    containerColor = SleepDarkGrey,
    ),
    modifier = Modifier
    .size(width = screenWidth/2,height = screenWidth)
        .padding(4.dp)

    ) {
        Text(
            text = title,
            modifier = Modifier
                .padding(16.dp),
            color = Color.White,
        )
        DoubleArcs(innerColour, outerColour,innerStartAngle,outerStartAngle)
        Text(
            text = title2,
            modifier = Modifier
                .padding(16.dp),
            color = Color.White,
        )
        Text(
            text = title3,
            modifier = Modifier
                .padding(16.dp),
            color = Color.White,
        )
    }}