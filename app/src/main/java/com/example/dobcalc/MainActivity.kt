package com.example.dobcalc

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
     private var SelectedDate : TextView? = null
    private var AgeInMinutes : TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

     val btn : Button = findViewById(R.id.Button)
        SelectedDate = findViewById(R.id.textView4)
        AgeInMinutes = findViewById(R.id.textView6)
        btn.setOnClickListener { view ->

            clickdatepicker()
        }
    }
    private fun clickdatepicker() {
       // how to get access of calender
        val myCalender = Calendar.getInstance()
        val year = myCalender.get(Calendar.YEAR)
        val month = myCalender.get(Calendar.MONTH)
        val day = myCalender.get(Calendar.DAY_OF_MONTH)
        val dpd =  DatePickerDialog(this,
        DatePickerDialog.OnDateSetListener{
            view, year, month, dayOfMonth ->
            Toast.makeText(this,
                "PASSED",Toast.LENGTH_LONG).show()

            // DATE FORMAT
            val selecteddate = "$dayOfMonth/${month+1}/$year"

            SelectedDate?.text = selecteddate

            val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)

            val theDate = sdf.parse(selecteddate)

            val result = theDate.time / 60000

            val current = sdf.parse(sdf.format(System.currentTimeMillis()))

            val currDateInMinutes = current.time / 60000

            val difference = currDateInMinutes - result

            AgeInMinutes?.text = difference.toString()
        },
        year,
            month,
            day
        )
        dpd.datePicker.maxDate = System.currentTimeMillis() - 86400000
            dpd.show()


    }
}