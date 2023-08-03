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

    private val divideCom = DivideCommand()
    private val minusCom = MinusCommand()
    private val multiplyCom = MultiplyCommand()
    private val percentCom = PercentCommand()
    private val plusCom = PlusCommand()

    private const val PLUS = "+"
    private const val MINUS = "-"
    private const val DIVIDE = "/"
    private const val MULTIPLY = "*"
    private const val EQUALS = '='
    private const val PERCENT = '%'
    private const val ZERO = "0"
    private const val POINT = '.'


    private var firstNumber = String()
    private var activeCommand = String() // оператор
    private var secondNumber = String()
    private var pointAllowance = true // разрешение для ввода точки

    fun clickedDeleteLast(text: String): String {
        if (text.isEmpty())
            return text

        val newString = text.dropLast(1)

        if (text.last() == POINT) // Удаляем точку
            pointAllowance = true

        if (text == activeCommand) { // Удаляем оператор
            activeCommand = newString
        } else {
            if (activeCommand.isEmpty()) // значит работаем с firstNumber
                firstNumber = newString
            else
                secondNumber = newString
        }
        return newString
    }

    fun clickedTwoZeros(): String {
        if (activeCommand.isEmpty()) {
            firstNumber += "$ZERO$ZERO"
            return firstNumber

        } else {
            secondNumber += "$ZERO$ZERO"
            return secondNumber
        }
    }

    fun clickedClear(): String { // Очистка данных
        firstNumber = String()
        activeCommand = String()
        secondNumber = String()
        pointAllowance = true
        return String()
    }

    fun clickedDigit(c: Char): String { // Цифра или точка
        if (activeCommand.isEmpty()) {
            firstNumber += c
            return firstNumber

        } else {
            secondNumber += c
            return secondNumber
        }
    }

    fun clickedPercent(text: String): String {

        if (text.last().isDigit().not())
            return text

        val temp: String
        if (activeCommand.isEmpty()) { // "20%..." - ищем процент от второго числа
            temp = firstNumber
            firstNumber = percentCom.execute(firstNumber, secondNumber)
            activeCommand = MULTIPLY

        } else {  // "100 - 20%..."
            temp = secondNumber
            secondNumber = percentCom.execute(firstNumber, secondNumber)
        }
        pointAllowance = true
        return temp + PERCENT
    }

    fun clickedEquals(text: String): String { // Проверка на допустимость ввода "="
        return if (secondNumber.isEmpty())
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
            activeCommand = c.toString() // Запись оператора
            pointAllowance = true
            return activeCommand

        } else {
            if (secondNumber.isEmpty()) {
                activeCommand = c.toString()  // Смена оператора
                return activeCommand
            }

            var temp = String()
            when (activeCommand) {
                (PLUS) -> {
                    temp = plusCom.execute(firstNumber, secondNumber)
                }

                (MINUS) -> {
                    temp = minusCom.execute(firstNumber, secondNumber)
                }

                (DIVIDE) -> {
                    temp = divideCom.execute(firstNumber, secondNumber)
                }

                (MULTIPLY) -> {
                    temp = multiplyCom.execute(firstNumber, secondNumber)
                }
            }
            secondNumber = String()

            if (c == EQUALS) { // Если ввели команду "=" - очищаем данные
                firstNumber = String()
                activeCommand = String()
            } else {
                firstNumber = temp
                activeCommand = c.toString()
            }

            try {
                temp.toDouble()
            } catch (e: Exception) {
                return temp
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