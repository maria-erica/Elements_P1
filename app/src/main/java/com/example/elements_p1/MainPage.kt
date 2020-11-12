package com.example.elements_p1

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import java.util.*

class MainPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_page)

        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)
        val pickBtn = findViewById<Button>(R.id.Birth)
        val date = findViewById(R.id.BirthDate) as TextView
        val signup = findViewById<Button>(R.id.SignUp)
        var bdy = findViewById(R.id.BirthDate) as TextView

        val pSwitch = findViewById<Switch>(R.id.pSwitch)
        val phoneText = findViewById(R.id.PhoneNumber) as EditText
        pSwitch.setOnClickListener{
            if (pSwitch.isChecked == true){
                phoneText.visibility == View.VISIBLE
            }else{
                pSwitch.isChecked == false
                phoneText.visibility == View.INVISIBLE
            }
        }
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

        }
        signup.setOnClickListener {
            var hbdy = bdy.text.toString()
            val firstname = intent.getStringExtra("First Name")
            val lastname = intent.getStringExtra("Last Name")
            val email = intent.getStringExtra("Email Address")
            val age = intent.getStringExtra("Age")
            val phoneNum = phoneText.text.toString()


            /*val hbd = intent.getStringExtra("BirthDate")*/
            val intent = Intent(this@MainPage, FinalInfo::class.java)
            intent.putExtra("First Name", firstname)
            intent.putExtra("Last Name", lastname)
            intent.putExtra("Email Address", email)
            intent.putExtra("Age", age)
            intent.putExtra("BirthDate", hbdy)
            intent.putExtra("Phone Number", phoneNum)
            startActivity(intent)
        }
    }
}


