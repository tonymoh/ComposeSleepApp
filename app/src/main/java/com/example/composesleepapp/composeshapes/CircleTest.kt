package com.example.composesleepapp.composeshapes

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composesleepapp.R
import com.example.composesleepapp.ui.theme.SleepBlue
import com.example.composesleepapp.ui.theme.SleepDarkGreen
import com.example.composesleepapp.ui.theme.SleepDarkGrey
import com.example.composesleepapp.ui.theme.SleepLightGreen
import com.example.composesleepapp.ui.theme.SleepLightGrey
import com.example.composesleepapp.ui.theme.SleepLightOrange
import com.example.composesleepapp.ui.theme.SleepPurple
import com.example.composesleepapp.ui.theme.SleepRed
import com.example.composesleepapp.ui.theme.SleepYellow

@Preview
@Composable
fun CircleTest(){

    // Transparency 50% black
    Column(modifier = Modifier.background(Color.Black.copy(alpha = 0.5f))) {
        Text(
            text = "7h 49m",
            color = Color.White,
            fontSize = 56.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(start = 16.dp,top= 16.dp)
        )

        Row() {
            DoubleArcs(SleepDarkGreen, SleepYellow,30f,-90f)
            DoubleArcs(SleepBlue, SleepPurple,-30f,-120f)
        }

        Row() {
            DoubleArcs(SleepLightOrange, SleepDarkGreen,130f,-90f)
            DoubleArcs(SleepLightGreen, SleepRed,90f,-45f)
        }

        Row(){
            Text(
                text = "SLEEP",
                color = Color.White,
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(start = 16.dp, bottom = 16.dp)
                    .weight(5f)
            )
            Image(
                painter = painterResource(id = R.drawable.baseline_note_alt_24),
                contentDescription = "",
                modifier = Modifier.weight(1f) ,
                colorFilter = ColorFilter.tint(SleepLightGrey)
            )
            Image(
                painter = painterResource(id = R.drawable.baseline_nights_stay_24),
                contentDescription = "",
                modifier = Modifier.weight(1f) ,
                colorFilter = ColorFilter.tint(SleepLightGrey)
            )

        }
    }

}

@Composable
fun DoubleArcs(
    innerColour: Color,
    outerColour: Color,
    innerStartAngle: Float,
    outerStartAngle: Float,
) {

    val screenWidth = LocalConfiguration.current.screenWidthDp.dp /2

    Canvas(modifier = Modifier
        .background(Color.Black.copy(alpha = 0.5f))
        .width(screenWidth)
        .height(screenWidth)
    ) {
        val arcRadius = 200f
        val canvasWidth = size.width
        val canvasHeight = size.height


        drawCircle(
            color = SleepDarkGrey,
            radius = arcRadius
        )

        drawArc(
            color = innerColour,
            startAngle = innerStartAngle,
            sweepAngle = 300f,
            topLeft = Offset(   (canvasWidth / 2) - (arcRadius / 2),
                canvasHeight / 2 - (arcRadius / 2)
            ),
            useCenter = false,
            style = Stroke(width = 50f, cap = StrokeCap.Round),
            size = Size(arcRadius, arcRadius)
        )

        val adjust = 120f

        drawArc(
            color = outerColour,
            startAngle = outerStartAngle,
            sweepAngle = 300f,
            topLeft = Offset(   (canvasWidth / 2) - ((arcRadius + adjust) / 2),
                canvasHeight / 2 - ((arcRadius + adjust) / 2)
            ),
            useCenter = false,
            style = Stroke(width = 50f, cap = StrokeCap.Round),
            size = Size(arcRadius+adjust, arcRadius+adjust)
        )


    }
}