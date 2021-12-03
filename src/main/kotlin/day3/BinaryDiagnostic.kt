package day3

import util.InputFileReader

class BinaryDiagnostic : InputFileReader {
    private val OXYGEN_GENERATOR_RATING = "oxygen"
    private val CO2_SCRUBBER_RATING = "co2"

    fun calculateProductOfGamaAndEpsilonRate(): Int {
        val numberOfPositions = input.first().length
        var gama = ""
        var epsilon = ""
        for (position: Int in 0 until numberOfPositions) {
            val numberOf0Bits = input.map { it[position] }.count { it == '0' }
            val numberOf1Bits = input.size - numberOf0Bits
            if (numberOf0Bits > numberOf1Bits) {
                gama += '0'
                epsilon += '1'
            } else {
                gama += '1'
                epsilon += '0'
            }
        }
        return gama.toInt(2) * epsilon.toInt(2)
    }

    fun calculateLifeSupportRatingOfSubmarine(): Int {
        return filterListByRatingType(input, 0, OXYGEN_GENERATOR_RATING).first()
            .toInt(2) * filterListByRatingType(input, 0, CO2_SCRUBBER_RATING).first().toInt(2)
    }

    private fun filterListByRatingType(list: List<String>, position: Int, ratingType: String): List<String> {
        return if (list.size == 1 || position >= input.first().length) {
            list
        } else {
            val numberOf0Bits = list.map { it[position] }.count { it == '0' }
            val numberOf1Bits = list.size - numberOf0Bits

            filterListByRatingType(
                list.filter {
                    it[position] == when {
                        numberOf0Bits > numberOf1Bits -> {
                            if (ratingType == OXYGEN_GENERATOR_RATING) '0' else '1'
                        }
                        else -> {
                            if (ratingType == OXYGEN_GENERATOR_RATING) '1' else '0'
                        }
                    }
                },
                position + 1,
                ratingType
            )
        }
    }
}