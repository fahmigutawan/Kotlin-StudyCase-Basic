package model

/**
 * data class Mahasiswa digunakan untuk membuat blueprint data yang bisa disimpan di SimpleDatabase.
 * Di dalamnya juga terdapat beberapa fungsi yang gunanya untuk melakukan operasi tertentu
 */
data class Mahasiswa(
    val nim: String,
    val nama: String,
    val jurusan: String,
    val nilaiMatkul: MutableMap<String, Int>? = null
) {
    fun average(): Double {
        /*
        Kembalikan rata-rata dari nilaiMatkul
         */
        TODO()
    }

    fun status(): String {
        /*
        Kembalikan "Lulus" atau "Tidak Lulus", dengan kriteria sebagai berikut:
        Jika rata-rata < 55, maka tidak lulus
        Jika rata-rata >= 55, maka lulus
         */
        TODO()
    }

    fun printPerLine(no: Int? = null):String {
        /*
        Print baris Mahasiswa dengan masing-masing memiliki format penulisan berikut:
        [No]. [NIM] - [NAMA] - [JURUSAN] | Rata-rata: [RATA-RATA] | [STATUS]
         */
        TODO()
    }
}
