package com.example.imagedownloader

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import java.net.MalformedURLException
import java.net.URL


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
            if ( et_uri.text.toString() == "") et_uri.error = "This field can not be empty"
            else{
                val url = URL(et_uri.text.toString())
                Thread(Runnable {
                    val bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream())
                    img_view.post {
                        img_view.setImageBitmap(bmp)
                    }
                }).start()
            }
        }
    }
}



