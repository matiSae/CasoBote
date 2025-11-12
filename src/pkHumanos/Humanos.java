package pkHumanos;

public abstract class Humanos {
    private String nombre;
    private String apellido;
    private Integer edad;
    private Boolean estaVivo;

    public Humanos() {
    }

    public Humanos(String nombre, String apellido, Integer edad, Boolean estaVivo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.estaVivo = estaVivo;
    }

    public String comer(String comida){
        return getNombre()+" a comido "+ comida;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        if (nombre != null && !nombre.trim().isEmpty()) {
            this.nombre = nombre;
        } else {
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        if (apellido != null && !apellido.trim().isEmpty()) {
            this.apellido = apellido;
        } else {
            throw new IllegalArgumentException("El apellido no puede estar vacío");
        }
    }
    public Integer getEdad() {
        return edad;
    }
    public void setEdad(Integer edad) {
        if (edad != null && edad >= 0 && edad <= 150) {
            this.edad = edad;
        } else {
            throw new IllegalArgumentException("La edad debe estar entre 0 y 150 años");
        }
    }
    public Boolean getEstaVivo() {
        return estaVivo;
    }
    public void setEstaVivo(Boolean estaVivo) {
        if (estaVivo != null) {
            this.estaVivo = estaVivo;
        } else {
            throw new IllegalArgumentException("El atributo estaVivo no puede ser nulo");
        }
    }


}
