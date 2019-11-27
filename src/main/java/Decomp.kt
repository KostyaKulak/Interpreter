package solution

object Decomp {
    private val trees = mutableListOf<Tree>()

    fun decompose(n: Long): String {
        val result = StringBuilder()
        if (n in 0L..4L) {
            result.append("null")
        } else {
            createTree(n)
            search(trees[0]).reversed().filter { it.key != n }.map { it.key }.forEach { result.append(it).append(" ") }
        }
        return result.toString().replace(Regex("\\s\$"), "")
    }

    private fun createTree(key: Long) {
        for (i in key downTo 1) {
            trees.add(Tree(i))
        }
        trees.add(Tree(0, square = Long.MAX_VALUE))
    }

    private fun search(tree: Tree): List<Tree> {
        val result = mutableListOf<Tree>()
        loop@ for (i in tree.leafs) {
            result.add(tree)
            trees[i].left = tree.left - trees[i].square
            when {
                trees[i].left == 0L -> {
                    result.add(trees[i])
                    break@loop
                }
                trees[i].left > 0L -> {
                    val list = search(trees[i])
                    if (list.isNotEmpty()) {
                        result.addAll(list)
                        break@loop
                    }
                }
            }
            result.clear()
        }
        return result
    }

    private val Tree.leafs get() = (trees.size - key).toInt() until trees.size
}

class Tree(var key: Long, val square: Long = key * key, var left: Long = square)

fun main() {
    val time = System.currentTimeMillis()
    println(Decomp.decompose(11))
    println(System.currentTimeMillis() - time)
}