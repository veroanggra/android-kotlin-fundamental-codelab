package com.veronica.idn.aboutmedatabinding

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.veronica.idn.aboutmedatabinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val myName: Names = Names("Veronica Putri")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.myName = myName
        binding.tvNickName.setOnClickListener { fetchNameDialog(it) }
        binding.btnDone.setOnClickListener { fetchName(it) }


    }

    private fun fetchNameDialog(it: View) {
        binding.apply {
            tvNickName.visibility = View.GONE
            etName.visibility = View.VISIBLE
            btnDone.visibility = View.VISIBLE
        }
        val inputMethodManager =
            getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(it.windowToken, 0)


    }

    private fun fetchName(it: View) {
        binding.apply {
            myName?.nickName = etName.text.toString()
            invalidateAll()
            etName.visibility = View.GONE
            btnDone.visibility = View.GONE
            tvNickName.visibility = View.VISIBLE
        }
        val inputMethodManager =
            getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(it.windowToken, 0)

    }
}
