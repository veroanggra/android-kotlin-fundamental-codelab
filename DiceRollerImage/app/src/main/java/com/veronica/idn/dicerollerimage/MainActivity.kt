package com.veronica.idn.dicerollerimage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton: Button = findViewById(R.id.btn_roll)
        rollButton.setOnClickListener { rolleDice() }

        val resetButton: Button = findViewById(R.id.btn_reset)
        resetButton.setOnClickListener { resetDice() }

    }


    private fun rolleDice() {
        val imageFirstDice: ImageView = findViewById(R.id.iv_first_dice)
        val imageSecondDice: ImageView = findViewById(R.id.iv_second_dice)
        val firstValue: TextView = findViewById(R.id.tv_first_dice_value)
        val secondValue: TextView = findViewById(R.id.tv_second_dice_value)
        val randomNumber = (1..6).random()
        val imagesRandomDice = when (randomNumber) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        val randomNumberDice = when (imagesRandomDice) {
            R.drawable.dice_1 -> "1"
            R.drawable.dice_2 -> "2"
            R.drawable.dice_3 -> "3"
            R.drawable.dice_4 -> "4"
            R.drawable.dice_5 -> "5"
            else -> "6"
        }
        imageFirstDice.setImageResource(imagesRandomDice)
        imageSecondDice.setImageResource(imagesRandomDice)
        firstValue.text = randomNumberDice
        secondValue.text = randomNumberDice

    }

    private fun resetDice() {
        val imageFirstDice: ImageView = findViewById(R.id.iv_first_dice)
        val imageSecondDice: ImageView = findViewById(R.id.iv_second_dice)
        val firstValue: TextView = findViewById(R.id.tv_first_dice_value)
        val secondValue: TextView = findViewById(R.id.tv_second_dice_value)
        if (firstValue.text != resources.getString(R.string.value)) {
            firstValue.text = "1"
            secondValue.text = "1"
            imageFirstDice.setImageResource(R.drawable.dice_1)
            imageSecondDice.setImageResource(R.drawable.dice_1)
        }
    }
}
