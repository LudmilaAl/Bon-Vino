package Entity;

import java.util.ArrayList;
import java.util.List;

public class Vino {
    private Integer anada;
    private String imagenEtiqueta;
    private String nombre;
    private String notaDeCadaBodega;
    private double precio;
    private List<Varietal> varietal;
    private Bodega bodega;
    private List<Resena> resenas;

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

    public List<Resena> getResenas() {
        return resenas;
    }

    public void setResenas(List<Resena> resenas) {
        this.resenas = resenas;
    }

    public boolean tieneResena(){
        return !this.resenas.isEmpty();
    }

    public double calcularPromedioCalif(){
        double total = 0;
        for (Resena resena : this.resenas) {
            total += resena.getPuntaje();
        }
        if (!this.resenas.isEmpty())
            return total / this.resenas.size();
        return 0;
    }

    public String obtenerNombreBodega(){
        return this.bodega.getNombre();
    }

    public List<String> obtenerDescripcionVarietal(){
        List<String> descripcionVarietal = new ArrayList<>();
        for (Varietal var : this.varietal) {
            descripcionVarietal.add(var.getDescripcion());
        }
        return descripcionVarietal;
    }

    public String obtenerUbicacion(List<Pais> paises){
        return this.bodega.obtenerNombrePais(paises);
    }

}
