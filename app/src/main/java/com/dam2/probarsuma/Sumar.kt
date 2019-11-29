package com.dam2.probarsuma

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_sumar.*

class Sumar : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sumar)

        val a = intent.getIntExtra("num1",0)
        val b = intent.getIntExtra("num2",0)

        val sum=a+b

        sumado.setText(sum.toString())

        volver.setOnClickListener{

            val data = Intent()
            data.putExtra("sumaResult",sum)
            setResult(Activity.RESULT_OK,data)
            finish()

        }

    }
}
