package com.projectbyzakaria.quizapp.ui.screens

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.projectbyzakaria.quizapp.R
import com.projectbyzakaria.quizapp.ui.components.LevelItem

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    levelNumber: Int,
    paints: List<Int?>,
    onClickLevel: (Int) -> Unit,
) {
    val context = LocalContext.current
    Column(
        modifier = modifier
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            items(10) {
                val borderColor = if (levelNumber >= it +1) Color(0xFF4CAF50) else Color(0xFF505050)

                LevelItem(
                    modifier = Modifier.testTag("test$it")
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(8.dp))
                        .background(if (levelNumber >= (it +1)) Color(0xFF4CAF50) else Color(0xFFC7C7C7))
                        .border(
                            width = 2.dp,
                            borderColor,
                            RoundedCornerShape(8.dp)
                        )
                        .clickable {
                            if (levelNumber >= it +1) {
                                onClickLevel(it + 1)
                            } else {
                                Toast.makeText(context, "unavailable level", Toast.LENGTH_SHORT).show()
                            }
                        },
                    paint =paints.get(it),
                    levelNumber = levelNumber,
                    targetLevelIndex = it + 1
                )
            }
        }
    }
}


@Preview(
    showBackground = true
)
@Composable
fun HomeScreenPreview() {
    HomeScreen(Modifier.fillMaxSize(), 5,(Array<Int?>(10){null}).toList()){

    }

}