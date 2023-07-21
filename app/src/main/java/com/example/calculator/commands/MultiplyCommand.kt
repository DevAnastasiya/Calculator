package com.example.calculator.commands

import com.example.calculator.Exceptions
import com.example.claculator.common.Command

class MultiplyCommand : Command {

    private val exceptions = Exceptions()

    override fun execute(firstNumber: String, secondNumber: String): String {

        if (exceptions.format(firstNumber, secondNumber).isEmpty()) {
            val temp: Double = firstNumber.toDouble() * secondNumber.toDouble()
            return temp.toString()
        }
        return exceptions.format(firstNumber, secondNumber)
    }
}