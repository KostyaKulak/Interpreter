fun josephusSurvivor(n: Int, k: Int): Int = when (n) {
    1 -> 1
    2 -> if (k % 2 == 0) 1 else 2
    else -> {
        var map = (0 until n).map { it to false }.toMap().toMutableMap()
        var step = if (n >= k) k else k - n
        var first = step - 1
        while (map.size != 2) {
            (first until map.size step step)
                .filter { !map.getAt(it).value }
                .forEach { map.getAt(it).setValue(true) }
            val count = map.size - 1
            step = if (map.size >= k) k else k - (map.size - 1)
            first = if (map.size >= k) map.size - count / step * step else step - 1
            map = map.filter { !it.value }.toMutableMap()
        }
        (if (step % 2 == 0) map.getAt(0).key else map.getAt(1).key).inc()
    }
}

fun Map<Int, Boolean>.getLast() = entries.stream().filter { !it.value }.findFirst().get().key.inc()
fun <T, K> MutableMap<T, K>.getAt(i: Int): MutableMap.MutableEntry<T, K> {
    val iter = this.iterator()
    repeat(i) { iter.next() }
    return iter.next()
}