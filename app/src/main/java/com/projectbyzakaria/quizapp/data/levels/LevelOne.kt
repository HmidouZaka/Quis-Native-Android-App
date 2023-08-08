package com.projectbyzakaria.quizapp.data.levels

import com.projectbyzakaria.quizapp.model.QuizQuestion

class LevelOne {

    companion object{
        fun getLevelOneQuestions():List<QuizQuestion>{
            val questionsList1 = listOf(
                QuizQuestion(
                    1,
                    "What is 2 + 2?",
                    1,
                    listOf("3", "4", "5", "6"),
                    false
                ),
                QuizQuestion(
                    2,
                    "Which color is the sky?",
                    1,
                    listOf("Green", "Blue", "Red", "Yellow"),
                    false
                ),
                QuizQuestion(
                    3,
                    "What is the capital of Japan?",
                    2,
                    listOf("Tokyo", "Beijing", "Seoul", "Bangkok"),
                    false
                ),
                QuizQuestion(
                    4,
                    "Which gas do plants use for photosynthesis?",
                    0,
                    listOf("Carbon dioxide", "Oxygen", "Hydrogen", "Nitrogen"),
                    false
                ),
                QuizQuestion(
                    5,
                    "What is the largest mammal?",
                    1,
                    listOf("Elephant", "Blue Whale", "Giraffe", "Hippopotamus"),
                    false
                ),
                QuizQuestion(
                    6,
                    "Which planet is known as the Red Planet?",
                    0,
                    listOf("Mars", "Venus", "Jupiter", "Saturn"),
                    false
                ),
                QuizQuestion(
                    7,
                    "Which programming language is used for Android app development?",
                    2,
                    listOf("Java", "Python", "Kotlin", "Swift"),
                    false
                ),
                QuizQuestion(
                    8,
                    "What is the chemical symbol for gold?",
                    3,
                    listOf("Au", "Ag", "Fe", "Cu"),
                    false
                ),
                QuizQuestion(
                    9,
                    "Which gas is responsible for the greenhouse effect?",
                    0,
                    listOf("Carbon dioxide", "Oxygen", "Nitrogen", "Helium"),
                    false
                ),
                QuizQuestion(
                    10,
                    "Which country is famous for its tulip fields?",
                    1,
                    listOf("Netherlands", "France", "Italy", "Spain"),
                    false
                ),
                QuizQuestion(
                    11,
                    "What is the boiling point of water in Celsius?",
                    0,
                    listOf("100", "50", "0", "200"),
                    false
                ),
                QuizQuestion(
                    12,
                    "Which gas is most abundant in Earth's atmosphere?",
                    2,
                    listOf("Oxygen", "Carbon dioxide", "Nitrogen", "Argon"),
                    false
                ),
                QuizQuestion(
                    13,
                    "Which famous scientist developed the theory of relativity?",
                    2,
                    listOf("Isaac Newton", "Marie Curie", "Albert Einstein", "Galileo Galilei"),
                    false
                ),
                QuizQuestion(
                    14,
                    "What is the chemical symbol for oxygen?",
                    0,
                    listOf("O", "X", "C", "H"),
                    false
                ),
                QuizQuestion(
                    15,
                    "Which ocean is the largest?",
                    3,
                    listOf("Indian Ocean", "Arctic Ocean", "Atlantic Ocean", "Pacific Ocean"),
                    false
                ),
                QuizQuestion(
                    16,
                    "Which gas do plants release during photosynthesis?",
                    1,
                    listOf("Carbon dioxide", "Oxygen", "Hydrogen", "Nitrogen"),
                    false
                ),
                QuizQuestion(
                    17,
                    "What is the chemical symbol for silver?",
                    1,
                    listOf("Si", "Ag", "Sr", "Sc"),
                    false
                ),
                QuizQuestion(
                    18,
                    "Which planet is known as the Morning Star or Evening Star?",
                    3,
                    listOf("Mercury", "Venus", "Mars", "Jupiter"),
                    false
                ),
                QuizQuestion(
                    19,
                    "What is the freezing point of water in Fahrenheit?",
                    1,
                    listOf("0", "32", "100", "212"),
                    false
                ),
                QuizQuestion(
                    20,
                    "Which gas makes up the majority of Earth's atmosphere?",
                    2,
                    listOf("Oxygen", "Carbon dioxide", "Nitrogen", "Argon"),
                    false
                )
            )

            return questionsList1
        }
    }

}