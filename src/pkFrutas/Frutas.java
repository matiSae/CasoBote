package pkFrutas;

public abstract class Frutas {
   private String nombreCientifico;
   private Boolean esComestible;
   
   public Frutas() {
   }

   // Constructor con parámetros
   public Frutas(String nombreCientifico, Boolean esComestible) {
      this.nombreCientifico = nombreCientifico;
      this.esComestible = esComestible;
   }
   
   public String getNombreCientifico() {
    return nombreCientifico;
   }
   public void setNombreCientifico(String nombreCientifico) {
    if (nombreCientifico != null && !nombreCientifico.trim().isEmpty()) {
        this.nombreCientifico = nombreCientifico;
    } else {
        throw new IllegalArgumentException("El nombre científico no puede estar vacío");
    }
   }
   public Boolean getEsComestible() {
    return esComestible;
   }
   public void setEsComestible(Boolean esComestible) {
    if (esComestible != null) {
        this.esComestible = esComestible;
    } else {
        throw new IllegalArgumentException("El atributo esComestible no puede ser nulo");
    }
   }



}
