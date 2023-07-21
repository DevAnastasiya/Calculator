package com.example.calculator.commands

import com.example.calculator.Exceptions
import com.example.claculator.common.Command

class DivideCommand : Command {

    private val zero = 0.0
    private val exceptions = Exceptions()
    override fun execute(firstNumber: String, secondNumber: String): String {
        if (secondNumber.toDouble() != zero) {
            val temp: Double = firstNumber.toDouble() / secondNumber.toDouble()
            return temp.toString()
        } else
            return exceptions.execute(firstNumber.toDouble(), secondNumber.toDouble())
    }
}