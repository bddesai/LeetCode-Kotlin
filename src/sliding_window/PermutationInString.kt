package sliding_window

fun main(){
    println(hasPermutation("ab", "eidbaooo"))

    println(hasPermutation("hello", "jhsgllehosdaheso"))

    println(hasPermutation("a", "ab"))
    println(hasPermutation("adc", "dcda"))
}


// work in progress
fun hasPermutation(s1: String, s2: String): Boolean {

    if(s1.length > s2.length) return false


    val k = s1.length
    var maps1 = mutableMapOf<Char, Int>()
    var maps2 = mutableMapOf<Char, Int>()

    for(i in 0 until s1.length){
        if(maps1.containsKey(s1[i]))
            maps1[s1[i]] = maps1[s1[i]]!! + 1
        else
            maps1[s1[i]] = 1
    }

    for(i in 0 until k){
        if(maps2.containsKey(s2[i]))
            maps2[s2[i]] = maps2[s2[i]]!! + 1
        else
            maps2[s2[i]] = 1
    }

    for(i in k until s2.length){


        maps2[s2[i-k]] = maps2[s2[i-k]]!! - 1

        if (maps2[s2[i-k]] == 0) maps2.remove(s2[i-k])

        if(maps2.containsKey(s2[i]))
            maps2[s2[i]] = maps2[s2[i]]!! + 1
        else
            maps2[s2[i]] = 1

        if(maps1 == maps2) return true
    }

    return false
}