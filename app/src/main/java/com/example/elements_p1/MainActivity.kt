package com.example.elements_p1

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.annotation.RequiresApi

class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val firstname = findViewById<EditText>(R.id.first_name)
        val lastname = findViewById<EditText>(R.id.last_name)
        val email = findViewById<EditText>(R.id.email_address)
        val next = findViewById<Button>(R.id.button)
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

        var slider: SeekBar
        var ages= findViewById(R.id.age)as TextView
        slider = findViewById(R.id.seekBar)as SeekBar
        slider.min = 18
        slider.max = 60
        slider.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, p2: Boolean) {
                ages.text= progress.toString()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }
        })

        next.setOnClickListener {
            val firstname = firstname.text.toString()
            val lastname = lastname.text.toString()
            val email = email.text.toString()
            val  age= ages.text.toString()
            val phoneNum = phoneText.text.toString()


            val intent = Intent(this@MainActivity, MainPage::class.java)
            intent.putExtra("First Name", firstname)
            intent.putExtra("Last Name", lastname)
            intent.putExtra("Email Address", email)
            intent.putExtra("Age",age)
            intent.putExtra("Phone Number", phoneNum)
            startActivity(intent)


        }
    }
}