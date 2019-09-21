package com.example.quizapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import androidx.fragment.app.Fragment


class MainActivity : AppCompatActivity() {

    private var indexOfQuestions = 0
    private var questionList = mutableListOf<Question>(
        MultipleChoiceQuestion("Question Three", "explanation", "1", "2", "3", "4", "1"),
        MultipleChoiceQuestion("Question Four", "explanation", "1", "2", "3", "4", "2"),
        TrueFalseQuestion("Question 1", "explanation", true),
        TrueFalseQuestion("Question 2", "explanation", false)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.question_main)

        setNextQuestion()

        val nextButton: Button = findViewById(R.id.next_button)
        nextButton.setOnClickListener {
            indexOfQuestions++
            if (indexOfQuestions == questionList.size) {
                questionList.shuffle()
                indexOfQuestions = 0
            }
            setNextQuestion()
        }
    }

    // sets the content view for the next question based on the type of question: true and false, multiple choice,
    // or question and answer pair
    fun setNextQuestion() {
        val selectedFragment: Fragment;
        when (val currentQuestion: Question = questionList[indexOfQuestions]) {
            is TrueFalseQuestion -> {
                selectedFragment = TrueFalseQuestionFragment(currentQuestion)
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_main, selectedFragment).commit()

            }
            is MultipleChoiceQuestion -> {
                selectedFragment = MultipleChoiceQuestionFragment(currentQuestion)
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_main, selectedFragment).commit()


            }
            is QuestionAnswer -> {
                selectedFragment = QuestionAnswerFragment(currentQuestion)
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_main, selectedFragment).commit()

            }
        }
    }
}
