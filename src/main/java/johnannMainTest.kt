package johnann

import org.junit.Test
import kotlin.test.assertEquals

class johnannMainTest {

    private fun testJohn(n:Long, res:List<Long>) {
        assertEquals(res, john(n))
    }
    private fun testAnn(n:Long, res:List<Long>) {
        assertEquals(res, ann(n))
    }
    private fun testSumAnn(n:Long, res:Long) {
        assertEquals(res, sumAnn(n))
    }
    private fun testSumJohn(n:Long, res:Long) {
        assertEquals(res, sumJohn(n))
    }

    @Test
    fun test1() {
        testJohn(11, listOf(0, 0, 1, 2, 2, 3, 4, 4, 5, 6, 6))

    }
    @Test
    fun test2() {
        testAnn(6, listOf(1, 1, 2, 2, 3, 3))

    }
    @Test
    fun test3() {
        testSumAnn(115, 4070)

    }
    @Test
    fun test4() {
        testSumJohn(75, 1720)

    }
}