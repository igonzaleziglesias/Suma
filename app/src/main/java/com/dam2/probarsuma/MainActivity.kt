package com.dam2.probarsuma

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import android.view.Menu
import android.view.MenuItem

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

const val PICK_SUMA_REQUEST = 1  // The request code

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        suma.setOnClickListener{
            //boton para realizar la suma,usando un intent
            val intent = Intent(this, Sumar::class.java)
            var num1 = numero1.text//primer operando
            var num2 = numero2.text//segundo operando
            intent.putExtra("num1",Integer.parseInt(num1.toString()))//pasamos el primer operando
            intent.putExtra("num2",Integer.parseInt(num2.toString()))//Pasamos el segundo operando
            startActivityForResult(intent, PICK_SUMA_REQUEST)//abrimos la otra activity
        }


    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent) {//obtenemos el resultado
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == PICK_SUMA_REQUEST) {//difrenciamos el valor por si hemos lanzado mas de una startActivityForResult
            if (resultCode == Activity.RESULT_OK) {//evaluamos valor
                resultado.setText(data.getIntExtra("sumaResult",0).toString())//insertamos el resultado
            }else{
                resultado.setText("Error al pasar datos")//condicion de error
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
