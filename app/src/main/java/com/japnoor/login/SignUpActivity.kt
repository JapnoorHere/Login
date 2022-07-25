package com.japnoor.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.*
import androidx.core.widget.doOnTextChanged

class SignUpActivity : AppCompatActivity() {
    lateinit var etFirstNameSU : EditText
    lateinit var etLastNameSU : EditText
    lateinit var etEmailSU : EditText
    lateinit var etPhoneNoSU : EditText
    lateinit var etPasswordSU : EditText
    lateinit var etRePasswordSU : EditText
    lateinit var rgGenderSU : RadioGroup
    lateinit var rbHeSU : RadioButton
    lateinit var rbSheSU : RadioButton
    lateinit var rbOtherSU : RadioButton
    lateinit var etDescriptionSU : EditText
    lateinit var btnSubmitSU : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        etFirstNameSU=findViewById(R.id.etFirstNameSU)
        etLastNameSU=findViewById(R.id.etLastNameSU)
        etEmailSU=findViewById(R.id.etEmailSU)
        etPhoneNoSU=findViewById(R.id.etPhoneNoSU)
        etPasswordSU=findViewById(R.id.etPasswordSU)
        etRePasswordSU=findViewById(R.id.etRePasswordSU)
        rgGenderSU=findViewById(R.id.rgGenderSU)
        rbHeSU=findViewById(R.id.rbHeSU)
        rbSheSU=findViewById(R.id.rbSheSU)
        rbOtherSU=findViewById(R.id.rbOtherSU)
        etDescriptionSU=findViewById(R.id.etDescriptionSU)
        btnSubmitSU=findViewById(R.id.btnSubmitSU)

        etFirstNameSU.doOnTextChanged { text, start, before, count ->
            if((text?.length ?:0) <3)
                etFirstNameSU.error=resources.getString(R.string.Enter_First_name)
            else
                etFirstNameSU.error=null
        }
        etLastNameSU.doOnTextChanged { text, start, before, count ->
            if((text?.length ?:0) <3)
                etLastNameSU.error=resources.getString(R.string.Enter_last_name)
            else
                etLastNameSU.error=null
        }
        etEmailSU.doOnTextChanged { text, start, before, count ->
            if (!Patterns.EMAIL_ADDRESS.matcher(etEmailSU.text.toString()).matches())
                etEmailSU.error = resources.getString(R.string.Enter_valid_email)
            else
                etEmailSU.error = null
        }
        etPhoneNoSU.doOnTextChanged { text, start, before, count ->
            if ((text?.length ?:0)!=10)
                etPhoneNoSU.error = resources.getString(R.string.Enter_valid_PhoneNo)
            else
                etPhoneNoSU.error = null
        }
        etPasswordSU.doOnTextChanged { text, start, before, count ->
            if ((text?.length ?:0) <6)
                etPasswordSU.error = resources.getString(R.string.password_must_be_at_least_6_characters)
            else
                etPasswordSU.error = null
        }
        etRePasswordSU.doOnTextChanged { text, start, before, count ->
            if (!(text.toString() == etPasswordSU.text.toString()))
                etRePasswordSU.error= resources.getString(R.string.Password_is_not_same)
            else
                etRePasswordSU.error = null
        }
        rgGenderSU.setOnCheckedChangeListener { group, id ->
            when(id) {
                R.id.rbOtherSU -> etDescriptionSU.visibility = View.VISIBLE
                else -> {
                    etDescriptionSU.visibility = View.GONE
                }
            }
        }
        etDescriptionSU.doOnTextChanged { text, start, before, count ->
            if((text?.length ?:0) <5)
            {
                etDescriptionSU.error=resources.getString(R.string.Description_should_be_at_leat_5_characters)
            }
            else{
                etDescriptionSU.error=null
            }
        }



        btnSubmitSU.setOnClickListener {
            if(etFirstNameSU.text.toString().isNullOrEmpty()){
                etFirstNameSU.requestFocus()
                etFirstNameSU.error=resources.getString(R.string.Enter_First_name)
            }
            else if(etLastNameSU.text.toString().isNullOrEmpty()){
                etLastNameSU.requestFocus()
                etLastNameSU.error=resources.getString(R.string.Enter_last_name)
            }
            else if(etEmailSU.text.toString().isNullOrEmpty()){
                etEmailSU.requestFocus()
                etEmailSU.error=resources.getString(R.string.Enter_email)
            }
            else if(etPhoneNoSU.text.toString().isNullOrEmpty()){
                etPhoneNoSU.requestFocus()
                etPhoneNoSU.error=resources.getString(R.string.Enter_phoneNo)
            }
            else if(etPasswordSU.text.toString().isNullOrEmpty()){
                etPasswordSU.requestFocus()
                etPasswordSU.error=resources.getString(R.string.Enter_Password)
            }
            else if(etRePasswordSU.text.toString().isNullOrEmpty()){
                etRePasswordSU.requestFocus()
                etRePasswordSU.error=resources.getString(R.string.Enter_Password_again)
            }
            else if(etDescriptionSU.text.toString().isNullOrEmpty()){
                etDescriptionSU.requestFocus()
                etDescriptionSU.error=resources.getString(R.string.Enter_Description)
            }
            else if(!(etRePasswordSU.text.toString() == etPasswordSU.text.toString()))
            {
                etRePasswordSU.requestFocus()
                etRePasswordSU.error=resources.getString(R.string.Password_must_be_same)
            }
            else{
                Toast.makeText(this,resources.getString(R.string.Signup_Successful),Toast.LENGTH_SHORT).show()
            }
        }
    }
}