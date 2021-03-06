import java.io.File
import java.io.InputStream

fun main(args: Array<String>) {

    // Check if arguments are passed
    if (args.size == 0){
        println("I need you to give me a file name...")
    } else {
        // Read from a file and turn into a string. any txt file > allTheWords
        val inputStream: InputStream = File(args[0]).inputStream()
        val allTheWords = inputStream.bufferedReader().use { it.readText() }

        // A list of all the words separated out
        val words = allTheWords
                .replace(".","")
                .replace(",","")
                .replace("!","")
                .replace("\n"," ")
                .replace("?","")
                .replace("-","")
                .split(" ")

        // Counted list of all words
        val wordMap = mutableMapOf<String, Int>()

        for (word in words) {
            // Getting rid of empty Strings
            if (word != "") {
                if (wordMap[word.toUpperCase()] == null) {
                    wordMap[word.toUpperCase()] = 1
                } else {
                    val wordCount = wordMap[word.toUpperCase()]!!
                    wordMap[word.toUpperCase()] = wordCount + 1
                }
            }
        }
        //for (word in wordMap) {println(word)}

        val wordList = wordMap.toList()
        //println(wordList[0])
        val sortedList = wordList.sortedWith(compareBy({it.second}))
        for (word in sortedList) {println("${word.first} - ${word.second}")}
    }
}