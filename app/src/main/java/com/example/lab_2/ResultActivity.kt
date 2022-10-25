package com.example.lab_2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        enterResOnScreen()
        exit.setOnClickListener{
            this.finish();
        }
    }
    fun enterResOnScreen(){
        val result:Double = intent.getDoubleExtra("result", Double.NaN)
        if (!result.isNaN())
            resultField.text = result.toString()

    }
}
