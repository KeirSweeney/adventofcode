package day1

import common.LineReader
import common.MerryChristmas

class Part1 : LineReader("/day1/part1.txt"), MerryChristmas<Int> {
    override fun run() : Int {
        var result = 0
        return linesAsInt().reduce {  prev, curr ->  if (curr > prev) result++; curr }
    }
}