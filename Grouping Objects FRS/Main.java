import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Dosen
        Dosen d1 = new Dosen("Radityo Anggoro");
        Dosen d2 = new Dosen("Royyana Muslim");
        Dosen d3 = new Dosen("Baskoro Adi");
        Dosen d4 = new Dosen("Dini Adni");
        Dosen d5 = new Dosen("Chastine");
        Dosen d6 = new Dosen("Hilmi Muchtar");
        Dosen d7 = new Dosen("Ilham Gurat");

        // Array daftar mata kuliah
        MataKuliah[] daftarMK = {
            new MataKuliah("Jaringan Komputer", "JK01", 4, d1),
            new MataKuliah("Jaringan Komputer", "JK02", 4, d2),
            new MataKuliah("Jaringan Komputer", "JK03", 4, d3),
            new MataKuliah("Konsep Kecerdasan Artifisial", "KKA01", 3, d4),
            new MataKuliah("Konsep Kecerdasan Artifisial", "KKA02", 3, d5),
            new MataKuliah("Matematika Diskrit", "MD01", 3, d6),
            new MataKuliah("Matematika Diskrit", "MD02", 3, d7)
        };

        // Karena saya buat sederhana, jadi saya anggap mahasiswanya hanya saya
        Mahasiswa mhs = new Mahasiswa("Salwa Nadia Maharani", "5025241041");

        System.out.println("Daftar Mata Kuliah yang bisa diambil:");
        for (int i = 0; i < daftarMK.length; i++) {
            System.out.println((i+1) + ". " + daftarMK[i]);
        }

        System.out.print("Jumlah mata kuliah yg ingin diambil: ");
        int jumlah = sc.nextInt();

        for (int i = 0; i < jumlah; i++) {
            System.out.print("Pilih MK ke-" + (i+1) + ": ");
            int pilihan = sc.nextInt();
            sc.nextLine();
            if (pilihan >= 1 && pilihan <= daftarMK.length) {
                mhs.tambahMataKuliah(daftarMK[pilihan-1]);
            } else {
                System.out.println("Pilihan tidak valid!");
                i--; 
            }
        }

        System.out.println();
        mhs.tampilkanFRS();
    }
}
