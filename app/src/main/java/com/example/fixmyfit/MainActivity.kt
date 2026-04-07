package com.example.fixmyfit

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Penanganan System Bars
        val mainLayout = findViewById<androidx.constraintlayout.widget.ConstraintLayout>(R.id.main)
        ViewCompat.setOnApplyWindowInsetsListener(mainLayout) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Pastikan ID ini sesuai dengan activity_main.xml
        val etEmail = findViewById<TextInputEditText>(R.id.etEmail)
        val etPassword = findViewById<TextInputEditText>(R.id.etPassword)
        val btnLogin = findViewById<Button>(R.id.btnLogin)
        val tvRegister = findViewById<TextView>(R.id.tvRegister)

        // Pindah ke Register
        tvRegister.setOnClickListener {
            startActivity(Intent(this, activity_register::class.java))
        }

        btnLogin.setOnClickListener {
            val emailInput = etEmail.text.toString().trim()
            val passInput = etPassword.text.toString().trim()

            // DEBUG: Cek di Logcat (tekan Alt+6) untuk melihat apa yang sebenarnya terbaca
            println("LOGIN_DEBUG: Email: '$emailInput', Pass: '$passInput'")

            if (emailInput.isEmpty() || passInput.isEmpty()) {
                Toast.makeText(this, "Email dan Password tidak boleh kosong!", Toast.LENGTH_SHORT).show()
            } else {
                    Toast.makeText(this, "Login Berhasil!", Toast.LENGTH_SHORT).show()
                    // PINDAH KE HOME
                    val intent = Intent(this, activity_home::class.java)
                    startActivity(intent)
                    finish()
            }
        }
    }
}