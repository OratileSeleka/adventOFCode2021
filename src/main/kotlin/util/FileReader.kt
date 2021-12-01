package util

import java.io.File

class FileReader {
    companion object {
        fun readFile(clazz: Class<Any>,fileName: String) : List<String> = File("src\\main\\kotlin\\${clazz.`package`.name}\\$fileName").readLines()
    }
}