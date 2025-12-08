public class Manusia extends MakhlukHidup {
    private String melahirkan;
    
    public Manusia(String melahirkan){
        this.melahirkan = melahirkan;
    }
    
    public void berkembangBiak (){
        System.out.println("Manusia berkembang biak menggunakan :  "+ melahirkan);
    }
}
