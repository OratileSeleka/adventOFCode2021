package day1

import util.InputFileReader

class SonarSweeps: InputFileReader {
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
                input.map { it.toInt() }.subList(windowIndexStart, (windowIndexEnd++) + 1).sum().let { sum ->
                    prev = if(windowIndexStart++ == 0) {
                        sum
                    } else {
                        if(sum > prev) { total++ }
                        sum
                    }
                }
            } else {
                break
            }
        }
        return total
    }
}