package com.example.imagedownloader

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import com.bumptech.glide.Glide

class MainActivity : AppCompatActivity() {
    private lateinit var et_uri:EditText
    private lateinit var btn_upload:Button
    private lateinit var img_view:ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()


    }

    private fun initViews(){
        et_uri = findViewById<EditText>(R.id.et_uri)
        btn_upload = findViewById(R.id.btn_upload)
        img_view = findViewById(R.id.img_view)
        btn_upload.setOnClickListener {
            if ( et_uri.text.toString() == "") et_uri.setError("This field can not be empty")
            else{
                Glide.with(this)
                    .load(et_uri.text.toString())
                    .centerCrop()
                    .into(img_view)
            }

        }
    }
}