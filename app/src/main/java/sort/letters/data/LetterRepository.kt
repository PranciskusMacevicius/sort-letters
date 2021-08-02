package sort.letters.data

class LetterRepository private constructor(private val letterDao: FakeLetterDao) {

    fun addLetter(letter: Letter) {
        letterDao.addLetter(letter)
    }

    fun getLetters() = letterDao.getLetters()

    companion object {
        @Volatile
        private var instance: LetterRepository? = null
        fun getInstance(letterDao: FakeLetterDao) =
            instance ?: synchronized(this) {
                instance ?: LetterRepository(letterDao).also { instance = it }
            }
    }
}