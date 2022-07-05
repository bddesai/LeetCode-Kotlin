package sliding_window

// link : https://leetcode.com/problems/find-k-length-substrings-with-no-repeated-characters/

fun main() {
    println(FindKLenSubstrNoRepeats("havefunonleetcode", 5)) // ans=6
}

fun FindKLenSubstrNoRepeats(s: String, k: Int): Int {
    if (s.length < k) return 0

    var hashMap = mutableMapOf<Char, Int>()
    var count = 0

    for (i in 0 until k) {
        if (hashMap.containsKey(s[i]))
            hashMap[s[i]] = hashMap[s[i]]!! + 1
        else
            hashMap[s[i]] = 1
    }


    count = if (hashMap.size == k) 1 else 0

    for (i in k until s.length) {
        //left end
        if (hashMap.containsKey(s[i]))
            hashMap[s[i]] = hashMap[s[i]]!! + 1
        else
            hashMap[s[i]] = 1

        // right end
        hashMap[s[i - k]] = hashMap[s[i - k]]!! - 1
        if (hashMap[s[i - k]] == 0)
            hashMap.remove(s[i - k])

        if (hashMap.size == k)
            count++
    }

    return count
}
