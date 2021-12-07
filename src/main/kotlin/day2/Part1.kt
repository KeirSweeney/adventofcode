package day2

import common.LineReader
import common.MerryChristmas

class Part1 : LineReader("/day2/part1.txt"), MerryChristmas<Long> {
    override fun run(): Long {
        var xAxis = 0L
        var yAxis = 0L

        lines.forEach { line -> 
            val split = line.split(' ')
            val direction = split[0]
            val value = split[1].toLong()
            
            when (DirectionEnum.values().first { it.direction == direction }) {
                DirectionEnum.Forward -> xAxis += value
                DirectionEnum.Up -> yAxis -= value
                DirectionEnum.Down -> yAxis += value
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