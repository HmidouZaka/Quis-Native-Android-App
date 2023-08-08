package com.projectbyzakaria.quizapp.data.levels

import com.projectbyzakaria.quizapp.model.QuizQuestion

class LevelTree {

    companion object{
        fun getLevelTreeQuestions():List<QuizQuestion>{
            val questionsList3 = listOf(
                QuizQuestion(
                    41,
                    "What is the largest organ in the human body?",
                    2,
                    listOf("Liver", "Brain", "Skin", "Heart"),
                    false
                ),
                QuizQuestion(
                    42,
                    "Which gas is known as 'laughing gas'?",
                    0,
                    listOf("Nitrous oxide", "Oxygen", "Carbon dioxide", "Hydrogen"),
                    false
                ),
                QuizQuestion(
                    43,
                    "Who wrote the novel 'Pride and Prejudice'?",
                    3,
                    listOf("Charles Dickens", "Mark Twain", "Jane Austen", "Leo Tolstoy"),
                    false
                ),
                QuizQuestion(
                    44,
                    "Which process involves the conversion of glucose into energy?",
                    1,
                    listOf("Respiration", "Photosynthesis", "Digestion", "Fermentation"),
                    false
                ),
                QuizQuestion(
                    45,
                    "What is the chemical symbol for nitrogen?",
                    3,
                    listOf("Ni", "Ne", "No", "N"),
                    false
                ),
                QuizQuestion(
                    46,
                    "Which famous artist painted the Sistine Chapel ceiling?",
                    1,
                    listOf("Pablo Picasso", "Michelangelo", "Leonardo da Vinci", "Vincent van Gogh"),
                    false
                ),
                QuizQuestion(
                    47,
                    "How many continents are there on Earth?",
                    0,
                    listOf("7", "5", "6", "4"),
                    false
                ),
                QuizQuestion(
                    48,
                    "What is the primary purpose of white blood cells in the body?",
                    1,
                    listOf("Producing energy", "Fighting infections", "Digesting food", "Transporting oxygen"),
                    false
                ),
                QuizQuestion(
                    49,
                    "Which gas is responsible for the greenhouse effect?",
                    0,
                    listOf("Carbon dioxide", "Oxygen", "Nitrogen", "Helium"),
                    false
                ),
                QuizQuestion(
                    50,
                    "Which famous physicist developed the theory of general relativity?",
                    2,
                    listOf("Isaac Newton", "Marie Curie", "Albert Einstein", "Galileo Galilei"),
                    false
                ),
                QuizQuestion(
                    51,
                    "Which planet is known as the 'Gas Giant'?",
                    2,
                    listOf("Venus", "Mars", "Jupiter", "Mercury"),
                    false
                ),
                QuizQuestion(
                    52,
                    "What is the main component of natural gas?",
                    1,
                    listOf("Methane", "Ethane", "Propane", "Butane"),
                    false
                ),
                QuizQuestion(
                    53,
                    "Who is known for discovering the laws of motion and universal gravitation?",
                    0,
                    listOf("Isaac Newton", "Albert Einstein", "Galileo Galilei", "Nikola Tesla"),
                    false
                ),
                QuizQuestion(
                    54,
                    "What is the chemical symbol for carbon?",
                    0,
                    listOf("C", "Ca", "Co", "Cu"),
                    false
                ),
                QuizQuestion(
                    55,
                    "Which planet is closest to the Sun?",
                    0,
                    listOf("Mercury", "Venus", "Earth", "Mars"),
                    false
                ),
                QuizQuestion(
                    56,
                    "What is the process by which liquid water turns into water vapor?",
                    1,
                    listOf("Evaporation", "Condensation", "Freezing", "Melting"),
                    false
                ),
                QuizQuestion(
                    57,
                    "Which gas is known as the 'Noble Gas'?",
                    3,
                    listOf("Oxygen", "Hydrogen", "Nitrogen", "Helium"),
                    false
                ),
                QuizQuestion(
                    58,
                    "Who developed the theory of natural selection?",
                    1,
                    listOf("Isaac Newton", "Charles Darwin", "Albert Einstein", "Galileo Galilei"),
                    false
                ),
                QuizQuestion(
                    59,
                    "What is the chemical symbol for silver?",
                    1,
                    listOf("Si", "Ag", "Sr", "Sc"),
                    false
                ),
                QuizQuestion(
                    60,
                    "What is the process of solid ice changing directly into water vapor?",
                    3,
                    listOf("Sublimation", "Evaporation", "Condensation", "Freezing"),
                    false
                )
            )


            return questionsList3
        }
    }

}