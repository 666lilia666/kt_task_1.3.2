fun main() {
    val transferAmount = 30
    val vk = Card("VK PAY", 0)
    val master = Card("MasterCard", 50_000, 75_000,0.006,20)
    val maestro = Card("Maestro", 0, 75_000,0.006,20)
    val mir = Card("Мир", 0,0,0.0075,0,35)
    val visa = Card("Visa", 0,0,0.0075,0,35)

    vk.commissionMassage(transferAmount)
    maestro.commissionMassage(transferAmount)
    master.commissionMassage(transferAmount)
    mir.commissionMassage(transferAmount)
    visa.commissionMassage(transferAmount)

    println(vk.commission(transferAmount))
    println(maestro.commission(transferAmount))
    println(master.commission(transferAmount))
    println(mir.commission(transferAmount))
    println(visa.commission(transferAmount))
}
