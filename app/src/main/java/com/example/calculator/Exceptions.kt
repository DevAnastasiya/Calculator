package com.example.calculator

class Exceptions {

    fun format (firstNumber: String, secondNumber: String): String {
        try {
            firstNumber.toDouble()
            secondNumber.toDouble()
        } catch (e: NumberFormatException) { // проверка оформления чисел
            return "Неверный формат"
        }
        return String()
    }
    fun formatFirst (firstNumber: String): String {
        try {
            firstNumber.toDouble()
        } catch (e: NumberFormatException) { // проверка оформления чисел
            return "Неверный формат"
        }
        return String()
    }

    fun divide (firstNumber: String, secondNumber: String): String {
        try {
            firstNumber.toDouble() / secondNumber.toDouble()
        } catch (e: ArithmeticException) { // деление на 0
            return "Деление на 0"
        }
        return String()
    }
}