package data

import model.Mahasiswa

/**
 * SimpleDatabase adalah tempat untuk menyimpan data.
 * Secara teknis, SimpleDatabase bukanlah database sesungguhnya, namun kegunaannya mirip
 */
object SimpleDatabase {
    val mahasiswaList = mutableListOf<Mahasiswa>()
}