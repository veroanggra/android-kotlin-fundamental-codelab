package com.veronica.idn.aboutmeinteractive

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val doneButton = findViewById<Button>(R.id.btn_done)
        doneButton.setOnClickListener { fecthName(it) }

        val inputName = findViewById<TextView>(R.id.tv_nickname)
        inputName.setOnClickListener { fecthNameDialog(it) }
    }

    private fun fecthNameDialog(it: View) {
        val inputName = findViewById<EditText>(R.id.et_name)
        val doneButton = findViewById<Button>(R.id.btn_done)
        val inputMethodManager =
            getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        it.visibility = View.GONE
        inputName.visibility = View.VISIBLE
        doneButton.visibility = View.VISIBLE
        inputMethodManager.hideSoftInputFromWindow(it.windowToken, 0)

    }

    private fun fecthName(it: View) {
        val inputName = findViewById<EditText>(R.id.et_name)
        val nickName = findViewById<TextView>(R.id.tv_nickname)
        val inputMethodManager =
            getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        nickName.text = inputName.text
        inputName.visibility = View.GONE
        it.visibility = View.GONE
        nickName.visibility = View.VISIBLE
        inputMethodManager.hideSoftInputFromWindow(it.windowToken, 0)

    }
}

