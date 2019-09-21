package com.example.quizapplication

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.ImageButton
import androidx.fragment.app.Fragment


class QuestionsActivity() : AppCompatActivity() {

    private var indexOfQuestions = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.question_main)

        var b: Bundle? = intent.getBundleExtra("Bundle")
        var questionList: ArrayList<Question> = b?.getSerializable("ArrayList") as ArrayList<Question>

        setNextQuestion(questionList[indexOfQuestions])

        val nextButton: Button = findViewById(R.id.next_button)
        nextButton.setOnClickListener {
            indexOfQuestions++
            if (indexOfQuestions == questionList.size) {
                questionList.shuffle()
                indexOfQuestions = 0
            }
            setNextQuestion(questionList[indexOfQuestions])
        }

        val close: ImageButton = findViewById(R.id.cancel_button)
        close.setOnClickListener {
            finish()
        }
    }

    // sets the content view for the next question based on the type of question: true and false, multiple choice,
    // or question and answer pair
    fun setNextQuestion(question : Question) {
        val selectedFragment: Fragment;
        when (question) {
            is TrueFalseQuestion -> {
                selectedFragment = TrueFalseQuestionFragment(question)
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_main, selectedFragment).commit()

            }
            is MultipleChoiceQuestion -> {
                selectedFragment = MultipleChoiceQuestionFragment(question)
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_main, selectedFragment).commit()


            }
            is QuestionAnswer -> {
                selectedFragment = QuestionAnswerFragment(question)
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_main, selectedFragment).commit()

            }
        }
    }
}
