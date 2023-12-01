package strings


fun main() {
    val testCases = listOf(
        Pair(arrayOf("x", "y", "z"), "xyyzyzyx") to "zyx",
        Pair(arrayOf("A"), "A") to "A",
        Pair(arrayOf("A", "B", "C"), "ADOBECODEBANCDDD") to "BANC",
        Pair(arrayOf("A", "B", "C"), "ABBBBBC") to "",
        Pair(arrayOf("A", "B", "C", "E", "K"), "KADOBECODEBANCDDD") to "KADOBEC",
        Pair(arrayOf("x", "y", "z"), "xyyzyzyx") to "zyx"
    )

    for ((input, expectedOutput) in testCases) {
        val (arr, str) = input
        val result = getShortestUniqueSubstring(arr, str)
        if (result == expectedOutput) {
            println("Test passed for input ${input.first.contentToString()} | ${input.second}")
        } else {
            println("Test failed for input ${input.first.contentToString()} | ${input.second}. " +
                    "  >>> Expected $expectedOutput but got $result")
        }
    }
}

fun getShortestUniqueSubstring(arr: Array<String>, str: String): String {
    var headIndex = 0
    var result = ""
    var uniqueCounter = 0
    val countMap = mutableMapOf<String, Int>()

    // initialize countMap
    for (i in arr.indices) {
        countMap[arr[i]] = 0
    }

    // scan str
    for (tailIndex in str.indices) {
        // handle the new tail
        val tailChar = str[tailIndex].toString()

        // skip all the characters not in arr
        if (!countMap.containsKey(tailChar)) {
            continue
        }

        val tailCount = countMap[tailChar] ?: 0
        if (tailCount == 0) {
            uniqueCounter++
        }

        countMap[tailChar] = tailCount + 1

        // push head forward
        while (uniqueCounter == arr.size) {
            val tempLength = tailIndex - headIndex + 1
            if (tempLength == arr.size) {
                // return a substring of str from
                // headIndex to tailIndex (inclusive)
                return str.substring(headIndex, tailIndex + 1)
            }

            if (result == "" || tempLength < result.length) {
                // return a substring of str from
                // headIndex to tailIndex (inclusive)
                result = str.substring(headIndex, tailIndex + 1)
            }

            val headChar = str[headIndex].toString()

            if (countMap.containsKey(headChar)) {
                val headCount = countMap[headChar] ?: (0 - 1)
                if (headCount == 0) {
                    uniqueCounter--
                }
                countMap[headChar] = headCount
            }

            headIndex++
        }
    }

    return result
}

