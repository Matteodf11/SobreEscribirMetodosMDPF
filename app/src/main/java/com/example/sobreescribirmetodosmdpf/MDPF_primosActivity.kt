package com.example.sobreescribirmetodosmdpf

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MDPF_primosActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mdpf_primos)

        val number = intent.getIntExtra("NUMBER", 0)
        Log.i("PRIMOS", "Número recibido en MDPF_primosActivity: $number")
        val buttonCalculate = findViewById<Button>(R.id.button_calculate)

        buttonCalculate.setOnClickListener {
            val primes = findPrimes(number)
            Log.i("PRIMOS", "Números primos calculados: $primes")
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
