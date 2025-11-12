package pkHumanos;

public class vikingo_Observador extends Humanos{
    private Boolean tieneHacha;

    public vikingo_Observador() {
        super();
    }

    public vikingo_Observador(String nombre, String apellido, Integer edad, Boolean estaVivo, Boolean tieneHacha) {
        super(nombre, apellido, edad, estaVivo);
        this.tieneHacha = tieneHacha;
    }

    public void meterAlBote(String objeto){

    }
    public void sacarBote(String objeto){

    }
    public void IndicarDondeEsta(){

    }

    public Boolean getTieneHacha() {
        return tieneHacha;
    }

    public void setTieneHacha(Boolean tieneHacha) {
        if (tieneHacha != null) {
            this.tieneHacha = tieneHacha;
        } else {
            throw new IllegalArgumentException("El atributo tieneHacha no puede ser nulo");
        }
    }


}
