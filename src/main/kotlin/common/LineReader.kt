package common

import java.io.File

open class LineReader(filePath : String) {
    protected val lines = this::class.java.getResource(filePath).readText().lines()
    fun LineReader.linesAsInt(): List<Int> {
        return lines.map { it.toInt() }
    }
}