package sort.letters.ui.letters

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import io.reactivex.Observable
import sort.letters.data.Letter
import sort.letters.data.Letters
import sort.letters.databinding.ActivityLettersBinding
import sort.letters.utilities.InjectorUtils

class LettersActivity : AppCompatActivity() {
    private val letters = Letters()

    var times = 5
    var listLetters = letters.listLetters(times)
    var solution = listLetters.sorted().toMutableList()

    var countUIEvents = 0

    lateinit var binding: ActivityLettersBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLettersBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        initializeUi()
    }

    @SuppressLint("CheckResult")
    private fun initializeUi() {
        val factory = InjectorUtils.provideLettersViewModelFactory()
        val viewModel = ViewModelProvider(this, factory)
            .get(LettersViewModel::class.java)

        viewModel.getLetters().observe(this, { letters ->
            if (countUIEvents < 6) {
                var lastIndex = 0

                repeat(letters.size) {
                    val textViewId = "editTextTextPersonName${lastIndex + 1}"
                    val resId = resources.getIdentifier(textViewId, "id", packageName)
                    val editTextTextPersonName = findViewById<View>(resId) as EditText

                    editTextTextPersonName.setText(letters[lastIndex].toString())

                    if (letters.size > 4) {
                        val lettersToList: List<String> = letters.map { it.letter }
                        val lettersToMutableList = lettersToList.toMutableList()

                        if (lettersToMutableList == solution) {
                            binding.textView.text = ("Correct")
                        } else {
                            binding.textView.text = ("Wrong")
                        }
                    }

                    lastIndex++
                }
                Observable.just("This is UI event")
                    .subscribe { value -> println(value) }
                countUIEvents++
            }
        })

        var lastIndex = 1

        repeat(times) {
            val textViewId = "textView${lastIndex}"
            val resId = resources.getIdentifier(textViewId, "id", packageName)
            val textView = findViewById<View>(resId) as TextView
            textView.text = listLetters[lastIndex - 1]
            textView.setOnClickListener {
                val letter = Letter(textView.text.toString())
                viewModel.addLetter(letter)
            }

            lastIndex++
        }
    }
}