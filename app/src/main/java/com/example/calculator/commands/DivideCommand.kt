package com.example.calculator.commands

import com.example.calculator.Validator
import com.example.claculator.common.Command

class DivideCommand : Command {

    private val Validator = Validator()

    override fun execute(firstNumber: String, secondNumber: String): String {

        if (Validator.format(firstNumber, secondNumber) is NumberFormatException)
            return "Неверный формат"
        // Увы, не совсем поняла как в идеале "ловить" ошибку из Валидатора...
        return if (Validator.divide(secondNumber) is ArithmeticException)
            "Деление на 0"
        else
            (firstNumber.toDouble() / secondNumber.toDouble()).toString()
    }
}