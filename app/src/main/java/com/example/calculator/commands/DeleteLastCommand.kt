package com.example.calculator.commands

class DeleteLastCommand {
     fun execute(str: String): String {
        return str.substring(0, str.lastIndex)
    }

}