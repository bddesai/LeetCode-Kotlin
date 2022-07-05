package two_pointer

// link: https://leetcode.com/problems/sort-array-by-parity/


fun main() {
//    sortArrayByParity(intArrayOf(3,1,2,4)).forEach {
//        println(it)
//    }

    sortArrayByParity(intArrayOf(3,7,9,1,2,4,6,8)).forEach {
        println(it)
    }
}

fun sortArrayByParity(nums: IntArray): IntArray {

    var l =0
    var r = nums.size-1
    while(l < r){

        if(nums[l]%2 > nums[r]%2) {
            swap(nums, l, r)
        }

        if(nums[l] % 2 == 0) l++
        if(nums[r] % 2 == 1) r--
    }

    return nums
}

fun swap(nums: IntArray, l: Int, r: Int) {
    var tmp = nums[l]
    nums[l] = nums[r]
    nums[r] = tmp
}

//time O(n)
// space O(1)
