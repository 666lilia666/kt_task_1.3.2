import kotlin.math.abs
fun main (){
    val transferAmount = 80_000
    val vk = Card("VK PAY",15_000,40_000,0)
    val master = Card("MasterCard",150_000,600_000,0,75_000)
    val maestro = Card("Maestro",150_000,600_000,0,75_000)
    val mir = Card("Мир",150_000,600_000,0)
    val visa = Card("Visa",150_000,600_000,0)

    println("Комиссия за перевод составляет: ${commission(maestro,transferAmount).toInt()} руб.")
}

fun commission (cardType: Card, transferAmount: Int,): Double = when (cardType._name){
    "MasterCard" -> when(cardType._transferAmount < cardType._freeLimit && cardType._transferAmount + transferAmount
            < cardType._freeLimit ) {
        true -> 0.0
        else -> (abs(cardType._freeLimit - cardType._transferAmount - transferAmount) * 0.006 + 20)
    }
    "Maestro" -> when(cardType._transferAmount < cardType._freeLimit && cardType._transferAmount + transferAmount
            < cardType._freeLimit ) {
        true -> 0.0
        else -> (abs(cardType._freeLimit - cardType._transferAmount - transferAmount) * 0.006 + 20)
    }
    "Visa" -> when (abs(cardType._freeLimit - cardType._transferAmount - transferAmount) * 0.0075 < 35) {
        true -> 35.0
        else -> abs(cardType._freeLimit - cardType._transferAmount - transferAmount) * 0.0075
    }
    "Мир" -> when (abs(cardType._freeLimit - cardType._transferAmount - transferAmount) * 0.0075 < 35) {
        true -> 35.0
        else -> abs(cardType._freeLimit - cardType._transferAmount - transferAmount) * 0.0075
    }
    else -> 0.0
}
