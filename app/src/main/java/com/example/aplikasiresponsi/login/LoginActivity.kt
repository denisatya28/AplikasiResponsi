package com.example.aplikasiresponsi.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.aplikasiresponsi.R
import com.example.aplikasiresponsi.home.HomeActivity
import com.example.aplikasiresponsi.recovery.RecoveryActivity
import com.example.aplikasiresponsi.register.RegisterActivity

class LoginActivity : AppCompatActivity() {
    private lateinit var getpass : EditText
    private lateinit var getmail : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val btnlog = findViewById<Button>(R.id.btnlogin)
        val mail = findViewById<EditText>(R.id.etgetmail)
        val pass = findViewById<EditText>(R.id.etgetpasword)
        val daftar = findViewById<TextView>(R.id.tvdaftar)
        val lupa = findViewById<TextView>(R.id.tvlupa)

        val bukabundle = intent.extras
        if (bukabundle!= null){
            getpass.setText(bukabundle.getString("setpass"))
            getmail.setText(bukabundle.getString("setmail"))
        }
            btnlog.setOnClickListener {
                if (Patterns.EMAIL_ADDRESS.matcher(mail.text.toString()).matches()) {
                    mail.error = "Masukan email dengan benar"
                } else if (pass.length() == 0) {
                    pass.error = "Password Tidak Boleh Kosong"
                } else if (mail.equals(getmail) && pass.equals(getpass)) {
                    val intent = Intent(this, HomeActivity::class.java)
                    startActivity(intent)
                }
                else{
                    Toast.makeText(this, "Silahkan Registrasi Dulu", Toast.LENGTH_SHORT).show()
                }
            }
        daftar.setOnClickListener{
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
        lupa.setOnClickListener{
            val intent = Intent(this, RecoveryActivity::class.java)
            startActivity(intent)
        }

    }
}