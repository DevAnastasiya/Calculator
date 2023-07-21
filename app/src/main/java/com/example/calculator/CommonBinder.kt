package com.example.claculator.common

import com.example.calculator.commands.ClearCommand
import com.example.calculator.commands.DeleteLastCommand
import com.example.calculator.commands.DivideCommand
import com.example.calculator.commands.MinusCommand
import com.example.calculator.commands.MultiplyCommand
import com.example.calculator.commands.PercentCommand
import com.example.calculator.commands.PlusCommand
import com.example.calculator.commands.TwoZerosCommand
import com.example.calculator.commands.ZeroCommand

object CommonBinder {

    // Функции:
    // 1. Прогоняет присланные из MainActivity данные через условия
    // 2. При необходимости связывается с command-ами
    // 3. Записывает и хранит операнды и операторы

    private val clearCom = ClearCommand()
    private val deleteCom = DeleteLastCommand()
    private val divideCom = DivideCommand()
    private val minusCom = MinusCommand()
    private val multiplyCom = MultiplyCommand()
    private val percentCom = PercentCommand()
    private val plusCom = PlusCommand()
    private val zeroCom = ZeroCommand()

    private val plus = "+"
    private val minus = "-"
    private val divide = "/"
    private val multiply = "*"
    private val point = "."
    private val equals = "="
    private val percent = "%"
    private val twoZeros = 'z'
    private val zero = "0"

    private var first_number = String()
    private var activeCommand = String() // оператор
    private var second_number = String()

    var readyToClear = false
    var pointAllowance = true

    fun clicked(str: String): String { // Для clear, deleteLast
        if (str.isEmpty()) {
            first_number = String()
            activeCommand = String()
            second_number = String()
            return clearCom.execute()
        } else {
            if (str == activeCommand) {
                activeCommand = String()
            }
            if (str == first_number) { // значит работает с firstNumber
                first_number = deleteCom.execute(str)
            } else {
                second_number = deleteCom.execute(str)
            }
            return deleteCom.execute(str)
        }
    }

    fun clicked(c: Char): String {
        if (activeCommand.isEmpty()) {
            if (c.isDigit() ||
                c.toString() == point
            ) { // Запись первого числа
                if (c == twoZeros)
                    first_number += zero + zero
                else
                    first_number += c
                return first_number
            } else {
                if (c.toString() == percent) { // "20%..."
                    first_number = (first_number.toDouble() / 100).toString()
                    activeCommand = multiply
                    return first_number
                }
                activeCommand = String() + c // Запись оператора
                return activeCommand
            }
        } else {
            if (c.isDigit() ||
                c.toString() == point
            ) { // Запись второго числа
                if (c == twoZeros)
                    second_number += zero + zero
                else
                    second_number += c
                return second_number
            } else {
                if (second_number.isEmpty()) { // Смена оператора
                    activeCommand = String() + c
                    return activeCommand
                }
                if (c.toString() == percent) { // 100 - 20%...
                    second_number = (
                            first_number.toDouble() / 100 * second_number.toDouble()).toString()
                }

                var temp = String()
                when (activeCommand) {
                    (plus) -> {
                        temp = plusCom.execute(first_number, second_number)
                    }

                    (minus) -> {
                        temp = minusCom.execute(first_number, second_number)
                    }

                    (divide) -> {
                        temp = divideCom.execute(first_number, second_number)
                    }

                    (multiply) -> {
                        temp = multiplyCom.execute(first_number, second_number)
                    }
                }
                second_number = String()

                if (c.toString() == equals) { // Если ввели команду "=" - очищаем данные
                    first_number = String()
                    activeCommand = String()
                } else {
                    first_number = temp
                    activeCommand = String() + c
                }
                if (temp.endsWith(".0"))
                    temp = temp.toDouble().toInt().toString()
                return temp
            }
        }
    }
}