package com.example.composesleepapp.views

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composesleepapp.ui.theme.SleepDarkGrey


@Composable
fun InfoCard(title: String) {

    val screenWidth = LocalConfiguration.current.screenWidthDp.dp

    Card(
        colors = CardDefaults.cardColors(
            containerColor = SleepDarkGrey,
        ),
        modifier = Modifier
            .size(width = screenWidth,height = screenWidth/2)

    ) {
        Text(
            text = title,
            modifier = Modifier
                .padding(16.dp),
            color = Color.White,
            textAlign = TextAlign.Center,
        )
    }


}