package academic.driver;

import academic.model.Enrollment;
import java.util.Scanner;

/**
 * Driver class untuk mensimulasikan penyimpanan multiple Enrollment menggunakan array.
 * Kelas ini akan membaca input dari pengguna, membuat objek Enrollment, menyimpannya,
 * dan menampilkannya kembali.
 *
 * Sebagai mahasiswa semester 3 yang sedang mempelajari PBO, kita akan terus belajar
 * bagaimana mengelola koleksi objek dengan array dan berinteraksi dengan input/output konsol.
 * Kita juga akan melihat bagaimana sebuah nilai default bisa ditetapkan pada objek.
 */
public class Driver3 {

    // Ukuran maksimum array untuk menyimpan Enrollment.
    // Ini menunjukkan batasan dari penggunaan array statis.
    private static final int MAX_ENROLLMENTS = 100;
    private static Enrollment[] enrollments = new Enrollment[MAX_ENROLLMENTS]; // Array untuk menyimpan objek Enrollment
    private static int enrollmentCount = 0; // Menghitung berapa banyak Enrollment yang sudah tersimpan

    public static void main(String[] args) {
        // --- Langkah 1: Inisialisasi Scanner untuk membaca input dari konsol ---
        // Objek Scanner digunakan untuk menerima masukan interaktif dari pengguna melalui keyboard.
        Scanner input = new Scanner(System.in);
        String line; // Variabel untuk menampung setiap baris input yang dibaca.

        // --- Langkah 2: Membaca input secara berulang hingga perintah berhenti diterima ---
        // Loop 'while' ini akan terus berjalan selama masih ada baris input dan belum ada perintah berhenti.
        while (input.hasNextLine()) {
            line = input.nextLine(); // Baca satu baris input dari pengguna.

            // --- Langkah 3: Cek apakah baris input adalah perintah berhenti "---" ---
            // Jika baris yang dibaca sama persis dengan "---", maka program akan berhenti membaca input.
            if (line.equals("---")) {
                break; // Keluar dari loop pembacaan input.
            }

            // --- Langkah 4: Memproses baris input data Enrollment ---
            // Setiap baris data Enrollment diharapkan memiliki 4 bagian yang dipisahkan oleh karakter '#'.
            // Contoh format: CourseCode#StudentId#AcademicYear#Semester
            String[] parts = line.split("#"); // Pisahkan string input menjadi beberapa bagian berdasarkan '#'.

            // --- Langkah 5: Validasi jumlah bagian dan pembuatan objek Enrollment ---
            // Pastikan bahwa baris input memiliki 4 bagian yang lengkap sebelum mencoba membuat objek Enrollment.
            if (parts.length == 4) {
                // Ekstraksi data dari bagian-bagian string yang sudah dipisahkan.
                String courseCode = parts[0];
                String studentId = parts[1];
                String academicYear = parts[2];
                String semester = parts[3];

                // --- Langkah 6: Menyimpan objek Enrollment baru ke dalam array ---
                // Cek agar array tidak melebihi kapasitas maksimum yang telah ditentukan.
                if (enrollmentCount < MAX_ENROLLMENTS) {
                    // Buat objek Enrollment baru. Perhatikan bahwa 'grade' akan otomatis "None" dari konstruktor.
                    Enrollment newEnrollment = new Enrollment(courseCode, studentId, academicYear, semester);
                    enrollments[enrollmentCount] = newEnrollment; // Simpan objek Enrollment ke dalam array pada indeks 'enrollmentCount'.
                    enrollmentCount++; // Tingkatkan jumlah Enrollment yang telah tersimpan.
                } else {
                    // Memberikan pesan kesalahan jika array penuh.
                    System.err.println("Penyimpanan penuh, tidak bisa menambah Enrollment lagi.");
                }
            } else {
                // Memberikan pesan kesalahan jika format input tidak sesuai.
                System.err.println("Format input tidak valid untuk Enrollment: " + line);
            }
        }

        // --- Langkah 7: Setelah input berhenti, tampilkan semua Enrollment yang tersimpan ---
        // Loop ini akan berjalan dari indeks pertama hingga indeks terakhir Enrollment yang tersimpan.
        for (int i = 0; i < enrollmentCount; i++) {
            // Memanggil metode toString() dari setiap objek Enrollment untuk mendapatkan format keluaran yang diinginkan.
            // Format output yang diharapkan: COURSE_CODE|STUDENT_ID|ACADEMIC_YEAR|SEMESTER|GRADE
            System.out.println(enrollments[i].toString());
        }

        // --- Langkah 8: Tutup objek Scanner ---
        // Penting untuk menutup Scanner setelah selesai digunakan untuk mencegah kebocoran sumber daya.
        input.close();
    }
}
