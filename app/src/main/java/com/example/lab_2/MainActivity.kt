package com.example.lab_2

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {


   private val inputType = InputType.TYPE_CLASS_NUMBER or
            InputType.TYPE_CLASS_TEXT

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        fillNums.inputType = inputType
        suma.setOnClickListener{operations("+")}
        vidnimanya.setOnClickListener{operations("-")}
        mnozhennya.setOnClickListener{operations("*")}
        dilennya.setOnClickListener{operations("/")}


        clearBtn.setOnClickListener{
            fillNums.setText("")
        }

        end.setOnClickListener{
           calculate()
        }
    }

    fun operations(op: String){
        fillNums.append(op)
    }
    fun calculate(){
        var res = Double.NaN
        try {
            val ex = ExpressionBuilder(fillNums.text.toString()).build()
            res = ex.evaluate()
        }catch (_:Exception){
            val toast = Toast.makeText(applicationContext, "Розплющ очі і перепиши", Toast.LENGTH_LONG)
            toast.show()
            return
        }
        startActivity(Intent(
            this, ResultActivity::class.java).apply {
            putExtra("result", res)
        })
    }
}