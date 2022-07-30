package com.Japnoor.login

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.*
import androidx.core.widget.doOnTextChanged
import com.japnoor.login.SignUpActivity
import com.japnoor.login.ForgotPasswordActivity
import com.japnoor.login.R
import com.japnoor.login.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

   lateinit var binding : ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnLogin.setOnClickListener {
            var email=binding.etEmail.text.toString()
            var password=binding.etPassword.text.toString()
            if(email.isNullOrEmpty()){
                binding.etEmail.error=resources.getString(R.string.please_enter_email)
                binding.etEmail.requestFocus()
            }
            else if(password.isNullOrEmpty()){
                binding.etPassword.error=resources.getString(R.string.please_enter_password)
                binding. etPassword.requestFocus()
            }
            else if(password.length<6){
                binding.etPassword.error=resources.getString(R.string.password_must_be_at_least_6_characters)
                binding.etPassword.requestFocus()
            }
            else{
                Toast.makeText(this,resources.getString(R.string.login_successful),Toast.LENGTH_LONG).show()
            }
        }

        binding.etPassword.doOnTextChanged { text, start, before, count ->

            if((text?.length ?:0) <6)
            {
                binding.etPassword.error=resources.getString(R.string.password_must_be_at_least_6_characters)
            }
            else{
                binding.etPassword.error=null
            }

        }

        binding.btnsignUp.setOnClickListener {
            var intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }

        binding.tvForgotPassword.setOnClickListener{
            var intent=Intent(this, ForgotPasswordActivity::class.java)
            intent.putExtra("email",binding.etEmail.text.toString())
            startActivity(intent)
        }

        binding.ibPhone.setOnClickListener{
            var intent=Intent(Intent.ACTION_DIAL)
            intent.data=Uri.parse("tel:9041175563")
            startActivity(intent)
        }

        binding.ibSms.setOnClickListener {
            var intent=Intent(Intent.ACTION_VIEW)
            intent.data=Uri.parse("sms:9041175563")
            startActivity(intent)
        }
        binding.ibShare.setOnClickListener {
            var intent=Intent(Intent.ACTION_VIEW)
            startActivity(intent)
        }
        binding.ibMail.setOnClickListener {
            var intent=Intent(Intent.ACTION_SEND)
            intent.data=Uri.parse("mailto:recipientMail")
            intent.putExtra(Intent.EXTRA_SUBJECT,"Hello")
            intent.putExtra(Intent.EXTRA_TEXT,"Hello")
            intent.type="text/plain"
            startActivity(Intent.createChooser(intent,"Select your email app"))
        }
    }
}