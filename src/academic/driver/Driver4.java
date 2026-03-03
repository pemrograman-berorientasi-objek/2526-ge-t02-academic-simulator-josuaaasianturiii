package academic.driver;

import academic.model.Course;
import academic.model.Student;
import academic.model.Enrollment;
import java.util.Scanner;
import java.util.ArrayList; // Menggunakan ArrayList untuk penyimpanan dinamis, lebih fleksibel dari array statis

/**
 * Driver class untuk mensimulasikan kemampuan penyimpanan multiple untuk Course, Student, dan Enrollment.
 * Kelas ini akan membaca input dari pengguna, mengidentifikasi jenis entitas berdasarkan prefix,
 * membuat objek yang sesuai, menyimpannya, dan menampilkannya kembali.
 *
 * Sebagai mahasiswa semester 3 yang sedang mempelajari PBO, kita akan melihat bagaimana
 * multiple objek dari tipe yang berbeda dapat dikelola dalam satu program utama,
 * menggunakan ArrayList untuk mengatasi keterbatasan ukuran array statis.
 */
public class Driver4 {

    // Menggunakan ArrayList untuk penyimpanan dinamis, sehingga kita tidak perlu membatasi MAX_COURSES, dll.
    private static ArrayList<Course> courses = new ArrayList<>();
    private static ArrayList<Student> students = new ArrayList<>();
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

            // --- Langkah 4: Memproses baris input berdasarkan prefix perintah ---
            // Setiap baris input diawali dengan perintah (e.g., "course-add", "student-add", "enrollment-add").
            String[] parts = line.split("#"); // Pisahkan string input menjadi beberapa bagian berdasarkan '#'.

            // Pastikan ada setidaknya satu bagian (perintah)
            if (parts.length > 0) {
                String command = parts[0]; // Bagian pertama adalah perintah

                // Kita akan menggunakan switch-case atau if-else if untuk membedakan perintah
                switch (command) {
                    case "course-add":
                        // Memproses input untuk Course
                        if (parts.length == 5) { // command + 4 data = 5 parts
                            String code = parts[1];
                            String name = parts[2];
                            int credits = Integer.parseInt(parts[3]);
                            String grade = parts[4]; // Nilai ini akan diabaikan jika Course hanya menyimpan metadata, tapi kita simpan saja

                            Course newCourse = new Course(code, name, credits, grade);
                            courses.add(newCourse); // Tambahkan objek Course ke ArrayList
                        } else {
                            System.err.println("Format input tidak valid untuk Course: " + line);
                        }
                        break;
                    case "student-add":
                        // Memproses input untuk Student
                        if (parts.length == 5) { // command + 4 data = 5 parts
                            String id = parts[1];
                            String name = parts[2];
                            int year = Integer.parseInt(parts[3]); // Menggunakan 'year' sesuai Student.java (jika sudah diubah)
                            String major = parts[4];

                            Student newStudent = new Student(id, name, year, major);
                            students.add(newStudent); // Tambahkan objek Student ke ArrayList
                        } else {
                            System.err.println("Format input tidak valid untuk Student: " + line);
                        }
                        break;
                    case "enrollment-add":
                        // Memproses input untuk Enrollment
                        if (parts.length == 5) { // command + 4 data = 5 parts
                            String courseCode = parts[1];
                            String studentId = parts[2];
                            String academicYear = parts[3];
                            String semester = parts[4];

                            // Perhatikan bahwa konstruktor Enrollment di Tugas 3 secara default menetapkan grade "None"
                            Enrollment newEnrollment = new Enrollment(courseCode, studentId, academicYear, semester);
                            enrollments.add(newEnrollment); // Tambahkan objek Enrollment ke ArrayList
                        } else {
                            System.err.println("Format input tidak valid untuk Enrollment: " + line);
                        }
                        break;
                    default:
                        System.err.println("Perintah tidak dikenal: " + command);
                        break;
                }
            } else {
                System.err.println("Input kosong atau tidak valid: " + line);
            }
        }

        // --- Langkah 5: Setelah input berhenti, tampilkan semua entitas yang tersimpan ---
        // Urutan output sesuai dengan permintaan: Course, lalu Student, lalu Enrollment.

        // Tampilkan semua Course
        for (Course course : courses) {
            System.out.println(course.toString());
        }

        // Tampilkan semua Student
        for (Student student : students) {
            System.out.println(student.toString());
        }

        // Tampilkan semua Enrollment
        for (Enrollment enrollment : enrollments) {
            System.out.println(enrollment.toString());
        }

        // --- Langkah 6: Tutup objek Scanner ---
        // Penting untuk menutup Scanner setelah selesai digunakan untuk mencegah kebocoran sumber daya.
        input.close();
    }
}