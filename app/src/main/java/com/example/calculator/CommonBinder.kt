package com.example.claculator.common

import com.example.calculator.commands.DivideCommand
import com.example.calculator.commands.MinusCommand
import com.example.calculator.commands.MultiplyCommand
import com.example.calculator.commands.PercentCommand
import com.example.calculator.commands.PlusCommand
import kotlin.math.roundToInt

object CommonBinder {

    // Функции:
    // 1. Прогоняет присланные из MainActivity данные через условия
    // 2. При необходимости связывается с command-ами
    // 3. Записывает и хранит операнды и операторы

    private val Divide_Com = DivideCommand()
    private val Minus_Com = MinusCommand()
    private val Multiply_Com = MultiplyCommand()
    private val Percent_Com = PercentCommand()
    private val Plus_Com = PlusCommand()

    private const val PLUS = "+"
    private const val MINUS = "-"
    private const val DIVIDE = "/"
    private const val MULTIPLY = "*"
    private const val EQUALS = '='
    private const val PERCENT = '%'
    private const val ZERO = "0"
    private const val POINT = '.'


    private var first_number = String()
    private var activeCommand = String() // оператор
    private var second_number = String()
    private var pointAllowance = true // разрешение для ввода точки

    fun clickedDeleteLast(text: String): String {
        if (text.isEmpty())
            return text
        val newString = text.dropLast(1)
        if (text == activeCommand) {
            activeCommand = newString

        } else {
            if (activeCommand.isEmpty()) // значит работаем с firstNumber
                first_number = newString
            else
                second_number = newString
        }
        return newString
    }

    fun clickedTwoZeros(): String {
        if (activeCommand.isEmpty()) {
            first_number += "$ZERO$ZERO"
            return first_number

        } else {
            second_number += "$ZERO$ZERO"
            return second_number
        }
    }

    fun clickedClear(): String { // Очистка данных
        first_number = String()
        activeCommand = String()
        second_number = String()
        pointAllowance = true
        return String()
    }

    fun clickedDigit(c: Char): String { // Цифра или точка
        if (activeCommand.isEmpty()) {
            first_number += c
            return first_number

        } else {
            second_number += c
            return second_number
        }
    }

    fun clickedPercent(text: String): String {

        if (text.last().isDigit().not())
            return text

        val temp: String
        if (activeCommand.isEmpty()) { // "20%..." - ищем процент от второго числа
            temp = first_number
            first_number = Percent_Com.execute(first_number, second_number)
            activeCommand = MULTIPLY

        } else {  // "100 - 20%..."
            temp = second_number
            second_number = Percent_Com.execute(first_number, second_number)
        }
        pointAllowance = true
        return temp + PERCENT
    }

    fun clickedEquals(text: String): String { // Проверка на допустимость ввода "="
        return if (second_number.isEmpty())
            text
        else
            clickedCommand(EQUALS)
    }

    fun clickedPoint(text: String): String { // Проверка на допустимость ввода "."
       return if (text.isNotEmpty()) {
            if (pointAllowance) {
                if (text.last().isDigit()) {
                    pointAllowance = false
                    clickedDigit(POINT)
                } else
                    text
            } else
                text
        } else
            text
    }

    fun clickedCommand(c: Char): String {
        if (activeCommand.isEmpty()) {
            activeCommand = String() + c // Запись оператора
            pointAllowance = true
            return activeCommand

        } else {
            if (second_number.isEmpty()) {
                activeCommand = String() + c // Смена оператора
                return activeCommand
            }

            var temp = String()
            when (activeCommand) {
                (PLUS) -> {
                    temp = Plus_Com.execute(first_number, second_number)
                }

                (MINUS) -> {
                    temp = Minus_Com.execute(first_number, second_number)
                }

                (DIVIDE) -> {
                    temp = Divide_Com.execute(first_number, second_number)
                }

                (MULTIPLY) -> {
                    temp = Multiply_Com.execute(first_number, second_number)
                }
            }
            second_number = String()

            if (c == EQUALS) { // Если ввели команду "=" - очищаем данные
                first_number = String()
                activeCommand = String()
            } else {
                first_number = temp
                activeCommand = String() + c
            }

            temp = if (temp.endsWith(".0"))
                temp.dropLast(2)
            else
                ((temp.toDouble() * 1000).roundToInt().toDouble() / 1000).toString()
            // В строке выше не убрать какое-либо из приведений к типу - иначе неверное округление

            pointAllowance = true
            return temp
        }
    }
}