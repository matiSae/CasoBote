package pkHumanos;

public abstract class Humanos {
    private String nombre;
    private String apellido;
    private Integer edad;
    private Boolean estaVivo;

    public String comida(String comida){
        return "";
    }





    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public Integer getEdad() {
        return edad;
    }
    public void setEdad(Integer edad) {
        this.edad = edad;
    }
    public Boolean getEstaVivo() {
        return estaVivo;
    }
    public void setEstaVivo(Boolean estaVivo) {
        this.estaVivo = estaVivo;
    }


}
