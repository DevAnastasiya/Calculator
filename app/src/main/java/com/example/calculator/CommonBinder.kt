package com.example.claculator.common

import com.example.calculator.commands.ClearCommand
import com.example.calculator.commands.DeleteLastCommand
import com.example.calculator.commands.DivideCommand
import com.example.calculator.commands.MinusCommand
import com.example.calculator.commands.MultiplyCommand
import com.example.calculator.commands.PercentCommand
import com.example.calculator.commands.PlusCommand
import com.example.calculator.commands.PointCommand
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
    private val pointCom = PointCommand()
    private val twoZerosCom = TwoZerosCommand()
    private val zeroCom = ZeroCommand()

    private val plus = "+"
    private val minus = "-"
    private val divide = "/"
    private val multiply = "*"
    private val point = "."
    private val equals = "="
    private val percent = "%"
    private val twoZeros = "00"
    private val zero = "0"

    private var first_number = String()
    private var activeCommand = String()
    private var second_number = String()

    // private var result = String
    var readyToClear = false
    var pointAllowance = true

    fun clicked(str: String): String { // Для clear, deleteLast
        if (str.isEmpty()) {
            return clearCom.execute()
        } else
            return deleteCom.execute(str)
    }

    fun clicked(c: Char): String {
        if (activeCommand.isEmpty()) {
            if (c.isDigit() ||
                c.toString() == point
            ) { // Запись первого числа
                first_number += c
                return first_number
            } else {
                activeCommand = String() + c // Запись оператора
                return activeCommand
            }
        } else {
            if (c.isDigit() ||
                c.toString() == point
            ) { // Запись второго числа
                second_number += c
                return second_number
            } else {
                if (second_number.isEmpty()) { // Смена оператора
                    activeCommand = String() + c
                    return activeCommand
                }
                var temp = String()
                when (activeCommand) { // ДОБАВИТЬ ПРОЦЕНТЫ!!
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
//
//    fun getFirstNumber(): String {
//        return first_number
//    }
//
//    fun setFirstNumber(number: String) {
//        this.first_number = number
//    }
//
//    fun getSecondNumber(): String {
//        return second_number
//    }
//
//    fun setSecondNumber(number: String) {
//        this.second_number = number
//    }
//
//    fun getOperator(): String {
//        return activeCommand
//    }
//
//    fun setOperator(operator: String) {
//        this.activeCommand = operator
//    }

//    fun getResult(): String {
//        return result
//    }
//
//    fun setResult(number: String) {
//        this.result = number
//    }
//
//    fun clearData() {
//        this.first_number = String()
//        this.second_number = String()
//        //this.result = String()
//        this.activeCommand = String()
//    }
//
//    fun setReadyToClear(tv: TextView) {
//        if (readyToClear) {
//            tv.text = String()
//            readyToClear = false
//        }
//    }
}