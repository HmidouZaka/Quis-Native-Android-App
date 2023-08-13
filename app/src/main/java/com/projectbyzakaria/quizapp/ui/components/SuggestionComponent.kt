package com.projectbyzakaria.quizapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.projectbyzakaria.quizapp.utils.SuggestionState

@Composable
fun SuggestionComponent(
    suggestion: String,
    suggestionState: SuggestionState,
    modifier: Modifier = Modifier,
    onSelect: () -> Unit,
) {

    val backgroundColor = when (suggestionState) {
        SuggestionState.ERROR -> Color(0xFFFFEBEB)
        SuggestionState.SUCCESS -> Color(0xFFCCFFD9)
        SuggestionState.NATING -> Color(0xFFF5F5F5)
        SuggestionState.SELECTED -> Color(0xFFFFFFFF)
    }
    val borderColor = when (suggestionState) {
        SuggestionState.ERROR -> Color(0xFFFF0000)
        SuggestionState.SUCCESS -> Color(0xFF00C532)
        SuggestionState.NATING -> Color(0xFFB8B8B8)
        SuggestionState.SELECTED -> Color(0xFF2E2E2E)
    }

    val icon: ImageVector? = when (suggestionState) {
        SuggestionState.ERROR -> Icons.Default.Clear
        SuggestionState.SUCCESS -> Icons.Default.Done
        SuggestionState.SELECTED -> Icons.Default.Star
        SuggestionState.NATING -> null
    }

    Row(
        modifier = modifier
            .clip(RoundedCornerShape(8.dp))
            .background(backgroundColor)
            .border(
                width = 2.dp,
                color = borderColor,
                shape = RoundedCornerShape(8.dp)
            )
            .clickable {
                onSelect()
            },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = suggestion,
            fontSize = 23.sp,
            modifier = Modifier.padding(12.dp),
            fontFamily = FontFamily.Monospace,
            fontWeight = FontWeight.Medium
        )

        Spacer(modifier = Modifier.weight(1f))

        icon?.let {
            Icon(
                imageVector = it, contentDescription = "",
                modifier = Modifier.padding(8.dp),
                tint = borderColor
            )
        }
    }

}

@Preview
@Composable
fun SuggestionComponentPreview() {
    SuggestionComponent(
        suggestion = "20",
        suggestionState = SuggestionState.NATING,
        modifier = Modifier.fillMaxWidth()
    ) {

    }
}

@Preview
@Composable
fun SuggestionComponentPreviewError() {
    SuggestionComponent(
        suggestion = "20",
        suggestionState = SuggestionState.ERROR,
        modifier = Modifier.fillMaxWidth()
    ) {

    }
}

@Preview
@Composable
fun SuggestionComponentPreviewSuccess() {
    SuggestionComponent(
        suggestion = "20",
        suggestionState = SuggestionState.SUCCESS,
        modifier = Modifier.fillMaxWidth()
    ) {

    }
}

@Preview
@Composable
fun SuggestionComponentPreviewSelected() {
    SuggestionComponent(
        suggestion = "20",
        suggestionState = SuggestionState.SELECTED,
        modifier = Modifier.fillMaxWidth()
    ) {

    }
}