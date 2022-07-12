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
    lateinit var getpass: EditText
    lateinit var getmail: EditText
    lateinit var regist: TextView
    lateinit var lupa : TextView
    lateinit var btnlog:Button
    lateinit var savepass:EditText
    lateinit var savemail:EditText
    val MIN_PASS = 6

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        viewInit()
        btnlog.setOnClickListener{
            performLogin()
        }
        lupa.setOnClickListener {
            performLupa()
        }
        regist.setOnClickListener {
            performRegist()
        }
    }
    fun viewInit(){
        getmail = findViewById(R.id.etgetmail)
        getpass = findViewById(R.id.etgetpasword)
        regist = findViewById(R.id.tvdaftar)
        lupa= findViewById(R.id.tvlupa)
        btnlog=findViewById(R.id.btnlogin)

        val bukabundle = intent.extras
        if (bukabundle!= null){
            savepass.setText(bukabundle.getString("setpass"))
            savemail.setText(bukabundle.getString("setmail"))
        }
    }
    fun validateInput():Boolean{
        if(getmail.text.toString().equals("")){
            getmail.setError("Please Enter Email")
            return false
        }
        if(getpass.text.toString().equals("")){
            getpass.setError("Please Enter Password")
            return false
        }
        if(!emailValid(getmail.text.toString())){
            getmail.setError("Please Enter Valid Email")
            return false
        }
        if(getpass.text.length < MIN_PASS){
            getpass.setError("Password Length Must be More Than "+MIN_PASS+" Characters")
            return false
        }
        if(getpass.text.toString()!=savepass.text.toString() && getmail.text.toString()!=savemail.text.toString()) {
            Toast.makeText(this, "Wrong Email/Password or Not Registered", Toast.LENGTH_SHORT).show()
            return false
        }
        return true
    }
    fun emailValid(email: String):Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }
    fun performLogin(){
        if(validateInput()){
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)

        }
    }
    fun performRegist(){
        val intent = Intent(this, RegisterActivity::class.java)
        startActivity(intent)
    }
    fun performLupa(){
        val intent = Intent(this, RecoveryActivity::class.java)
        startActivity(intent)
    }
}

//        val btnlog = findViewById<Button>(R.id.btnlogin)
//        val mail = findViewById<EditText>(R.id.etgetmail)
//        val pass = findViewById<EditText>(R.id.etgetpasword)
//        val daftar = findViewById<TextView>(R.id.tvdaftar)
//        val lupa = findViewById<TextView>(R.id.tvlupa)
//
//        val bukabundle = intent.extras
//        if (bukabundle!= null){
//            getpass.setText(bukabundle.getString("setpass"))
//            getmail.setText(bukabundle.getString("setmail"))
//        }
//            btnlog.setOnClickListener {
//                if (mail.length() == 0) {
//                    mail.error = "Email Tidak Boleh Kosong"
//                } else if (pass.length() == 0) {
//                    pass.error = "Password Tidak Boleh Kosong"
//                } else if (mail.equals(getmail) && pass.equals(getpass)) {
//                    val intent = Intent(this, HomeActivity::class.java)
//                    startActivity(intent)
//                }
//                else{
//                    Toast.makeText(this, "Silahkan Registrasi Dulu", Toast.LENGTH_SHORT).show()
//                }
//            }
//        daftar.setOnClickListener{
//            val intent = Intent(this, RegisterActivity::class.java)
//            startActivity(intent)
//        }
//        lupa.setOnClickListener{
//            val intent = Intent(this, RecoveryActivity::class.java)
//            startActivity(intent)
//        }
//
//    }
//}