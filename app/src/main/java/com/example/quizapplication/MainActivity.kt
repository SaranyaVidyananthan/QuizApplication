package com.example.quizapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.true_false.*

class MainActivity : AppCompatActivity() {

    private var indexOfQuestions = 0
    private var questionList = mutableListOf<Question>(
        TrueFalseQuestion("Question One", "explanation",true),
        TrueFalseQuestion("Question Two", "explanation",false),
        MultipleChoiceQuestion("Question Three", "explanation","1","2","3","4", "answer"),
        MultipleChoiceQuestion("Question Four", "explanation","1","2","3","4", "answer")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        when {
            questionList[indexOfQuestions] is TrueFalseQuestion -> {
                val tfquestion: TrueFalseQuestion? = questionList[indexOfQuestions] as? TrueFalseQuestion
                setContentView(R.layout.true_false)

                val trueButton: Button = findViewById(R.id.true_button)
                trueButton.setOnClickListener {
                    checkAnswer(true)
                }

                val falseButton: Button = findViewById(R.id.false_button)
                falseButton.setOnClickListener {
                    checkAnswer(false)
                }
            }
            questionList[indexOfQuestions] is MultipleChoiceQuestion -> {
                val mcquestion: MultipleChoiceQuestion? = questionList[indexOfQuestions] as? MultipleChoiceQuestion
                setContentView(R.layout.multiple_choice)

                val choiceone: TextView = findViewById(R.id.answer1)
                var setchoice: String? = mcquestion?.choice1
                choiceone.text = setchoice

                val choicetwo: TextView = findViewById(R.id.answer2)
                setchoice = mcquestion?.choice2
                choicetwo.text = setchoice

                val choicethree: TextView = findViewById(R.id.answer3)
                setchoice = mcquestion?.choice3
                choicethree.text = setchoice

                val choicefour: TextView = findViewById(R.id.answer4)
                setchoice = mcquestion?.choice4
                choicefour.text = setchoice
            }
            else -> {
                val qaquestion: QuestionAnswer? = questionList[indexOfQuestions] as? QuestionAnswer
                setContentView(R.layout.question_answer)
            }
        }

        val questionText: TextView = findViewById(R.id.question)
        var setQuestion: String = questionList[indexOfQuestions].question
        questionText.text = setQuestion

        val nextButton: Button = findViewById(R.id.next_button)
        nextButton.setOnClickListener {
            indexOfQuestions++
            setQuestion = questionList[indexOfQuestions].question
            questionText.text = setQuestion
        }
    }

    fun checkAnswer(isAnswer: Boolean) {
        val answer = questionList[indexOfQuestions].answer
        var explanation = questionList[indexOfQuestions].info
        if (isAnswer == answer) {
            Toast.makeText(this,"Correct answer!" , Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Incorrect.$explanation", Toast.LENGTH_SHORT).show()
        }
    }

    /*  override fun onCreateOptionsMenu(menu: Menu): Boolean {
          // Inflate the menu; this adds items to the action bar if it is present.
          menuInflater.inflate(R.menu.menu_main, menu)
          return true
      }

      override fun onOptionsItemSelected(item: MenuItem): Boolean {
          // Handle action bar item clicks here. The action bar will
          // automatically handle clicks on the Home/Up button, so long
          // as you specify a parent activity in AndroidManifest.xml.
          return when (item.itemId) {
              R.id.action_settings -> true
              else -> super.onOptionsItemSelected(item)
          }
      }*/
}
