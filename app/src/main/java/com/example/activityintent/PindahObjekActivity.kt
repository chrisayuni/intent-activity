package com.example.activityintent

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class PindahObjekActivity : AppCompatActivity() {

    private lateinit var terimaObjek : TextView

    companion object{
        const val EXTRA_PEOPLE = "extra_people"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_pindah_objek)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        terimaObjek = findViewById(R.id.terima_objek)
        val people: People = intent.getParcelableExtra<People>(EXTRA_PEOPLE) as People
        val text = "Name: ${people.name} \nYear: ${people.year} \nGeneration: ${people.generation}"
        terimaObjek.text = text
    }
}