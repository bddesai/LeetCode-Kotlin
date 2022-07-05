import java.util.ArrayList
import java.util.Arrays


fun main(args: Array<String>) {

    val nums = intArrayOf(2, 1, 2)

    print(subsetsWithDup(nums))
}


fun subsetsWithDup(nums: IntArray): List<List<Int>> {
    nums.sort()
    val result = ArrayList<List<Int>>()
    val currentSubset = ArrayList<Int>()

    subsetHelperAlt(result, currentSubset, nums, 0)
    return result
}


fun subsetHelperAlt(result: MutableList<List<Int>>,
                    currentSubset: MutableList<Int>,
                    nums: IntArray,
                    index: Int) {
    result.add(ArrayList(currentSubset))

    for (i in index until nums.size) {
        if (i != index && nums[i] == nums[i - 1]) {
            continue
        }

        currentSubset.add(nums[i])
        subsetHelperAlt(result, currentSubset, nums, i + 1)
        currentSubset.removeAt(currentSubset.size - 1)
    }
}

// time complexity = O(2^n * n)


fun subsetHelper(result: MutableList<List<Int>>, slate: MutableList<Int>, nums: IntArray, i: Int) {
    if (i == nums.size) {
        result.add(ArrayList(slate))
        return
    }
    var count = 0
    for (index in i until nums.size - 1) {
        if (nums[index] != nums[i]) {
            break
        }
        count++
    }

    // exclude
    //subsetHelper(result, slate, nums, i+count) // i+ count because you have to jump all copies of that occurence for next iteration

    // multi way inclusion
    for (c in 1 until count) {
        //choose c copies of slate[i]
        slate.add(nums[i])
        subsetHelper(result, slate, nums, i + count)
    }



    for (c in 1 until count) {
        slate.removeAt(slate.size - 1)
    }
}


