fun main(){
    val n = 4
    val k = 2

    print(combinations(n, k))

}

fun combinations(n: Int, k: Int): List<List<Int>> {
    val result = ArrayList<ArrayList<Int>>()


    helper(n, k, result, ArrayList(), 1)
    return result
}


fun helper(n: Int, k: Int, result: ArrayList<ArrayList<Int>>, slate: MutableList<Int>, index: Int){
    if(slate.size == k){
        result.add(ArrayList(slate))
        return
    }


    for (i in index..n){
        slate.add(i)
        helper(n, k, result, slate, i+1)
        slate.removeAt(slate.size-1)
    }

}