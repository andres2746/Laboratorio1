package com.example.myapplication

import android.app.DatePickerDialog
import android.app.Dialog
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.DialogFragment
import java.util.*
import kotlinx.android.synthetic.main.activity_main.*
import android.widget.*
import com.google.android.material.textfield.TextInputEditText
import kotlinx.android.synthetic.main.activity_main.view.*
var opc1 = 0
var opc2 = 0
var opc3 = 0
var d1 = 0
var d2 = 0
var multiplicador = 0
var rs = String()
var mostrar = 0
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val conv1 = arrayOf("Negro", "Marron", "Rojo", "Naranja", "Amarillo", "Verde", "Azul", "Violeta", "Gris", "Blanco")
        val arrayAdapter1 = ArrayAdapter(this, android.R.layout.simple_spinner_item, conv1)
        B1.adapter = arrayAdapter1
        B1.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, pos: Int, id: Long) { // An item was selected. You can retrieve the selected item using // parent.getItemAtPosition(pos)
               d1 = pos
            }

            override fun onNothingSelected(parent: AdapterView<*>) { // Another interface callback }
            }
        }
        val conv2 = arrayOf("Negro", "Marron", "Rojo", "Naranja", "Amarillo", "Verde", "Azul", "Violeta", "Gris", "Blanco")
        val arrayAdapter2 = ArrayAdapter(this, android.R.layout.simple_spinner_item, conv2)
        B2.adapter = arrayAdapter2
        B2.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, pos: Int, id: Long) { // An item was selected. You can retrieve the selected item using // parent.getItemAtPosition(pos)
                d2 = pos
            }

            override fun onNothingSelected(parent: AdapterView<*>) { // Another interface callback }
            }
        }
        val conv3 = arrayOf("Negro", "Marron", "Rojo", "Naranja", "Amarillo", "Verde", "Azul", "Violeta", "Gris", "Blanco")
        val arrayAdapter3 = ArrayAdapter(this, android.R.layout.simple_spinner_item, conv3)
        B3.adapter = arrayAdapter3
        B3.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, pos: Int, id: Long) { // An item was selected. You can retrieve the selected item using // parent.getItemAtPosition(pos)
                when(pos){
                    0 -> multiplicador = 1
                    1 -> multiplicador = 10
                    2 -> multiplicador = 100
                    3 -> multiplicador = 1000
                    4 -> multiplicador = 10000
                    5 -> multiplicador = 100000
                    6 -> multiplicador = 1000000
                    7 -> multiplicador = 10000000
                    8 -> multiplicador = 100000000
                    9 -> multiplicador = 1000000000

                }
            }

            override fun onNothingSelected(parent: AdapterView<*>) { // Another interface callback }
            }
        }
        button.setOnClickListener() {
            val show = findViewById<TextView>(R.id.resultado)
            rs = d1.toString()+d2.toString()
            mostrar = rs.toInt() * multiplicador
            show.setText("Valor de la resitencia: "+mostrar+" OHM")
        }
    }

}