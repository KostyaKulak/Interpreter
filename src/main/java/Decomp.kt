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

    fun createTree(key: Long) {
        for (i in key downTo 1) {
            trees.add(Tree(i))
        }
        trees.add(Tree(0, square = Long.MAX_VALUE))
    }

    private fun search(tree: Tree): List<Tree> {
        val result = mutableListOf<Tree>()
        if (tree.leafs.isNotEmpty()) {
            loop@ for (leaf in tree.leafs) {
                if (!leaf.visited) {
                    result.add(tree)
                    leaf.visited = true
                    leaf.left = tree.left - leaf.square
                    when {
                        leaf.left == 0L -> {
                            result.add(leaf)
                            break@loop
                        }
                        leaf.left > 0L -> {
                            val list = search(leaf)
                            if (list.isNotEmpty()) {
                                result.addAll(list)
                                break@loop
                            } else {
                                leaf.leafs.forEach { it.visited = false }
                                result.clear()
                            }
                        }
                        else -> {
                            leaf.leafs.forEach { it.visited = false }
                            result.clear()
                        }
                    }
                }
            }
        } else {
            result.add(tree)
        }
        return result
    }

    private val Tree.leafs get() = trees.subList((trees.size - key).toInt(), trees.size)
}

class Tree(var key: Long, val square: Long = key * key, var visited: Boolean = false, var left: Long = square)

fun main() {
    val time = System.currentTimeMillis()
    println(Decomp.decompose(12))
    println(System.currentTimeMillis() - time)
}