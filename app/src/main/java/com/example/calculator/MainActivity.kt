package com.example.claculator

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.ComponentActivity
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

            val str: String = binder.clicked('1')
            tv.text = str
        }

        // 2
        btnTwo.setOnClickListener {

            val str: String = binder.clicked('2')
            tv.text = str
        }
//
//        // 3
        btnThree.setOnClickListener {

            val str: String = binder.clicked('3')
            tv.text = str
        }
//
//        // 4
        btnFour.setOnClickListener {

            val str: String = binder.clicked('4')
            tv.text = str
        }
//
//        // 5
        btnFive.setOnClickListener {

            val str: String = binder.clicked('5')
            tv.text = str
        }
//
//        // 6
        btnSix.setOnClickListener {

            val str: String = binder.clicked('6')
            tv.text = str
        }
//
//        // 7
        btnSeven.setOnClickListener {

            val str: String = binder.clicked('7')
            tv.text = str
        }
//
//        // 8
        btnEight.setOnClickListener {

            val str: String = binder.clicked('8')
            tv.text = str
        }
//
//        // 9
        btnNine.setOnClickListener {

            val str: String = binder.clicked('9')
            tv.text = str
        }
//
//        // 00
//        btnTwoZeros.setOnClickListener {
//
//            val str: String? = binder.clicked("00")
//            tv.text = str
//        }

        // ОПЕРАТОРЫ

        // clear
//        btnClear.setOnClickListener {
//
//            val clearButton = ClearButton(tv)
//            val clearCommand = ClearCommand(clearButton)
//            clearCommand.execute()
//            binder.clearData()
//            binder.pointAllowance = true
//        }
//
//        // delete last char
//        btnDeleteLast.setOnClickListener {
//
//            binder.setReadyToClear(tv)
//            val deleteLastButton = DeleteLastButton(tv)
//            val deleteLastCommand = DeleteLastCommand(deleteLastButton)
//            deleteLastCommand.execute()
//        }
//
//        // точка
//        btnPoint.setOnClickListener {
//
//            binder.setReadyToClear(tv)
//            val pointButton = PointButton(tv)
//            val pointCommand = PointCommand(pointButton)
//            pointCommand.execute()
//        }

        // сложение
        btnPlus.setOnClickListener {

            val str: String = binder.clicked('+')
            tv.text = str
            tv.maxLines = 1
        }

        // вычитание
        btnMinus.setOnClickListener {

            val str: String = binder.clicked('-')
            tv.text = str
            tv.maxLines = 1
        }
//
//        // умножить
        btnMultiply.setOnClickListener {

            val str: String = binder.clicked('*')
            tv.text = str
            tv.maxLines = 1
        }
//
//        // разделить
        btnDivide.setOnClickListener {

            val str: String = binder.clicked('/')
            tv.text = str
            tv.maxLines = 1 // Проблема с исключениями
        }
//
//        // проценты
//        btnPercent.setOnClickListener {
//
//            binder.setReadyToClear(tv)
//            val percentButton = PercentButton(tv)
//            val percentCommand = PercentCommand(percentButton)
//            percentCommand.execute()
//        }

        // посчитать
        btnEquals.setOnClickListener {

            val str: String = binder.clicked('=')
            tv.text = str
            tv.maxLines = 1
        }
    }
}