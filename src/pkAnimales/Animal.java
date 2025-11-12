package pkAnimales;

public abstract class Animal {

    private String tipoPelaje;
    private Boolean esCarnivoro;

    public void comer(String objeto ){
        
    }


    public String getTipoPelaje() {
        return tipoPelaje;
    }
    public void setTipoPelaje(String tipoPelaje) {
        this.tipoPelaje = tipoPelaje;
    }
    public Boolean getEsCarnivoro() {
        return esCarnivoro;
    }
    public void setEsCarnivoro(Boolean esCarnivoro) {
        this.esCarnivoro = esCarnivoro;
    }

}
