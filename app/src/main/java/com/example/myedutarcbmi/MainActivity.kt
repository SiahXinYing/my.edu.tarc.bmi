package com.example.myedutarcbmi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import kotlin.math.pow

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Link UI to program
        val editTextWeight: EditText = findViewById(R.id.editTextWeight)
        val editTextHeight: EditText = findViewById(R.id.editTextHeight)
        val textViewBMI: TextView = findViewById(R.id.textViewBMI)
        val imageViewBMI: ImageView = findViewById(R.id.imageViewBMI)
        val buttonCalculate: Button = findViewById(R.id.buttonCalculate)
        val buttonReset: Button = findViewById(R.id.buttonReset)

        buttonCalculate.setOnClickListener {
            //get input from user
            //toFloatOrNull = Float is datatype, null is it is ok for user input nothing

            if(editTextHeight.text.isEmpty()) {
                editTextWeight.setError(getString(R.string.value_required))
                return@setOnClickListener
            }
            val weight = editTextWeight.text.toString().toFloatOrNull()
            val height = editTextHeight.text.toString().toFloatOrNull()

            if(weight == null){
                editTextWeight.setError(getString(R.string.value_required))
                return@setOnClickListener //end the program here
            }

            if(height != null){

                //underweight < 18.5
                //normal 18.5 - 24.5
                //overweight > 25

                val bmi = weight/(height/100).pow(2)

                if(bmi < 18.5){
                    imageViewBMI.setImageResource(R.drawable.under)
                    textViewBMI.text = String.format("%s : %s (%.2f)", getString(R.string.app_name), getString(R.string.underweight),bmi)
                }else if(bmi > 18.5 && bmi < 25){
                    imageViewBMI.setImageResource(R.drawable.normal)
                    textViewBMI.text = String.format("%s : %s (%.2f)", getString(R.string.app_name), getString(R.string.normal),bmi)
                }else if(bmi > 25){
                    imageViewBMI.setImageResource(R.drawable.over)
                    textViewBMI.text = String.format("%s : %s (%.2f)", getString(R.string.app_name), getString(R.string.overweight),bmi)
                }


            }



        }

        buttonReset.setOnClickListener {

        }
    }
}