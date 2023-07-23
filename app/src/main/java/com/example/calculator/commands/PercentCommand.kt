package com.example.calculator.commands

import com.example.calculator.Validator
import com.example.claculator.common.Command

class PercentCommand : Command {

    private val Validator = Validator()

    override fun execute(firstNumber: String, secondNumber: String): String {

        if (secondNumber.isEmpty()) { // "20%..." - ищем процент от второго числа
            return if (Validator.formatFirst(firstNumber) is NumberFormatException)
                "Неверный формат"
            else
                (firstNumber.toDouble() / 100).toString()
        } else {
            return if (Validator.format(firstNumber, secondNumber) is NumberFormatException)
                "Неверный формат"
            else { // находим значение второго числа
                val temp = firstNumber.toDouble() / 100 * secondNumber.toDouble()
                temp.toString()
            }
        }
    }
}