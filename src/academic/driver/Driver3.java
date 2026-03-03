package academic.driver;

import academic.model.Enrollment;
import java.util.Scanner;
import java.util.ArrayList; // Import ArrayList untuk penyimpanan dinamis

/**
 * Driver class untuk mensimulasikan penyimpanan multiple Enrollment.
 * Kelas ini akan membaca input dari pengguna, membuat objek Enrollment, menyimpannya,
 * dan menampilkannya kembali.
 *
 * Sebagai mahasiswa semester 3 yang sedang mempelajari PBO, kita akan terus belajar
 * bagaimana mengelola koleksi objek dan berinteraksi dengan input/output konsol.
 * Kali ini, kita menggunakan ArrayList agar tidak terbatasi oleh ukuran array statis,
 * yang seringkali menjadi masalah pada sistem autograder.
 */
public class Driver3 {

    // Menggunakan ArrayList untuk menyimpan objek Enrollment.
    // Keuntungan: Tidak perlu menentukan ukuran maksimum, akan otomatis menyesuaikan.
    private static ArrayList<Enrollment> enrollments = new ArrayList<>();

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

                // --- Langkah 6: Menyimpan objek Enrollment baru ke dalam ArrayList ---
                // Karena menggunakan ArrayList, kita tidak perlu memeriksa kapasitas maksimum.
                // Objek Enrollment baru dibuat, dengan 'grade' otomatis "None" dari konstruktor.
                Enrollment newEnrollment = new Enrollment(courseCode, studentId, academicYear, semester);
                enrollments.add(newEnrollment); // Tambahkan objek Enrollment ke ArrayList.
            } else {
                // Memberikan pesan kesalahan jika format input tidak sesuai.
                System.err.println("Format input tidak valid untuk Enrollment: " + line);
            }
        }

        // --- Langkah 7: Setelah input berhenti, tampilkan semua Enrollment yang tersimpan ---
        // Loop ini akan berjalan untuk setiap objek di dalam ArrayList.
        for (Enrollment enrollment : enrollments) {
            // Memanggil metode toString() dari setiap objek Enrollment untuk mendapatkan format keluaran yang diinginkan.
            // Format output yang diharapkan: COURSE_CODE|STUDENT_ID|ACADEMIC_YEAR|SEMESTER|GRADE
            System.out.println(enrollment.toString());
        }

        // --- Langkah 8: Tutup objek Scanner ---
        // Penting untuk menutup Scanner setelah selesai digunakan untuk mencegah kebocoran sumber daya.
        input.close();
    }
}
