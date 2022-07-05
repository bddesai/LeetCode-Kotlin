package sliding_window

import java.util.*


// link : https://leetcode.com/problems/sliding-window-maximum/

fun main(){

    maxSlidingWindow(intArrayOf(1,3,-1,-3,5,3,6,7), 3).forEach {
        println(it)
    }

    //println(maxSlidingWindow(intArrayOf(1,3,-1,-3,5,3,6,7), 3))
}
var deque = ArrayDeque<Int>()

fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {

    val n = nums.size
    if (n * k == 0) return IntArray(0)
    if (k == 1) return nums

    // init deque and output
    var max_idx = 0
    for (i in 0 until k) {
        clean_deque(i, k, nums)
        deque.addLast(i)
        // compute max in nums[:k]
        if (nums[i] > nums[max_idx]) max_idx = i
    }
    val output = IntArray(n - k + 1)
    output[0] = nums[max_idx]

    // build output
    for (i in k until n) {
        clean_deque(i, k, nums)
        deque.addLast(i)
        output[i - k + 1] = nums[deque.first]
    }
    return output
}

fun clean_deque(i: Int, k: Int, nums: IntArray) {
    // remove indexes of elements not from sliding window
    if (!deque.isEmpty() && deque.first == i - k)
        deque.removeFirst()

    // remove from deq indexes of all elements
    // which are smaller than current element nums[i]
    while (!deque.isEmpty() && nums[i] > nums[deque.last])
        deque.removeLast()
}



// --------------------------

fun maxSlidingWindow1(nums: IntArray, k: Int): IntArray {

    if (k > nums.size) return intArrayOf(0)

    if(k==1) return nums


    var deque = ArrayDeque<Int>()

    var result = intArrayOf()

    for (i in 0 until k){
        while (!deque.isEmpty()   &&   deque.last < nums[i])
            deque.addLast(nums[i])

        result[deque.first]
    }

    for(i in k until nums.size){
        if(nums[i-k] == deque.first)
            deque.remove(nums[i-k])

        while (!deque.isEmpty()   &&   deque.last < nums[i])
            deque.removeLast()

        result[deque.first]
    }


    return result
}





