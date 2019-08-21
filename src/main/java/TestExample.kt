package dna

import kotlin.test.assertEquals
import org.junit.Test

class TestExample {
    @Test
    fun test01() {
        assertEquals("TTTT", makeComplement("AAAA"));
    }
    @Test
    fun test02() {
        assertEquals("TAACG", makeComplement("ATTGC"));
    }

}
