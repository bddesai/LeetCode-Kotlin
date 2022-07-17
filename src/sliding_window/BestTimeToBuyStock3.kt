package sliding_window

// link: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/

fun main() {
    print(maxProfit3(intArrayOf(3, 3, 5, 0, 0, 3, 1, 4)))
    //ans=6
}

fun maxProfit3(prices: IntArray): Int {
    var (first, second, low, high) = listOf(0, 0, 0, 1)

    while (high < prices.size) {
        if (high - low > 2) {
            low = high
            continue
        }

        if (prices[high] > prices[low]) {
            val profit = prices[high] - prices[low]

            if (profit > second) {
                first = second
                second = profit
            } else if (profit > first) {
                first = profit
            }
        } else {
            low = high
        }
        high++
    }

    return first + second
}
