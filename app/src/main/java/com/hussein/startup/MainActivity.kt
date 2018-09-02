package com.hussein.startup

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import  kotlinx.android.synthetic.main.activity_main.*
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    var dotFlag:Int? = null
    var op = "*"
    var oldNum = ""
    //var plusMinus:Int? = null

    fun buClick(view: View){
        //showField.setText("")
        var buSelect = view as Button
        var buValue:String = showField.text.toString()

        when(buSelect.id)
            {

            bu0.id ->{
                buValue+="0"
            }
            bu1.id ->{
                buValue+="1"
            }
            bu2.id ->{
                buValue+="2"
            }
            bu3.id ->{
                buValue+="3"
            }
            bu4.id ->{
                buValue+="4"
            }
            bu5.id ->{
                buValue+="5"
            }
            bu6.id ->{
                buValue+="6"
            }
            bu7.id ->{
                buValue+="7"
            }
            bu8.id ->{
                buValue+="8"
            }
            bu9.id ->{
                buValue+="9"
            }
            buDot.id ->{
                //TODO: prevent more than one dot
                if(!buValue.contains("."))
                {
                    buValue = "." + buValue
                }
                else{
                    Toast.makeText(this,"Dot (.) already used once ", Toast.LENGTH_SHORT).show()
                }
            }
            buPlusMinus.id ->{
                if(!buValue.contains("-") && !buValue.contains("+"))
                {
                    buValue = "-" + buValue
                }
                if(buValue.contains("-"))
                {
                    buValue = buValue.replace("-" , "+")
                }
                else {
                    buValue = buValue.replace("+", "-")
                }
            }
        }//end of when
        showField.setText(buValue)
    }


    fun buEvent(view: View)
    {
        var buSelect = view as Button
        when(buSelect.id)
        {
            buDiv.id ->
            {
                op = "/"Q
            }
            buMul.id ->
            {
                op = "*"
            }
            buSub.id ->
            {
                op = "-"
            }
            buAdd.id->
            {
                op = "+"
            }
        }

        oldNum = showField.text.toString()
        showField.setText("")
        dotFlag = 0
        Toast.makeText(this,"operator used : " + op, Toast.LENGTH_SHORT).show()
    }

    fun buEqualEvent(view: View)
    {
        var newNum = showField.text.toString()
        var finalNum:Double? = null
        when(op)
        {
            "*" -> {
                finalNum = oldNum.toDouble() * newNum.toDouble()
            }
            "-" -> {
                finalNum = oldNum.toDouble() - newNum.toDouble()
            }
            "/" -> {
                finalNum = oldNum.toDouble() / newNum.toDouble()
            }
            "+" -> {
                finalNum = oldNum.toDouble() + newNum.toDouble()
            }
        }
        showField.setText(finalNum.toString())
    }

    fun percent(view: View)
    {

        var num = showField.text.toString().toDouble()/100
        showField.setText(num.toString())

        bu0.isEnabled = false
        bu1.isEnabled = false
        bu2.isEnabled = false
        bu3.isEnabled = false
        bu4.isEnabled = false
        bu5.isEnabled = false
        bu6.isEnabled = false
        bu7.isEnabled = false
        bu8.isEnabled = false
        bu9.isEnabled = false

        buPercent.isEnabled = false
        buAdd.isEnabled = false
        buMul.isEnabled = false
        buSub.isEnabled = false
        buDiv.isEnabled = false
        buEqual.isEnabled = false
        buDot.isEnabled = false
        buPlusMinus.isEnabled = false

    }
    fun cleanUp(view: View)
    {

        showField.setText("")
        bu0.isEnabled = true
        bu1.isEnabled = true
        bu2.isEnabled = true
        bu3.isEnabled = true
        bu4.isEnabled = true
        bu5.isEnabled = true
        bu6.isEnabled = true
        bu7.isEnabled = true
        bu8.isEnabled = true
        bu9.isEnabled = true

        buPercent.isEnabled = true
        buAdd.isEnabled = true
        buMul.isEnabled = true
        buSub.isEnabled = true
        buDiv.isEnabled = true
        buEqual.isEnabled = true
        buDot.isEnabled = true
        buPlusMinus.isEnabled = true
    }
}
