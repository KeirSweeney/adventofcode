package day1

import common.LineReader
import common.MerryChristmas

class Part2 : LineReader("/day1/part2.txt"), MerryChristmas<Int> {
    override fun run(): Int {
        var result = 0
        val lines = linesAsInt()
        for(i in 2 until lines.count() - 1) {
            if (lines[i + 1] > lines[i - 2]) result++
        }
        return result
    }

}