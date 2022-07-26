package com.Japnoor.login

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.*
import androidx.core.widget.doOnTextChanged
import com.japnoor.login.SignUpActivity
import com.japnoor.login.ForgotPasswordActivity
import com.japnoor.login.R

class MainActivity : AppCompatActivity() {

    lateinit var tvLOGIN : TextView
    lateinit var etEmail : EditText
    lateinit var etPassword : EditText
    lateinit var btnLogin : Button
    lateinit var btnsignUp : Button
    lateinit var tvForgotPassword : TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvLOGIN=findViewById(R.id.tvLOGIN)
        etEmail=findViewById(R.id.etEmail)
        etPassword=findViewById(R.id.etPassword)
        btnLogin=findViewById(R.id.btnLogin)
        btnsignUp=findViewById(R.id.btnsignUp)
        tvForgotPassword=findViewById(R.id.tvForgotPassword)

        btnLogin.setOnClickListener {
            var email=etEmail.text.toString()
            var password=etPassword.text.toString()
            if(email.isNullOrEmpty()){
                etEmail.error=resources.getString(R.string.please_enter_email)
                etEmail.requestFocus()
            }
            else if(password.isNullOrEmpty()){
                etPassword.error=resources.getString(R.string.please_enter_password)
                etPassword.requestFocus()
            }
            else if(password.length<6){
                etPassword.error=resources.getString(R.string.password_must_be_at_least_6_characters)
                etPassword.requestFocus()
            }
            else{
                Toast.makeText(this,resources.getString(R.string.login_successful),Toast.LENGTH_LONG).show()
            }
        }

        etPassword.doOnTextChanged { text, start, before, count ->

            if((text?.length ?:0) <6)
            {
                etPassword.error=resources.getString(R.string.password_must_be_at_least_6_characters)
            }
            else{
                etPassword.error=null
            }

        }

        btnsignUp.setOnClickListener {
            var intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }

        tvForgotPassword.setOnClickListener{
            var intent=Intent(this, ForgotPasswordActivity::class.java)
            intent.putExtra("email",etEmail.text.toString())
            startActivity(intent)
        }
    }
}