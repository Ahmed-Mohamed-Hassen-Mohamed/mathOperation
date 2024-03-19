import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.myapp.CalculatorModel
import com.example.myapp.CalculatorView
import com.example.myapp.R
import com.google.android.material.textfield.TextInputEditText



interface CalculatorContract {
    interface View {
        fun showResult(result: Int)
    }

    interface Presenter {
        fun sum(num1: Int, num2: Int)
        fun subtract(num1: Int, num2: Int)
    }

    interface Model {
        fun sum(num1: Int, num2: Int): Int
        fun subtract(num1: Int, num2: Int): Int
    }
}

// CalculatorModel.kt


class CalculatorModel : CalculatorContract.Model {
    override fun sum(num1: Int, num2: Int): Int {
        return num1 + num2
    }

    override fun subtract(num1: Int, num2: Int): Int {
        return num1 - num2
    }
}
class MainActivity : AppCompatActivity(), CalculatorView {

    private lateinit var presenter: CalculatorPresenter
    private lateinit var num1EditText: TextInputEditText
    private lateinit var num2EditText: TextInputEditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter = CalculatorPresenter(this, CalculatorModel())

        num1EditText = findViewById(R.id.num2EditText)
        num2EditText = findViewById(R.id.num2EditText)
        val btnSum: Button = findViewById(R.id.btnSum)
        val btnSubtract: Button = findViewById(R.id.btnSubtract
      )

        btnSum.setOnClickListener {
            val num1 = num1EditText.text.toString().toIntOrNull() ?: 0
            val num2 = num2EditText.text.toString().toIntOrNull() ?: 0
            presenter.sum(num1, num2)
        }

        btnSubtract.setOnClickListener {
            val num1 = num1EditText.text.toString().toIntOrNull() ?: 0
            val num2 = num2EditText.text.toString().toIntOrNull() ?: 0
            presenter.subtract(num1, num2)
        }
    }

    override fun showResult(result: Int) {
        val resultTextView: TextView = findViewById(R.id.resultTextView)
        resultTextView.text = "Result: $result"
    }
}
