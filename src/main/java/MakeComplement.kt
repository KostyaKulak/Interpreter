fun persistence(num: Int): Int {
    var digit = num
    var count = 0
    while (digit > 9) {
        digit = multiply(digits(digit))
        count++
    }
    return count
}

fun digits(num: Int) = num.toString().split("").filter { it.isNotBlank() }.map { it.toInt() }.toList()

fun multiply(digits: List<Int>): Int {
    var res = 1
    digits.forEach { res *= it }
    return res
}