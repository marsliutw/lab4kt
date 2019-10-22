package com.example.lab4

import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class aty1 : AppCompatActivity() {
    internal var btn: Button
    internal var t_drink: TextView
    internal var t_sugar: TextView
    internal var t_ice: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main1)
        btn = findViewById(R.id.sent) as Button
        btn.setOnClickListener {
            val i = Intent()
            i.setClass(this@aty1, aty2::class.java!!)
            startActivityForResult(i, 0)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 0) {
            if (resultCode == 101) {
                val b = data!!.extras
                val str1 = b!!.getString("drink_level")
                val str2 = b.getString("sugar_level")
                val str3 = b.getString("ice_level")
                t_drink = findViewById(R.id.drink) as TextView
                t_sugar = findViewById(R.id.sugar) as TextView
                t_ice = findViewById(R.id.ice) as TextView
                t_drink.text = str1
                t_sugar.text = str2
                t_ice.text = str3
            }
        }
    }
}