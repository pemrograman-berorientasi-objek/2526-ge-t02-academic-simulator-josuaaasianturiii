package academic.model;

/**
 * Kelas Course merepresentasikan sebuah mata kuliah.
 * Ini adalah model data yang akan menyimpan informasi tentang mata kuliah.
 */
public class Course {
    private String code;        // Kode mata kuliah
    private String name;        // Nama mata kuliah
    private int credits;        // Jumlah SKS
    private String grade;       // Nilai akhir

    /**
     * Konstruktor untuk membuat objek Course baru.
     * @param code Kode mata kuliah (contoh: 12S2203)
     * @param name Nama mata kuliah (contoh: Object-oriented Programming)
     * @param credits Jumlah SKS (contoh: 3)
     * @param grade Nilai akhir (contoh: C)
     */
    public Course(String code, String name, int credits, String grade) {
        this.code = code;
        this.name = name;
        this.credits = credits;
        this.grade = grade;
    }

    // --- Metode Getter untuk mengakses properti Course ---

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public int getCredits() {
        return credits;
    }

    public String getGrade() {
        return grade;
    }

    /**
     * Metode untuk menghasilkan representasi string dari objek Course.
     * Format: CODE|NAME|CREDITS|GRADE
     * @return String representasi Course
     */
    @Override
    public String toString() {
        return code + "|" + name + "|" + credits + "|" + grade;
    }
}