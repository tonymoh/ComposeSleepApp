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
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


data class sample(
    val height: Float
)

val samples: List<sample> = listOf(
    sample(2f),
    sample(5f),
    sample(-4f),
    sample(3f),
    sample(2f),
    sample(-3f),
    sample(3f),
    sample(4f),
    sample(-2f),
    sample(3f),
    sample(-1f),
    sample(-2f),
    sample(2f),
    sample(5f),
    sample(-4f),
    sample(3f),
    sample(2f),
    sample(-4f),
    sample(3f),
    sample(4f),
    sample(-2f),
    sample(3f),
    sample(-2f),
    sample(-2f),
    sample(2f),
    sample(5f),
    sample(-4f),
    sample(3f),
    sample(2f)
)

// Earlier code - not used
@Preview
@Composable
fun BarGraph() {

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
        val yAdjustment = canvasHeight/2

        // need to scale data
        val sampleMax = samples.maxBy { it.height }
        val scalar = canvasHeight/(sampleMax.height * 6)

        // bar = 1 and interspace = 0.5 of a bar
        val interBarSpaceRatio = 1.5f
        val barWidth = (canvasWidth / numberBars) / interBarSpaceRatio

        // Change col on value
        var col = Color.Green

        for ((index, value) in samples.withIndex()) {

            if (value.height > 3){
                col = Color.Red
            }
            else if (value.height < -3){
                col = Color.Green
            }
            else {
                col = Color.Yellow
            }

            drawRect(
                color = col,
                topLeft = Offset(x=(index*barWidth*interBarSpaceRatio),y = yAdjustment),
                size = Size(width = barWidth, height = value.height*scalar)
            )
        }

    }

}