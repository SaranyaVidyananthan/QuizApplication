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
            questionList.add(QuestionAnswer("Convert the binary number to it's decimal value using Two's Complement Form: 00010101", "Convert the number like an unsigned integer, and stop if the leading bit is a 0.","21"))
            questionList.add(MultipleChoiceQuestion("What is the MIPS instruction used to return from a program", "This instruction is not used to return.", "add $1, $2, $3", "lw $2, 1($2)", "lis $6", "jr $31", "jr $31"))
            questionList.add(QuestionAnswer("Convert the binary number to it's decimal value using Two's Complement Form: 10010011", "Convert the number like an unsigned integer, and if the leading bit is 1, subtract 2^(number of bits).", "-109"))
            questionList.add(TrueFalseQuestion("true false question", "explanation", true))
            questionList.add(QuestionAnswer("Convert the decimal number to binary: -20", "Write the number in binary(00010100), take the complement(11101011) and add 1.", "11101100"))

            val intent = Intent(this, QuestionsActivity::class.java)
            val args = Bundle()
            args.putSerializable("ArrayList", questionList)
            intent.putExtra("Bundle", args)
            startActivity(intent)
        }

        // the user chose the CS 246 topic
        val secondTopic: Button = findViewById(R.id.CS246)
        secondTopic.setOnClickListener {

            val questionList = ArrayList<Question>()
            questionList.add(MultipleChoiceQuestion("CS246 Three", "explanation", "1", "2", "3", "4", "1"))
            questionList.add(MultipleChoiceQuestion("CS246 Four", "explanation", "1", "2", "3", "4", "2"))
            questionList.add(TrueFalseQuestion("CS246 1", "explanation", true))
            questionList.add(TrueFalseQuestion("CS246 2", "explanation", false))

            val intent = Intent(this, QuestionsActivity::class.java)
            val args = Bundle()
            args.putSerializable("ArrayList", questionList)
            intent.putExtra("Bundle", args)
            startActivity(intent)
        }

        // user chose the CS 240 topic
        val thirdTopic: Button = findViewById(R.id.CS240)
        thirdTopic.setOnClickListener {

            val questionList = ArrayList<Question>()
            questionList.add(MultipleChoiceQuestion("CS240 Three", "explanation", "1", "2", "3", "4", "1"))
            questionList.add(MultipleChoiceQuestion("CS240 Four", "explanation", "1", "2", "3", "4", "2"))
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
