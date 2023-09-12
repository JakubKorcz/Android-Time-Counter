package edu.put.inf151855

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

import android.widget.Button
import android.widget.EditText


class TimeActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_time)

        val plusButton = findViewById<Button>(R.id.buttonplustime)
        plusButton.setOnClickListener { onButtonPlusClick() }
        val minusButton = findViewById<Button>(R.id.buttonminustime)
        minusButton.setOnClickListener { onButtonMinusClick() }
        val clearButton = findViewById<Button>(R.id.buttoncleartime)
        clearButton.setOnClickListener { onButtonClearClick() }

    }

    fun onClear(v:View){
        onButtonClearClick()
    }

    private fun onButtonClearClick() {
        val hourEditText1 = findViewById<EditText>(R.id.editTextHour1)
        val minuteEditText1 = findViewById<EditText>(R.id.editTextMin1)
        val secondEditText1 = findViewById<EditText>(R.id.editTextSec1)
        val hourEditText2 = findViewById<EditText>(R.id.editTextHour2)
        val minuteEditText2 = findViewById<EditText>(R.id.editTextMin2)
        val secondEditText2 = findViewById<EditText>(R.id.editTextSec2)
        hourEditText2.setText(0.toString())
        minuteEditText2.setText(0.toString())
        secondEditText2.setText(0.toString())
        hourEditText1.setText(0.toString())
        minuteEditText1.setText(0.toString())
        secondEditText1.setText(0.toString())

    }

    fun onButtonMinusClick1(v:View) {
      onButtonMinusClick()
    }

    fun onButtonPlusClick1(v:View) {
      onButtonPlusClick()
    }

    private fun onButtonMinusClick() {
       val operator='-'
        calculate(operator)
    }

    private fun onButtonPlusClick() {
        val operator='+'
        calculate(operator)
    }

    fun calculate(operator: Char) {
            val hourEditText1 = findViewById<EditText>(R.id.editTextHour1)
            val text = hourEditText1.text.toString()
            val intValue = text.toIntOrNull() ?: 0

            val minuteEditText1 = findViewById<EditText>(R.id.editTextMin1)
            val text1 = minuteEditText1.text.toString()
            val intValue1 = text1.toIntOrNull() ?: 0

            val secondEditText1 = findViewById<EditText>(R.id.editTextSec1)
            val text2 = secondEditText1.text.toString()
            val intValue2 = text2.toIntOrNull() ?: 0

            val hourEditText2 = findViewById<EditText>(R.id.editTextHour2)
            val text3 = hourEditText2.text.toString()
            val intValue3 = text3.toIntOrNull() ?: 0

            val minuteEditText2 = findViewById<EditText>(R.id.editTextMin2)
            val text4 = minuteEditText2.text.toString()
            val intValue4 = text4.toIntOrNull() ?: 0

            val secondEditText2 = findViewById<EditText>(R.id.editTextSec2)
            val text5 = secondEditText2.text.toString()
            val intValue5 = text5.toIntOrNull() ?: 0

            if(operator=='+')
                {
                    var dodminuty=0
                    var dodgodziny=0
                    var sekundy=intValue2+intValue5
                    while(sekundy>60){
                        sekundy-=60
                        dodminuty+=1
                    }
                    var minuty=intValue1+intValue4+dodminuty
                    while(minuty>60){
                        minuty-=60
                        dodgodziny+=1
                    }
                    var godziny=intValue+intValue3+dodgodziny
                    val wyliczonesekundy=sekundy
                    val wyliczoneminuty=minuty
                    val wyliczonegodziny=godziny%24
                    hourEditText1.setText(wyliczonegodziny.toString())
                    minuteEditText1.setText(wyliczoneminuty.toString())
                    secondEditText1.setText(wyliczonesekundy.toString())
                }
            else if(operator=='-')
                {
                    var dodminuty=0
                    var dodgodziny=0
                    var sekundy=intValue2-intValue5
                    while(sekundy<0){
                        sekundy+=60
                        dodminuty-=1
                    }
                    var minuty=intValue1-intValue4+dodminuty
                    while(minuty<0){
                        minuty+=60
                        dodgodziny-=1
                    }
                    var godziny=intValue-intValue3+dodgodziny
                    while(godziny<0){
                        godziny+=24
                    }
                    val wyliczonesekundy=sekundy
                    val wyliczoneminuty=minuty
                    val wyliczonegodziny=godziny%24
                    hourEditText1.setText(wyliczonegodziny.toString())
                    minuteEditText1.setText(wyliczoneminuty.toString())
                    secondEditText1.setText(wyliczonesekundy.toString())
                }

            hourEditText2.setText(0.toString())
            minuteEditText2.setText(0.toString())
            secondEditText2.setText(0.toString())
        }
    }

