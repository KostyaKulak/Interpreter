package johnann

fun john(n: Long): List<Long> = (0 until n.toInt()).map { johnL(it) }

fun johnL(n: Int): Long {
    if (Storage.john.size < n + 1) {
        if (n == 0)
            Storage.john.add(0)
        else {
            val t = johnL(n - 1)
            val j = n - annL(t.toInt())
            Storage.john.add(j)
        }
    }
    return Storage.john[n]
}

fun ann(n: Long): List<Long> = (0 until n.toInt()).map { annL(it) }

fun annL(n: Int): Long {
    if (Storage.ann.size < n + 1) {
        if (n == 0)
            Storage.ann.add(1)
        else {
            val t = annL(n - 1)
            val j = n - johnL(t.toInt())
            Storage.ann.add(j)
        }
    }
    return Storage.ann[n]
}

fun sumJohn(n: Long) = john(n).sum()

fun sumAnn(n: Long) = ann(n).sum()

object Storage {
    var john = mutableListOf<Long>()
    var ann = mutableListOf<Long>()
}