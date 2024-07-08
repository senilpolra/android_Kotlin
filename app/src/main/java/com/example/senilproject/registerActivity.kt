package com.example.senilproject

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.AppCompatTextView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class registerActivity : AppCompatActivity() {


    var pref: SharedPreferences? = null
    var password: AppCompatEditText? = null
    var Email: AppCompatEditText? =null
    var name: AppCompatEditText?=null
    var edEnterText:AppCompatEditText?=null
    var ConfirmPassword:AppCompatEditText?=null
    var username : String = ""

    lateinit var auth: FirebaseAuth
    lateinit var database:DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {

        auth = Firebase.auth
        database=Firebase.database.reference

        super.onCreate(savedInstanceState)
        setContentView(R.layout.register)
        pref =
            this.getSharedPreferences("my_pref", Context.MODE_PRIVATE)


        var btnsignup = findViewById<AppCompatButton>(R.id.btnsignup)
        var Email =findViewById<AppCompatEditText>(R.id.Email)
        var name = findViewById<AppCompatEditText>(R.id.name)
        var password = findViewById<AppCompatEditText>(R.id.password)
        var ConfirmPassword = findViewById<AppCompatEditText>(R.id.ConfirmPassword)

        btnsignup.setOnClickListener() {

//            firebase-->

            auth.createUserWithEmailAndPassword(Email.text.toString(),password.text.toString()).addOnCompleteListener(this) {
                if (it.isSuccessful) {
                    val userid = it.result.user?.uid

                    Toast.makeText(this, "Successful", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "Not Successful", Toast.LENGTH_SHORT).show()
                }
            }
//                <--
            if (password.text.toString() == ConfirmPassword.text.toString()) {
                val editor: SharedPreferences.Editor = pref!!.edit()
                editor.putString("email", Email.text.toString())
                editor.putString("name", name.text.toString())
                editor.putString("password", password.text.toString())
                editor.putString("ConfirmPassword",ConfirmPassword.text.toString())
                editor.apply()
                editor.commit()

                startActivity(Intent(this, destbord::class.java))

//            Toast.makeText(this,"password is a conform",Toast.LENGTH_LONG).show()
            } else {


                Toast.makeText(this, "password is not a Conform", Toast.LENGTH_LONG).show()
            }
        }

        val login = findViewById<AppCompatTextView>(R.id.LoginUp)
        login.setOnClickListener() {
            startActivity(Intent(this, loginActivity::class.java))
        }

    }

    fun getString() {
        val sharedIdValue = pref?.getInt("id_key", 0)

    }

}