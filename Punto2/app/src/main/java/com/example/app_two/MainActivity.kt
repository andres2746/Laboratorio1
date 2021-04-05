package com.example.app_two

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

import java.lang.Object
var opc1 = 0
var opc2 = 0
var resul = 0.0
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val conv1 = arrayOf("Cop", "Dolar", "Yuan")
        val arrayAdapter1 = ArrayAdapter(this, android.R.layout.simple_spinner_item, conv1)
        spinner1.adapter = arrayAdapter1
        spinner1.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, pos: Int, id: Long) { // An item was selected. You can retrieve the selected item using // parent.getItemAtPosition(pos)
                opc1 = pos }
            override fun onNothingSelected(parent: AdapterView<*>) { // Another interface callback }
            }
        }
        val conv2 = arrayOf("Cop", "Dolar", "Yuan")
        val arrayAdapter2 = ArrayAdapter(this, android.R.layout.simple_spinner_item, conv2)
        spinner2.adapter = arrayAdapter2
        spinner2.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, pos: Int, id: Long) { // An item was selected. You can retrieve the selected item using // parent.getItemAtPosition(pos)
                opc2 = pos }
            override fun onNothingSelected(parent: AdapterView<*>) { // Another interface callback }
            }
        }

        button.setOnClickListener() {
            var entrada = conver.text.toString()

            when (opc1) {
                0 -> when (opc2) {
                    0 -> resul = entrada.toInt().toDouble()
                    1 -> resul = entrada.toInt().toDouble() * 0.00027
                    2 -> resul = entrada.toInt().toDouble() * 0.0018
                }
                1 -> when (opc2) {
                    0 -> resul = entrada.toInt().toDouble() * 3661.70
                    1 -> resul = entrada.toInt().toDouble()
                    2 -> resul = entrada.toInt().toDouble() * 6.57
                }
                2 -> when (opc2) {
                    0 -> resul = entrada.toInt().toDouble() * 557.55
                    1 -> resul = entrada.toInt().toDouble() * 0.15
                    2 -> resul = entrada.toInt().toDouble()
                }
            }
            val mostrar = findViewById<TextView>(R.id.Text_View)
            mostrar.setText(""+resul)
        }
    }

}