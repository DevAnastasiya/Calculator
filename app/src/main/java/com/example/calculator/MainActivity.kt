package com.example.claculator

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.ComponentActivity
import com.example.calculator.R
import com.example.claculator.common.CommonBinder

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        // find views by id: операторы
        val btnClear: Button = findViewById(R.id.btn_clear)
        val btnDeleteLast: Button = findViewById(R.id.btn_delete_last)
        val btnPlus: Button = findViewById(R.id.btn_plus)
        val btnMinus: Button = findViewById(R.id.btn_minus)
        val btnMultiply: Button = findViewById(R.id.btn_multiply)
        val btnDivide: Button = findViewById(R.id.btn_divide)
        val btnEquals: Button = findViewById(R.id.btn_equals)
        val btnPercent: Button = findViewById(R.id.btn_percentage)
        val tv: TextView = findViewById(R.id.tv_result)

        // find views by id: числа
        val btnZero: Button = findViewById(R.id.btn_zero)
        val btnOne: Button = findViewById(R.id.btn_one)
        val btnTwo: Button = findViewById(R.id.btn_two)
        val btnThree: Button = findViewById(R.id.btn_three)
        val btnFour: Button = findViewById(R.id.btn_four)
        val btnFive: Button = findViewById(R.id.btn_five)
        val btnSix: Button = findViewById(R.id.btn_six)
        val btnSeven: Button = findViewById(R.id.btn_seven)
        val btnEight: Button = findViewById(R.id.btn_eight)
        val btnNine: Button = findViewById(R.id.btn_nine)
        val btnPoint: Button = findViewById(R.id.btn_point)
        val btnTwoZeros: Button = findViewById(R.id.btn_two_zeros)

        val binder = CommonBinder

        // ДАЛЕЕ - ИНИЦИАЛИЗАЦИЯ КНОПОЧЕК

        // 0
        btnZero.setOnClickListener {

            val str: String? = binder.clicked('0')
            tv.text = str
        }

        // 1
        btnOne.setOnClickListener {

            val str: String? = binder.clicked('1')
            tv.text = str
        }

        // 2
        btnTwo.setOnClickListener {

            val str: String? = binder.clicked('2')
            tv.text = str
        }

        // 3
        btnThree.setOnClickListener {

            binder.setReadyToClear(tv)
            val threeButton = ThreeButton(tv)
            val threeCommand = ThreeCommand(threeButton)
            threeCommand.execute()
        }

        // 4
        btnFour.setOnClickListener {

            binder.setReadyToClear(tv)
            val fourButton = FourButton(tv)
            val fourCommand = FourCommand(fourButton)
            fourCommand.execute()
        }

        // 5
        btnFive.setOnClickListener {

            binder.setReadyToClear(tv)
            val fiveButton = FiveButton(tv)
            val fiveCommand = FiveCommand(fiveButton)
            fiveCommand.execute()
        }

        // 6
        btnSix.setOnClickListener {

            binder.setReadyToClear(tv)
            val sixButton = SixButton(tv)
            val sixCommand = SixCommand(sixButton)
            sixCommand.execute()
        }

        // 7
        btnSeven.setOnClickListener {

            binder.setReadyToClear(tv)
            val sevenButton = SevenButton(tv)
            val sevenCommand = SevenCommand(sevenButton)
            sevenCommand.execute()
        }

        // 8
        btnEight.setOnClickListener {

            binder.setReadyToClear(tv)
            val eightButton = EightButton(tv)
            val eightCommand = EightCommand(eightButton)
            eightCommand.execute()
        }

        // 9
        btnNine.setOnClickListener {

            binder.setReadyToClear(tv)
            val nineButton = NineButton(tv)
            val nineCommand = NineCommand(nineButton)
            nineCommand.execute()
        }

        // 00
        btnTwoZeros.setOnClickListener {

            binder.setReadyToClear(tv)
            val twoZerosButton = TwoZerosButton(tv)
            val twoZerosCommand = TwoZerosCommand(twoZerosButton)
            twoZerosCommand.execute()
        }

        // ОПЕРАТОРЫ

        // clear
        btnClear.setOnClickListener {

            val clearButton = ClearButton(tv)
            val clearCommand = ClearCommand(clearButton)
            clearCommand.execute()
            binder.clearData()
            binder.pointAllowance = true
        }

        // delete last char
        btnDeleteLast.setOnClickListener {

            binder.setReadyToClear(tv)
            val deleteLastButton = DeleteLastButton(tv)
            val deleteLastCommand = DeleteLastCommand(deleteLastButton)
            deleteLastCommand.execute()
        }

        // точка
        btnPoint.setOnClickListener {

            binder.setReadyToClear(tv)
            val pointButton = PointButton(tv)
            val pointCommand = PointCommand(pointButton)
            pointCommand.execute()
        }

        // сложение
        btnPlus.setOnClickListener {

            binder.setReadyToClear(tv)
            val plusButton = PlusButton(tv)
            val plusCommand = PlusCommand(plusButton)
            plusCommand.execute()
        }

        // вычитание
        btnMinus.setOnClickListener {

            binder.setReadyToClear(tv)
            val minusButton = MinusButton(tv)
            val minusCommand = MinusCommand(minusButton)
            minusCommand.execute()
        }

        // умножить
        btnMultiply.setOnClickListener {

            binder.setReadyToClear(tv)
            val multiplyButton = MultiplyButton(tv)
            val multiplyCommand = MultiplyCommand(multiplyButton)
            multiplyCommand.execute()
        }

        // разделить
        btnDivide.setOnClickListener {

            binder.setReadyToClear(tv)
            val divideButton = DivideButton(tv)
            val divideCommand = DivideCommand(divideButton)
            divideCommand.execute()
        }

        // проценты
        btnPercent.setOnClickListener {

            binder.setReadyToClear(tv)
            val percentButton = PercentButton(tv)
            val percentCommand = PercentCommand(percentButton)
            percentCommand.execute()
        }

        // посчитать
        btnEquals.setOnClickListener {

            val equalsButton = EqualsButton(tv)
            val equalsCommand = EqualsCommand(equalsButton)
            equalsCommand.execute()
            binder.clearData()
            binder.readyToClear = true
            binder.pointAllowance = true
        }
    }
}