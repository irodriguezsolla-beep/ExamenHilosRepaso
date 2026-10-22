package CadenaDeMontaje;

public class Pasos extends Thread{
    private String maquina;

    public Pasos(String estacion){
        super("Estación-"+ estacion);
    }
    public void run(){
        for(int i =0; i<5 ;i++){
            System.out.println(maquina+"- paso "+i);
        }

    }
}
