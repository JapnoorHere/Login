package com.japnoor.login


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.widget.doOnTextChanged

class ForgotPasswordActivity : AppCompatActivity() {
    lateinit var etEmailFP : EditText
    lateinit var btnNextFP : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)

        etEmailFP=findViewById(R.id.etEmailFP)
        btnNextFP=findViewById(R.id.btnNextFP)

        etEmailFP.doOnTextChanged { text, start, before, count ->
            if (!(Patterns.EMAIL_ADDRESS.matcher(etEmailFP.text.toString()).matches()))
                etEmailFP.error = resources.getString(R.string.Enter_valid_email)
            else
                etEmailFP.error=null
        }

        btnNextFP.setOnClickListener {
            if (etEmailFP.text.toString().isNullOrEmpty()) {
                etEmailFP.requestFocus()
                etEmailFP.error = resources.getString(R.string.Enter_email)
            }
            else{
                var intent=Intent(this,OTPActivity::class.java)
                startActivity(intent)
            }
        }
    }
}