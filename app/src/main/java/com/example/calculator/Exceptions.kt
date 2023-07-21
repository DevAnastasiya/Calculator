package com.example.calculator

class Exceptions {

    fun execute(firstNumber: Double, secondNumber: Double): String {
        try {
            firstNumber / secondNumber
        } catch (e: ArithmeticException) { // деление на 0

        }
        return "Деление на 0"
    }
}