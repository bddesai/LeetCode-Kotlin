import java.util.*

fun main(args: Array<String>) {
    val nums = intArrayOf(1, 2, 3)
    println(permute(nums))

    val nums2 = intArrayOf(1)
    println(permute(nums2))

    val nums3 = intArrayOf(1,2,2)
    println(permuteWithRepetition(nums3))
}

fun permute(nums: IntArray): List<List<Int>> {
    val result = ArrayList<List<Int>>()
    permutationHelper(result, nums.toMutableList(), 0)
    return result
}

fun permutationHelper(
        result: ArrayList<List<Int>>,
        nums: MutableList<Int>,
        index: Int): ArrayList<List<Int>> {
    if (index == nums.size) {
        result.add(ArrayList<Int>(nums))
        return result
    }

    for (i in index until nums.size) {
        Collections.swap(nums, index, i)
        permutationHelper(result, nums, index + 1)
        Collections.swap(nums, index, i)
    }

    return result
}

fun permuteWithRepetition(nums: IntArray): List<List<Int>>{
    val result = ArrayList<List<Int>>()
    permuteWithRepetitionHelper(result, nums.toList(), 0)
    return result
}

fun permuteWithRepetitionHelper(
        result: ArrayList<List<Int>>,
        nums: List<Int>,
        index: Int){

    if (index == nums.size) {
        result.add(ArrayList<Int>(nums))
        return
    }

    val set = HashSet<Int>()

    // logic
    for (i in index until nums.size) {

        if (!set.contains(nums[i])) {
            set.add(nums[i])

            Collections.swap(nums, index, i)
            permuteWithRepetitionHelper(result, nums, index + 1)
            Collections.swap(nums, index, i)
        }
    }
}
