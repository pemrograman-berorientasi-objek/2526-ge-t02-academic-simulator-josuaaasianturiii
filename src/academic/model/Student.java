package academic.model;

/**
 * Kelas Student merepresentasikan informasi dasar seorang mahasiswa.
 * Ini adalah model data yang akan menyimpan detail seperti NIM, nama, tahun masuk, dan program studi.
 */
public class Student {
    private String id;          // Nomor Induk Mahasiswa (NIM)
    private String name;        // Nama lengkap mahasiswa
    private int year;           // Tahun masuk mahasiswa
    private String major;       // Program Studi/Jurusan

    /**
     * Konstruktor untuk membuat objek Student baru.
     * @param id NIM mahasiswa (contoh: 12S20999)
     * @param name Nama mahasiswa (contoh: Wiro Sableng)
     * @param year Tahun masuk (contoh: 2020)
     * @param major Program Studi (contoh: Information Systems)
     */
    public Student(String id, String name, int year, String major) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.major = major;
    }

    // --- Metode Getter untuk mengakses properti Student ---

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public String getMajor() {
        return major;
    }

    /**
     * Metode untuk menghasilkan representasi string dari objek Student.
     * Format: ID|NAME|YEAR|MAJOR
     * @return String representasi Student
     */
    @Override
    public String toString() {
        return id + "|" + name + "|" + year + "|" + major;
    }
}