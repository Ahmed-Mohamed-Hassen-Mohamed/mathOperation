//import com.example.calculatorapp.mvp.CalculatorModel
//import com.example.calculatorapp.mvp.CalculatorView


import com.example.myapp.CalculatorModel
import com.example.myapp.CalculatorView


class CalculatorPresenter(private val view: CalculatorView, private val model: CalculatorModel) {
    fun sum(num1: Int, num2: Int) {
        val result = model.sum(num1, num2)
        view.showResult(result)
    }

    fun subtract(num1: Int, num2: Int) {
        val result = model.subtract(num1, num2)
        view.showResult(result)
    }
}
