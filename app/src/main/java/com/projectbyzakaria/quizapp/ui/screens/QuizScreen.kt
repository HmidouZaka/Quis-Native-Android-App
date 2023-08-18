package com.projectbyzakaria.quizapp.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTagsAsResourceId
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import com.projectbyzakaria.quizapp.R
import com.projectbyzakaria.quizapp.model.QuizQuestion
import com.projectbyzakaria.quizapp.ui.components.PaintsHeader
import com.projectbyzakaria.quizapp.ui.components.SuggestionComponent
import com.projectbyzakaria.quizapp.ui.viewmodels.QuizViewModel
import com.projectbyzakaria.quizapp.utils.SuggestionState

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun QuizScreen(
    modifier: Modifier = Modifier,
    question: QuizQuestion,
    onClickNextQuestion: () -> Unit,
    numberOfQuestion: () -> Int,
    targetPaint: () -> Int,
    viewModel: QuizViewModel,
    onSubmit: (isSuccess: Boolean) -> Unit,
    isLastQuestion: Boolean = false,
) {
    Column(
        modifier = modifier.semantics {
            this.testTagsAsResourceId = true
        },
    ) {

        Spacer(modifier = Modifier.height(20.dp))


        PaintsHeader(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            numberOfQuestion = numberOfQuestion,
            targetPaint = targetPaint,
            viewModel = viewModel,
            maxTime = viewModel.maxTime
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = question.questions,
            fontSize = 30.sp,
            fontWeight = FontWeight.W500,
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            lineHeight = TextUnit(30f, TextUnitType.Sp)
        )

        var selectedIndex: Int? by rememberSaveable {
            mutableStateOf(null)
        }

        var answerState: SuggestionState by rememberSaveable {
            mutableStateOf(SuggestionState.NATING)
        }

        question.suggestion.forEachIndexed { index, suggestion ->
            SuggestionComponent(
                suggestion = suggestion,
                suggestionState = if (selectedIndex == index && answerState == SuggestionState.NATING) {
                    SuggestionState.SELECTED
                } else if (selectedIndex != index && answerState == SuggestionState.NATING) {
                    SuggestionState.NATING
                } else if (selectedIndex == index && answerState == SuggestionState.SUCCESS) {
                    SuggestionState.SUCCESS
                } else if (selectedIndex == index && answerState == SuggestionState.ERROR) {
                    SuggestionState.ERROR
                } else {
                    SuggestionState.NATING
                },
                modifier = Modifier.testTag("option$index")
                    .padding(8.dp)
                    .fillMaxWidth()
            ) {
                if (answerState == SuggestionState.NATING) {
                    selectedIndex = index
                }
            }
        }

        if (answerState == SuggestionState.ERROR || answerState == SuggestionState.SUCCESS) {
            Button(
                onClick = {
                    onClickNextQuestion()
                    answerState = SuggestionState.NATING
                    selectedIndex = null
                },
                modifier = Modifier.testTag("next")
                    .padding(8.dp)
                    .fillMaxWidth(),
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF00C503)
                )
            ) {
                val text = if (isLastQuestion) "Show Result" else "Next"
                Text(
                    text = text,
                    fontSize = 18.sp
                )

            }
        } else {
            AnimatedVisibility(visible = selectedIndex != null) {
                Button(
                    onClick = {
                        if (selectedIndex == question.correctAnswerIndex) {
                            answerState = SuggestionState.SUCCESS
                            onSubmit(true)
                        } else {
                            onSubmit(false)
                            answerState = SuggestionState.ERROR
                        }
                    },
                    modifier = Modifier.testTag("submit")
                        .padding(8.dp)
                        .fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF24D3FF)
                    )
                ) {

                    Text(
                        text = "Submit",
                        fontSize = 18.sp
                    )

                }
            }
        }

    }
}
