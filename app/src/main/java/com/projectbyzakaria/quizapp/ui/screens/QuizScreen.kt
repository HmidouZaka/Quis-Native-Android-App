package com.projectbyzakaria.quizapp.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.projectbyzakaria.quizapp.R
import com.projectbyzakaria.quizapp.model.QuizQuestion
import com.projectbyzakaria.quizapp.ui.components.SuggestionComponent
import com.projectbyzakaria.quizapp.utils.SuggestionState

@Composable
fun QuizScreen(
    modifier: Modifier = Modifier,
    question: QuizQuestion,
) {
    Surface(
        modifier = modifier,
    ) {


        Text(
            text = question.questions,
            fontSize = 30.sp,
            fontWeight = FontWeight.W500,
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
        )


        question.suggestion.forEach {
            SuggestionComponent(
                suggestion = it,
                suggestionState = SuggestionState.NATING,
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()
            ) {

            }
        }


    }
}


@Preview(showBackground = true)
@Composable
fun QuizScreenPreview() {
    QuizScreen(
        Modifier.fillMaxSize(), QuizQuestion(
            id = 1,
            questions = "How old are you ?",
            correctAnswerIndex = 1,
            suggestion = listOf("4", "20", "5", "30"),
            isMultipleCorrectAnswer = false
        )
    )
}