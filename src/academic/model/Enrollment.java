package academic.model;

/**
 * Kelas Enrollment merepresentasikan pendaftaran mahasiswa pada suatu mata kuliah
 * dalam periode akademik tertentu.
 * Ini adalah model data yang akan menyimpan detail seperti kode mata kuliah, ID mahasiswa,
 * tahun/semester akademik, dan nilai yang diperoleh.
 * Dirancang untuk mahasiswa semester 3 yang sedang mempelajari PBO.
 */
public class Enrollment {
    private String courseCode;      // Kode mata kuliah (contoh: 12S2203)
    private String studentId;       // ID mahasiswa (contoh: 12S20999)
    private String academicYear;    // Tahun akademik (contoh: 2021/2022)
    private String semester;        // Semester (contoh: even)
    private String grade;           // Nilai yang diperoleh (contoh: A, B, C, D, E, None)

    /**
     * Konstruktor untuk membuat objek Enrollment baru.
     * Secara default, nilai awal (grade) akan diatur ke "None" jika tidak disediakan,
     * sesuai dengan contoh output yang diberikan.
     *
     * @param courseCode Kode mata kuliah yang di-enroll.
     * @param studentId ID mahasiswa yang melakukan enrollment.
     * @param academicYear Tahun akademik enrollment.
     * @param semester Semester enrollment (misalnya: "even", "odd").
     */
    public Enrollment(String courseCode, String studentId, String academicYear, String semester) {
        this.courseCode = courseCode;
        this.studentId = studentId;
        this.academicYear = academicYear;
        this.semester = semester;
        this.grade = "None"; // Nilai default, sesuai contoh output
    }

    // --- Metode Getter untuk mengakses properti Enrollment ---

    public String getCourseCode() {
        return courseCode;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getAcademicYear() {
        return academicYear;
    }

    public String getSemester() {
        return semester;
    }

    public String getGrade() {
        return grade;
    }

    /**
     * Metode untuk menghasilkan representasi string dari objek Enrollment.
     * DIKEMBALIKAN: Menyertakan 'semester' dalam output string agar sesuai dengan
     *              format 'expected-output' t02-03-01 dan deskripsi awal tugas 03.
     *              (COURSE_CODE|STUDENT_ID|ACADEMIC_YEAR|SEMESTER|GRADE).
     * @return String representasi Enrollment
     */
    @Override
    public String toString() {
        return courseCode + "|" + studentId + "|" + academicYear + "|" + semester + "|" + grade;
    }
}
