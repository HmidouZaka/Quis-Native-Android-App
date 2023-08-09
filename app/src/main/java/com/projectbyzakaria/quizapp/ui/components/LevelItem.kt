package com.projectbyzakaria.quizapp.ui.components

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.projectbyzakaria.quizapp.R

@Composable
fun LevelItem(
    modifier: Modifier,
    levelNumber:Int,
    targetLevelIndex:Int,
    paint:Int?
) {
    val textColor = if (levelNumber >= targetLevelIndex) Color(0xFFFFFFFF) else Color(0xFF000000)
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = if (levelNumber >= targetLevelIndex) R.drawable.unlocked else R.drawable.lock),
            contentDescription = "lock",
            modifier = Modifier
                .padding(8.dp)
                .width(40.dp)
        )

        Text(
            text = "Level ${targetLevelIndex }",
            modifier = Modifier.padding(8.dp),
            fontSize = 22.sp,
            fontFamily = FontFamily.Monospace,
            color = textColor
        )
        if (levelNumber >= targetLevelIndex){
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = "${paint ?: 0}/20",
                modifier = Modifier.padding(8.dp),
                fontSize = 16.sp,
                fontFamily = FontFamily.Monospace,
                color = textColor
            )
        }

    }
}