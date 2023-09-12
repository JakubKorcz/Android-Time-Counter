package edu.put.inf151855

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dateButton = findViewById<Button>(R.id.dateButton)
        dateButton.setOnClickListener { showDateActivity() }

        val timeButton = findViewById<Button>(R.id.timeButton)
        timeButton.setOnClickListener { showTimeActivity() }

    }

    fun showDateActivity() {
        val i= Intent(this,DateActivity::class.java)
        startActivity(i)
    }

    fun runDateButtonClick(v:View){
        showDateActivity();
    }

    fun showTimeActivity() {
        val i= Intent(this,TimeActivity::class.java)
        startActivity(i)
    }

    fun runTimeButtonClick(v:View){
        showTimeActivity();
    }
}