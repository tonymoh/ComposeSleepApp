package com.example.composesleepapp.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.composesleepapp.composeshapes.CircleTest
import com.example.composesleepapp.ui.theme.SleepLightBlack

// @Preview
@Composable
fun MainScreen(padding : PaddingValues) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(SleepLightBlack)
            .verticalScroll(rememberScrollState())

    ){
        CircleTest()
        InfoCard("SLEEP SESSION")
        Spacer(modifier = Modifier
            .padding(vertical = 16.dp))
        InfoCard("SLEEP ACTIVITY")
        Spacer(modifier = Modifier
            .padding(vertical = 16.dp))
        InfoCard("LIGHTS OFF")
        Spacer(modifier = Modifier.padding(vertical = padding.calculateBottomPadding()))
    }
}