package basics

fun main() {
//    howSum(7, intArrayOf(2, 3), mutableMapOf())?.forEach { print("$it, ") }
//    print("\n")
//    howSum(7, intArrayOf(5,3,4,7), mutableMapOf())?.forEach { print("$it, ") }
//    print("\n")
//    howSum(7, intArrayOf(2, 4), mutableMapOf())?.forEach { print("$it, ") }
//    print("\n")
//    howSum(8, intArrayOf(2, 3, 5), mutableMapOf())?.forEach { print("$it, ") }
//    print("\n")
//    howSum(300, intArrayOf(7, 14), mutableMapOf())?.forEach { print("$it, ") }


    howSumTabulation(7, intArrayOf(2, 3))?.forEach { print("$it, ") }
    print("\n")
    howSumTabulation(7, intArrayOf(5, 3, 4, 7))?.forEach { print("$it, ") }
    print("\n")
    howSumTabulation(7, intArrayOf(2, 4))?.forEach { print("$it, ") }
    print("\n")
    howSumTabulation(8, intArrayOf(2, 3, 5))?.forEach { print("$it, ") }
    print("\n")
    howSumTabulation(300, intArrayOf(7, 14))?.forEach { print("$it, ") }


}


fun howSum(targetSum: Int, nums: IntArray, memo: MutableMap<Int, IntArray?>): IntArray? {
    if (memo.containsKey(targetSum)) return memo[targetSum]

    if (targetSum == 0) return intArrayOf()
    if (targetSum < 0) return null

    for (num in nums) {
        val rem = targetSum - num
        val remainderResult = howSum(rem, nums, memo)

        if (remainderResult != null) {
            memo[targetSum] = remainderResult + num
            return memo[targetSum]
        }
    }

    memo[targetSum] = null
    return null
}
// time = O(n * m * m) = O (n * (m^2))          // copy m array to remainderResult
// space =  O (m * m) = O (m^2)                // hashmap and array


fun howSumTabulation(targetSum: Int, numbers: IntArray): IntArray? {
    val table = arrayOfNulls<IntArray>(targetSum + 1) // initialize with null(s)
    table[0] = intArrayOf()
    for (i in 0..targetSum) {
        if (table[i] != null) {
            for (num in numbers) {
                if (i + num <= targetSum)
                    table[i + num] = table[i]?.plus(num)
            }
        }
    }
    return table[targetSum]
}
