package com.example.senilproject

import android.annotation.SuppressLint
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.AppCompatTextView
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.database

class loginActivity : AppCompatActivity() {

    var uservalu: Int? = null
    var isper: Boolean? = false
    var pref: SharedPreferences? = null

    lateinit var auth:FirebaseAuth
    lateinit var database:DatabaseReference

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {

        auth = Firebase.auth
        database = Firebase.database.reference

        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)
        pref =
            this.getSharedPreferences("my_pref", MODE_PRIVATE)


        val buttonlogin = findViewById<AppCompatButton>(R.id.buttonlogin)
        val Email = findViewById<AppCompatEditText>(R.id.Email)
        val Password = findViewById<AppCompatEditText>(R.id.Password)


        val prEmail: String? = pref?.getString("email",0.toString())
        val prPassword: String? = pref?.getString("password", 0.toString())

        buttonlogin.setOnClickListener() {

            auth.signInWithEmailAndPassword(Email.text.toString(),Password.text.toString()).addOnCompleteListener(this){
                if (it.isSuccessful){
                    val userid = it.result.user?.uid
                    Toast.makeText(this, "Successful", Toast.LENGTH_SHORT).show()
                }
                else{
                    Toast.makeText(this, "Not Successful", Toast.LENGTH_SHORT).show()
                }
            }

            val value = if (prEmail != Email.text.toString()) {
                Toast.makeText(this, "Email is not conform", Toast.LENGTH_LONG).show()
            } else if (prPassword != Password.text.toString()) {
                Toast.makeText(this, "password is not conform", Toast.LENGTH_LONG).show()
            } else {

                Toast.makeText(this, "Email and Password is a Conform", Toast.LENGTH_LONG).show()

                startActivity(Intent(this, destbord::class.java))
            }


//            if (prPassword == Password.text.toString()) {
//                Toast.makeText(this, "password is a conform", Toast.LENGTH_LONG).show()
//            } else {
//
//                Toast.makeText(this, "password is a not Conform", Toast.LENGTH_LONG).show()
//            }

        }
        val SignUp = findViewById<AppCompatTextView>(R.id.SignUp)
        SignUp.setOnClickListener() {
            startActivity(Intent(this, registerActivity::class.java))
        }

    }

    private fun startActivity(intent: Any): Any {
        TODO("Not yet implemented")
    }
}



