package two_pointer

// link: https://leetcode.com/problems/valid-palindrome-ii/

class ValidPalindromeII {

}

fun isPalindromeII(s: String): Boolean {
    if(s.isEmpty()) return true

    var left = 0
    var right = s.length - 1

    while(left<right){
        if(!s[left].isLetterOrDigit()){
            left++
            continue
        }

        if (!s[right].isLetterOrDigit()){
            right--
            continue
        }

        if(s[left].toLowerCase() != s[right].toLowerCase()){
            return false
        }

        left++
        right--
    }

    return true
}

fun isPalindrome(s: String, left: Int, right: Int): Boolean{
    while(left < right){
        if(s[left] != s[right]){
            return false
        }
    }
    return true
}