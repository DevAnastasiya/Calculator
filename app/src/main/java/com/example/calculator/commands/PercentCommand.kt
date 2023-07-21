package com.example.calculator.commands

import com.example.calculator.Exceptions
import com.example.claculator.common.Command

class PercentCommand : Command {

    private val exceptions = Exceptions()
    override fun execute(firstNumber: String, secondNumber: String): String {

        val temp: String
        val res: String

        if (secondNumber.isEmpty()) {
            if (exceptions.formatFirst(firstNumber).isEmpty()) {
                return (firstNumber.toDouble() / 100).toString()

            }
            return exceptions.formatFirst(firstNumber)
        } else {
            if (exceptions.format(firstNumber, secondNumber).isEmpty()) {
                temp = (firstNumber.toDouble() / 100).toString()
                return (temp.toDouble() * secondNumber.toDouble()).toString()
            }
            return exceptions.format(firstNumber, secondNumber)
        }
    }
}