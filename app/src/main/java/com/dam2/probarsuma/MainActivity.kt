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

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        suma.setOnClickListener{
            val intent = Intent(this, Sumar::class.java)
            var num1 = numero1.text
            var num2 = numero2.text
            intent.putExtra("num1",Integer.parseInt(num1.toString()))
            intent.putExtra("num2",Integer.parseInt(num2.toString()))
            startActivityForResult(intent, PICK_SUMA_REQUEST)
        }


    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == PICK_SUMA_REQUEST) {
            if (resultCode == Activity.RESULT_OK) {
                resultado.setText(data.getIntExtra("sumaResult",0).toString())
            }else{
                resultado.setText("Error al pasar datos")
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
