package com.example.odev5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.odev5.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val buttonList = mutableListOf(
            binding.button0,
            binding.button1,
            binding.button2,
            binding.button3,
            binding.button4,
            binding.button5,
            binding.button6,
            binding.button7,
            binding.button8,
            binding.button9,
            binding.btnSum,
            binding.btnDeleteAll,
            binding.btnEqual
        )
        val numbers = arrayListOf<Int>()
        var previousValue: String? = null
        for (button in buttonList) {
            when (button) {
                binding.btnEqual -> {
                    button.setOnClickListener {
                        numbers.addAll(
                            binding.textViewIslemGoster.text.toString().split("+")
                                .map { it.toInt() })
                        val sum = numbers.sum()
                        binding.textViewSonuc.text = sum.toString()
                        numbers.clear()
                        previousValue = null
                    }
                }

                binding.btnDeleteAll -> {
                    button.setOnClickListener {
                        binding.textViewIslemGoster.text = ""
                        binding.textViewSonuc.text = "0"
                        numbers.clear()
                        previousValue = null
                    }
                }

                binding.btnSum -> {
                    button.setOnClickListener {
                        val buttonText = button.text.toString()

                        if (previousValue != buttonText) {
                            binding.textViewIslemGoster.text =
                                "${binding.textViewIslemGoster.text}$buttonText"
                            previousValue = buttonText
                        }
                    }
                }

                else -> {
                    val buttonText = button.text.toString()
                    button.setOnClickListener {
                        binding.textViewIslemGoster.text =
                            "${binding.textViewIslemGoster.text}$buttonText"
                        previousValue = null
                    }
                }
            }
        }


    }
}




