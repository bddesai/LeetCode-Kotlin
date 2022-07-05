package problems

import kotlin.math.max

fun main() {
    val profits = intArrayOf(2, 3, 1, 4)
    val weights = intArrayOf(4, 5, 3, 7)
    val capacity = 5

    println("Ans = ${solveKnapsack(profits, weights, capacity)}")
}

fun solveKnapsack(profits: IntArray, weights: IntArray, capacity: Int): Int {
    return knapsackHelper(profits, weights, capacity, 0)
}

fun knapsackHelper(profits: IntArray, weights: IntArray, capacity: Int, currentIndex: Int): Int {
    if (capacity <= 0 || currentIndex >= profits.size)
        return 0

    // include
    var profit1 = 0
    if (weights[currentIndex] < capacity) {
        profit1 = profits[currentIndex] +
                knapsackHelper(profits, weights, capacity - weights[currentIndex], currentIndex + 1)
    }

    // exclude
    val profit2 = knapsackHelper(profits, weights, capacity, currentIndex + 1)

    return max(profit1, profit2)
}