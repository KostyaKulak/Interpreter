package solution

import org.junit.Test
import kotlin.test.assertEquals

class  TourTest {

    @Test
    fun basicTests() {
        val friends1 = arrayOf("A1", "A2", "A3", "A4", "A5")
        val fTowns1 = arrayOf(arrayOf("A1", "X1"), arrayOf("A2", "X2"), arrayOf("A3", "X3"), arrayOf("A4", "X4"))
        val distTable1: MutableMap<String, Double> = HashMap()
        distTable1["X1"] = 100.0
        distTable1["X2"] = 200.0
        distTable1["X3"] = 250.0
        distTable1["X4"] = 300.0
        assertEquals(889, Tour.tour(friends1, fTowns1, distTable1))

        val friends2 = arrayOf("A1", "A2", "A3", "A4", "A5", "A6")
        val fTowns2 = arrayOf(arrayOf("A1", "X1"), arrayOf("A2", "X2"), arrayOf("A3", "X3"), arrayOf("A4", "X4"), arrayOf("A5", "X5"))
        val distTable2: MutableMap<String, Double> = HashMap()
        distTable2["X1"] = 100.0
        distTable2["X2"] = 200.0
        distTable2["X3"] = 250.0
        distTable2["X4"] = 300.0
        distTable2["X5"] = 320.0
        assertEquals(1020, Tour.tour(friends2, fTowns2, distTable2))

    }
}