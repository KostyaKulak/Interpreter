package growth

fun nbYear(pp0: Int, percent: Double, aug: Int, p: Int): Int {
    var count = pp0
    var k = 0
    while (count < p) {
        count = (count * (100 + percent) / 100).toInt() + aug
        k++
    }
    return k
}