package com.example.activityintent

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var btnPindah: Button
    private lateinit var tvResult: TextView
    private val REQUEST_CODE_RESULT = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        btnPindah = findViewById(R.id.btn_pindah)
        val btnIntentData = findViewById<Button>(R.id.btn_pindah_data)
        val btnIntentObjek = findViewById<Button>(R.id.btn_pindah_objek)
        val btnIntentResult = findViewById<Button>(R.id.btn_pindah_result)

        tvResult = findViewById(R.id.tv_result)

        btnPindah.setOnClickListener(this)
        btnIntentData.setOnClickListener(this)
        btnIntentObjek.setOnClickListener(this)
        btnIntentResult.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.btn_pindah -> {
                val intentPindah = Intent(this@MainActivity, PindahActivity::class.java)
                startActivity(intentPindah)
            }

            R.id.btn_pindah_data -> {
                val intentData = Intent(this@MainActivity, PindahDataActivity::class.java)
                intentData.putExtra(PindahDataActivity.EXTRA_TEXT, "Hi i'm a Gen Z")
                startActivity(intentData)
            }

            R.id.btn_pindah_objek -> {
                val people = People(
                    name = "Christina Ayuni",
                    year = 2003,
                    generation = "Z"
                )

                val intentObjek = Intent(this@MainActivity, PindahObjekActivity::class.java)
                intentObjek.putExtra(PindahObjekActivity.EXTRA_PEOPLE,people)
                startActivity(intentObjek)
            }

            R.id.btn_pindah_result -> {
                val intentResult = Intent(this@MainActivity, PindahResultActivity::class.java)
                startActivityForResult(intentResult, REQUEST_CODE_RESULT)
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE_RESULT && resultCode == Activity.RESULT_OK) {
            val hasilGenerasi = data?.getStringExtra("hasilGenerasi")
            hasilGenerasi?.let {
                tvResult.text = "You are $it Generation"
            }
        }
    }
}



