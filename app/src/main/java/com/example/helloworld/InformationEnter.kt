package com.example.helloworld

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.text.Html
import android.text.format.DateFormat
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class InformationEnter : AppCompatActivity(), DatePickerDialog.OnDateSetListener{
     var day=0
     var month=0
     var year=0
     var savedDay=0
     var savedMonth=0
     var savedYear=0

    var hour=0
    var minute=0
    var savedHour=0
    var savedMinute=0

    override fun onCreate(savedInstanceState: Bundle?) {

//        EditText editDate
//        DatePickerDialog.onDateSetListener()

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_information_enter)

        val editText = findViewById<EditText>(R.id.nameText)
        val editDate = findViewById<EditText>(R.id.editDate)
        pickDate()

        val nextResultButton=findViewById<Button>(R.id.nextResult)
        val defaultError="Name here!*"
        val defaultErrorDate="Date here!*"
        nextResultButton.setOnClickListener() {
            val text = editText.text
            val dateText = editDate.text
            if (text.length == 0 || text.toString() == defaultError) {
                Toast.makeText(
                    this,
                    "Stop being lazy! Please enter all fields.",
                    Toast.LENGTH_SHORT
                ).show()
                editText.setText(Html.fromHtml("Name here!<font color='red'>*</font>"))
            } else if (dateText.length == 0 || dateText.toString() == defaultErrorDate) {

//                if(calendarInfo[0])
                Toast.makeText(
                    this,
                    "Stop being lazy! Please enter all fields.",
                    Toast.LENGTH_SHORT
                ).show()
                editDate.setText(Html.fromHtml("Date here!<font color='red'>*</font>"))
            } else {
                var infoDay=editDate.text.split("-")

                var currDay=Calendar.getInstance().time
                val monthNumber = DateFormat.format("M", currDay) as String
                println(monthNumber)
                println(infoDay[0])
                if (monthNumber != infoDay[0]) {
//                    Toast.makeText(this, "Stop it!", Toast.LENGTH_SHORT).show()
                    openInvalidNextScreen()
                } else {
//                    Toast.makeText(this, "Here's the result: " + , Toast.LENGTH_SHORT).show()
                    openNextScreen()
                }

            }
        }
    }
    fun openNextScreen(){
        val intent = Intent(this, SecondActivity::class.java)
        startActivity(intent)
    }
    fun openInvalidNextScreen(){
        val intent = Intent(this, InvalidSecondActivity::class.java)
        startActivity(intent)
    }
     fun getDateTimeCalendar(){
         val cal:Calendar= Calendar.getInstance();
         day =cal.get(Calendar.DAY_OF_MONTH)
         month =cal.get(Calendar.MONTH)
         year =cal.get(Calendar.YEAR)
         hour =cal.get(Calendar.HOUR)
         minute =cal.get(Calendar.MINUTE)
     }
     fun  pickDate(){
         val editDate = findViewById<EditText>(R.id.editDate)
         editDate.setOnClickListener{
             getDateTimeCalendar()
             DatePickerDialog(this,this, year,month,day).show()
         }
     }

    override fun onDateSet(p0: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        savedDay=dayOfMonth
        savedMonth=month+1
        savedYear=year
        val editDate = findViewById<EditText>(R.id.editDate)
        editDate.setText("$savedMonth-$savedDay-$savedYear")
    }



}