fun incrementString(str: String): String {
    val result = StringBuilder("")
    if (str.matches(Regex("[a-zA-Z]+"))) {
        result.append(str).append(1)
    } else {
        val parts = str.split(Regex("\\d+")).filter { it.isNotEmpty() }
        if (parts.isEmpty()) {
            if (str.matches(Regex("^0+\\d+$"))) {
                appendZeroes(result, str)
            } else {
                var temp = str
                if (temp.isEmpty()) {
                    temp = "0"
                }
                result.append(temp.toInt().plus(1))
            }
        } else {
            appendLetters(result, str, parts[0])
        }
    }
    return result.toString()
}

fun appendZeroes(result: StringBuilder, str: String) {
    var temp = str
    var zeroCount = 0
    while (temp.matches(Regex("^0+\\d*$"))) {
        temp = temp.replaceFirst(Regex("^0"), "")
        zeroCount++
    }
    var sizeBefore = 0
    if (temp.isEmpty()) {
        temp = "0"
    } else {
        sizeBefore = temp.length
    }
    val sizeAfter = temp.toInt().plus(1).toString().length
    for (j in 1..(zeroCount - (sizeAfter - sizeBefore))) {
        result.append(0)
    }
    result.append(temp.toInt().plus(1))
}

fun appendLetters(result: StringBuilder, str: String, letters: String) {
    val temp = str.replace(letters, "")
    result.append(letters)
    if (temp.matches(Regex("^0+\\d+$"))) {
        appendZeroes(result, temp)
    } else {
        result.append(temp.toInt().plus(1))
    }
}