package com.example.lab4

import androidx.appcompat.app.AppCompatActivity

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup

class aty2 : AppCompatActivity() {
    internal var sent_btn: Button
    internal var sugar = "無糖"
    internal var set_drink: EditText
    internal var ice_opt = "微冰"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main2)
        val rg1 = findViewById(R.id.radioGroup1) as RadioGroup
        rg1.setOnCheckedChangeListener { group, checkedld ->
            when (checkedld) {
                R.id.radio0 -> sugar = "無糖"
                R.id.radio1 -> sugar = "少糖"
                R.id.radio2 -> sugar = "半糖"
                R.id.radio3 -> sugar = "全糖"
            }
        }
        val rg = findViewById(R.id.radioGroup) as RadioGroup
        rg.setOnCheckedChangeListener { group, checkedId ->
            when (checkedId) {
                R.id.radioButton1 -> ice_opt = "微冰"
                R.id.radioButton2 -> ice_opt = "少冰"
                R.id.radioButton3 -> ice_opt = "正常冰"
            }
        }

        sent_btn = findViewById(R.id.sent) as Button
        sent_btn.setOnClickListener {
            set_drink = findViewById(R.id.editText1) as EditText
            val temp = set_drink.text.toString()
            val i = Intent()
            val b = Bundle()
            b.putString("sugar_level", sugar)
            b.putString("drink_level", temp)
            b.putString("ice_level", ice_opt)
            i.putExtras(b)
            setResult(101, i)
            finish()
        }
    }
}