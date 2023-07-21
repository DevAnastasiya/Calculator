package com.example.calculator.commands

import com.example.calculator.Exceptions
import com.example.claculator.common.Command

class DivideCommand : Command {

    private val exceptions = Exceptions()
    override fun execute(firstNumber: String, secondNumber: String): String {

        if (exceptions.format(firstNumber, secondNumber).isEmpty()) {
            if (exceptions.divide(firstNumber, secondNumber).isEmpty()) {
                return (firstNumber.toDouble() / secondNumber.toDouble()).toString()
            }
            return exceptions.divide(firstNumber, secondNumber)
        }
        return exceptions.format(firstNumber, secondNumber)
    }
}