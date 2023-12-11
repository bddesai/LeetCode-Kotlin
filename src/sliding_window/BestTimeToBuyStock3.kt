package sliding_window

// 123. Best Time to Buy and Sell Stock III
// link: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/

fun main() {
    print(maxProfit3(intArrayOf(3, 3, 5, 0, 0, 3, 1, 4)))
    //ans=6
}

fun maxProfit3(prices: IntArray): Int {

    val n = prices.size
    if (n <= 1) return 0

    var firstBuy = Int.MIN_VALUE
    var firstSell = 0
    var secondBuy = Int.MIN_VALUE
    var secondSell = 0

    for (price in prices) {
        firstBuy = maxOf(firstBuy, -price)
        firstSell = maxOf(firstSell, firstBuy+price)
        secondBuy = maxOf(secondBuy, firstSell-price)
        secondSell = maxOf(secondSell, secondBuy+price)
    }
    return  secondSell
}