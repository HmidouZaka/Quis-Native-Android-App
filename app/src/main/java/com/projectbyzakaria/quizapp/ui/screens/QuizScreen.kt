package com.projectbyzakaria.quizapp.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.projectbyzakaria.quizapp.R

data class Question(val text: String, val answers: List<String>, val correctAnswerIndex: Int)

@Composable
fun QuizScreen(questions: List<Question>) {
    var currentQuestionIndex by remember { mutableStateOf(0) }
    var selectedAnswerIndex by remember { mutableStateOf(-1) }

    val currentQuestion = questions[currentQuestionIndex]

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = currentQuestion.text, style = MaterialTheme.typography.bodyLarge)

        Spacer(modifier = Modifier.height(16.dp))

        currentQuestion.answers.forEachIndexed { index, answer ->
            AnswerButton(
                text = answer,
                isSelected = index == selectedAnswerIndex,
                onClick = { selectedAnswerIndex = index }
            )

            Spacer(modifier = Modifier.height(8.dp))
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                if (selectedAnswerIndex != -1) {
                    val isCorrect = selectedAnswerIndex == currentQuestion.correctAnswerIndex
                    // Handle correct/incorrect logic here

                    // Move to the next question
                    if (currentQuestionIndex < questions.size - 1) {
                        currentQuestionIndex++
                        selectedAnswerIndex = -1
                    }
                }
            }
        ) {
            Text(text = "SSSSSSSS")
        }
    }
}

@Composable
fun AnswerButton(text: String, isSelected: Boolean, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier.fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(
            containerColor = if (isSelected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.primary
        )
    ) {
        Text(text = text)
    }
}

@Preview
@Composable
fun PreviewQuizScreen() {
    val questions = listOf(
        Question(
            text = "What is the capital of France?",
            answers = listOf("Paris", "London", "Berlin", "Madrid"),
            correctAnswerIndex = 0
        ),
        // Add more questions here
    )

    QuizScreen(questions = questions)
}