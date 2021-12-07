package day2

import common.LineReader
import common.MerryChristmas

class Part2 : LineReader("/day2/part2.txt"), MerryChristmas<Long> {
    override fun run(): Long {
        var xAxis = 0L
        var yAxis = 0L
        var aim = 0L

        lines.forEach { line ->
            val split = line.split(' ')
            val direction = split[0]
            val value = split[1].toLong()

            when (DirectionEnum.values().first { it.direction == direction }) {
                DirectionEnum.Forward -> {
                    xAxis += value
                    yAxis += (value * aim)
                }
                DirectionEnum.Up -> aim -= value
                DirectionEnum.Down -> aim += value
            }
        }

        return xAxis * yAxis
    }

    enum class DirectionEnum(val direction: String) {
        Forward("forward"),
        Up("up"),
        Down("down")
    }
}