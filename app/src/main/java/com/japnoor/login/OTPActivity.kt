package com.japnoor.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.widget.doOnTextChanged

class OTPActivity : AppCompatActivity() {
    lateinit var et1OTP : EditText
    lateinit var et2OTP : EditText
    lateinit var et3OTP : EditText
    lateinit var et4OTP : EditText
    lateinit var btnSubmitOTP : Button
    lateinit var tvResendOTP : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_otpactivity)

        et1OTP=findViewById(R.id.et1OTP)
        et2OTP=findViewById(R.id.et2OTP)
        et3OTP=findViewById(R.id.et3OTP)
        et4OTP=findViewById(R.id.et4OTP)
        btnSubmitOTP=findViewById(R.id.btnSubmitOTP)
        tvResendOTP=findViewById(R.id.tvResendOTP)

        et1OTP.doOnTextChanged { text, start, before, count ->
            if((text?.length ?:0) ==1)
            et2OTP.requestFocus()
        }
        et2OTP.doOnTextChanged { text, start, before, count ->
            if((text?.length ?:0) ==1)
                et3OTP.requestFocus()
        }
        et3OTP.doOnTextChanged { text, start, before, count ->
            if((text?.length ?:0) ==1)
                et4OTP.requestFocus()
        }

        tvResendOTP.setOnClickListener{
            Toast.makeText(this,resources.getString(R.string.will_be_implemented_soon),Toast.LENGTH_SHORT).show()
        }

        btnSubmitOTP.setOnClickListener{
            if(et1OTP.text.toString().isNullOrEmpty()){
                et1OTP.requestFocus()
                et1OTP.error=resources.getString(R.string.Enter_OTP)
            }
            else if(et2OTP.text.toString().isNullOrEmpty()){
                et2OTP.requestFocus()
                et2OTP.error=resources.getString(R.string.Enter_OTP)
            }
            else if(et3OTP.text.toString().isNullOrEmpty()){
                et3OTP.requestFocus()
                et3OTP.error=resources.getString(R.string.Enter_OTP)
            }
            else if(et4OTP.text.toString().isNullOrEmpty()){
                et4OTP.requestFocus()
                et4OTP.error=resources.getString(R.string.Enter_OTP)
            }
            else{
            Toast.makeText(this,resources.getString(R.string.Submit_Successfully),Toast.LENGTH_SHORT).show()
        }
        }
    }
}