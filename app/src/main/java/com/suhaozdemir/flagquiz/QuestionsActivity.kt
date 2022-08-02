package com.suhaozdemir.flagquiz

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.content.ContextCompat

class QuestionsActivity : AppCompatActivity(), View.OnClickListener {

    private var mCurrentPosition : Int = 1
    private var mQuestionList : ArrayList<Question>? = null
    private var mSelectedOptionPosition : Int = 0
    private var mUserName : String? = null
    private var mCorrectAnswers : Int = 0

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

        mUserName = intent.getStringExtra(Constants.USER_NAME)

        progressBar = findViewById(R.id.progressBar)
        txtProgress = findViewById(R.id.txtProgress)
        txtQuestion = findViewById(R.id.txtQuestion)
        imgQuestion = findViewById(R.id.imgFlagImage)

        txtOptionA = findViewById(R.id.txtOptionOne)
        txtOptionB = findViewById(R.id.txtOptionTwo)
        txtOptionC = findViewById(R.id.txtOptionThree)
        txtOptionD = findViewById(R.id.txtOptionFour)
        btnSubmit = findViewById(R.id.btnSubmit)

        txtOptionA?.setOnClickListener(this)
        txtOptionB?.setOnClickListener(this)
        txtOptionC?.setOnClickListener(this)
        txtOptionD?.setOnClickListener(this)
        btnSubmit?.setOnClickListener(this)

        mQuestionList = Constants.getQuestions()

        setQuestion()
    }

    private fun setQuestion() {
        defaultOptionView()
        val question: Question = mQuestionList!![mCurrentPosition - 1]
        progressBar?.progress = mCurrentPosition

        txtProgress?.text = "$mCurrentPosition/${progressBar?.max}"
        txtQuestion?.text = question.question
        imgQuestion?.setImageResource(question.image)
        txtOptionA?.text = question.optionA
        txtOptionB?.text = question.optionB
        txtOptionC?.text = question.optionC
        txtOptionD?.text = question.optionD
        btnSubmit?.setEnabled(false)

        if(mCurrentPosition == mQuestionList!!.size)
            btnSubmit?.text = "Finish"
        else
            btnSubmit?.text = "Submit"

    }

    private fun defaultOptionView(){
        val options = ArrayList<TextView>()
        txtOptionA?.let{
            options.add(0, it)
        }
        txtOptionB?.let {
            options.add(1, it)
        }
        txtOptionC?.let {
            options.add(2, it)
        }
        txtOptionD?.let {
            options.add(3, it)
        }

        for(option in options){
           option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                this,
                R.drawable.default_option_border_bg
            )
        }
    }

    private fun selectedOptionView(txtView : TextView, selectedOptionNum : Int){
        defaultOptionView()

        mSelectedOptionPosition = selectedOptionNum
        txtView.setTextColor(Color.parseColor("#363A43"))
        txtView.setTypeface(txtView.typeface, Typeface.BOLD)
        txtView.background = ContextCompat.getDrawable(
            this,
            R.drawable.selected_option_border_bg
        )
    }

    override fun onClick(view: View?) {
        when(view?.id){
            R.id.txtOptionOne -> {
                txtOptionA?.let {
                    selectedOptionView(it, 1)
                    btnSubmit?.setEnabled(true)
                }
            }
            R.id.txtOptionTwo -> {
                txtOptionB?.let {
                    selectedOptionView(it, 2)
                    btnSubmit?.setEnabled(true)
                }
            }
            R.id.txtOptionThree -> {
                txtOptionC?.let {
                    selectedOptionView(it, 3)
                    btnSubmit?.setEnabled(true)
                }
            }
            R.id.txtOptionFour -> {
                txtOptionD?.let {
                    selectedOptionView(it, 4)
                    btnSubmit?.setEnabled(true)
                }
            }
            R.id.btnSubmit ->{
                if (mSelectedOptionPosition == 0){
                    mCurrentPosition ++

                    when{
                        mCurrentPosition <= mQuestionList!!.size ->{
                            setQuestion()
                        }else ->{
                            val intent = Intent(this, ResultActivity::class.java)
                        intent.putExtra(Constants.USER_NAME, mUserName)
                        intent.putExtra(Constants.CORRECT_ANSWERS, mCorrectAnswers)
                        intent.putExtra(Constants.TOTAL_QUESTIONS, mQuestionList?.size)
                        startActivity(intent)
                        finish()
                        }
                    }
                }else{
                    val question = mQuestionList?.get(mCurrentPosition -1)
                    if(question!!.answer != mSelectedOptionPosition){
                        answerView(mSelectedOptionPosition, R.drawable.wrong_option_border_bg)
                    }else{
                        mCorrectAnswers++
                    }
                    answerView(question.answer, R.drawable.correct_option_border_bg)

                    if(mCurrentPosition == mQuestionList!!.size)
                        btnSubmit?.text = "Finish"
                    else
                        btnSubmit?.text = "Go to the next question"

                    mSelectedOptionPosition = 0

                }
            }
        }
    }

    private fun answerView(answer : Int, drawableView : Int){
        when(answer){
            1 -> {
                txtOptionA?.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
            2 -> {
                txtOptionB?.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
            3 -> {
                txtOptionC?.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
            4 -> {
                txtOptionD?.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
        }
    }
}