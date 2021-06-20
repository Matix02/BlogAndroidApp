package com.example.blogandroidapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class ContactActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val sendButton: Button = findViewById(R.id.send_Btn)
        val name = findViewById<TextView>(R.id.editTextName)
        val messageBody = findViewById<EditText>(R.id.description_ET)
        val isLike = findViewById<CheckBox>(R.id.like_ChB)

        val spinner: Spinner = findViewById(R.id.comment_type_sp)

        ArrayAdapter.createFromResource(
                this,
                R.array.planets_array,
                android.R.layout.simple_spinner_item
        ).also { arrayAdapter ->
            arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = arrayAdapter
        }

        sendButton.setOnClickListener {
            var goodWord = ""
            val commentType = spinner.selectedItem.toString()
            val message = messageBody.text.toString()
            if (isLike.isChecked) {
                goodWord = "Nice Web,"
            }

            val intent = Intent(Intent.ACTION_SEND)
            intent.putExtra(Intent.EXTRA_EMAIL, arrayOf("mgeslowski@wp.pl"))
            intent.putExtra(Intent.EXTRA_SUBJECT, commentType)
            intent.putExtra(Intent.EXTRA_TEXT, "Dzień dobry\n" + message + "\n" + goodWord + "\n" + "Pozdrawiam \n " + name.text.toString())
            intent.type = "message/rfc822"
            startActivity(Intent.createChooser(intent, "Select email"))
        }

    }

    override fun onBackPressed() {
        super.onBackPressed()
        return
    }
}