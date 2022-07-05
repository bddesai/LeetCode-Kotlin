package basics

fun main() {
    val grid1: Array<IntArray> = arrayOf(
        intArrayOf(1, 3, 1),
        intArrayOf(1, 5, 1),
        intArrayOf(4, 2, 1)
    )

    println(pathSum(grid1))
}

fun pathSum(grid: Array<IntArray>): Int {
    val m = grid.size
    val n = grid[0].size
    val table = Array(m) { IntArray(n) }
    table[0][0] = grid[0][0]

    for (i in 1 until m) {
        table[i][0] = grid[i][0] + table[i - 1][0]
    }

    for (j in 1 until n) {
        table[0][j] = grid[0][j] + table[0][j - 1]
    }

    for (row in 1 until m) {
        for (col in 1 until n) {
            table[row][col] = grid[row][col] +
                    Math.max(table[row - 1][col], table[row][col - 1])
        }
    }

    return table[m - 1][n - 1]
}
//time = O(m * n)
//space = O(m * n)