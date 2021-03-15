fun main() {
    print("""Введите Тип карты/счёта
         1: MasterCard и Maestro
         2: Visa и Мир
         (по умолчанию - Vk Pay): """.trimMargin())
    val cardType:Int = checkMyReadLine()
    print("Введите сумму предыдущих переводов в этом месяце (по умолчанию - 0): ")
    val amountPreviousTransfer:Int = checkMyReadLine()
    print("Введите сумму перевода в копейках: ")
    val amount:Int = readLine()!!.toInt()
    println("""Сумма перевода: $amount коп.
      Комиссия: ${printMyAmountСommission(cardType, amountPreviousTransfer, amount)} коп.
        """.trimMargin())
}

fun checkMyReadLine(): Int {
    val myString:String = readLine()!!
    return if (myString.isEmpty()) 0 else myString.toInt()
}

fun printMyAmountСommission(cardType: Int, amountPreviousTransfer: Int, amount: Int):Int {
    return when (cardType) {
        1 -> giveMyMasterCardMaestro(amountPreviousTransfer, amount)
        2 -> giveMyVisaMir(amount)
        else -> 0
    }
}

fun giveMyMasterCardMaestro(amountPreviousTransfer:Int, amount: Int):Int {
    return when (amountPreviousTransfer) {
        in 300 until 75000 -> 0
        else -> (amount * 0.006 + 2000).toInt()
    }
}

fun giveMyVisaMir(amount: Int, minCommission: Int = 3500):Int {
    return if (amount*0.0075<=minCommission) minCommission else (amount*0.0075).toInt()
}