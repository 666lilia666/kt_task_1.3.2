import org.junit.Assert.assertEquals
import org.junit.Test

class CardTest {

    @Test
    fun commissionOnFreeLimit() {
        val amount: Int = 70_000
        val name: String = "Card Test 1"
        val transferAmount: Int = 0
        val freeLimit: Int = 75_000
        val comPrecent: Double = 0.0075
        val dopCom: Int = 20
        val minCom: Int = 35

        val cardTest = Card(
            name,
            transferAmount,
            freeLimit,
            comPrecent,
            dopCom,
            minCom
        )

        val result = cardTest.commission(amount)
        assertEquals(0, result.toInt())
    }

    @Test
    fun minCommission() {
        val amount: Int = 30
        val name: String = "Card Test 1"
        val transferAmount: Int = 0
        val freeLimit: Int = 0
        val comPrecent: Double = 0.0075
        val dopCom: Int = 0
        val minCom: Int = 35

        val cardTest = Card(
            name,
            transferAmount,
            freeLimit,
            comPrecent,
            dopCom,
            minCom
        )

        val result = cardTest.commission(amount)
        assertEquals(35, result.toInt())

    }

    @Test
    fun dopCommission() {
        val amount: Int = 1000
        val name: String = "Card Test 1"
        val transferAmount: Int = 0
        val freeLimit: Int = 0
        val comPrecent: Double = 0.0075
        val dopCom: Int = 20
        val minCom: Int = 0

        val cardTest = Card(
            name,
            transferAmount,
            freeLimit,
            comPrecent,
            dopCom,
            minCom
        )

        val result = cardTest.commission(amount)
        assertEquals(27, result.toInt())

    }

    @Test
    fun overFreeLimitCommission() {
        val amount: Int = 20000
        val name: String = "Card Test 1"
        val transferAmount: Int = 0
        val freeLimit: Int = 10000
        val comPrecent: Double = 0.0075
        val dopCom: Int = 0
        val minCom: Int = 35

        val cardTest = Card(
            name,
            transferAmount,
            freeLimit,
            comPrecent,
            dopCom,
            minCom
        )

        val result = cardTest.commission(amount)
        assertEquals(75, result.toInt())

    }

    @Test
    fun commission() {
        val amount: Int = 20000
        val name: String = "Card Test 1"
        val transferAmount: Int = 0
        val freeLimit: Int = 0
        val comPrecent: Double = 0.0075
        val dopCom: Int = 0
        val minCom: Int = 0

        val cardTest = Card(
            name,
            transferAmount,
            freeLimit,
            comPrecent,
            dopCom,
            minCom
        )

        val result = cardTest.commission(amount)
        assertEquals(150, result.toInt())

    }
}