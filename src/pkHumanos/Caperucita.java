package pkHumanos;

public class Caperucita extends Humanos{

    public Caperucita(String nombre, String apellido, Integer edad, Boolean estaVivo) {
        super(nombre,apellido, edad, estaVivo);
    }

    public Boolean comerUva(String objeto){
        System.out.println();
        return true;
    }
}
