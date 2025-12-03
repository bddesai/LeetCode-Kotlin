package sliding_window

import kotlin.math.max

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

fun main() {
    println(maxProfit1(intArrayOf(7, 1, 5, 3, 6, 4)))
    println(maxProfit1(intArrayOf(7, 6, 4, 3, 1)))
}

fun maxProfit1(prices: IntArray): Int {
    var low = 0
    var high = 1
    var maxProfit = 0

    while (high < prices.size) {
        if (prices[low] < prices[high]) {
            var profit = prices[high] - prices[low]
            maxProfit = max(maxProfit, profit)
        } else {
            low = high
        }
        high++
    }

    return maxProfit
}

fun maxProfit1_2(prices: IntArray): Int {
    var maxProfit = 0
    var minPrice = Int.MAX_VALUE

    for (i in prices.indices) {
        if (prices[i] < minPrice) minPrice = prices[i]
        else if (maxProfit < prices[i] - minPrice) maxProfit = prices[i] - minPrice
    }
    return maxProfit
}
