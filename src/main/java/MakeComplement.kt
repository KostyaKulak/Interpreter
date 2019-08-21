package dna

import java.util.stream.Collectors

fun makeComplement(dna: String): String = dna.split("").map { dict[it] }.stream().collect(Collectors.joining())

val dict = mapOf("A" to "T", "G" to "C", "T" to "A", "C" to "G", "" to "")