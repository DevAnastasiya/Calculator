package com.example.calculator

class Validator {

    fun format (firstNumber: String, secondNumber: String): NumberFormatException? {
        try {
            firstNumber.toDouble() + secondNumber.toDouble()
        } catch (e: NumberFormatException) { // проверка оформления чисел
            return e
        }
        return null
    }
    fun formatFirst (firstNumber: String): NumberFormatException? {
        try {
            firstNumber.toDouble()
        } catch (e: NumberFormatException) { // проверка оформления одного числа
            return e
        }
        return null
    }

    fun divide (secondNumber: String): ArithmeticException? {
        if (secondNumber.toDouble().toInt() == 0)
            return ArithmeticException()
        return null
    }
}