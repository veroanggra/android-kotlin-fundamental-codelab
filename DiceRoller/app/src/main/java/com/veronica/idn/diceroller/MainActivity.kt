package com.veronica.idn.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.btn_roll)
        rollButton.setOnClickListener { rollNumber() }

        val countButton: Button = findViewById(R.id.btn_count)
        countButton.setOnClickListener { countNumber() }

        val resetButton: Button = findViewById(R.id.btn_reset)
        resetButton.setOnClickListener { resetNumber() }
    }

    private fun resetNumber() {
        val resultNumber: TextView = findViewById(R.id.tv_value)
        if (resultNumber.text != resources.getString(R.string.hello_world)) {
            resultNumber.text = "0"

        }

    }

    private fun countNumber() {
        val resultNumber: TextView = findViewById(R.id.tv_value)
        if (resultNumber.text == resources.getString(R.string.hello_world)) {
            resultNumber.text = "1"
        } else {
            var lastResultNumber = resultNumber.text.toString().toInt()
            if (lastResultNumber < 6) {
                lastResultNumber++
                resultNumber.text = lastResultNumber.toString()
            }
        }


    }

    private fun rollNumber() {
        val resultNumber: TextView = findViewById(R.id.tv_value)
        val randomNumber = (1..6).random()
        resultNumber.text = randomNumber.toString()
        Toast.makeText(this, "Roll Button Clicked", Toast.LENGTH_SHORT).show()
    }
}
