import java.math.BigInteger;

fun lastDigit(base: BigInteger, exponent: BigInteger): Int {
    return if (exponent != BigInteger.ZERO) {
        if(base == BigInteger.ZERO)
            return 0
        var strBase = base.toString()
        var lastDigits = DIGITS.getDigits(strBase[strBase.lastIndex].toString().toInt()).lastDigits
        var t = exponent.remainder(BigInteger(lastDigits.size.toString()))
        when {
            lastDigits.size == 2 -> lastDigits[lastDigits.size - t.inc().toInt()]
            lastDigits.size == 1 -> lastDigits[0]
            else -> lastDigits[t.dec().toInt()]
        }
    } else {
        1
    }
}

enum class DIGITS(var digit: Int, var lastDigits: List<Int>) {
    ZERO(0, listOf(0)),
    ONE(1, listOf(1)),
    TWO(2, listOf(2, 4, 8, 6)),
    THREE(3, listOf(3, 9, 7, 1)),
    FOUR(4, listOf(4, 6)),
    FIVE(5, listOf(5)),
    SIX(6, listOf(6)),
    SEVEN(7, listOf(7, 9, 3, 1)),
    EIGHT(8, listOf(8, 4, 2, 6)),
    NINE(9, listOf(9, 1));

    companion object {
        fun getDigits(digit: Int) =
            when (digit) {
                ZERO.digit -> ZERO
                ONE.digit -> ONE
                TWO.digit -> TWO
                THREE.digit -> THREE
                FOUR.digit -> FOUR
                FIVE.digit -> FIVE
                SIX.digit -> SIX
                SEVEN.digit -> SEVEN
                EIGHT.digit -> EIGHT
                NINE.digit -> NINE
                else -> ZERO
            }
    }
}