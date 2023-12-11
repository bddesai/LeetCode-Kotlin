package sliding_window

// 122. Best Time to Buy and Sell Stock II
// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/description/
fun main() {
    println(
        maxProfit2(intArrayOf(7, 1, 5, 3, 6, 4))
    )
    println(
        maxProfit2(intArrayOf(1, 2, 3, 4, 5))
    )
}

// sliding window
fun maxProfit2(prices: IntArray): Int {
    var (l, r) = 0 to 1
    var maxProfit = 0
    while (r < prices.size) {
        if (prices[r] > prices[l]) {
            val profit = prices[r] - prices[l]
            maxProfit += profit
            l++
        } else {
            l = r
        }
        r++
    }
    return maxProfit
}

fun maxProfit2_2(prices: IntArray): Int {
    var profit = 0
    for(i in 1 until prices.size){
        if(prices[i] > prices[i-1]){
            profit += prices[i] - prices[i-1]
        }
    }
    return profit
}