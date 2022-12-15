fun main() {
    fun part1(input: List<String>): Int {
        var currentElfCalorieCount: Int = 0
        var highestCalorieCount: Int = 0
        for (row in input) {
            if (row == "") {
                if (currentElfCalorieCount > highestCalorieCount) {
                    highestCalorieCount = currentElfCalorieCount
                }
                currentElfCalorieCount = 0
            } else {
                currentElfCalorieCount += row.toInt()
            }
        }
        return highestCalorieCount;
    }

    fun tryReplaceLowestCount(toCheck: Int, counts: MutableList<Int>) {
        if (toCheck > counts.last()) {
            counts.set(counts.size - 1, toCheck)
            counts.sort()
            counts.reverse()
        }
    }

    fun part2(input: List<String>): Int {
        var currentElfCalorieCount: Int = 0
        var threeHighestCalorieCounts: MutableList<Int> = mutableListOf(0, 0, 0)
        for (row in input) {
            if (row == "") {
                tryReplaceLowestCount(currentElfCalorieCount, threeHighestCalorieCounts)
                currentElfCalorieCount = 0
            } else {
                currentElfCalorieCount += row.toInt()
            }
        }
        return threeHighestCalorieCounts.sum();
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01/test")
    val testResult = part1(testInput)
    "Test Result: ${testResult}".println()

    val input = readInput("Day01/input")
    "Part 1 Result: ${part1(input)}".println()
    "Part 2 Result: ${part2(input)}".println()
}
