package ru.netology

import kotlin.math.roundToInt

fun calculationCommission(card: String = "Мир", amountMonth: Int = 0, amount: Int): Double {
    if (amount > 150_000 || amountMonth >= 600_000) {
        println("Ошибка, превышение лимита переводов")
        return 0.0
    }
    return when {
        card == "Mastercard" && amountMonth > 75_000 || card == "Mastercard" && amount > 75000 ->
            if (amount > 75_000) (amount - 75_000) * 0.006 + 20 else amount * 0.006 + 20
        card == "Visa" -> if (amount * 0.0075 > 35) amount * 0.0075 else 35.0
        else -> 0.0
    }
}

fun main() {
    val amount = 80_000
    val amountMonth = 424569 + amount
    val card = "Visa"

    val commission = (calculationCommission(card, amountMonth, amount)).roundToInt()
    println("Комиссия составляет $commission руб.")
}