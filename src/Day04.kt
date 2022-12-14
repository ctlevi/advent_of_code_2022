fun main() {
    fun parseElfPair(row: String): Pair<Set<Int>, Set<Int>> {
        val (first, second) = row.split(',')
        val (firstOne, firstTwo) = first.split('-')
        val firstElfRange = (firstOne.toInt()..firstTwo.toInt()).toSet()
        val (secondOne, secondTwo) = second.split('-')
        val secondElfRange = (secondOne.toInt()..secondTwo.toInt()).toSet()

        return Pair(firstElfRange, secondElfRange)
    }

    fun part1(input: List<String>): Int {
        var count = 0
        for (row in input) {
            val (firstElfRange, secondElfRange) = parseElfPair(row)
            val intersectionSize = firstElfRange.intersect(secondElfRange).size
            if (intersectionSize == firstElfRange.size || intersectionSize == secondElfRange.size) {
                count += 1
            }
        }
        return count
    }

    fun part2(input: List<String>): Int {
        var count = 0
        for (row in input) {
            val (firstElfRange, secondElfRange) = parseElfPair(row)

            val intersectionSize = firstElfRange.intersect(secondElfRange).size
            if (intersectionSize > 0) {
                count += 1
            }
        }
        return count
    }

    val testInput = readInput("Day04_test")
    val testResult = part1(testInput)
    "Test Result: ${testResult}".println()

    val input = readInput("Day04")
    "Part 1 Result: ${part1(input)}".println()
    "Part 2 Result: ${part2(input)}".println()
}
