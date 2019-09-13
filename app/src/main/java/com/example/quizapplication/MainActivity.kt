package com.example.quizapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private var indexOfQuestions = 0
    private var questionList = mutableListOf<TrueFalseQuestion>(
        TrueFalseQuestion("a", "explanation",true),
        TrueFalseQuestion("b", "explanation",false)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.true_false)

        var questionText: TextView = findViewById(R.id.question_tf)
        var setQuestion: String = questionList[indexOfQuestions].question
        questionText.text = setQuestion

        var trueButton: Button = findViewById(R.id.true_button)
        trueButton.setOnClickListener {
            checkAnswer(true)
        }

        var falseButton: Button = findViewById(R.id.false_button)
        falseButton.setOnClickListener {
            checkAnswer(false)
        }

        var nextButton: Button = findViewById(R.id.next_button)
        nextButton.setOnClickListener {
            indexOfQuestions++
            setQuestion = questionList[indexOfQuestions].question
            questionText.text = setQuestion
        }
    }

    fun checkAnswer(isAnswer: Boolean) {
        var answer = questionList[indexOfQuestions].answer
        if (isAnswer == answer) {
            Toast.makeText(this, "right", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "wrong", Toast.LENGTH_SHORT).show()
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
