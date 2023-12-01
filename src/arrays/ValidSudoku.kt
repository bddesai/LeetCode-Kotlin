package arrays

// link: https://leetcode.com/problems/valid-sudoku/description/
fun main() {
    val board1 = arrayOf(
        charArrayOf('5', '3', '.', '.', '7', '.', '.', '.', '.'),
        charArrayOf('6', '.', '.', '1', '9', '5', '.', '.', '.'),
        charArrayOf('.', '9', '8', '.', '.', '.', '.', '6', '.'),
        charArrayOf('8', '.', '.', '.', '6', '.', '.', '.', '3'),
        charArrayOf('4', '.', '.', '8', '.', '3', '.', '.', '1'),
        charArrayOf('7', '.', '.', '.', '2', '.', '.', '.', '6'),
        charArrayOf('.', '6', '.', '.', '.', '.', '2', '8', '.'),
        charArrayOf('.', '.', '.', '4', '1', '9', '.', '.', '5'),
        charArrayOf('.', '.', '.', '.', '8', '.', '.', '7', '9')
    )

    val board2 = arrayOf(
        charArrayOf('8', '3', '.', '.', '7', '.', '.', '.', '.'),
        charArrayOf('6', '.', '.', '1', '9', '5', '.', '.', '.'),
        charArrayOf('.', '9', '8', '.', '.', '.', '.', '6', '.'),
        charArrayOf('8', '.', '.', '.', '6', '.', '.', '.', '3'),
        charArrayOf('4', '.', '.', '8', '.', '3', '.', '.', '1'),
        charArrayOf('7', '.', '.', '.', '2', '.', '.', '.', '6'),
        charArrayOf('.', '6', '.', '.', '.', '.', '2', '8', '.'),
        charArrayOf('.', '.', '.', '4', '1', '9', '.', '.', '5'),
        charArrayOf('.', '.', '.', '.', '8', '.', '.', '7', '9')
    )

    println("Is board1 valid? ${isValidSudoku(board1)}") // Should print true
    println("Is board2 valid? ${isValidSudoku(board2)}") // Should print false
}
fun isValidSudoku(board: Array<CharArray>): Boolean {

    val rows = Array(9) { BooleanArray(9) }
    val columns = Array(9) { BooleanArray(9) }
    val boxes = Array(9) { BooleanArray(9) }

    for (row in 0 until 9) {
        for (col in 0 until 9) {
            if (board[row][col] != '.') {
                val digit = board[row][col] - '1'
                val boxIndex = 3 * (row / 3) + col / 3

                if (rows[row][digit] || columns[col][digit] || boxes[boxIndex][digit]) {
                    return false
                }

                rows[row][digit] = true
                columns[col][digit] = true
                boxes[boxIndex][digit] = true
            }
        }
    }

    return true
}

