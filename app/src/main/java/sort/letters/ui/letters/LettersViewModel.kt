package sort.letters.ui.letters

import androidx.lifecycle.ViewModel
import sort.letters.data.Letter
import sort.letters.data.LetterRepository;

class LettersViewModel(private val letterRepository: LetterRepository) : ViewModel() {

    fun getLetters() = letterRepository.getLetters()

    fun addLetter(letter: Letter) = letterRepository.addLetter(letter)
}
