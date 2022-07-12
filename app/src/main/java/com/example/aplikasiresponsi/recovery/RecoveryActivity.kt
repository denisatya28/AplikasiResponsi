package com.example.aplikasiresponsi.recovery

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import com.example.aplikasiresponsi.R
import com.example.aplikasiresponsi.home.HomeActivity
import com.example.aplikasiresponsi.login.LoginActivity
import com.example.aplikasiresponsi.register.RegisterActivity

class RecoveryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recovery)

        val etMail = findViewById<EditText>(R.id.etrmail)
        val kembalire = findViewById<ImageButton>(R.id.btnkembalira)
        val btnkirim = findViewById<Button>(R.id.btnsend)

        kembalire.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        btnkirim.setOnClickListener {
            if (Patterns.EMAIL_ADDRESS.matcher(etMail.text.toString()).matches()) {
                etMail.error = "Email Tidak Boleh Kosong"
            }
            else {
                Toast.makeText(this, "Email Recovery Telah Di kirim", Toast.LENGTH_SHORT).show()
            }

        }
    }
}