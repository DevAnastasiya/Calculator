package com.example.calculator.commands

import com.example.calculator.Validator
import com.example.claculator.common.Command

class MinusCommand : Command {

    private val Validator = Validator()

    override fun execute(firstNumber: String, secondNumber: String): String {

        return if (Validator.format(firstNumber, secondNumber) is NumberFormatException)
            "Неверный формат"
        else
            (firstNumber.toDouble() - secondNumber.toDouble()).toString()
    }
}