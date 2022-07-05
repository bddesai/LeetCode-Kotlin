package sliding_window

// link: https://leetcode.com/problems/grumpy-bookstore-owner/

fun main() {

    print(maxSatisfied(
            intArrayOf(1, 0, 1, 2, 1, 1, 7, 5),  //customers
            intArrayOf(0, 1, 0, 1, 0, 1, 0, 1), // grumpy
            3 // minutes
    ))
}

// strategy : Find max num of dissatisfied customers in that window to find eventual num of satisfied customers
fun maxSatisfied(customers: IntArray, grumpy: IntArray, minutes: Int): Int {
    var numAngry=0
    val x = minutes

    for (i in 0 until x){
        if(grumpy[i]==1) numAngry+= customers[i]
    }

    var numSatisfied = 0
    for (i in 0 until customers.size){
        if (grumpy[i]==0) numSatisfied+= customers[i]
    }

    var globalMax = numAngry

    for (i in x until customers.size){
        // compute num of angry customers in window ending at index i (right end)
         if(grumpy[i]==1)
             numAngry += customers[i]

        // subtract angry customers at the left end
        if (grumpy[i-x]==1){
            numAngry -= customers[i-x]
        }

        // max num of angry customers in any window
        globalMax = Math.max(globalMax, numAngry)
    }

    return globalMax + numSatisfied
}
