package com.example.sobreescribirmetodosmdpf

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText

class MDPF_primosXActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mdpf_primos_xactivity)

        val buttonCalculate = findViewById<Button>(R.id.button_calculate)
        val inputNumber = findViewById<TextInputEditText>(R.id.input_number)

        buttonCalculate.setOnClickListener {
            val n = inputNumber.text.toString().toIntOrNull() ?: 0
            val primes = findPrimes(n)

            val resultIntent = Intent()
            resultIntent.putIntegerArrayListExtra("PRIMES", ArrayList(primes))
            setResult(RESULT_OK, resultIntent)
            finish()
        }
    }

    private fun findPrimes(n: Int): List<Int> {
        val primes = mutableListOf<Int>()
        calculatePrimes(n - 1, primes)
        return primes
    }

    private fun calculatePrimes(num: Int, primes: MutableList<Int>) {
        if (num < 2) return
        if (isPrime(num)) primes.add(num)
        calculatePrimes(num - 1, primes)
    }

    private fun isPrime(number: Int): Boolean {
        if (number <= 1) return false
        for (i in 2 until number) {
            if (number % i == 0) return false
        }
        return true
    }
}
