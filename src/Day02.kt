enum class PlayOption {
    ROCK, PAPER, SCISSORS
}

enum class OutcomeOption {
    LOSE, DRAW, WIN
}

fun main() {
    val LOSE_SCORE = 0
    val DRAW_SCORE = 3
    val WIN_SCORE = 6
    val ROCK_SCORE = 1
    val PAPER_SCORE = 2
    val SCISSOR_SCORE = 3

    fun convertToPlayOption(option: String): PlayOption {
        return when (option) {
            "A", "X" -> PlayOption.ROCK
            "B", "Y" -> PlayOption.PAPER
            "C", "Z" -> PlayOption.SCISSORS
            else -> throw Exception("bad input: ${option}")
        }
    }

    fun convertToOutcomeOption(option: String): OutcomeOption {
        return when (option) {
            "X" -> OutcomeOption.LOSE
            "Y" -> OutcomeOption.DRAW
            "Z" -> OutcomeOption.WIN
            else -> throw Exception("bad input: ${option}")
        }
    }

    fun roundScore(opponentPlay: PlayOption, myPlay: PlayOption): Int {
        return when (opponentPlay) {
            PlayOption.ROCK -> when(myPlay) {
                PlayOption.ROCK -> ROCK_SCORE + DRAW_SCORE
                PlayOption.PAPER -> PAPER_SCORE + WIN_SCORE
                PlayOption.SCISSORS -> SCISSOR_SCORE + LOSE_SCORE
            }
            PlayOption.PAPER -> when(myPlay) {
                PlayOption.ROCK -> ROCK_SCORE + LOSE_SCORE
                PlayOption.PAPER -> PAPER_SCORE + DRAW_SCORE
                PlayOption.SCISSORS -> SCISSOR_SCORE + WIN_SCORE
            }
            PlayOption.SCISSORS -> when(myPlay) {
                PlayOption.ROCK -> ROCK_SCORE + WIN_SCORE
                PlayOption.PAPER -> PAPER_SCORE + LOSE_SCORE
                PlayOption.SCISSORS -> SCISSOR_SCORE + DRAW_SCORE
            }
        }
    }

    fun part2RoundScore(opponentPlay: PlayOption, myPlay: OutcomeOption): Int {
        return when(opponentPlay) {
            PlayOption.ROCK -> when(myPlay) {
                OutcomeOption.LOSE -> SCISSOR_SCORE + LOSE_SCORE
                OutcomeOption.DRAW -> ROCK_SCORE + DRAW_SCORE
                OutcomeOption.WIN -> PAPER_SCORE + WIN_SCORE
            }
            PlayOption.PAPER -> when(myPlay) {
                OutcomeOption.LOSE -> ROCK_SCORE + LOSE_SCORE
                OutcomeOption.DRAW -> PAPER_SCORE + DRAW_SCORE
                OutcomeOption.WIN -> SCISSOR_SCORE + WIN_SCORE
            }
            PlayOption.SCISSORS -> when(myPlay) {
                OutcomeOption.LOSE -> PAPER_SCORE + LOSE_SCORE
                OutcomeOption.DRAW -> SCISSOR_SCORE + DRAW_SCORE
                OutcomeOption.WIN -> ROCK_SCORE + WIN_SCORE
            }
        }
    }

    fun part1(input: List<String>): Int {
        val roundScores = input.map {
            val (opponentPlay, myPlay) = it.split(" ")
            roundScore(convertToPlayOption(opponentPlay), convertToPlayOption(myPlay))
        }
        return roundScores.sum();
    }

    fun part2(input: List<String>): Int {
        val roundScores = input.map {
            val (opponentPlay, myPlay) = it.split(" ")
            part2RoundScore(convertToPlayOption(opponentPlay), convertToOutcomeOption(myPlay))
        }
        return roundScores.sum();
    }

    val testInput = readInput("Day02_test")
    val testResult = part1(testInput)
    "Test Result: ${testResult}".println()

    val input = readInput("Day02")
    "Part 1 Result: ${part1(input)}".println()
    "Part 2 Result: ${part2(input)}".println()
}
