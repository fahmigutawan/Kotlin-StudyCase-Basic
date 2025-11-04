package presentation

import data.SimpleDatabase
import data.SimpleRepository
import model.Mahasiswa
import util.NilaiUtil
import kotlin.system.exitProcess

object SimpleNavigation {
    fun showDashboard() {
        while (true) {
            println("\n===== DASHBOARD AKADEMIK =====")
            println("1. Lihat Semua Mahasiswa")
            println("2. Tambah Mahasiswa")
            println("3. Detail Mahasiswa")
            println("4. Mahasiswa Lulus")
            println("5. Mahasiswa Tidak Lulus")
            println("0. Keluar")
            print("Pilih menu: ")

            when (readLine()?.trim()) {
                "1" -> showAllMahasiswaUI()
                "2" -> showAddMahasiswaUI()
                "3" -> showDetailMahasiswaUI()
                "4" -> showMahasiswaLulusUI()
                "5" -> showMahasiswaTidakLulusUI()
                "0" -> exitProcess(0)
                else -> println("Pilihan tidak valid.")
            }
        }
    }

    fun showAllMahasiswaUI() {
        println("\n===== DAFTAR MAHASISWA =====")

        val mahasiswa = SimpleRepository.getAllMahasiswaLulus()

        if (mahasiswa.isEmpty()) {
            println("Belum ada mahasiswa.")
            return
        }

        mahasiswa.forEachIndexed { index, item ->
            item.printPerLine(index + 1)
        }
    }

    fun showAddMahasiswaUI() {
        println("\n===== TAMBAH MAHASISWA =====")

        print("NIM: ");
        val nim = readLine()?.trim().orEmpty()

        print("Nama: ");
        val nama = readLine()?.trim().orEmpty()

        print("Jurusan: ");
        val jurusan = readLine()?.trim().orEmpty()

        val nilaiMatkul = mutableMapOf<String, Int>()

        while (true) {
            print("Masukkan nama mata kuliah (kosongkan untuk selesai): ")
            val mk = readLine()?.trim().orEmpty()
            if (mk.isEmpty()) break
            print("Nilai (0-100): ")
            val nilai = readLine()?.toIntOrNull() ?: continue
            nilaiMatkul.put(mk, nilai)
        }

        SimpleRepository.addNewMahasiswa(
            nim = nim,
            nama = nama,
            jurusan = jurusan,
            nilaiMatkul = nilaiMatkul,
        )

        println("Mahasiswa berhasil ditambahkan.")
    }

    fun showDetailMahasiswaUI() {
        println("\n===== DETAIL MAHASISWA =====")
        print("Masukkan NIM: ")
        val nim = readLine()?.trim()
        val mhs = SimpleDatabase.mahasiswaList.find { it.nim == nim }

        if (mhs == null) {
            println("Mahasiswa tidak ditemukan.")
            return
        }

        println("NIM: ${mhs.nim}")
        println("Nama: ${mhs.nama}")
        println("Jurusan: ${mhs.jurusan}")
        println("Status: ${mhs.status()}")
        println("Rata-rata: ${mhs.average()}")

        if (mhs.nilaiMatkul.isNullOrEmpty()) {
            println("Belum ada nilai untuk mahasiswa ini.")
        } else {
            println("Daftar Nilai:")
            mhs.nilaiMatkul.forEach {
                TODO()
                // Print per-baris dengan format:
                // - [Nama Matkul]: [Nilai] ([Huruf Nilai])
            }
        }
    }

    fun showMahasiswaLulusUI() {
        println("\n===== MAHASISWA LULUS =====")
        val lulus = SimpleRepository.getAllMahasiswaLulus()

        if (lulus.isEmpty()) {
            println("Belum ada mahasiswa yang lulus.")
            return
        }

        lulus.forEachIndexed { index, item ->
            item.printPerLine(index + 1)
        }
    }

    fun showMahasiswaTidakLulusUI() {
        println("\n===== MAHASISWA TIDAK LULUS =====")
        val tidakLulus = SimpleRepository.getAllMahasiswaTidakLulus()

        if (tidakLulus.isEmpty()) {
            println("Tidak ada mahasiswa yang tidak lulus.")
            return
        }

        tidakLulus.forEachIndexed { index, item ->
            item.printPerLine(index + 1)
        }
    }
}