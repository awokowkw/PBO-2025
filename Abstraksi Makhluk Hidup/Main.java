public class MainMakhlukHidup {
    public void cekMakhlukHidup (MakhlukHidup mHidup){
        mHidup.berkembangBiak();
        mHidup.bertahanHidup();
    }
    
    public static void main(String[] args) {
        MainMakhlukHidup tMakhlukHidup = new MainMakhlukHidup();        
        
        tMakhlukHidup.cekMakhlukHidup(new Manusia("Melahirkan"));       
        
        System.out.println("-----------------------------------------");                              
        tMakhlukHidup.cekMakhlukHidup(new Hewan ("Bertelur","Melahirkan"));
        
        System.out.println("-----------------------------------------");        
        tMakhlukHidup.cekMakhlukHidup(new Tumbuhan ("Rizoma"));
        
    }
}
