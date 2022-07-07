package misc

// https://leetcode.com/problems/logger-rate-limiter/submissions/

fun main(){
    val obj = LoggerRateLimiter()

    //obj.shouldPrintMessage()
    println( obj.shouldPrintMessage(1, "foo"))
    println(obj.shouldPrintMessage(2, "bar"))
    println(obj.shouldPrintMessage(3, "foo"))
    println(obj.shouldPrintMessage(8, "bar"))
    println(obj.shouldPrintMessage(10, "foo"))
    println(obj.shouldPrintMessage(11, "foo"))

}

class LoggerRateLimiter {

    var map = mutableMapOf<String, Int>()
    fun shouldPrintMessage(timestamp: Int?, message: String?): Boolean {
        if(map.containsKey(message) && (timestamp!! - map[message]!!) < 10)
            return false

        map[message!!] = timestamp!!
        return true
    }
}