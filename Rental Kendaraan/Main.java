import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        List<Kendaraan> daftarKendaraan = new ArrayList<>();
        daftarKendaraan.add(new Mobil("McLaren", "Senna", 2018, 4));
        daftarKendaraan.add(new Motor("Yamaha", "NMAX", 2021, 2));
        daftarKendaraan.add(new Sepeda("Polygon", "Strattos", 2020, "Balap"));
        daftarKendaraan.add(new Sepeda("BMX", "Street", 2019, "BMX"));
        daftarKendaraan.add(new Mobil("Honda", "Civic", 2023, 4));

        List<Penyewa> daftarPenyewa = new ArrayList<>();

        boolean lanjut = true;
        while (lanjut) {
            if (daftarKendaraan.isEmpty()) {
                System.out.println("Maaf, semua kendaraan sudah disewa!");
                break;
            }

            System.out.print("\nMasukkan nama penyewa: ");
            String nama = input.nextLine();

            System.out.println("\n=== Daftar Kendaraan Tersedia ===");
            for (int i = 0; i < daftarKendaraan.size(); i++) {
                System.out.println((i + 1) + ". " + daftarKendaraan.get(i));
            }

            System.out.print("\nPilih nomor kendaraan yang ingin disewa: ");
            int pilihan;

            try {
                pilihan = Integer.parseInt(input.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Input tidak valid. Coba lagi.");
                continue;
            }

            if (pilihan < 1 || pilihan > daftarKendaraan.size()) {
                System.out.println("Pilihan tidak valid!");
                continue;
            }

            Kendaraan dipilih = daftarKendaraan.get(pilihan - 1);
            daftarPenyewa.add(new Penyewa(nama, dipilih));
            daftarKendaraan.remove(pilihan - 1);

            System.out.println("\nPenyewaan berhasil!");
            System.out.println(nama + " menyewa " + dipilih);

            System.out.print("\nApakah ingin sewa lagi? (y/n): ");
            String jawab = input.nextLine().trim().toLowerCase();
            if (!jawab.equals("y")) {
                lanjut = false;
            }
        }

        System.out.println("\n=== DAFTAR PENYEWA ===");
        if (daftarPenyewa.isEmpty()) {
            System.out.println("Belum ada penyewa.");
        } else {
            for (Penyewa p : daftarPenyewa) {
                System.out.println(p);
            }
        }

        System.out.println("\n=== KENDARAAN TERSEDIA ===");
        if (daftarKendaraan.isEmpty()) {
            System.out.println("Tidak ada kendaraan tersisa.");
        } else {
            for (Kendaraan k : daftarKendaraan) {
                System.out.println("- " + k);
            }
        }

        System.out.println("\nTerima kasih telah menggunakan sistem rental kendaraan kami!");
        input.close();
    }
}
