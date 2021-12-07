package day3

import common.LineReader
import common.MerryChristmas

class Part1 : LineReader("/day3/part1.txt"), MerryChristmas<Int> {
    override fun run(): Int {
        
        var gammaRate = ""
        var epsilonRate = ""
        val mapOfBits = mutableMapOf<Long, MutableList<Long>>()
        lines.map { str -> 
            val split = str.chunked(1)
            split.forEachIndexed { idx, item ->
                val listOfBitsByIndex  = mapOfBits.getOrPut(idx.toLong()) { mutableListOf() }
                listOfBitsByIndex.add(item.toLong())
            }
        }
        
        mapOfBits.forEach { (bitIndex, listOfBits) -> 
            val mostCommon = listOfBits.groupingBy { it }.eachCount().maxByOrNull { it.value }?.key
            val leastCommon = listOfBits.groupingBy { it }.eachCount().minByOrNull { it.value }?.key
            gammaRate += mostCommon.toString()
            epsilonRate += leastCommon
        }
        
        println(gammaRate)
        println(epsilonRate)
        
        val gammaRateToBase10 = Integer.parseInt(gammaRate, 2);
        val epsilonRateToBase10 = Integer.parseInt(epsilonRate, 2);

        println(gammaRateToBase10)
        println(epsilonRateToBase10)
        val powerConsumption = gammaRateToBase10 * epsilonRateToBase10
        println("Total power consuption = ${gammaRateToBase10 * epsilonRateToBase10}")
        return powerConsumption
    }
}