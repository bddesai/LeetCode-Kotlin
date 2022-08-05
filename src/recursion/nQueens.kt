package recursion

import kotlin.math.abs

fun main() {
    solveNQueens(4).forEach {
        println(it)
    }
}

fun solveNQueens(n: Int): List<List<String>> {
    var result = mutableListOf<MutableList<String>>()

    solveNQueensHelper(result, mutableListOf<Int>(), n, 0)

    return result
}

fun solveNQueensHelper(
    result: MutableList<MutableList<String>>,
    slate: MutableList<Int>, N: Int, row: Int
) {

    if (isSafe(slate))
        return

    if (row == N) {
        val strResult = getStringsResult(slate, N)
        result.add(strResult)
    }

    for (col in 0 until N) {
        slate.add(col)
        solveNQueensHelper(result, slate, N, row + 1)
        slate.removeAt(slate.size - 1)
    }
}

fun getStringsResult(slate: MutableList<Int>, N: Int): MutableList<String> {
    // Debug
    // slate.forEach { print(it) }
    // print("\n")

    val result = mutableListOf<String>()

    for (queenColPos in slate) {
        var str = StringBuilder()
        for (col in 0 until N) {
            if (queenColPos != col) {
                str.append(".")
                continue
            }
            str.append("Q")
        }
        result.add(str.toString())
    }
    return result
}

fun isSafe(slate: MutableList<Int>): Boolean {

    if (slate.size < 2) return false

    var lastRowIdx = slate.size - 1

    for (currRowIdx in 0 until lastRowIdx) {

        //if place in the same column
        if (slate[currRowIdx] == slate[lastRowIdx])
            return true

        if (abs(slate[currRowIdx] - slate[lastRowIdx]) == abs(lastRowIdx - currRowIdx))
            return true
    }

    return false
}


