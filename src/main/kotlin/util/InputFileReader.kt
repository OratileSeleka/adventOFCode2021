package util

interface InputFileReader {
    val input: List<String>
        get() = FileReader.readFile(this.javaClass.`package`.name)
}