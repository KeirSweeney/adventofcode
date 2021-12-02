import java.io.File
class Part2 {

    init {
        val day1Part2Input = File("day1Part2Input.txt")
        val part2Lines = day1Part2Input.readLines().map {
            it.toInt()
        }

        var result2 = 0
        for(i in 2 until part2Lines.count() - 1) {
            if (part2Lines[i + 1] > part2Lines[i - 2]) result2++
        }

        println(result2)
    }
}
