package partlist


fun partlist(arr: Array<String>): Array<Array<String>> {
    var res = arrayOfNulls<Array<String>>(arr.size - 1)
    (0 until arr.size - 1).forEach {
        var str1 = (0..it).joinToString(separator = " ") { it1 -> arr[it1] }
        var str2 = (it + 1 until arr.size).joinToString(separator = " ") { it1 -> arr[it1] }
        res[it] = arrayOf(str1, str2)
    }
    return res as Array<Array<String>>
}