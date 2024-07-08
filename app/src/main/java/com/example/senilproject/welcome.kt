package com.example.senilproject

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton

class welcome : AppCompatActivity() {
    var uservalu: Int? = null
    var isper: Boolean? = false



    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout5)



        val btnloginwelcome = findViewById<AppCompatButton>(R.id.btnloginwelcome)

        btnloginwelcome.setOnClickListener {
            startActivity(Intent(this, loginActivity::class.java))

        }

        val register = findViewById<AppCompatButton>(R.id.register)

        register.setOnClickListener {
            startActivity(Intent(this, registerActivity::class.java))
        }


//
//        val edEnterText =  findViewById<AppCompatButton>(R.id.btnloginwelcome)
//
//        if(edEnterText.text.toString().length > 0) {
//            uservalu = edEnterText.text.toString().toInt()
//            isper = true
//            edEnterText.setText("")
//            Toast.makeText(this, "login successful", Toast.LENGTH_LONG).show()
//        }
//        else {
//            Toast.makeText(this, "login is not successful", Toast.LENGTH_LONG).show()
//        }
//
//        if (isper == true) {
//            var add = uservalu?.plus(edEnterText.text.toString().toInt())
//            edEnterText.setText(add.toString())
//        }

//        isper = false
//        Toast.makeText(this, "login", Toast.LENGTH_LONG).show()
//
    }


}