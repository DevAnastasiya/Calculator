package com.example.calculator.commands

import com.example.claculator.common.Command

class MultiplyCommand : Command {
    override fun execute(firstNumber: String, secondNumber: String): String {
        val temp: Double = firstNumber.toDouble() * secondNumber.toDouble()
        return temp.toString()
    }
}