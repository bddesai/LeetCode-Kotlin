package sliding_window

// link https://leetcode.com/problems/longest-substring-without-repeating-characters/


fun main() {
    print(lengthOfLongestSubstring("pwwkew"))
}

fun lengthOfLongestSubstring(s: String): Int {
    val charSet = mutableSetOf<Char>()
    var (l, res) = listOf(0, 0)


    for (r in 0 until s.length) {
        while (charSet.contains(s[r])) {
            charSet.remove(s[l])
            l++
        }

        charSet.add(s[r])
        res = Math.max(res, r - l + 1)
    }

    return res
}