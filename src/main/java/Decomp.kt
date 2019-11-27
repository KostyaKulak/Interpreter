package solution

import kotlin.math.sqrt

object Decomp {

    fun decompose(n: Long): String {
        val result = StringBuilder()
        if (n in 0L..4L) {
            result.append("null")
        } else {
            val map = mutableMapOf<Long, Long>()
            decompose(map, n)
            map.keys.sorted().forEach { result.append(it).append(" ") }
        }
        return result.replace(Regex("\\s\$"), "")
    }

    fun decompose(map: MutableMap<Long, Long>, n: Long): Long {
        var result = 0L
        if (n == 0L) {
            result = 0L
        } else if (n in 1L..4L) {
            result = n
        } else {
            decompose(map, n, n)
        }
        return result
    }

    fun decompose(map: MutableMap<Long, Long>, n: Long, i: Long) {
        map[i - 1] = n dif mutableMapOf(i - 1 to 0L)
        var dif = n dif map
        while (dif != 0L) {
            map[dif] = dif
            dif = n dif map
            if (map.containsKey(dif)) {

            }
        }
    }

    fun Long.sqrt() = sqrt(this.toDouble()).toLong()

    fun Long.n2() = this * this

    infix fun Long.dif(map: MutableMap<Long, Long>) = (this.n2() - map.keys.map { it.n2() }.sum()).sqrt()
}

fun main() {
    println(Decomp.decompose(50))
}