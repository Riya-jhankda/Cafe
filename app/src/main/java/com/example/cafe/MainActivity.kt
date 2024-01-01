package com.example.cafe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    companion object{
        const val KEY="package com.example.cafe.MainActivity.KEY"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn=findViewById<Button>(R.id.button)
        val ett1=findViewById<EditText>(R.id.et1)
        val ett2=findViewById<EditText>(R.id.et2)
        val ett3=findViewById<EditText>(R.id.et3)
        val ett4=findViewById<EditText>(R.id.et4)

        btn.setOnClickListener{

            val orderPlaced=ett1.text.toString() + " "+ ett2.text.toString() + " "+ ett3.text.toString() + " "+ett4.text.toString()
            intent= Intent(this,SecondActivity::class.java)
            intent.putExtra(KEY,orderPlaced)
            startActivity(intent)
        }
    }
}