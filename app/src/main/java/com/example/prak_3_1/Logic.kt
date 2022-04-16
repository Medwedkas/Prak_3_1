package com.example.prak_3_1

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.prak_3_1.databinding.ActivityLogicBinding
import kotlinx.android.synthetic.main.activity_logic.*

class Logic : AppCompatActivity() {

    private lateinit var bind: ActivityLogicBinding

    companion object {
        const val TOTAL_MIN = "value_min"
        const val TOTAL_MAX = "value_max"
    }

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        bind = ActivityLogicBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_logic)
        setContentView(bind.root)

        var min = intent.getStringExtra(TOTAL_MIN)
        var max = intent.getStringExtra(TOTAL_MAX)

        bind.big.setOnClickListener {
            min = bind.questview.text.toString()
            bind.questview.text = calculateGuess(min, max)
        }

        bind.little.setOnClickListener {
            max = bind.questview.text.toString()
            bind.questview.text = calculateGuess(min, max)
        }

        bind.Done.setOnClickListener {
            bind.questview.text = "Угадал"
            val activity_Intent = Intent(this, MainActivity::class.java)
            Toast.makeText(applicationContext, "Ураааа, я угадал", Toast.LENGTH_SHORT).show()
            startActivity(activity_Intent)
        }

        bind.questview.text = calculateGuess(min.toString(), max.toString())
    }

    private fun calculateGuess(firstBorder: String?, secondBorder: String?): String {
        val min: Int = Integer.parseInt(firstBorder)
        val max: Int = Integer.parseInt(secondBorder)
        return ((min + max) / 2).toString()
    }
}