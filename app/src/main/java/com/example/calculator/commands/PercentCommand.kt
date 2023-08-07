package com.example.calculator.commands

import com.example.claculator.common.Command

class PercentCommand : Command {

    override fun execute(firstNumber: String, secondNumber: String): String {

        if (secondNumber.isEmpty()) { // "20%..." - ищем процент от второго числа
            return try {
                (firstNumber.toDouble() / 100).toString()
            } catch (e: Exception) {
                when (e) {
                    is NumberFormatException -> "Неверный формат"
                    else -> "Ошибка операции с %"
                }
            }
        } else {
            return try {
                val temp = firstNumber.toDouble() / 100 * secondNumber.toDouble()
                temp.toString()
            } catch (e: Exception) {
                when (e) {
                    is NumberFormatException -> "Неверный формат"
                    else -> "Ошибка операции с %"
                }
            }
        }
    }
}