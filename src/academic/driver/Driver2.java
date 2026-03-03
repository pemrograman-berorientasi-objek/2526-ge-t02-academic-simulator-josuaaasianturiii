package academic.driver;

import academic.model.Student;
import java.util.Scanner;

/**
 * Driver class untuk mensimulasikan penyimpanan multiple Student menggunakan array.
 * Kelas ini berfungsi mirip dengan Driver1, tetapi fokus pada entitas Student.
 * Kita akan belajar bagaimana membuat objek Student, menyimpannya dalam array,
 * dan menampilkannya, sambil memperkuat konsep PBO sederhana.
 */
public class Driver2 {

    // Kita tentukan ukuran maksimum array untuk menyimpan Student.
    // Ini menunjukkan bagaimana array statis memiliki batasan kapasitas.
    private static final int MAX_STUDENTS = 100;
    private static Student[] students = new Student[MAX_STUDENTS]; // Array untuk menyimpan objek Student
    private static int studentCount = 0; // Menghitung berapa banyak Student yang sudah tersimpan

    public static void main(String[] args) {
        // --- Langkah 1: Siapkan alat untuk membaca input dari konsol ---
        // Objek Scanner akan kita gunakan untuk membaca setiap baris masukan dari pengguna.
        Scanner input = new Scanner(System.in);
        String line; // Variabel sementara untuk menyimpan setiap baris yang dibaca

        // --- Langkah 2: Lakukan perulangan untuk membaca input secara terus-menerus ---
        // Loop ini akan berjalan selama masih ada baris input yang diberikan dan belum ada perintah berhenti.
        while (input.hasNextLine()) {
            line = input.nextLine(); // Baca satu baris penuh dari konsol

            // --- Langkah 3: Periksa apakah input adalah perintah untuk berhenti ---
            // Jika pengguna mengetik "---", program akan berhenti menerima input.
            if (line.equals("---")) {
                break; // Keluar dari loop pembacaan input
            }

            // --- Langkah 4: Proses baris input untuk membuat objek Student ---
            // Setiap baris data Student dipisahkan oleh karakter '#'.
            // Contoh format: 12S20999#Wiro Sableng#2020#Information Systems
            String[] parts = line.split("#"); // Memisahkan string berdasarkan tanda '#'

            // Kita harus memastikan bahwa ada 4 bagian data (NIM, Nama, Tahun, Jurusan)
            if (parts.length == 4) {
                String id = parts[0];
                String name = parts[1];
                // Mengkonversi string tahun menjadi integer, karena properti 'year' di Student adalah int.
                int year = Integer.parseInt(parts[2]);
                String major = parts[3];

                // --- Langkah 5: Buat objek Student baru dan simpan ke dalam array ---
                // Sebelum menyimpan, kita cek apakah array masih memiliki ruang kosong.
                if (studentCount < MAX_STUDENTS) {
                    Student newStudent = new Student(id, name, year, major); // Buat objek Student baru
                    students[studentCount] = newStudent; // Simpan objek ke posisi yang tersedia di array
                    studentCount++; // Tambahkan jumlah Student yang sudah tersimpan
                } else {
                    // Jika array penuh, berikan pesan error (untuk pembelajaran penanganan batasan).
                    System.err.println("Penyimpanan penuh, tidak bisa menambah Student lagi.");
                }
            } else {
                // Jika format input tidak sesuai, beritahu pengguna.
                System.err.println("Format input tidak valid: " + line);
            }
        }

        // --- Langkah 6: Setelah semua input diterima, tampilkan data Student yang tersimpan ---
        // Loop ini akan mengulang dari awal array hingga jumlah Student yang benar-benar tersimpan.
        for (int i = 0; i < studentCount; i++) {
            // Memanggil metode toString() dari setiap objek Student untuk mencetak datanya.
            // Format output yang diinginkan: ID|NAME|YEAR|MAJOR
            System.out.println(students[i].toString());
        }

        // --- Langkah 7: Tutup objek Scanner ---
        // Ini adalah langkah penting untuk melepaskan sumber daya sistem yang digunakan oleh Scanner.
        input.close();
    }
}