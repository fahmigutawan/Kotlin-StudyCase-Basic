package util

object NilaiUtil {
    fun getHuruf(nilai: Int) {
        when (nilai) {
            in 85..100 -> "A"
            in 70..84 -> "B"
            in 55..69 -> "C"
            in 40..54 -> "D"
            else -> "E"
        }
    }
}