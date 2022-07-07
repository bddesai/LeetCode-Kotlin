package misc

class Temp {
}


/* Part 1:
 * Given a list of bookmark objects and a search term, return bookmarks
 * where the search term is a prefix of one of the words in the business
 * name. Return the first 4 business names that match  the search term.
 * For example searching for ‘bur’ in these bookmark objects should
 * suggest “Burger King”, “Bob's Burgers”, and “Super Duper Burgers”.

 "Burger k" -> ["Burger King"}
 "Duper B" -> ["Super Duper Burgers"]
 */

//term delimiter - 2
// result demilit - 3
//  if (2< 3){
//      iterate over all
//  }

// expected
// search for prefix
// return first 4 business = List<String>
// https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.text/index-of.html
fun main(args: Array<String>) {
    val bizNames =
        arrayOf("Burger King", "McDonald's", "Bob’s Burgers", "Five Guys", "Super Duper Burgers", "Wahlburgers")
    val term = "Bur"

    var result = search(bizNames, term)
    for (item in result) {
        println(item)
    }
}

// each string iterated, tokenize the string with space " "
/// ignore case and match substring with term
// eg : Super Duper Burgers
fun search(bizNames: Array<String>, term: String): MutableList<String> {

    //var termTokenizer = term.split(" ") //array of string


    var result = mutableListOf<String>()
    for (biz in bizNames) {
        val index = biz.indexOf(term)
        if (index != -1) {
            println(index)
            result.add(biz)
        }
    } // end for

    return result
}
