package com.example.naruto

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
import android.widget.Toast
import androidx.core.content.ContextCompat


class Quizquestions : AppCompatActivity(), View.OnClickListener {

    private var mCurrentPosition:Int =1
    private var mQuestionList: ArrayList<Questions>? = null
    private var mSelectedOptionPosition : Int=0
    private var mCorrectAnswers: Int=0
    private var mUserName: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quizquestions)
        mUserName= intent.getStringExtra(constants.USER_NAME)
        mQuestionList= constants.getquestions()
        setQuestion()

        val btnsubmitans = findViewById<Button>(R.id.btn_submitans)
        val optionone= findViewById(R.id.tv_option_one) as TextView
        val optiontwo= findViewById(R.id.tv_option_two) as TextView
        val optionthree= findViewById(R.id.tv_option_three) as TextView
        val optionfour= findViewById(R.id.tv_option_four) as TextView
        optionone.setOnClickListener(this)
        optiontwo.setOnClickListener(this)
        optionthree.setOnClickListener(this)
        optionfour.setOnClickListener(this)
        btnsubmitans.setOnClickListener(this)




    }
    private fun setQuestion(){

        val question = mQuestionList!![mCurrentPosition-1]
        defaultOptionView()
        val btnsubmitans = findViewById<Button>(R.id.btn_submitans)
        if(mCurrentPosition==mQuestionList!!.size){
            btnsubmitans.text="FINISH"
        }

        else{
            btnsubmitans.text="SUBMIT"

        }
        val progressbar= findViewById(R.id.progressbar) as ProgressBar
        val tvprogress = findViewById(R.id.tv_progress) as TextView
        val tvquestion = findViewById(R.id.tv_question) as TextView
        val ivimage = findViewById(R.id.iv_image) as ImageView
        val optionone= findViewById(R.id.tv_option_one) as TextView
        val optiontwo= findViewById(R.id.tv_option_two) as TextView
        val optionthree= findViewById(R.id.tv_option_three) as TextView
        val optionfour= findViewById(R.id.tv_option_four) as TextView



        progressbar.progress= mCurrentPosition
        tvprogress.text= "$mCurrentPosition" + "/" + progressbar.max
        tvquestion.text= question!!.question
        ivimage.setImageResource(question.image)
        optionone.text=question.optionone
        optiontwo.text=question.optiontwo
        optionthree.text=question.optionthree
        optionfour.text=question.optionfour


    }

    private fun defaultOptionView(){
        val optionone= findViewById(R.id.tv_option_one) as TextView
        val optiontwo= findViewById(R.id.tv_option_two) as TextView
        val optionthree= findViewById(R.id.tv_option_three) as TextView
        val optionfour= findViewById(R.id.tv_option_four) as TextView
        val options= ArrayList<TextView>()
        options.add(0,optionone)
        options.add(1,optiontwo)
        options.add(2,optionthree)
        options.add(3,optionfour)

        for(option in options){
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface= Typeface.DEFAULT
            option.background= ContextCompat.getDrawable(this, R.drawable.option_backgrounf_colour)

        }

    }

    override fun onClick(v: View?) {
        val btnsubmitans= findViewById<Button>(R.id.btn_submitans)
        val optionone= findViewById(R.id.tv_option_one) as TextView
        val optiontwo= findViewById(R.id.tv_option_two) as TextView
        val optionthree= findViewById(R.id.tv_option_three) as TextView
        val optionfour= findViewById(R.id.tv_option_four) as TextView

        when(v?.id){
            R.id.tv_option_one ->{
                SelectedOptionView(optionone,1)
            }
            R.id.tv_option_two ->{
                SelectedOptionView(optiontwo,2)
            }
            R.id.tv_option_three ->{
                SelectedOptionView(optionthree,3)
            }
            R.id.tv_option_four ->{
                SelectedOptionView(optionfour,4)
            }
            R.id.btn_submitans ->{
                if(mSelectedOptionPosition == 0){
                    mCurrentPosition ++

                    when{
                        mCurrentPosition <= mQuestionList!!.size ->{
                            setQuestion()
                        }else->{
                            val intent= Intent(this, ResultActivity::class.java)
                            intent.putExtra(constants.USER_NAME,mUserName)
                            intent.putExtra(constants.CORRECT_ANSWERS,mCorrectAnswers)
                            intent.putExtra(constants.TOTAL_QUESTIONS,mQuestionList!!.size)
                            Toast.makeText(this,"congrats you are a narutard",Toast.LENGTH_SHORT).show()
                            startActivity(intent)
                            finish()
                        }
                    }
                }
                else{
                    val question = mQuestionList?.get(mCurrentPosition-1)
                    if(question!!.correctans != mSelectedOptionPosition){
                        answerView(mSelectedOptionPosition,R.drawable.wrong_option_order)
                    }
                    else{
                        mCorrectAnswers ++
                    }
                    answerView(question.correctans,R.drawable.correct_option_border)
                    if(mCurrentPosition == mQuestionList!!.size){
                        btnsubmitans.text="FINISH"
                    }
                    else{
                        btnsubmitans.text="GO TO NEXT QUESTION"
                    }
                    mSelectedOptionPosition=0
                }
            }
        }

    }

    private fun answerView(answer: Int, drawableView:Int){
        val optionone= findViewById(R.id.tv_option_one) as TextView
        val optiontwo= findViewById(R.id.tv_option_two) as TextView
        val optionthree= findViewById(R.id.tv_option_three) as TextView
        val optionfour= findViewById(R.id.tv_option_four) as TextView
        when(answer){
            1 ->{
                optionone.background= ContextCompat.getDrawable(this,drawableView)
            }
            2 ->{
                optiontwo.background= ContextCompat.getDrawable(this,drawableView)
            }
            3 ->{
                optionthree.background= ContextCompat.getDrawable(this,drawableView)
            }
            4 ->{
                optionfour.background= ContextCompat.getDrawable(this,drawableView)
            }
        }
    }

    private fun SelectedOptionView(tv: TextView, selectedOptionNum: Int){
        defaultOptionView()
        mSelectedOptionPosition=selectedOptionNum
        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface,Typeface.BOLD)
        tv.background= ContextCompat.getDrawable(this, R.drawable.selected_option_border)

    }
}