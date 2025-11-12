package pkFrutas;

public class Uvas {

    private Integer cantidadRacimos;

    public Uvas() {
    }

    public Uvas(Integer cantidadRacimos) {
        this.cantidadRacimos = cantidadRacimos;
    }

    public Boolean desaparecer(){
        return true;
    }

    public Integer getCantidadRacimos() {
        return cantidadRacimos;
    }

    public void setCantidadRacimos(Integer cantidadRacimos) {
        if (cantidadRacimos != null && cantidadRacimos > 0) {
            this.cantidadRacimos = cantidadRacimos;
        } else {
            throw new IllegalArgumentException("La cantidad de racimos debe ser mayor a 0");
        }
    }

}
