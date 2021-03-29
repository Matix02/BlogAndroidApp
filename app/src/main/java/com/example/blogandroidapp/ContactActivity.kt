package com.example.blogandroidapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem

class ContactActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)



    }
    override fun onBackPressed() {
        super.onBackPressed()
        return
    }
}