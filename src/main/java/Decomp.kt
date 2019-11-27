package solution

object Decomp {
    private val trees = mutableListOf(Tree(0, square = Long.MAX_VALUE))

    init {
        trees.add(Tree(1, mutableListOf(trees[0])))
    }

    fun decompose(n: Long): String {
        val result = StringBuilder()
        if (n in 0L..4L) {
            result.append("null")
        } else {
            val tree = createTree(n)
            tree.search().filter { it.key != n }.reversed().map { it.key }.forEach { result.append(it).append(" ") }
        }
        return result.toString().replace(Regex("\\s\$"), "")
    }

    private fun createTree(key: Long): Tree = if (key == 0L) {
        trees[0]
    } else if (key == 1L) {
        trees[1]
    } else {
        val tree = Tree(key)
        for (i in 0 until key) {
            if (trees.size < i + 1) {
                trees.add(createTree(i))
            }
            tree.leafs.add(trees[i.toInt()])
        }
        tree.leafs.reverse()
        tree
    }
}

class Tree(var key: Long, var leafs: MutableList<Tree> = mutableListOf(), val square: Long = key * key, var left: Long = square) {
    fun search(): List<Tree> {
        val result = mutableListOf<Tree>()
        if (leafs.isNotEmpty()) {
            loop@ for (leaf in leafs) {
                result.add(this)
                leaf.left = left - leaf.square
                when {
                    leaf.left == 0L -> {
                        result.add(leaf)
                        break@loop
                    }
                    leaf.left > 0L -> {
                        val list = leaf.search()
                        if (list.isNotEmpty()) {
                            result.addAll(list)
                            break@loop
                        }
                    }
                }
                result.clear()
            }
        } else {
            result.add(this)
        }
        return result
    }
}

fun main() {
    println(Decomp.decompose(11))
}