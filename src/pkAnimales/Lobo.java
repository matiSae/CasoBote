package pkAnimales;

public class Lobo {

    private Boolean tieneHambre;

    public Lobo() {
    }

    public Lobo(Boolean tieneHambre) {
        this.tieneHambre = tieneHambre;
    }

    public Boolean matar (String objeto){
        return true;
    }

    public Boolean getTieneHambre() {
        return tieneHambre;
    }

    public void setTieneHambre(Boolean tieneHambre) {
        if (tieneHambre != null) {
            this.tieneHambre = tieneHambre;
        } else {
            throw new IllegalArgumentException("El atributo tieneHambre no puede ser nulo");
        }
    }

}
