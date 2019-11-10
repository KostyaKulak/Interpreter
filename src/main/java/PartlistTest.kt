import org.junit.Test
import org.junit.Assert.assertEquals
import java.math.BigInteger

class SolutionTest {
    @Test
    fun basicTests() {
        assertEquals(BigInteger.ZERO, Faberge.height(BigInteger.ZERO, BigInteger.valueOf(14)))
        assertEquals(BigInteger.ZERO, Faberge.height(BigInteger.valueOf(2), BigInteger.ZERO))
        assertEquals(BigInteger.valueOf(105), Faberge.height(BigInteger.valueOf(2), BigInteger.valueOf(14)))
        assertEquals(BigInteger.valueOf(137979), Faberge.height(BigInteger.valueOf(7), BigInteger.valueOf(20)))
    }

    @Test
    fun advancedTests() {
        assertEquals(BigInteger.valueOf(621773656), Faberge.height(BigInteger.valueOf(13), BigInteger.valueOf(550)))
        assertEquals(BigInteger.valueOf(424414512), Faberge.height(BigInteger.valueOf(531), BigInteger.valueOf(550)))
    }

    @Test
    fun seriousTests() {
        assertEquals(BigInteger.valueOf(132362171), Faberge.height(BigInteger.valueOf(10000), BigInteger.valueOf(100000)))
        assertEquals(BigInteger.valueOf(805097588), Faberge.height(BigInteger.valueOf(80000), BigInteger.valueOf(100000)))
        assertEquals(BigInteger.valueOf(141903106), Faberge.height(BigInteger.valueOf(3000), BigInteger.valueOf(2).pow(200)))
        assertEquals(BigInteger.valueOf(616494770), Faberge.height(BigInteger.valueOf(80000), BigInteger.valueOf(40000)))
        assertEquals(BigInteger.valueOf(303227698), Faberge.height(BigInteger.valueOf(40000), BigInteger.valueOf(80000)))
    }
}
