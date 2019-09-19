package com.example.quizapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment


class MainActivity : AppCompatActivity() {

    private var indexOfQuestions = 0
    private var questionList = mutableListOf<Question>(
        MultipleChoiceQuestion("Question Three", "explanation","1","2","3","4", "1"),
        MultipleChoiceQuestion("Question Four", "explanation","1","2","3","4", "2"),
        TrueFalseQuestion("Question 1", "explanation",true),
        TrueFalseQuestion("Question 2", "explanation",false)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main)

        setNextQuestion()

        val nextButton: Button = findViewById(R.id.next_button)
        nextButton.setOnClickListener {
            indexOfQuestions++
            if (indexOfQuestions == questionList.size) {
                questionList.shuffle()
                indexOfQuestions=0
            }
            setNextQuestion()
        }
    }

 /*   // checks if the user's answer for a true and false question is correct
    fun checkAnswer(isAnswer: Boolean) {
        val currentQuestion = questionList[indexOfQuestions] as TrueFalseQuestion
        val answer = currentQuestion.answer
        val explanation = currentQuestion.info
        if (isAnswer == answer) {
            Toast.makeText(this,"Correct answer!" , Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Incorrect.$explanation", Toast.LENGTH_SHORT).show()
        }
    }

    // checks if the user's answer for a multiple choice question is correct
    fun checkMCAnswer(userAnswer: String) {
        val currentQuestion: MultipleChoiceQuestion = questionList[indexOfQuestions] as MultipleChoiceQuestion
        val answer = currentQuestion.answer
        val explanation = currentQuestion.info
        if (userAnswer == answer) {
            Toast.makeText(this,"Correct answer!" , Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Incorrect.$explanation", Toast.LENGTH_SHORT).show()
        }
    }*/

    // sets the content view for the next question based on the type of question: true and false, multiple choice,
    // or question and answer pair
    fun setNextQuestion() {
        val selectedFragment: Fragment;
        when(val currentQuestion: Question = questionList[indexOfQuestions]) {
            is TrueFalseQuestion -> {
                selectedFragment = TrueFalseQuestionFragment(currentQuestion)
                supportFragmentManager.beginTransaction().replace(R.id.fragment_main, selectedFragment).commit()


              /*      val trueButton: Button = findViewById(R.id.true_button)
                    trueButton.setOnClickListener {
                        checkAnswer(true)
                    }

                    val falseButton: Button = findViewById(R.id.false_button)
                    falseButton.setOnClickListener {
                        checkAnswer(false)
                    }*/
            }
            is MultipleChoiceQuestion -> {
                selectedFragment = MultipleChoiceQuestionFragment(currentQuestion)
                supportFragmentManager.beginTransaction().replace(R.id.fragment_main, selectedFragment).commit()

      /*          val choiceOne: TextView = findViewById(R.id.answer1)
                var setChoice: String = currentQuestion.choice1
                choiceOne.text = setChoice

                val choiceTwo: TextView = findViewById(R.id.answer2)
                setChoice = currentQuestion.choice2
                choiceTwo.text = setChoice

                val choiceThree: TextView = findViewById(R.id.answer3)
                setChoice = currentQuestion.choice3
                choiceThree.text = setChoice

                val choiceFour: TextView = findViewById(R.id.answer4)
                setChoice = currentQuestion.choice4
                choiceFour.text = setChoice

                choiceOne.setOnClickListener {
                    checkMCAnswer(currentQuestion.choice1)
                }

                choiceTwo.setOnClickListener {
                    checkMCAnswer(currentQuestion.choice2)
                }

                choiceThree.setOnClickListener {
                    checkMCAnswer(currentQuestion.choice3)
                }

                choiceFour.setOnClickListener {
                    checkMCAnswer(currentQuestion.choice4)
                }*/
            }
            is QuestionAnswer -> {
                selectedFragment = QuestionAnswerFragment(currentQuestion)
                supportFragmentManager.beginTransaction().replace(R.id.fragment_main, selectedFragment).commit()

            }
        }

      /*  val questionText: TextView = findViewById(R.id.question)
        val setQuestion: String = questionList[indexOfQuestions].question
        questionText.text = setQuestion*/
    }
}
