package com.suhaozdemir.flagquiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
     window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        val btnStart : Button = findViewById(R.id.btnStart)
        val txtName : EditText = findViewById(R.id.etxt_Name)

        btnStart.setOnClickListener {
            if(txtName.text.isEmpty())
                Toast.makeText(this, "Name cannot be empty", Toast.LENGTH_LONG).show()
            else{
                startActivity(Intent(this, QuestionsActivity::class.java))
                finish()
            }
        }

    }
}