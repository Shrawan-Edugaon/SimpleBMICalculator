package com.example.simplebmicalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var height:EditText
    private lateinit var weight:EditText
    private lateinit var calculate:Button
    private lateinit var result:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        height = findViewById(R.id.heightText)
        weight = findViewById(R.id.weightText)
        calculate = findViewById(R.id.calcBMI)
        result = findViewById(R.id.result)

        calculate.setOnClickListener {
            calculateBMIFunction()
        }
    }

    private fun calculateBMIFunction() {
        val strHeight = height.text.toString()
        val strWeight = weight.text.toString()
        val valHeight:Float
        val valWeight:Float

        if (TextUtils.isEmpty(strHeight))
        {
            height.error = "Cannot be empty.."
            return
        }
        else
        {
            valHeight = strHeight.toFloat()
        }
        if (TextUtils.isEmpty(strWeight))
        {
            weight.error = "Cannot be empty.."
            return
        }
        else
        {
            valWeight = strWeight.toFloat()
        }
        val bmi = valWeight/(valHeight * valHeight)
        displayBMIFuction(bmi)
    }

    private fun displayBMIFuction(bmi: Float) {

        val strResult:String
        val bmiLevel:String = when{
            bmi <16 ->"Severely Underweight"
            bmi <18.25 ->"Underweight"
            bmi <25 -> "Normal"
            bmi <30 -> "Overweight"
            else -> "Obese"
        }
        strResult = "$bmi Kg/M2 \n $bmiLevel"
        result.text = strResult
    }
}