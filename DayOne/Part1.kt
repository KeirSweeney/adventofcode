import java.io.File
class Part1 {

    init {
        val day1Part1Input = File("day1Part1Input.txt")
        val part1Lines = day1Part1Input.readLines().map { 
            it.toInt()
        }

        var result = 0
        part1Lines.reduce { prev, curr ->  if (curr > prev) result++; curr }
        println(result)        
    }
}
