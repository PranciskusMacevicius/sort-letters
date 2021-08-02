package sort.letters.data

class Letters {
    var list = listOf(
        "A",
        "B",
        "C",
        "D",
        "E",
        "F",
        "G",
        "H",
        "I",
        "J",
        "K",
        "L",
        "M",
        "N",
        "O",
        "P",
        "Q",
        "R",
        "S",
        "T",
        "U",
        "V",
        "W",
        "Z"
    )
    var listSelected = mutableListOf<String>()
    fun listLetters(times: Int): MutableList<String> {
        repeat(times) {
            listSelected.add(list.random())
        }

        return listSelected
    }
}
