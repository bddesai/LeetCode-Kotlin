package basics

fun main() {
//    bestSum(7, intArrayOf(5, 3, 4, 7), mutableMapOf())?.forEach { print("$it, ") }
//    print("\n")
//    bestSum(8, intArrayOf(2, 3, 5), mutableMapOf())?.forEach { print("$it, ") }
//    print("\n")
//    bestSum(8, intArrayOf(1, 4, 5), mutableMapOf())?.forEach { print("$it, ") }
//    print("\n")
//    bestSum(100, intArrayOf(1, 2, 5, 25), mutableMapOf())?.forEach { print("$it, ") }


    bestSumTabulation(7, intArrayOf(5, 3, 4, 7))?.forEach { print("$it, ") }
    print("\n")
    bestSumTabulation(8, intArrayOf(2, 3, 5))?.forEach { print("$it, ") }
    print("\n")
    bestSumTabulation(8, intArrayOf(1, 4, 5))?.forEach { print("$it, ") }
    print("\n")
    bestSumTabulation(100, intArrayOf(1, 2, 5, 25))?.forEach { print("$it, ") }
}

fun bestSum(targetSum: Int, nums: IntArray, memo: MutableMap<Int, IntArray?>): IntArray? {
    if (memo.containsKey(targetSum)) return memo[targetSum]
    if (targetSum == 0) return intArrayOf()
    if (targetSum <= 0) return null

    var shortestCombination: IntArray? = null

    for (num in nums) {
        val rem = targetSum - num

        val remainderCombination = bestSum(rem, nums, memo)
        if (remainderCombination != null) {
            val combination = remainderCombination + num

            // if combination is shorter than the current shortest combo, update it
            if (shortestCombination == null || combination.size < shortestCombination.size) {
                shortestCombination = combination
            }
        }
    }
    memo[targetSum] = shortestCombination
    return shortestCombination
}

// With memoization
// time = O(m^2  *  n)
// space = O(m^2)

// Brute Force without memo
// time = O (n^m * m)    branching factor ^ height * increasing combination
// space = O(m^2)        hashmap and intArray


fun bestSumTabulation(targetSum: Int, nums: IntArray): IntArray? {
    val table = arrayOfNulls<IntArray>(targetSum + 1) // initialize with null(s)
    table[0] = intArrayOf()

    for (i in 0..targetSum) {
        if (table[i] != null) {
            for (num in nums) {
                val combination = table[i]?.plus(num)

                if (table[i + num] != null && table[i + num]?.size!! > combination?.size!!)
                    table[i + num] = combination

            }
        }
    }

    return table[targetSum]
}
