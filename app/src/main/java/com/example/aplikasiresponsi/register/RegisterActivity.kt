package com.example.aplikasiresponsi.register

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.aplikasiresponsi.R
import com.example.aplikasiresponsi.login.LoginActivity


class RegisterActivity : AppCompatActivity() {
    lateinit var btnkembali: ImageButton
    lateinit var btnreg: Button
    lateinit var setmail: EditText
    lateinit var setpass: EditText
    lateinit var setcpass: EditText
    val MIN_PASS = 6

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        viewInit()
        btnreg.setOnClickListener {
            performReg()
        }
        btnkembali.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

    }

    fun viewInit() {
        btnkembali = findViewById(R.id.btnkembalire)
        btnreg = findViewById(R.id.btnregister)
        setmail = findViewById(R.id.etsetmail)
        setpass = findViewById(R.id.etsetpasword)
        setcpass = findViewById(R.id.etcsetpasword)

    }

    fun validateInput():Boolean{
        if(setmail.text.toString().equals("")){
            setmail.setError("Please Enter Email")
            return false
        }
        if(setpass.text.toString().equals("")){
            setpass.setError("Please Enter Password")
            return false
        }
        if(setcpass.text.toString().equals("")){
            setcpass.setError("Please Confirm Password")
            return false
        }
        if(!emailValid(setmail.text.toString())){
            setmail.setError("Please Enter Valid Email")
            return false
        }
        if(setpass.text.length < MIN_PASS){
            setpass.setError("Password Length Must be More Than "+MIN_PASS+" Characters")
            return false
        }
        if(!setpass.text.toString().equals(setcpass.text.toString())){
            setcpass.setError("Password does not match")
            return false
        }
        return true
    }

    fun emailValid(setmail: String):Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(setmail).matches()
    }
    fun performReg(){
        if(validateInput()){
            val bundle = Bundle()
            bundle.putString("setpass",setpass.text.toString())
            bundle.putString("setmail",setmail.text.toString())

            Toast.makeText(this,"Register Succes",Toast.LENGTH_SHORT).show()

            val intent = Intent(this, LoginActivity::class.java)
            intent.putExtras(bundle)
            startActivity(intent)
        }
    }

}








//        val btnkembali=findViewById<ImageButton>(R.id.btnkembalire)
//        val btnreg = findViewById<Button>(R.id.btnregister)
//        val setmail = findViewById<EditText>(R.id.etsetmail)
//        val setpass = findViewById<EditText>(R.id.etsetpasword)
//        val setcpass = findViewById<EditText>(R.id.etcsetpasword)
//
//        btnreg.setOnClickListener {
//            val bundle = Bundle()
//            bundle.putString("setpass",setpass.text.toString())
//            bundle.putString("setmail",setmail.text.toString())
//
//            if (Patterns.EMAIL_ADDRESS.matcher(setmail.text.toString()).matches()) {
//                setmail.error = "Email Tidak Boleh Kosong"
//            }
//            else if (setpass.length()==0) {
//                setpass.error = "Password Tidak Boleh Kosong"
//            }
//            else if (setcpass.equals(setpass)){
//                val alertDialogBuilder = AlertDialog.Builder(this)
//                alertDialogBuilder.setTitle("Peringatan..!!!")
//                alertDialogBuilder.setMessage("Apakah Data Anda Sudah Benar..?")
//                    .setCancelable(false)
//                    .setPositiveButton("Yes"){
//                            dialogInterface, i ->
//                        val intent = Intent(this, LoginActivity::class.java)
//                        intent.putExtras(bundle)
//                        startActivity(intent)
//                        Toast.makeText(this, "Silahkan Login", Toast.LENGTH_SHORT).show()
//                    }
//                    .setNegativeButton("No"){
//                            dialogInterface, i -> dialogInterface.cancel()
//                    }
//                val alertDialog = alertDialogBuilder.create()
//                alertDialog.show()
//            }
//            else{
//                Toast.makeText(this, "Password Harus Sama", Toast.LENGTH_SHORT).show()
//            }
//        }
//        btnkembali.setOnClickListener{
//            val intent = Intent(this, LoginActivity::class.java)
//            startActivity(intent)
//        }