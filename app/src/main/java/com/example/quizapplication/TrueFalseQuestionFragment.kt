package com.example.quizapplication

import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.true_false.*
import java.util.*

class TrueFalseQuestionFragment(private val myquestion: TrueFalseQuestion) : Fragment(), TextToSpeech.OnInitListener {

    var text: TextToSpeech? = null

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

        speech_button.isEnabled = false

        text = TextToSpeech(this.activity, TextToSpeech.OnInitListener {
        })
        val speechButton: ImageButton = view.findViewById(R.id.speech_button)
        speechButton.setOnClickListener {
            speak(myquestion.question + " Is this true or false?")
        }

        return view
    }

    override fun onInit(status: Int) {
        text?.language = Locale.CANADA
        speech_button.isEnabled = true
    }

    override fun onDestroy() {
        if (text != null) {
            text?.stop()
            text?.shutdown()
        }
        super.onDestroy()
    }

    private fun speak(s: CharSequence) {
        text?.speak(s, TextToSpeech.QUEUE_FLUSH, null, "")
    }

    // checks if the user's answer for a true and false question is correct
    private fun checkAnswer(isAnswer: Boolean) {
        val answer = myquestion.answer
        val explanation = myquestion.info
        if (isAnswer == answer) {
            Toast.makeText(activity, "Correct answer!", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(activity, "Incorrect. $explanation", Toast.LENGTH_SHORT).show()
        }
    }
}

