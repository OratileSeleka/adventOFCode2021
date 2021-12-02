package day2

import util.FileReader

class Dive {
    private val input by lazy { FileReader.readFile(this.javaClass.`package`.name) }
    fun calculateProductOFDepthAndPosition(): Int {
        var horizontalPosition = 0
        var depth = 0
        input.forEach {
            it.createMovementPair().let { pair ->
                if(pair.first == "forward") {
                    horizontalPosition += pair.second
                } else {
                    depth += pair.second
                }
            }
        }
        return horizontalPosition * depth
    }

    fun calculateProductOFDepthAndPositionWithAim(): Int {
        var aim = 0
        var horizontalPosition = 0
        var depth = 0

        input.forEach {
            it.createMovementPair().let { pair ->
                if(pair.first == "forward") {
                    horizontalPosition += pair.second
                    depth += (aim * pair.second)
                } else {
                    aim += pair.second
                }
            }
        }

        return horizontalPosition * depth
    }

    private fun String.createMovementPair(): Pair<String, Int> {
        this.split(' ').let {
            return Pair(it.first(), if(it.first() == "up") {
                it[1].toInt() * -1
            } else {
                it[1].toInt()
            })
        }
    }
}