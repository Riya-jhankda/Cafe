package com.example.cafe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class Signup : AppCompatActivity() {

    lateinit var database:DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        val btn_signup=findViewById<Button>(R.id.signup)
        val et_name=findViewById<TextInputEditText>(R.id.name)
        val et_mail=findViewById<TextInputEditText>(R.id.mail)
        val et_pass=findViewById<TextInputEditText>(R.id.pass)
        val et_id=findViewById<TextInputEditText>(R.id.uniid)

        btn_signup.setOnClickListener{
            val name= et_name.text.toString()
            val mail= et_mail.text.toString()
            val pass= et_pass.text.toString()
            val id=et_id.text.toString()

            //we are creating an object for the data class we created previously
            val user= Users(name,id,mail,pass)
            //in this we created a variable that stores the address of the firebase location where our data is stored
            database=FirebaseDatabase.getInstance().getReference("riya")
            //creating a child to set the other values in the firebase
            //must remember thechild must be unique
            database.child(id).setValue(user).addOnSuccessListener {
                Toast.makeText(this,"User Registered Sucessfully",Toast.LENGTH_SHORT).show()
            }.addOnSuccessListener {
                Toast.makeText(this,"Failed",Toast.LENGTH_SHORT).show()
            }

            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
    }
}