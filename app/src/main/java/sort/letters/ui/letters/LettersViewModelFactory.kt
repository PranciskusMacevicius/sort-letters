package sort.letters.ui.letters

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import sort.letters.data.LetterRepository

class LettersViewModelFactory(private val letterRepository: LetterRepository) :
    ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return LettersViewModel(letterRepository) as T
    }
}