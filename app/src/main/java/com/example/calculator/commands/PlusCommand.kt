package com.example.calculator.commands

import com.example.calculator.Validator
import com.example.claculator.common.Command

class PlusCommand : Command {

    private val Validator = Validator()

    override fun execute(firstNumber: String, secondNumber: String): String {

        if (Validator.format(firstNumber, secondNumber) is NumberFormatException)
            return "Неверный формат"
        else
            return (firstNumber.toDouble() + secondNumber.toDouble()).toString()
    }
}