package com.example.app_one

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


var calendario = String()
var instrument1 = String()
var instrument2 = String()
var instrument3 = String()
var instrument4 = String()
var city = 0


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?   ) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val ciudades = arrayOf("Medellin","Cali","Bogota","Cargatena","Leticia")
        val arrayAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item,ciudades)

        spinner.adapter = arrayAdapter
        spinner.onItemSelectedListener = object:
            AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>, view: View?, pos: Int, id: Long) { // An item was selected. You can retrieve the selected item using // parent.getItemAtPosition(pos)
                city = pos
            }
            override fun onNothingSelected(parent: AdapterView<*>) { // Another interface callback }
        }
    }



        guardar.setOnClickListener(){
            val pass1 = password.text.toString()
            val pass2 = password_again.text.toString()
            val mensaje = findViewById<TextView>(R.id.nombre_guardado)
            val user_name_save = name.text.toString()
            val mail_save = mail.text.toString()
            val password_save = password.text.toString()
            val g = radioGroup.checkedRadioButtonId
            var ciudad = String()
            var genero = String()
            when (g) {
                R.id.man -> genero = "Hombre"
                R.id.woman -> genero = "Mujer"
            }
            val hobby = instrument1+instrument2+instrument3+instrument4
            when(city){
                0 -> ciudad = "Medellin"
                1 -> ciudad = "Cali"
                2 -> ciudad = "Bogota"
                3 -> ciudad = "Cargatena"
                4 -> ciudad = "Leticia"
            }
            if (pass1 != pass2 ){
                mensaje.setText("Contraseña no coincide" )

                }
                else {
                    val user_name = name.text.toString()
                mensaje.setText("Nombre: " + user_name_save +
                                           "\nCorreo: "+ mail_save +
                                           "\nContraseña: " + password_save +
                                           "\nGenero: " + genero +
                                           "\nHobbys: " + hobby +
                                           "\nFecha: " + calendario +
                                           "\nCiudad: " + ciudad )
                }

        }

    }

    fun showDatePickerDialog(v: View) {
        val editar = findViewById<TextView>(R.id.dtx)
        val newFragment = DatePickerFragment()
        newFragment.show(supportFragmentManager, "datePicker")
        editar.setText(calendario)
    }
    fun Piano(view: View) {
         instrument1 = "Piano "
    }

    fun Guitar(view: View) {
        instrument2 = "Guitar "
    }
    fun Drums(view: View) {
        instrument3 = "Drums "
    }
    fun Bass(view: View) {
        instrument4 = "Bass "
    }
}

class DatePickerFragment : DialogFragment(), DatePickerDialog.OnDateSetListener {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        // Use the current date as the default date in the picker
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        // Create a new instance of DatePickerDialog and return it
        return DatePickerDialog(activity as Context, this, year, month, day)
    }


    override fun onDateSet(view: DatePicker, year: Int, month: Int, day: Int){
    calendario = "Dia: " + day.toString() + " Mes: " + month.toString() + " Año: " + year.toString()
    }

}




