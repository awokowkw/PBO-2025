 import java.util.Map;  
 import java.util.HashMap;  
 import java.util.Random;
 
 public class TechSupport {  
   private Map<String, String> responses;  
   private Random random;  
   public TechSupport() {  
     responses = new HashMap<>();  
     random = new Random();
     initializeResponses();  
   }  
   
   private void initializeResponses() {
     responses.put("login", "Pastikan NRP dan password Anda benar");
     responses.put("krs", "Untuk mengisi KRS, buka menu 'Pengisian KRS' dan fix kan mata kuliah dengan dosen wali.");
     responses.put("mata", "Apakah mata kuliah tidak muncul? Coba refresh halaman atau periksa jadwal perkuliahan yang tersedia.");
     responses.put("wali", "Jika Anda belum bisa konsultasi ke dosen wali, pastikan status akun FRS sudah aktif.");
     responses.put("validasi", "Setelah mengisi KRS, jangan lupa tekan tombol 'Validasi' agar data Anda tersimpan di sistem.");
     responses.put("jadwal", "Anda dapat melihat jadwal kuliah melalui menu 'Jadwal Kuliah' setelah KRS tervalidasi.");
     responses.put("error", "Jika sistem FRS menolak input Anda, pastikan tidak ada bentrok jadwal atau mata kuliah penuh.");
     responses.put("reset", "Jika data KRS bermasalah, hubungi admin akademik untuk reset FRS Anda.");
     responses.put("habis", "Waktu pengisian FRS sudah berakhir. Silakan hubungi bagian akademik untuk pengajuan manual.");
     responses.put("batal", "Untuk membatalkan mata kuliah, gunakan fitur 'Batal Tambah' sebelum masa KRS berakhir.");
     responses.put("capek", "Salwa here's for you ^-^");
   }
   
   public String getResponse(String userInput) {  
     String[] words = userInput.toLowerCase().split("\\s+");  
     
     for (String w : words) {  
       if (responses.containsKey(w)) {  
         return responses.get(w);  
       }  
     }  
     // kalau tidak ada kata kunci cocok, jawaban acak generik  
     String[] generic = {  
       "Coba jelaskan lebih rinci.",  
       "Saya belum mengerti, bisa ulangi?",  
       "Bisakah Anda memberi detail lebih lanjut?"  
     };  
     
     return generic[random.nextInt(generic.length)];  
   }    
 } 
