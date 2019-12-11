package solution

import kotlin.streams.toList

object Cubes {
    fun isSumOfCubes(s: String): String {
        val digits = s.stripNonDigits()
        val result = digits
            .asSequence()
            .map { it to it.replace(Regex("^0+"), "") }
            .map {
                if (it.second.isEmpty()) it.first to "0" else it
            }
            .filter { it.second.isCubic() }
            .map { it.first }
            .toList()
        return if (result.isEmpty()) {
            "Unlucky"
        } else {
            "${result.joinToString ( " " )} ${result
                .map { it.replace(Regex("^0+"), "") }
                .filter { it.isNotEmpty() }
                .map { it.toInt() }
                .sum()
            } Lucky"
        }
    }

    private fun String.stripNonDigits(): List<String> {
        val sb = StringBuilder(this.length)
        this.forEach { element ->
            if (element.toInt() in 48..57) sb.append(element)
            if (element == ' ') sb.append(' ')
        }
        return sb.split(Regex("\\s+"))
            .map {
                (0..it.length step 3)
                    .map { i -> it.substring(i, if (i + 3 < it.length) i + 3 else it.length) }
            }
            .stream()
            .flatMap { it.stream() }
            .filter { it.isNotEmpty() }
            .toList()
    }

    private fun String.isCubic(): Boolean =
        this.split("")
            .filter { it.isNotEmpty() }
            .map { it.toInt() }
            .map { it * it * it }
            .sum() == this.toInt()
}