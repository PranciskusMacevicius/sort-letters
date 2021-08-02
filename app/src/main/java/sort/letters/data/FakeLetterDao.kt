package sort.letters.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class FakeLetterDao {
    private val listLetters = mutableListOf<Letter>()
    private val letters = MutableLiveData<List<Letter>>()

    init {
        letters.value = listLetters
    }

    fun addLetter(letter: Letter) {
        listLetters.add(letter)
        letters.value = listLetters
    }

    fun getLetters() = letters as LiveData<List<Letter>>
}