package com.example.aplikasiresponsi.register

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.aplikasiresponsi.R
import com.example.aplikasiresponsi.login.LoginActivity

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val btnkembali=findViewById<ImageButton>(R.id.btnkembalire)
        val btnreg = findViewById<Button>(R.id.btnregister)
        val setmail = findViewById<EditText>(R.id.etsetmail)
        val setpass = findViewById<EditText>(R.id.etsetpasword)
        val setcpass = findViewById<EditText>(R.id.etcsetpasword)

        btnreg.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("setpass",setpass.text.toString())
            bundle.putString("setcpass",setcpass.text.toString())
            bundle.putString("setmail",setmail.text.toString())

            if (setmail.length() == 0) {
                setmail.error = "Email Tidak Boleh Kosong"
            }
            else if (setpass.length()==0) {
                setpass.error = "Password Tidak Boleh Kosong"
            }
            else if (setcpass.equals(setpass)){
                val alertDialogBuilder = AlertDialog.Builder(this)
                alertDialogBuilder.setTitle("Peringatan..!!!")
                alertDialogBuilder.setMessage("Apakah Data Anda Sudah Benar..?")
                    .setCancelable(false)
                    .setPositiveButton("Yes"){
                            dialogInterface, i ->
                        val intent = Intent(this, LoginActivity::class.java)
                        intent.putExtras(bundle)
                        startActivity(intent)
                        Toast.makeText(this, "Silahkan Login", Toast.LENGTH_SHORT).show()
                    }
                    .setNegativeButton("No"){
                            dialogInterface, i -> dialogInterface.cancel()
                    }
                val alertDialog = alertDialogBuilder.create()
                alertDialog.show()
            }
            else{
                Toast.makeText(this, "Password Harus Sama", Toast.LENGTH_SHORT).show()
            }
        }
        btnkembali.setOnClickListener{
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

    }
}