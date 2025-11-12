package pkFrutas;

public abstract class Frutas {
   private String nombreCientifico;
   private Boolean esComestible;
   
   public String getNombreCientifico() {
    return nombreCientifico;
   }
   public void setNombreCientifico(String nombreCientifico) {
    this.nombreCientifico = nombreCientifico;
   }
   public Boolean getEsComestible() {
    return esComestible;
   }
   public void setEsComestible(Boolean esComestible) {
    this.esComestible = esComestible;
   }



}
