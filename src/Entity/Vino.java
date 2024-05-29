package Entity;

import java.util.List;

public class Vino {
    private Integer anada;
    private String imagenEtiqueta;
    private String nombre;
    private String notaDeCadaBodega;
    private double precio;
    private List<Varietal> varietal;
    private Bodega bodega;
    private List<Resena> resena;

    public Integer getAnada() {
        return anada;
    }

    public void setAnada(Integer anada) {
        this.anada = anada;
    }

    public String getImagenEtiqueta() {
        return imagenEtiqueta;
    }

    public void setImagenEtiqueta(String imagenEtiqueta) {
        this.imagenEtiqueta = imagenEtiqueta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNotaDeCadaBodega() {
        return notaDeCadaBodega;
    }

    public void setNotaDeCadaBodega(String notaDeCadaBodega) {
        this.notaDeCadaBodega = notaDeCadaBodega;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public List<Varietal> getVarietal() {
        return varietal;
    }

    public void setVarietal(List<Varietal> varietal) {
        this.varietal = varietal;
    }

    public Bodega getBodega() {
        return bodega;
    }

    public void setBodega(Bodega bodega) {
        this.bodega = bodega;
    }

    public List<Resena> getResena() {
        return resena;
    }

    public void setResena(List<Resena> resena) {
        this.resena = resena;
    }

    public boolean tieneResena(){

        return false;
    }

    public double calcularPromedioCalif(){

        return 0.0;
    }

    public String obtenerNombreBodega(){

        return "nombre";
    }

    public String obtenerDescripcionVarietal(){

        return "descripcion";
    }

    public String obtenerUbicacion(){

        return "ubicacion";
    }

}
