import java.util.ArrayList;
import java.util.List;

public class Mahasiswa {
    private String nama;
    private String nrp;
    private List<MataKuliah> daftarMataKuliah;

    public Mahasiswa(String nama, String nrp) {
        this.nama = nama;
        this.nrp = nrp;
        this.daftarMataKuliah = new ArrayList<>();
    }

    public void tambahMataKuliah(MataKuliah mk) {
        daftarMataKuliah.add(mk);
    }

    public void tampilkanFRS() {
        System.out.println("Nama  : " + nama);
        System.out.println("NRP   : " + nrp);
        System.out.println("Formulir Rencana Studi:");
        for (MataKuliah mk : daftarMataKuliah) {
            System.out.println("- " + mk);
        }
    }
}
