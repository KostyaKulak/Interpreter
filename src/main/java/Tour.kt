package solution

import kotlin.math.pow
import kotlin.math.sqrt

object Tour {
    fun tour(arrFriends: Array<String>, ftwns: Array<Array<String>>, h: Map<String, Double>): Int {
        val allH = HashMap<String, Double>()
        h.forEach { allH[it.key.replace("X", "X0X")] = it.value }
        for (i in 1 until h.size - 1) {
            allH["X${i}X${i + 1}"] = sqrt(h.getValue("X${i + 1}").pow(2) - h.getValue("X$i").pow(2))
        }
        val toVisit = ftwns.map { it[1] }

        return 0
    }
}

fun main() {
    val a = arrayOf<Double>(100.0, 200.0, 250.0, 300.0)
    var sum = 0.0
    for (i in 1 until a.size) {
        sum += sqrt(a[i].pow(2) - a[i - 1].pow(2))
    }
    println(sum)
}