package com.suhaozdemir.flagquiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView

class QuestionsActivity : AppCompatActivity() {

    private var progressBar : ProgressBar? = null
    private var txtProgress : TextView? = null
    private var txtQuestion : TextView? = null
    private var imgQuestion : ImageView? = null

    private var txtOptionA : TextView? = null
    private var txtOptionB : TextView? = null
    private var txtOptionC : TextView? = null
    private var txtOptionD : TextView? = null

    private var btnSubmit : Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questions)

        progressBar = findViewById(R.id.progressBar)
        txtProgress = findViewById(R.id.txtProgress)
        txtQuestion = findViewById(R.id.txtQuestion)
        imgQuestion = findViewById(R.id.imgFlagImage)

        txtOptionA = findViewById(R.id.txtOptionOne)
        txtOptionB = findViewById(R.id.txtOptionTwo)
        txtOptionC = findViewById(R.id.txtOptionThree)
        txtOptionD = findViewById(R.id.txtOptionFour)

        btnSubmit = findViewById(R.id.btnSubmit)

        val questionList = Constants.getQuestions()
        var currPosition = 1

        val question : Question = questionList[currPosition - 1]
        progressBar?.progress = currPosition

        txtProgress?.text = "$currPosition/${progressBar?.max}"
        txtQuestion?.text = question.question
        imgQuestion?.setImageResource(question.image)
        txtOptionA?.text = question.optionA
        txtOptionB?.text = question.optionB
        txtOptionC?.text = question.optionC
        txtOptionD?.text = question.optionD
    }
}