package com.example.quizapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class TopicsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.topics)

        // the user chose the CS 241 option
        val firstTopic: Button = findViewById(R.id.CS241)
        firstTopic.setOnClickListener {
            val questionList = ArrayList<Question>()
            questionList.add(
                MultipleChoiceQuestion(
                    "CS241 Three", "explanation", "1", "2", "3", "4", "1"
                )
            )
            questionList.add(
                MultipleChoiceQuestion("CS241 Four", "explanation", "1", "2", "3", "4", "2"
                )
            )
            questionList.add(TrueFalseQuestion("CS241 1", "explanation", true))
            questionList.add(TrueFalseQuestion("CS241 2", "explanation", false))
            val intent = Intent(this, QuestionsActivity::class.java)
            val args: Bundle = Bundle()
            args.putSerializable("ArrayList", questionList)
            intent.putExtra("Bundle", args)
            startActivity(intent)
        }

        // the user chose the CS 246 topic
        val secondTopic: Button = findViewById(R.id.CS246)
        secondTopic.setOnClickListener {
            val questionList = ArrayList<Question>()
            questionList.add(
                MultipleChoiceQuestion(
                    "CS246 Three", "explanation", "1", "2", "3", "4", "1"
                )
            )
            questionList.add(
                MultipleChoiceQuestion("CS246 Four", "explanation", "1", "2", "3", "4", "2"
                )
            )
            questionList.add(TrueFalseQuestion("CS246 1", "explanation", true))
            questionList.add(TrueFalseQuestion("CS246 2", "explanation", false))

            val intent = Intent(this, QuestionsActivity::class.java)
            val args: Bundle = Bundle()
            args.putSerializable("ArrayList", questionList)
            intent.putExtra("Bundle", args)
            startActivity(intent)
        }

        // user chose the CS 240 topic
        val thirdTopic: Button = findViewById(R.id.CS240)
        thirdTopic.setOnClickListener {
            val questionList = ArrayList<Question>()
            questionList.add(
                MultipleChoiceQuestion(
                    "CS240 Three", "explanation", "1", "2", "3", "4", "1"
                )
            )
            questionList.add(
                MultipleChoiceQuestion("CS240 Four", "explanation", "1", "2", "3", "4", "2"
                )
            )
            questionList.add(TrueFalseQuestion("CS240 1", "explanation", true))
            questionList.add(TrueFalseQuestion("CS240 2", "explanation", false))

            val intent = Intent(this, QuestionsActivity::class.java)
            val args = Bundle()
            args.putSerializable("ArrayList", questionList)
            intent.putExtra("Bundle", args)
            startActivity(intent)
        }
    }
}
