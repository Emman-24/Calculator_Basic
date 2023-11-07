package com.example.calculatorbasic

import android.os.Bundle
import android.text.InputType
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var displayEditText: EditText
    private lateinit var clearButton: Button
    private lateinit var dotButton: Button
    private lateinit var button0: Button
    private lateinit var button1: Button
    private lateinit var button2: Button
    private lateinit var button3: Button
    private lateinit var button4: Button
    private lateinit var button5: Button
    private lateinit var button6: Button
    private lateinit var button7: Button
    private lateinit var button8: Button
    private lateinit var button9: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        displayEditText = findViewById(R.id.displayEditText)
        clearButton = findViewById(R.id.clearButton)
        dotButton = findViewById(R.id.dotButton)
        button0 = findViewById(R.id.button0)
        button1 = findViewById(R.id.button1)
        button2 = findViewById(R.id.button2)
        button3 = findViewById(R.id.button3)
        button4 = findViewById(R.id.button4)
        button5 = findViewById(R.id.button5)
        button6 = findViewById(R.id.button6)
        button7 = findViewById(R.id.button7)
        button8 = findViewById(R.id.button8)
        button9 = findViewById(R.id.button9)

        displayEditText.inputType = InputType.TYPE_NULL

        clearButton.setOnClickListener {
            displayEditText.setText("")
        }

        dotButton.setOnClickListener {
            when {
                displayEditText.text.toString().isEmpty() -> {
                    displayEditText.append("0.")
                }

                displayEditText.text.toString().contains(".") -> {
                    return@setOnClickListener
                }

                else -> {
                    displayEditText.append(".")
                }
            }
        }

        button0.setOnClickListener {
            if (displayEditText.text.toString() == "0") {
                return@setOnClickListener
            } else {
                displayEditText.append("0")
            }
        }

        for (i in 1..9) {
            val button = when (i) {
                1 -> button1
                2 -> button2
                3 -> button3
                4 -> button4
                5 -> button5
                6 -> button6
                7 -> button7
                8 -> button8
                9 -> button9
                else -> null
            }

            button?.setOnClickListener {
                if (displayEditText.text.toString() == "0") {
                    displayEditText.setText("")
                }
                displayEditText.append(i.toString())
            }
        }
    }
}