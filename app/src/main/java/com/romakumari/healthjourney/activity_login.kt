package com.romakumari.healthjourney

import android.content.Intent
import android.graphics.Color
import android.graphics.LinearGradient
import android.graphics.Shader
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextPaint
import com.romakumari.healthjourney.databinding.ActivityLoginBinding
import com.romakumari.healthjourney.databinding.ActivityMainBinding
import java.util.Locale

class activity_login : AppCompatActivity() {
       lateinit var binding:ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvWelcome.setText("Welcome".uppercase(Locale.getDefault()))

        val paint: TextPaint = binding.tvWelcome.paint
        val width = paint.measureText("WELCOME")

        val textShader: Shader = LinearGradient(
            0f, 0f, width, paint.textSize,
            intArrayOf(
                Color.parseColor("#AC6FCA"),
                Color.parseColor("#D8CC8C"),
                Color.parseColor("#FFADAD"),
                Color.parseColor("#478AEA"),
                Color.parseColor("#8446CC")
            ), null, Shader.TileMode.CLAMP
        )

        binding.tvWelcome.paint.shader = textShader


        // Handle register button click
        binding.RegisterButton.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }

        // Handle skip button click
        binding.SkipButton.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }
}