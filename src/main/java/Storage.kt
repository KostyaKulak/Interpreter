fun rangeExtraction(arr: IntArray): String {
    val result = mutableListOf<MutableList<Int>>()
    val temp = mutableListOf<Int>()
//    temp.add(arr.first())
    for (i in arr.indices) {
        if (arr[i] + 1 == arr[i + 1]) {
            temp.add(arr[i])
            if (i == arr.lastIndex - 1) {
                temp.add(arr[i + 1])
                result.add(temp.toMutableList())
                break
            }
        } else {
            if (i != 0 && arr[i] - 1 == arr[i - 1]) {
                temp.add(arr[i])
                if (temp.size < 3) {
                    temp.forEach { result.add(mutableListOf(it)) }
                } else {
                    result.add(temp.toMutableList())
                }
                temp.clear()
                continue
            }
            if (i == arr.lastIndex - 1) {
                result.add(mutableListOf(arr.last()))
                break
            } else {
                result.add(mutableListOf(arr[i]))
            }
        }
    }
    return result.joinToString(",") {
        if (it.size == 1) {
            it.first().toString()
        } else {
            "${it.first()}-${it.last()}"
        }
    }
}