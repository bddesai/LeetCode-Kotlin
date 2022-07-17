package sliding_window

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
            maxProfit = Math.max(maxProfit, profit)
        } else {
            low = high
        }
        high++
    }

    return maxProfit
}