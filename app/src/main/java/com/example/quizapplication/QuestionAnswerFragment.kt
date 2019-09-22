package com.example.quizapplication

import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import java.util.*

class QuestionAnswerFragment(private val myquestion: QuestionAnswer) : Fragment() {

    var text: TextToSpeech? = null

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
            val answer: String =
                userAnswer.text.toString().trim().trimStart('0').toLowerCase(Locale.CANADA)
            checkAnswer(answer)
        }

        text = TextToSpeech(this.activity, TextToSpeech.OnInitListener {
        })
        val speechButton: ImageButton = view.findViewById(R.id.speech_button)
        speechButton.setOnClickListener {
            speak(myquestion.question)
        }

        return view
    }

    override fun onDestroy() {
        if (text != null) {
            text?.stop()
            text?.shutdown()
        }
        super.onDestroy()
    }

    // read out the question for the user
    fun speak(s: CharSequence) {
        text?.speak(s, TextToSpeech.QUEUE_FLUSH, null, "")
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