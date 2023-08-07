package com.example.calculator.commands

import com.example.claculator.common.Command

class DivideCommand : Command {

    override fun execute(firstNumber: String, secondNumber: String): String {
        if (secondNumber.toDouble() == 0.0)
            return "Делить на 0 нельзя!"
        return try {
            (firstNumber.toDouble() / secondNumber.toInt()).toString()
        } catch (e: Exception) {
            when (e) {
                is NumberFormatException -> "Неверный формат"
                is ArithmeticException -> "Делить на 0 нельзя!"
                else -> "Ошибка деления"
            }
        }
    }
}