public class Penyewa {
    private String nama;
    private Kendaraan kendaraan;

    public Penyewa(String nama, Kendaraan kendaraan) {
        this.nama = nama;
        this.kendaraan = kendaraan;
    }

    @Override
    public String toString() {
        return nama + " menyewa " + kendaraan.toString();
    }
}
