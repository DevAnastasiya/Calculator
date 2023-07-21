package com.example.claculator.common

interface Command {

    fun execute(firstNumber: String, secondNumber: String) : String
}