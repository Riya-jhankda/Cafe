package com.example.cafe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val ordersplaced=intent.getStringExtra(MainActivity.KEY)

        val ord=findViewById<TextView>(R.id.orders)

        ord.text="The order placed by you is : \n"+ordersplaced.toString()
    }
}