package academic.driver;

import academic.model.Enrollment;
import java.util.Scanner;
import java.util.ArrayList;

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

    private static ArrayList<Enrollment> enrollments = new ArrayList<>();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String line;

        while (input.hasNextLine()) {
            line = input.nextLine();

            if (line.equals("---")) {
                break;
            }

            String[] parts = line.split("#");

            if (parts.length == 4) {
                String courseCode = parts[0];
                String studentId = parts[1];
                String academicYear = parts[2];
                String semester = parts[3];

                Enrollment newEnrollment = new Enrollment(courseCode, studentId, academicYear, semester);
                enrollments.add(newEnrollment);
            } else {
                System.err.println("Format input tidak valid untuk Enrollment: " + line);
            }
        }

        for (Enrollment enrollment : enrollments) {
            System.out.println(enrollment.toString());
        }

        input.close();
    }
}

