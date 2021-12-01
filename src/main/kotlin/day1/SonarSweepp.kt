package day1

import util.FileReader

class SonarSweepp {
    private val input by lazy { FileReader.readFile(this.javaClass, "Input.txt") }
    fun numberOfTimesDepthMeasurementIncreases() : Int {
        var total = 0
        var prev = -1
        input.forEachIndexed { index, input ->
            if(index != 0) {
                input.toInt().let {
                    if(it > prev) { total++ }
                    prev = it
                }
            }
        }
        return total
    }

    fun numberOfTimesDepthMeasurementIncreasesWithWindows() : Int {
        var total = 0
        var prev = -1
        var windowIndexStart = 0
        var windowIndexEnd = 2
        while (true) {
            if(windowIndexEnd < input.size) {
                input.map { it.toInt() }.subList(windowIndexStart, (windowIndexEnd++)+ 1).sum().let {
                    prev = if(windowIndexStart++ == 0) {
                        println("$it n/a")
                        it
                    } else {
                        if(it > prev) {
                            println("$it increase")
                            total++
                        } else {
                            println("$it decrease")
                        }
                        it
                    }
                }
            } else {
                break
            }
        }
        return total
    }
}