package com.example.calculator.commands

import com.example.claculator.common.Command

class PlusCommand : Command {

    override fun execute(firstNumber: String, secondNumber: String): String =

        try {
            (firstNumber.toDouble() + secondNumber.toDouble()).toString()
        } catch (e: NumberFormatException) {
            "Неверный формат"
        }
}