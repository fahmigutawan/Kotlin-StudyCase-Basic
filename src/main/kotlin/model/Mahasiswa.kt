package model

/**
 * data class Mahasiswa digunakan untuk membuat blueprint data yang bisa disimpan di SimpleDatabase.
 * Di dalamnya juga terdapat beberapa fungsi yang gunanya untuk melakukan operasi tertentu
 */

data class Mahasiswa(
    val nim: String,
    val nama: String,
    val jurusan: String,
    val nilaiMatkul: Map<String, Int>
) {
    fun average(): Double {
        TODO()
    }

    fun status(): String {
        // Jika average >= 55, Lulus
        // Jika average < 55, Tidak Lulus
        TODO()
    }

    fun printPerLine() {
        // Print dalam bentuk
        // "> [NIM] - [NAMA] - [JURUSAN] | Rata-rata: [AVERAGE] | [STATUS]"
        TODO()
    }
}



