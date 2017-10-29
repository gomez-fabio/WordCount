fun main(args: Array<String>) {
    // Read from a file and turn into a string. test.txt > allTheWords
    val allTheWords="Hello there, my name is Fabio and I really like to play tennis, I'm just average player, but is important to me to improve my tennis!, so I practice a lot."

    // A list of all the words separated out
    val words = allTheWords
            .replace(".","")
            .replace(",","")
            .replace("!","")
            .split(" ")

    val wordMap = mutableMapOf<String, Int>()

    for (word in words) {
        if (wordMap[word.toUpperCase()] == null){
            wordMap[word.toUpperCase()] = 1
        } else {
            val wordCount = wordMap[word.toUpperCase()]!!
            wordMap[word.toUpperCase()] = wordCount + 1
        }
    }
    //for (word in wordMap) {println(word)}

    val wordList = wordMap.toList()
    //println(wordList[0])
    val sortedList = wordList.sortedWith(compareByDescending({it.second}))
    for (word in sortedList) {println("${word.first} - ${word.second}")}
}