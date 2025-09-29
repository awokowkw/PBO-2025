public class MataKuliah {
    private String nama;
    private String kode;
    private int sks;
    private Dosen dosen;

    public MataKuliah(String nama, String kode, int sks, Dosen dosen) {
        this.nama = nama;
        this.kode = kode;
        this.sks = sks;
        this.dosen = dosen;
    }

    public String getNama() {
        return nama;
    }

    public String getKode() {
        return kode;
    }

    public int getSks() {
        return sks;
    }

    public Dosen getDosen() {
        return dosen;
    }

    public String toString() {
        return nama + " (" + sks + " sks) - " + dosen.getNama();
    }
}
