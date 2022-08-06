package recursion

fun main() {
    combinationSum(intArrayOf(2, 3, 6, 7), 7).forEach { print(it) }
    combinationSum(intArrayOf(2, 3, 5), 8).forEach { print(it) }
    combinationSum(intArrayOf(2), 1).forEach { print(it) }
}

fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
    val result = mutableListOf<MutableList<Int>>()

    helper(candidates, target, result, mutableListOf(), 0)

    return result
}

fun helper(
    candidates: IntArray, target: Int, result: MutableList<MutableList<Int>>,
    slate: MutableList<Int>, index: Int
) {

    if (target < 0) return

    if (target == 0) {
        result.add(ArrayList(slate))
        return
    }

    for (i in index until candidates.size) {
        slate.add(candidates[i])
        helper(candidates, target - candidates[i], result, slate, i)
        slate.removeAt(slate.size - 1)
    }

}
