package recursion

// link: https://leetcode.com/problems/palindrome-partitioning/solution/

fun main(){
    partition("aab").forEach {slate ->
        print(slate)
    }
}

fun partition(s: String): List<List<String>> {

    val result = mutableListOf<MutableList<String>>()

    helper(s, result, mutableListOf(), 0)

    return result
}

fun helper(s: String, result: MutableList<MutableList<String>>,
           slate: MutableList<String>, index: Int){

    // base case
    if(index >= s.length){
        result.add(ArrayList(slate))
        return
    }

    for(i in index until s.length){

        if( isPalindrome(s, index, i) ) {

            slate.add(s.substring(index, i+1))

            helper(s, result, slate, i + 1)

            slate.removeAt(slate.size - 1)
        }
    }
}

fun isPalindrome(str: String, start: Int, end: Int): Boolean{

    var _start = start
    var _end = end

    while (_start < _end){
        if(str[_start++] != str[_end--]) return false
    }

    return true
}