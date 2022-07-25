package com.japnoor.login

import com.japnoor.login.R

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.*
import androidx.core.widget.doOnTextChanged

class SignUpActivity : AppCompatActivity() {
    lateinit var etFirstNameFP : EditText
    lateinit var etLastNameFP : EditText
    lateinit var etEmailFP : EditText
    lateinit var etPhoneNoFP : EditText
    lateinit var etPasswordFP : EditText
    lateinit var etRePasswordFP : EditText
    lateinit var rgGenderFP : RadioGroup
    lateinit var rbHeFP : RadioButton
    lateinit var rbSheFP : RadioButton
    lateinit var rbOtherFP : RadioButton
    lateinit var etDescriptionFP : EditText
    lateinit var btnSubmitFP : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        etFirstNameFP=findViewById(R.id.etFirstNameFP)
        etLastNameFP=findViewById(R.id.etLastNameFP)
        etEmailFP=findViewById(R.id.etEmailFP)
        etPhoneNoFP=findViewById(R.id.etPhoneNoFP)
        etPasswordFP=findViewById(R.id.etPasswordFP)
        etRePasswordFP=findViewById(R.id.etRePasswordFP)
        rgGenderFP=findViewById(R.id.rgGenderFP)
        rbHeFP=findViewById(R.id.rbHeFP)
        rbSheFP=findViewById(R.id.rbSheFP)
        rbOtherFP=findViewById(R.id.rbOtherFP)
        etDescriptionFP=findViewById(R.id.etDescriptionFP)
        btnSubmitFP=findViewById(R.id.btnSubmitFP)

        etFirstNameFP.doOnTextChanged { text, start, before, count ->
            if((text?.length ?:0) <3)
                etFirstNameFP.error=resources.getString(R.string.Enter_First_name)
            else
                etFirstNameFP.error=null
        }
        etLastNameFP.doOnTextChanged { text, start, before, count ->
            if((text?.length ?:0) <3)
                etLastNameFP.error=resources.getString(R.string.Enter_last_name)
            else
                etLastNameFP.error=null
        }
        etEmailFP.doOnTextChanged { text, start, before, count ->
            if (!Patterns.EMAIL_ADDRESS.matcher(etEmailFP.text.toString()).matches())
                etEmailFP.error = resources.getString(R.string.Enter_valid_email)
            else
                etEmailFP.error = null
        }
        etPhoneNoFP.doOnTextChanged { text, start, before, count ->
            if ((text?.length ?:0)!=10)
                etPhoneNoFP.error = resources.getString(R.string.Enter_valid_PhoneNo)
            else
                etPhoneNoFP.error = null
        }
        etPasswordFP.doOnTextChanged { text, start, before, count ->
            if ((text?.length ?:0) <6)
                etPasswordFP.error = resources.getString(R.string.password_must_be_at_least_6_characters)
            else
                etPasswordFP.error = null
        }
        etRePasswordFP.doOnTextChanged { text, start, before, count ->
            if (!(text.toString() == etPasswordFP.text.toString()))
                etRePasswordFP.error= resources.getString(R.string.Password_is_not_same)
            else
                etRePasswordFP.error = null
        }
        rgGenderFP.setOnCheckedChangeListener { group, id ->
            when(id) {
                R.id.rbOtherFP -> etDescriptionFP.visibility = View.VISIBLE
                else -> {
                    etDescriptionFP.visibility = View.GONE
                }
            }
        }
        etDescriptionFP.doOnTextChanged { text, start, before, count ->
            if((text?.length ?:0) <5)
            {
                etDescriptionFP.error=resources.getString(R.string.Description_should_be_at_leat_5_characters)
            }
            else{
                etDescriptionFP.error=null
            }
        }



        btnSubmitFP.setOnClickListener {
            if(etFirstNameFP.text.toString().isNullOrEmpty()){
                etFirstNameFP.requestFocus()
                etFirstNameFP.error=resources.getString(R.string.Enter_First_name)
            }
            else if(etLastNameFP.text.toString().isNullOrEmpty()){
                etLastNameFP.requestFocus()
                etLastNameFP.error=resources.getString(R.string.Enter_last_name)
            }
            else if(etEmailFP.text.toString().isNullOrEmpty()){
                etEmailFP.requestFocus()
                etEmailFP.error=resources.getString(R.string.Enter_email)
            }
            else if(etPhoneNoFP.text.toString().isNullOrEmpty()){
                etPhoneNoFP.requestFocus()
                etPhoneNoFP.error=resources.getString(R.string.Enter_phoneNo)
            }
            else if(etPasswordFP.text.toString().isNullOrEmpty()){
                etPasswordFP.requestFocus()
                etPasswordFP.error=resources.getString(R.string.Enter_Password)
            }
            else if(etRePasswordFP.text.toString().isNullOrEmpty()){
                etRePasswordFP.requestFocus()
                etRePasswordFP.error=resources.getString(R.string.Enter_Password_again)
            }
            else if(etDescriptionFP.text.toString().isNullOrEmpty()){
                etDescriptionFP.requestFocus()
                etDescriptionFP.error=resources.getString(R.string.Enter_Description)
            }
            else if(!(etRePasswordFP.text.toString() == etPasswordFP.text.toString()))
            {
                etRePasswordFP.requestFocus()
                etRePasswordFP.error=resources.getString(R.string.Password_must_be_same)
            }
            else{
                Toast.makeText(this,resources.getString(R.string.Signup_Successful),Toast.LENGTH_SHORT).show()
            }
        }
    }
}