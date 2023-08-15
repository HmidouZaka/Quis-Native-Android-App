package com.projectbyzakaria.quizapp.ui.screens

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.projectbyzakaria.quizapp.R

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun ResultScreen(
    modifier: Modifier = Modifier,
    currentLevel: Int,
    nextLevel: Int?,
    paints: () -> Int,
    isSuccess: Boolean,
    isLastPaint: () -> Boolean,
    onClickNextLevel: () -> Unit,
    onClickTryAgain: () -> Unit,
    onClickBack: () -> Unit,
) {

    val text = if (isSuccess)
        "Congratulations! You've successfully completed the level. Your skills are truly impressive. Are you ready to take on the next challenge? Get ready to push your limits and showcase your abilities in the upcoming level. Good luck!" else
        "Don't be discouraged! Even the best face setbacks from time to time. Remember, failure is just a stepping stone towards success. . With determination and practice, you'll surely conquer this level and be ready to move on to the next one in no time. Keep up the effort!"
    val image = if (isSuccess) R.drawable.success else R.drawable.sadface
    val color = if (isSuccess) Color(0xFFC3FFBD) else Color(0xFFFFA4A7)
    val animate = rememberInfiniteTransition(label = text)
    val animateImagePosition by animate.animateFloat(
        initialValue = -50f,
        targetValue = 50f,
        animationSpec = infiniteRepeatable(animation = tween(durationMillis = 1000,), repeatMode = RepeatMode.Reverse),
        label = "image"
    )
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.TopStart
        ) {
            IconButton(onClick = { onClickBack() }) {
                Icon(
                    imageVector = Icons.Default.Close, contentDescription = ""
                )
            }
        }

        Spacer(modifier = Modifier.height(50.dp))
        Image(
            painter = painterResource(id = image), contentDescription = text,
            modifier = Modifier
                .graphicsLayer {
                    this.translationY = this.translationY + animateImagePosition
                }
                .clip(CircleShape)
                .background(color)
                .padding(10.dp),
            alignment = Alignment.Center,
        )

        if (isSuccess) {
            Text(
                text = buildAnnotatedString {
                    withStyle(
                        SpanStyle(
                            color = Color(0xFF03A9F4)
                        )
                    ) {
                        append("Level $currentLevel")
                    }
                    if ( currentLevel < 10) {
                        append(" To ")
                        withStyle(
                            SpanStyle(
                                color = Color(0xFF11E219)
                            )
                        ) {
                            append(" Level $nextLevel")
                        }
                    }

                },
                fontSize = 40.sp,
                color = MaterialTheme.colorScheme.onBackground,
            )
        } else {
            Text(
                text = "Level $currentLevel",
                fontSize = 40.sp,
                color = Color(0xFF03A9F4)
            )
        }

        Text(
            text = text,
            fontSize = 18.sp,
            color = Color(0xFF000000),
            modifier = Modifier.padding(8.dp),
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(10.dp))

        Box(
            modifier = Modifier
                .size(150.dp)
                .clip(RoundedCornerShape(20.dp))
                .background(color),
            contentAlignment = Alignment.Center
        ) {
            AnimatedContent(targetState = paints, label = "paint") {
                Text(
                    text = "${paints()}",
                    fontSize = 60.sp,
                    color = MaterialTheme.colorScheme.onBackground,
                )
            }
        }


        Spacer(modifier = Modifier.height(40.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            AnimatedVisibility(visible = isLastPaint()) {
                Button(
                    onClick = {
                        onClickTryAgain()
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF03A9F4)
                    )
                ) {
                    Text(
                        text = "Retry",
                        modifier = Modifier,
                        fontSize = 20.sp,

                        )
                }
            }
            if (isSuccess && currentLevel < 10) {
                Spacer(modifier = Modifier.width(8.dp))
                AnimatedVisibility(visible = isLastPaint()) {
                    Button(
                        onClick = {
                            onClickNextLevel()
                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF0DB901)
                        )
                    ) {
                        Text(text = "Next", fontSize = 20.sp)
                    }
                }
            }

        }


    }

}


@Preview(showBackground = true)
@Composable
fun SuccessScreenPreview() {
    ResultScreen(
        modifier = Modifier.fillMaxSize(),
        currentLevel = 5,
        nextLevel = 6,
        paints = { 20 },
        onClickNextLevel = {

        },
        onClickTryAgain = {

        },
        isSuccess = true,
        isLastPaint = {
            true
        },
        onClickBack = {

        }
    )
}

@Preview(showBackground = true)
@Composable
fun SuccessScreenPreview2() {
    ResultScreen(
        modifier = Modifier.fillMaxSize(),
        currentLevel = 5,
        nextLevel = 6,
        paints = { 20 },
        onClickNextLevel = {

        },
        onClickTryAgain = {

        },
        isSuccess = false,
        isLastPaint = {
            true
        },
        onClickBack = {

        }
    )
}