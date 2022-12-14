fun main() {
    fun part1(input: List<String>): Int {
        return input.map { row ->
            val first = row.toList().subList(0, row.length / 2).toSet()
            val second = row.toList().subList(row.length / 2, row.length).toSet()

            val overlappingChar = first.intersect(second).first()

            if (overlappingChar in 'a'..'z') {
                overlappingChar.code - 96
            } else {
                overlappingChar.code - 64 + 26
            }
        }.sum()
    }

    fun part2(input: List<String>): Int {
        return input.chunked(3).map {
            val first = it[0].toSet()
            val second = it[1].toSet()
            val third = it[2].toSet()
            val overlappingChar = first.intersect(second).intersect(third).first()

            if (overlappingChar in 'a'..'z') {
                overlappingChar.code - 96
            } else {
                overlappingChar.code - 64 + 26
            }
        }.sum()
    }

    val testInput = readInput("Day03_test")
    val testResult = part1(testInput)
    "Test Result: ${testResult}".println()

    val input = readInput("Day03")
    "Part 1 Result: ${part1(input)}".println()
    "Part 2 Result: ${part2(input)}".println()
}
