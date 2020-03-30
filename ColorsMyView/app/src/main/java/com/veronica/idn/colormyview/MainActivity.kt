package com.veronica.idn.colormyview

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val resetButton = findViewById<Button>(R.id.btn_reset)

        setListener()
        resetButton.setOnClickListener { reset() }
    }

    private fun reset() {
        val boxOneText = findViewById<TextView>(R.id.tv_box_one)
        val boxTwoText = findViewById<TextView>(R.id.tv_box_two)
        val boxThreeText = findViewById<TextView>(R.id.tv_box_three)
        val boxFourText = findViewById<TextView>(R.id.tv_box_four)
        val boxFiveText = findViewById<TextView>(R.id.tv_box_five)
        val redButton = findViewById<Button>(R.id.btn_red)
        val yellowButton = findViewById<Button>(R.id.btn_yellow)
        val greenButton = findViewById<Button>(R.id.btn_green)
        val rootConstraintLayout = findViewById<View>(R.id.constraintMain)
        
        boxOneText.setBackgroundColor(Color.WHITE)
        boxTwoText.setBackgroundColor(Color.WHITE)
        boxThreeText.setBackgroundColor(Color.WHITE)
        boxFourText.setBackgroundColor(Color.WHITE)
        boxFiveText.setBackgroundColor(Color.WHITE)
        redButton.setBackgroundColor(Color.WHITE)
        yellowButton.setBackgroundColor(Color.WHITE)
        greenButton.setBackgroundColor(Color.WHITE)
        rootConstraintLayout.setBackgroundColor(Color.WHITE)

    }

    private fun makeColored(view: View) {
        when (view.id) {
            R.id.tv_box_one -> view.setBackgroundColor(Color.DKGRAY)
            R.id.tv_box_two -> view.setBackgroundResource(R.drawable.ic_image)
            R.id.tv_box_three -> view.setBackgroundColor(Color.BLUE)
            R.id.tv_box_four -> view.setBackgroundColor(Color.MAGENTA)
            R.id.tv_box_five -> view.setBackgroundColor(Color.BLUE)
            R.id.btn_red -> tv_box_three.setBackgroundResource(R.color.my_red)
            R.id.btn_yellow -> tv_box_four.setBackgroundResource(R.color.my_yellow)
            R.id.btn_green -> tv_box_five.setBackgroundResource(R.color.my_green)
            else -> view.setBackgroundColor(Color.LTGRAY)
        }
    }

    private fun setListener() {
        val boxOneText = findViewById<TextView>(R.id.tv_box_one)
        val boxTwoText = findViewById<TextView>(R.id.tv_box_two)
        val boxThreeText = findViewById<TextView>(R.id.tv_box_three)
        val boxFourText = findViewById<TextView>(R.id.tv_box_four)
        val boxFiveText = findViewById<TextView>(R.id.tv_box_five)
        val redButton = findViewById<Button>(R.id.btn_red)
        val yellowButton = findViewById<Button>(R.id.btn_yellow)
        val greenButton = findViewById<Button>(R.id.btn_green)

        val rootConstraintLayout = findViewById<View>(R.id.constraintMain)
        val clickableViews: List<View> = listOf(
            boxOneText,
            boxTwoText,
            boxThreeText,
            boxFourText,
            boxFiveText,
            rootConstraintLayout,
            redButton,
            yellowButton,
            greenButton
        )
        for (item in clickableViews) {
            item.setOnClickListener { makeColored(it) }
        }
    }
}
