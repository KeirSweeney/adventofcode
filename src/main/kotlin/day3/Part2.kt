package day3

import common.LineReader
import common.MerryChristmas
import kotlin.Long

class Part2 : LineReader("/day3/part2.txt"), MerryChristmas<Int> {
    override fun run(): Int {

        var oxygen = ""
        var co2 = ""
        var mapOfBits = mutableMapOf<Long, MutableList<Long>>()

        lines.map { str -> str.chunked(1).forEachIndexed { idx, item -> mapOfBits.getOrPut(idx.toLong()) { mutableListOf() }.add(item.toLong()) } }
        
        var newList = mutableListOf<String>()
        newList.addAll(lines)
        
        val numberOfBits = lines.first().chunked(1).size
        
        for (i in 0L until numberOfBits) {
            if(newList.size == 2 || i == numberOfBits - 1L) {
                oxygen = newList[1]
                break
            }
            val result = mapOfBits[i]!!.findBitCriteria(BitCriteriaType.Oxygen)
            newList.removeAll {
                it.chunked(1)[i.toInt()].toLong() != result
            }
            mapOfBits = mutableMapOf()
            newList.map { str -> str.chunked(1).forEachIndexed { idx, item ->
                mapOfBits.getOrPut(idx.toLong()) { mutableListOf()} .add(item.toLong()) } 
            }
        }
        
        lines.map { str -> str.chunked(1).forEachIndexed { idx, item -> mapOfBits.getOrPut(idx.toLong()) { mutableListOf() }.add(item.toLong()) } }

        newList = mutableListOf()
        newList.addAll(lines)

        for (i in 0L until numberOfBits) {
            if(newList.size == 1 || i == numberOfBits - 1L) { 
                co2 = newList[0]
                break
            }
            val result = mapOfBits[i]!!.findBitCriteria(BitCriteriaType.CO2)
            newList.removeAll {
                it.chunked(1)[i.toInt()].toLong() != result
            }
            mapOfBits = mutableMapOf()
            newList.map { str -> str.chunked(1).forEachIndexed { idx, item ->
                mapOfBits.getOrPut(idx.toLong()) { mutableListOf()}.add(item.toLong()) }
            }
        }

        println(oxygen)
        println(co2)

        val oxygenToBase10 = Integer.parseInt(oxygen, 2)
        val co2ToBase10 = Integer.parseInt(co2, 2)

        println(oxygenToBase10)
        println(co2ToBase10)
        val powerConsumption = oxygenToBase10 * co2ToBase10
        println("Total power consumption = ${oxygenToBase10 * co2ToBase10}")
        return powerConsumption
    }
}

private fun MutableList<Long>.findBitCriteria(type : BitCriteriaType): Long {
    val countBits :Map<Long,  Int> = this.groupingBy { it }.eachCount()

    when (type) {
        BitCriteriaType.Oxygen -> {
            val mostCommon : Long = if (countBits.getValue(0L) == countBits.getValue(1L)) {
                1L
            } else {
                countBits.maxByOrNull { it.value }?.key!!.toLong()
            }
            return mostCommon
        }
        BitCriteriaType.CO2 -> {
            val leastCommon : Long = if (countBits.getValue(0L) == countBits.getValue(1L)) {
                0L
            } else {
                countBits.minByOrNull { it.value }?.key!!.toLong()
            }
            return leastCommon
        }
    }
}

enum class BitCriteriaType {
    CO2,
    Oxygen
}
