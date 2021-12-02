package util

import java.io.File

class FileReader {
    companion object {
        fun readFile(packageName: String) : List<String> = File("src\\main\\kotlin\\$packageName\\Input.txt").readLines()
    }
}