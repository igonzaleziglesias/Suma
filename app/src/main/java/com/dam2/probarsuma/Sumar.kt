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

        val a = intent.getIntExtra("num1",0)//asignamos primer operando
        val b = intent.getIntExtra("num2",0)//asignamos segundo operando

        val sum=a+b//realizamos suma

        sumado.setText(sum.toString())//asignamos al textview la suma

        volver.setOnClickListener{
            //boton para volver(cerrando la activityç)
            val data = Intent()
            data.putExtra("sumaResult",sum)//asignamos el resultado
            setResult(Activity.RESULT_OK,data)//devolvemos el resultado
            finish()//cerramos la activity

        }

    }
}
