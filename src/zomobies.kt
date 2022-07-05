

fun main() {
    val array = arrayOf('H', 'Z', 'H', 'Z')

    sortHumansZombies(array).forEach{
        println(it)
    }
}

fun sortHumansZombies(input: Array<Char>): Array<Char>{

    var (left, right) = listOf(0, input.size-1)

    while(left < right){
        if(input[left] == 'H'){
            left++
            continue
        }

        if(input[right] == 'Z'){
            right--
            continue
        }

        swap(input, left, right)
    }

    return input
}

fun swap(input: Array<Char>, left: Int, right: Int) {
    val temp = input[left]
    input[left] = input[right]
    input[right] = temp
}