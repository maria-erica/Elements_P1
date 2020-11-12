package com.example.elements_p1

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.DatePicker
import android.widget.TextView
import java.util.*

class MainPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_page)

        var intent = intent
        val firstname = intent.getStringExtra("firstname")
        val lastname = intent.getStringExtra("lastname")
        val email = intent.getStringExtra("email")
        val  age= intent.getStringExtra("age")
        val phoneNum = intent.getStringExtra("phoneNum")

        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)
        val pickBtn = findViewById<Button>(R.id.Birth)
        val date = findViewById(R.id.BirthDate) as TextView
        val signup = findViewById<Button>(R.id.SignUp)
        var bdy = findViewById(R.id.BirthDate) as TextView

        pickBtn.setOnClickListener {
            val calendar = DatePickerDialog(
                    this,
                    DatePickerDialog.OnDateSetListener { view: DatePicker, mYear: Int, mMonth: Int, mDay: Int ->
                        date.setText("" + mDay + "/" + mMonth + "/" + mYear)
                    },
                    year,
                    month,
                    day
            )
            calendar.show()

            /*val hbd = intent.getStringExtra("BirthDate")*/
            val intent = Intent(this@MainPage, FinalInfo::class.java)
            intent.putExtra("First Name", firstname)
            intent.putExtra("Last Name", lastname)
            intent.putExtra("Email Address", email)
            intent.putExtra("Age",age)
            intent.putExtra("Phone Number", phoneNum)
            startActivity(intent)
        }

    }
}


