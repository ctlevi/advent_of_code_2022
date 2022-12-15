data class Move(val amount: Int, val from: Int, val to: Int)

fun main() {
    fun parseInput(input: List<String>): Pair<List<MutableList<Char>>, List<Move>> {
        val blankLineIndex = input.indexOf("")

        val paletCountIndex = blankLineIndex - 1
        val paletCount = input[paletCountIndex].last().digitToInt()
        val paletStacks = List(paletCount, { mutableListOf<Char>() })
        for (i in 0 until paletCountIndex) {
            val crateRow = input[i]
            for (paletStackIndex in 0 until paletCount) {
                val crateCharPosition = paletStackIndex + 1 + (paletStackIndex * 3)
                if (crateCharPosition < crateRow.length && crateRow[crateCharPosition] != ' ') {
                    paletStacks[paletStackIndex].add(0, crateRow[crateCharPosition])
                }
            }
        }

        val movesIndex = blankLineIndex + 1
        val moves = (movesIndex until input.size).map {
            val split = input[it].split(" ")
            Move(amount = split[1].toInt(), from = split[3].toInt(), to = split[5].toInt())
        }

        return Pair(paletStacks, moves);
    }


    fun part1(input: List<String>): String {
        val (paletStacks, moves) = parseInput(input)
        for (move in moves) {
            repeat(move.amount) {
                val fromStack = paletStacks[move.from - 1]
                val toStack = paletStacks[move.to - 1]
                val last = fromStack.removeLast()
                toStack.add(last)
            }
        }

        val topStacks = paletStacks.joinToString("") {
            it.last().toString()
        }

        return topStacks
    }

    fun part2(input: List<String>): String {
        val (paletStacks, moves) = parseInput(input)
        for (move in moves) {
            val fromStack = paletStacks[move.from - 1]
            val toStack = paletStacks[move.to - 1]

            val moved = (0 until move.amount).map { fromStack.removeLast() }.reversed()
            toStack.addAll(moved)
        }

        val topStacks = paletStacks.joinToString("") {
            it.last().toString()
        }

        return topStacks
    }

    val testInput = readInput("Day05/test")
    val testResult = part1(testInput)
    "Test Result: ${testResult}".println()

    val input = readInput("Day05/input")
    "Part 1 Result: ${part1(input)}".println()
    "Part 2 Result: ${part2(input)}".println()
}
