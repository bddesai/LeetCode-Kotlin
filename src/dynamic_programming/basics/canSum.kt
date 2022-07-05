package basics

fun main() {
//    println(canSum(7, intArrayOf(2, 3), mutableMapOf()))
//    println(canSum(7, intArrayOf(5, 3, 4, 7), mutableMapOf()))
//    println(canSum(7, intArrayOf(2, 4), mutableMapOf()))
//    println(canSum(8, intArrayOf(2, 3, 5), mutableMapOf()))
//    println(canSum(300, intArrayOf(7, 14), mutableMapOf()))

    println(canSumTabulation(7, intArrayOf(2, 3)))
    println(canSumTabulation(7, intArrayOf(5, 3, 4, 7)))
    println(canSumTabulation(7, intArrayOf(2, 4)))
    println(canSumTabulation(8, intArrayOf(2, 3, 5)))
    println(canSumTabulation(300, intArrayOf(7, 14)))

}

fun canSum(targetSum: Int, nums: IntArray, memo: MutableMap<Int, Boolean>): Boolean {


    if (memo.containsKey(targetSum)) return memo[targetSum]!!

    if (targetSum == 0) return true

    if (targetSum < 0) return false

    for (num in nums) {
        val rem = targetSum - num

        if (canSum(rem, nums, memo)) {
            memo[targetSum] = true
            return true
        }
    }

    memo[targetSum] = false
    return false
}
// time = O(m * n)
// space = O()


fun canSumTabulation(targetSum: Int, numbers: IntArray): Boolean {
    val table = Array(targetSum + 1) { false }
    //table.forEach { print("$it, ") }

    table[0] = true
    for (i in 0..targetSum) {
        if (table[i] == true) {
            for (num in numbers) {
                if(i + num <= targetSum) table[i + num] = true
            }
        }
    }

    return table[targetSum]
}