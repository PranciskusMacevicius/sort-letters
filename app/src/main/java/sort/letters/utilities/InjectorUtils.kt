package sort.letters.utilities

import sort.letters.data.FakeDatabase
import sort.letters.data.LetterRepository
import sort.letters.ui.letters.LettersViewModelFactory


object InjectorUtils {


    fun provideLettersViewModelFactory(): LettersViewModelFactory {


        val letterRepository = LetterRepository.getInstance(FakeDatabase.getInstance().letterDao)
        return LettersViewModelFactory(letterRepository)
    }
}