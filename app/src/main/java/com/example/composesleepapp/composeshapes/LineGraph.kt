package com.example.composesleepapp.composeshapes

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composesleepapp.ui.theme.SleepBlue
import com.example.composesleepapp.ui.theme.SleepDarkRed
import com.example.composesleepapp.ui.theme.SleepGreen
import com.example.composesleepapp.ui.theme.SleepPurple

// Calculates number of elements in data sample and uses that to divide up view width to
// calculate bar width and space. Space is a ratio of the bar width.
// Height is calculated as a ratio of max data value and view screen.
// Path of line is modulated with cornerpatheffect for smoother lines.
// Scale factor (6) is for aesthetic value only.

@Preview
@Composable
fun LineGraph() {

    val screenWidth = LocalConfiguration.current.screenWidthDp.dp

    Canvas(
        modifier = Modifier
            .background(Color.Black)
            .width(screenWidth)
            .height(screenWidth/2)
    ) {
        val numberBars = samples.size
        val canvasWidth = size.width
        val canvasHeight = size.height
        val yAdjustment = canvasHeight / 2
        val lyAdjustment = canvasHeight / 3

        // need to scale data
        val sampleMax = samples.maxBy { it.height }
        val scalar = canvasHeight / (sampleMax.height * 6)

        // bar = 1 and interspace = 0.5 of a bar
        val interBarSpaceRatio = 1.5f
        val barWidth = (canvasWidth / numberBars) / interBarSpaceRatio

        val path = Path()
        path.moveTo(0f, samples[0].height * scalar + lyAdjustment)

        var col = Color.Green

        for ((index, value) in samples.withIndex()) {

            if (value.height > 0){
                col = SleepPurple
            }
            else if (value.height < -3){
                col = SleepGreen
            }
            else {
                col = SleepBlue
            }
            drawRect(
                color = col,
                topLeft = Offset(x = (index * barWidth * interBarSpaceRatio), y = yAdjustment),
                size = Size(width = barWidth, height = value.height * scalar)
            )

            path.lineTo(x = (index * barWidth * interBarSpaceRatio), value.height*scalar +  lyAdjustment)

        }

        drawPath(
            color = SleepDarkRed,
            path = path,
            style = Stroke(
                width = 1.dp.toPx(),
               pathEffect = PathEffect.cornerPathEffect(50f)
            )
        )

    }


}