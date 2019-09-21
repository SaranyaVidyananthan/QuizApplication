package com.example.quizapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import java.util.*

public class QuestionAnswerFragment(private val myquestion: QuestionAnswer) : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.question_answer, container, false)

        val questionText: TextView = view.findViewById(R.id.question)
        val setQuestion: String = myquestion.question
        questionText.text = setQuestion

        val done: Button = view.findViewById(R.id.done_button)
        done.setOnClickListener {
            val userAnswer: EditText = view.findViewById(R.id.plain_text_input)
            val answer: String = userAnswer.text.toString().trim().trimStart('0').toLowerCase(Locale.CANADA)
            checkAnswer(answer)
        }
        return view
    }

    // checks if the user's answer for a question and answer is correct
    fun checkAnswer(isAnswer: String) {
        val answer = myquestion.answer
        val explanation = myquestion.info
        if (isAnswer == answer) {
            Toast.makeText(activity, "Correct answer!", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(activity, "Incorrect. $explanation", Toast.LENGTH_LONG).show()
        }
    }
}