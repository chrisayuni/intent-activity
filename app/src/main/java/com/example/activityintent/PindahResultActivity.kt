package com.example.activityintent

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.w3c.dom.Text

class PindahResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_pindah_result)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var edTahunLahir = findViewById<EditText>(R.id.ed_tahun_lahir)
        var btnResult = findViewById<Button>(R.id.btn_result)

        btnResult.setOnClickListener {
            val input = edTahunLahir.text.toString()
            val hasil = when (input.toInt()) {
                in 1946..1964 -> "Baby Boomers"
                in 1965..1980 -> "X"
                in 1981..1995 -> "Millenial"
                in 1996..2010 -> "Z"
                in 2011..2024 -> "Alpha"
                else -> "Unknown"
            }

            val resultIntent = Intent()
            resultIntent.putExtra("hasilGenerasi", hasil)
            setResult(Activity.RESULT_OK, resultIntent)
            finish()
        }
    }
}