package com.example.prak_3_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import com.example.prak_3_1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var bind: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        bind = ActivityMainBinding.inflate(layoutInflater)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setContentView(bind.root)

        bind.transition.setOnClickListener {
            val activity_Intent = Intent(this, Logic::class.java)
            val min = bind.min.text.toString()
            val max = bind.max.text.toString()
            activity_Intent.putExtra(Logic.TOTAL_MIN, min)
            activity_Intent.putExtra(Logic.TOTAL_MAX, max)
            startActivity(activity_Intent)
        }
    }
}