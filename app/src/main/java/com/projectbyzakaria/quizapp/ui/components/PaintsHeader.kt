package com.projectbyzakaria.quizapp.ui.components

import android.util.Log
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.inset
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import com.projectbyzakaria.quizapp.ui.viewmodels.QuizViewModel
import kotlin.math.log

@Composable
fun PaintsHeader(
    modifier: Modifier = Modifier,
    numberOfQuestion: ()->Int,
    targetPaint: ()->Int,
    maxTime:Int,
    viewModel: QuizViewModel,
    ) {

    var timer = viewModel.timer
    val animateFloat by animateFloatAsState(targetValue = numberOfQuestion().toFloat(), label = "progress")
    val animateFloatTimeOut by animateFloatAsState(targetValue = timer.toFloat() , label = "timeout")

    Row(
        modifier = modifier
            .clip(RoundedCornerShape(8.dp))
            .background(MaterialTheme.colorScheme.background)
            .border(
                width = 2.dp,
                color = Color(0xFFDFDFDF),
                shape = RoundedCornerShape(8.dp)
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier
                .padding(vertical = 8.dp)
                .weight(1f)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "${numberOfQuestion()}/20",
                    modifier = Modifier.padding(8.dp),
                    fontSize = 24.sp,
                    fontWeight = FontWeight.W500,
                )
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text = "${targetPaint()}/20",
                    modifier = Modifier.padding(8.dp),
                    fontSize = 24.sp,
                    fontWeight = FontWeight.W500,
                )
            }

            Spacer(modifier = Modifier.height(2.dp))
            LinearProgressIndicator(
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .padding(bottom = 8.dp)
                    .height(8.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .fillMaxWidth(),
                color = Color(0xFF48F036),
                trackColor = Color(0xFFD8D8D8),
                progress = animateFloat / 20f
            )
        }

        val sizeProgress = with(LocalDensity.current){ 60.dp.toPx() }

        Box(
            modifier = Modifier
                .width(100.dp)
                .height(80.dp)
                .drawBehind {

                    drawArc(
                        color = Color(0xFFDADADA),
                        startAngle = 270f,
                        sweepAngle = 360f,
                        useCenter = false,
                        size = Size(sizeProgress, sizeProgress),
                        style = Stroke(
                            width = 15f,
                            cap = StrokeCap.Round
                        ),
                        topLeft = Offset(
                            size.width * 0.5f - sizeProgress * 0.5f,
                            size.height * 0.5f - sizeProgress * 0.5f
                        )
                    )

                    val dogree = animateFloatTimeOut/maxTime * 100f
                    val sweepAngle = dogree/100f * 360
                    drawArc(
                        color = Color(0xFF03A9F4),
                        startAngle = 270f,
                        sweepAngle = sweepAngle,
                        useCenter = false,
                        size = Size(sizeProgress, sizeProgress),
                        style = Stroke(
                            width = 15f,
                            cap = StrokeCap.Round
                        ),
                        topLeft = Offset(
                            size.width * 0.5f - sizeProgress * 0.5f,
                            size.height * 0.5f - sizeProgress * 0.5f
                        )
                    )

                },
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = viewModel.timer.toString(),
                modifier = Modifier.padding(8.dp),
                fontSize = 20.sp,
                fontWeight = FontWeight.W400,
                color = Color.Black,
            )
        }

    }
}
