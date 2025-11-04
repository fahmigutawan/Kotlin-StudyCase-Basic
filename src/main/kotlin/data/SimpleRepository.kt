package data

import model.Mahasiswa

/**
 * SimpleRepository digunakan untuk mengumpulkan semua logika bisnis dari proyek.
 */
object SimpleRepository {
    fun addNewMahasiswa(
        nim:String,
        nama:String,
        jurusan:String,
        nilaiMatkul:Map<String, Int>
    ){
        TODO()
    }

    fun getAllMahasiswa(): List<Mahasiswa> {
        TODO()
    }

    fun getAllMahasiswaLulus(): List<Mahasiswa> {
        TODO()
    }

    fun getAllMahasiswaTidakLulus(): List<Mahasiswa> {
        TODO()
    }
}