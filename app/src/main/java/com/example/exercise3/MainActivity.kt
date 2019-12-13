package com.example.exercise3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var premiumModel: PremiumModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        premiumModel = ViewModelProviders.of(this).get(PremiumModel::class.java)

        btnCal.setOnClickListener(){
            val age = spinner.selectedItemPosition
            var premium = 0.00

            when(age){
                0 -> premium = 60.00
                1 -> premium = 70.00 +
                        (if(rbMale.isChecked) 50.00 else 0.00) +
                        (if(chkSmoker.isChecked) 100.00 else 0.00)
                2 -> premium = 90.00 +
                        (if(rbMale.isChecked) 100.00 else 0.0) +
                        (if(chkSmoker.isChecked) 150.00 else 0.0)
                3 -> premium = 120.00 +
                        (if(rbMale.isChecked) 150.00 else 0.0) +
                        (if(chkSmoker.isChecked) 200.00 else 0.0)
                4 -> premium = 150.00 +
                        (if(rbMale.isChecked) 200.00 else 0.0) +
                        (if(chkSmoker.isChecked) 250.00 else 0.0)
                5 -> premium = 150.00 +
                        (if(rbMale.isChecked) 250.00 else 0.0) +
                        (if(chkSmoker.isChecked) 300.00 else 0.0)
                else -> premium = 0.00
            }

            txtTotal.text = "RM %.2f".format(premium)
            premiumModel.premium = premium
        }

        txtTotal.text = "RM " + premiumModel.premium.toString()


        btnReset.setOnClickListener(){
            spinner.setSelection(0)
            rgGender.clearCheck()
            chkSmoker.setChecked(false)
            txtTotal.text = "RM 0.0"
        }
    }
}
