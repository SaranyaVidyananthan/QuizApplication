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

public class MultipleChoiceQuestionFragment(private val myquestion: MultipleChoiceQuestion) :
    Fragment() {

    var text: TextToSpeech? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.multiple_choice, container, false)

        val questionText: TextView = view.findViewById(R.id.question)
        val setQuestion: String = myquestion.question
        questionText.text = setQuestion

        val choiceOne: TextView = view.findViewById(R.id.answer1)
        var setChoice: String = myquestion.choice1
        choiceOne.text = setChoice

        val choiceTwo: TextView = view.findViewById(R.id.answer2)
        setChoice = myquestion.choice2
        choiceTwo.text = setChoice

        val choiceThree: TextView = view.findViewById(R.id.answer3)
        setChoice = myquestion.choice3
        choiceThree.text = setChoice

        val choiceFour: TextView = view.findViewById(R.id.answer4)
        setChoice = myquestion.choice4
        choiceFour.text = setChoice

        choiceOne.setOnClickListener {
            checkMCAnswer(myquestion.choice1)
        }

        choiceTwo.setOnClickListener {
            checkMCAnswer(myquestion.choice2)
        }

        choiceThree.setOnClickListener {
            checkMCAnswer(myquestion.choice3)
        }

        choiceFour.setOnClickListener {
            checkMCAnswer(myquestion.choice4)
        }

        text = TextToSpeech(this.activity, TextToSpeech.OnInitListener {
        })
        val speechButton: ImageButton = view.findViewById(R.id.speech_button)
        speechButton.setOnClickListener {
            speak(myquestion.question)
            speak("a " + myquestion.choice1)
            speak("b " + myquestion.choice2)
            speak("c " + myquestion.choice3)
            speak("d " + myquestion.choice4)
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

    fun speak(s: CharSequence) {
        text?.speak(s, TextToSpeech.QUEUE_ADD, null, "")
    }

    // checks if the user's answer for a multiple choice question is correct
    fun checkMCAnswer(userAnswer: String) {
        val answer = myquestion.answer
        val explanation = myquestion.info
        if (userAnswer == answer) {
            Toast.makeText(activity, "Correct answer!", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(activity, "Incorrect. $explanation", Toast.LENGTH_SHORT).show()
        }
    }
}
