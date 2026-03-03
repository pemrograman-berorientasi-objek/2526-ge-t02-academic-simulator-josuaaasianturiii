package academic.driver;

import academic.model.Course;
import java.util.Scanner;

/**
 * Driver class untuk mensimulasikan penyimpanan multiple Course menggunakan array.
 * Kelas ini akan membaca input dari pengguna, membuat objek Course, menyimpannya,
 * dan menampilkannya kembali..
 *
 * Sebagai mahasiswa yang sedang mempelajari PBO, kita akan melihat bagaimana
 * data disimpan dalam objek dan diorganisir dalam struktur data sederhana (array).
 */
public class Driver1 {

    // Ukuran maksimum array untuk menyimpan Course.
    // Ini adalah contoh batasan karena menggunakan array statis.
    private static final int MAX_COURSES = 100;
    private static Course[] courses = new Course[MAX_COURSES]; // Array untuk menyimpan objek Course
    private static int courseCount = 0; // Menghitung berapa banyak Course yang sudah tersimpan

    public static void main(String[] args) {
        // --- Langkah 1: Inisialisasi Scanner untuk membaca input dari konsol ---
        // Scanner adalah alat bantu untuk membaca masukan interaktif dari pengguna.
        Scanner input = new Scanner(System.in);
        String line; // Variabel untuk menyimpan setiap baris input

        // --- Langkah 2: Membaca input secara berulang sampai ada perintah berhenti ---
        // Loop ini akan terus berjalan selama pengguna memasukkan baris data.
        while (input.hasNextLine()) {
            line = input.nextLine(); // Baca satu baris input

            // --- Langkah 3: Cek apakah baris input adalah perintah berhenti "---" ---
            if (line.equals("---")) {
                break; // Jika ya, keluar dari loop
            }

            // --- Langkah 4: Memproses baris input data Course ---
            // Setiap baris data Course dipisahkan oleh karakter '#'
            // Contoh: 12S2203#Object-oriented Programming#3#C
            String[] parts = line.split("#"); // Pisahkan string berdasarkan '#'

            // Pastikan ada 4 bagian data sebelum mencoba membuatnya menjadi objek Course
            if (parts.length == 4) {
                String code = parts[0];
                String name = parts[1];
                int credits = Integer.parseInt(parts[2]); // Konversi String ke Integer untuk SKS
                String grade = parts[3];

                // --- Langkah 5: Membuat objek Course baru dan menyimpannya ke array ---
                // Pastikan array tidak penuh sebelum menambahkan Course baru
                if (courseCount < MAX_COURSES) {
                    Course newCourse = new Course(code, name, credits, grade);
                    courses[courseCount] = newCourse; // Simpan objek Course ke dalam array
                    courseCount++; // Tambah hitungan Course yang tersimpan
                } else {
                    System.err.println("Penyimpanan penuh, tidak bisa menambah Course lagi.");
                }
            } else {
                // Memberi tahu pengguna jika format input salah, agar mudah dipelajari
                System.err.println("Format input tidak valid: " + line);
            }
        }

        // --- Langkah 6: Setelah input berhenti, tampilkan semua Course yang tersimpan ---
        // Loop ini akan mengulang dari indeks 0 sampai jumlah Course yang tersimpan.
        for (int i = 0; i < courseCount; i++) {
            // Memanggil metode toString() dari objek Course untuk mendapatkan format output yang diinginkan.
            System.out.println(courses[i].toString());
        }

        // --- Langkah 7: Tutup scanner untuk menghindari resource leak ---
        // Ini adalah praktik yang baik dalam pemrograman untuk mengelola sumber daya.
        input.close();
    }
}
