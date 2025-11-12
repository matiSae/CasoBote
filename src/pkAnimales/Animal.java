package pkAnimales;

public abstract class Animal {

    private String tipoPelaje;
    private Boolean esCarnivoro;

    public Animal() {
    }

    public Animal(String tipoPelaje, Boolean esCarnivoro) {
        this.tipoPelaje = tipoPelaje;
        this.esCarnivoro = esCarnivoro;
    }

    public void comer(String objeto ){
        
    }


    public String getTipoPelaje() {
        return tipoPelaje;
    }
    public void setTipoPelaje(String tipoPelaje) {
        if (tipoPelaje != null && !tipoPelaje.trim().isEmpty()) {
            this.tipoPelaje = tipoPelaje;
        } else {
            throw new IllegalArgumentException("El tipo de pelaje no puede estar vacío");
        }
    }
    public Boolean getEsCarnivoro() {
        return esCarnivoro;
    }
    public void setEsCarnivoro(Boolean esCarnivoro) {
        if (esCarnivoro != null) {
            this.esCarnivoro = esCarnivoro;
        } else {
            throw new IllegalArgumentException("El atributo esCarnivoro no puede ser nulo");
        }
    }

}
