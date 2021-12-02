import day1.SonarSweeps
import day2.Dive

fun main(args: Array<String>) {
    val dive = Dive()
    val sweeps = SonarSweeps()
    println("Total is: ${sweeps.numberOfTimesDepthMeasurementIncreases()}")
    println("Total is: ${dive.calculateProductOFDepthAndPositionWithAim()}")
}