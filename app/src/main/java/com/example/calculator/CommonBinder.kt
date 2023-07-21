package com.example.claculator.common

import android.widget.TextView
import com.example.calculator.commands.ClearCommand
import com.example.calculator.commands.DeleteLastCommand
import com.example.calculator.commands.DigitCommand
import com.example.calculator.commands.DivideCommand
import com.example.calculator.commands.EqualsCommand
import com.example.calculator.commands.MinusCommand
import com.example.calculator.commands.MultiplyCommand
import com.example.calculator.commands.PercentCommand
import com.example.calculator.commands.PlusCommand
import com.example.calculator.commands.PointCommand
import com.example.calculator.commands.TwoZerosCommand
import com.example.calculator.commands.ZeroCommand

object CommonBinder {

    private val clearCom = ClearCommand()
    private val deleteCom = DeleteLastCommand()
    private val digitCom = DigitCommand()
    private val divideCom = DivideCommand()
    private val equalsCom = EqualsCommand()
    private val minusCom = MinusCommand()
    private val multiplyCom = MultiplyCommand()
    private val percentCom = PercentCommand()
    private val plusCom = PlusCommand()
    private val pointCom = PointCommand()
    private val twoZerosCom = TwoZerosCommand()
    private val zeroCom = ZeroCommand()

    private val plus = '+'
    private val minus = '-'
    private val divide = '/'
    private val multiply = '*'
    private val point = '.'
    private val equals = '='

    private var first_number = String()
    private var activeCommand = String()
    private var second_number = String()
    private var result = String
    var readyToClear = false
    var pointAllowance = true

    fun clicked(c: Char): String? {
        if (activeCommand.isEmpty()) { // Запись первого числа ИЛИ оператора
            if (c.isDigit()) {
                first_number += c
                return first_number
            } else {
                activeCommand = String() + c
                return activeCommand
            }
        } else { // Запись второго числа ИЛИ оператора ИЛИ вызов команды
            if (c.isDigit()) {
                second_number += c
                return second_number
            } else {
                if (second_number.isEmpty()) { // меняем оператор
                    activeCommand = String() + c
                    return activeCommand
                }
                when (c) {
                    (equals) -> equalsCom.execute()
                    ()
                    else -> {

                    }
                }
            }
        }

        fun getFirstNumber(): String {
            return first_number
        }

        fun setFirstNumber(number: String) {
            this.first_number = number
        }

        fun getSecondNumber(): String {
            return second_number
        }

        fun setSecondNumber(number: String) {
            this.second_number = number
        }

        fun getOperator(): String {
            return activeCommand
        }

        fun setOperator(operator: String) {
            this.activeCommand = operator
        }

        fun getResult(): String {
            return result
        }

        fun setResult(number: String) {
            this.result = number
        }

        fun clearData() {
            this.first_number = String()
            this.second_number = String()
            this.result = String()
            this.activeCommand = String()
        }

        fun setReadyToClear(tv: TextView) {
            if (readyToClear) {
                tv.text = String()
                readyToClear = false
            }
        }
    }