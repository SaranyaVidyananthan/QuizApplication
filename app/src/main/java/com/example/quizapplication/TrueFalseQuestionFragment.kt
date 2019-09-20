package com.example.quizapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment

public class TrueFalseQuestionFragment(private val myquestion: TrueFalseQuestion) : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.true_false, container, false)

        val questionText: TextView = view.findViewById(R.id.question)
        val setQuestion: String = myquestion.question
        questionText.text = setQuestion

        val trueButton: Button = view.findViewById(R.id.true_button)
        trueButton.setOnClickListener {
            checkAnswer(true)
        }
        val falseButton: Button = view.findViewById(R.id.false_button)
        falseButton.setOnClickListener {
            checkAnswer(false)
        }

        return view

    }

    // checks if the user's answer for a true and false question is correct
    fun checkAnswer(isAnswer: Boolean) {
        val answer = myquestion.answer
        val explanation = myquestion.info
        if (isAnswer == answer) {
            Toast.makeText(activity, "Correct answer!", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(activity, "Incorrect.$explanation", Toast.LENGTH_SHORT).show()
        }
    }
}

