public class Hewan extends MakhlukHidup {
    private String ovipar, vivipar ;
    
    public Hewan(String ovipar, String vivipar){
        this.ovipar = ovipar;
        this.vivipar = vivipar;
    }
    
    public void berkembangBiak (){
        System.out.println("Ayam berkembang biak menggunakan :  " + ovipar);
        System.out.println("Kucing berkembang biak menggunakan    :  " + vivipar);
    }    
}
