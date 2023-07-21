package com.example.calculator.commands

import com.example.calculator.Exceptions
import com.example.claculator.common.Command

class PlusCommand  : Command {

    val exceptions = Exceptions()

    override fun execute(firstNumber: String, secondNumber: String): String {
        val temp: Double = firstNumber.toDouble() + secondNumber.toDouble()
        return temp.toString()
    }
}