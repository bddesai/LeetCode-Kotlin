package binary_search



fun main() {
    println(findMin(intArrayOf(3, 4, 5, 1, 2)))
    println(findMin(intArrayOf(4, 5, 6, 7, 0, 1, 2)))
    println(findMin(intArrayOf(11, 13, 15, 17)))
}

fun findMin(nums: IntArray): Int {
    var (left, right) = 0 to nums.size - 1

    while (left < right) {
        val mid = (left + right) / 2

        if (nums[mid] > nums[right]) {
            left = mid + 1
        } else {
            right = mid
        }
    }
    return nums[left]
}
