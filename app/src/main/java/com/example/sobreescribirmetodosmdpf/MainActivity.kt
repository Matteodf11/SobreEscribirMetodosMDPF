package com.example.sobreescribirmetodosmdpf

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {

    private lateinit var launcher: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val editTextNumber = findViewById<EditText>(R.id.editTextNumber)


        launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == RESULT_OK) {
                val primes = result.data?.getIntegerArrayListExtra("PRIMES") ?: emptyList()

                Log.i("PRIMOSX", "Números primos recibidos: $primes")
            }
        }

        val b_estadosX = findViewById<Button>(R.id.button3)
        b_estadosX.setOnClickListener {
            val intent = Intent(this, MDPF_primosXActivity::class.java)
            launcher.launch(intent)
        }

        val b_estados = findViewById<Button>(R.id.button2)
        b_estados.setOnClickListener {
            val n = editTextNumber.text.toString().toIntOrNull() ?: 0
            val intent = Intent(this, MDPF_primosActivity::class.java)
            intent.putExtra("NUMBER", n)
            startActivityForResult(intent, 1)
        }



    }
}
