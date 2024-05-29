package Entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class Vino {

    //ATRIBUTOS
    private Integer anada;
    private String imagenEtiqueta;
    private String nombre;
    private String notaDeCadaBodega;
    private double precio;
    private List<Varietal> varietal;
    private Bodega bodega;
    private List<Resena> resenas;
    private double promedioCalificacion;

    //GETTERS AND SETTERS

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

    public double getPromedioCalificacion() {
        return promedioCalificacion;
    }

    public void setPromedioCalificacion(double promedioCalificacion) {
        this.promedioCalificacion = promedioCalificacion;
    }

    //CONSTRUCTOR

    public Vino(Integer anada, String imagenEtiqueta, String nombre, String notaDeCadaBodega, double precio,
                List<Varietal> varietal, Bodega bodega, List<Resena> resenas) {
        this.anada = anada;
        this.imagenEtiqueta = imagenEtiqueta;
        this.nombre = nombre;
        this.notaDeCadaBodega = notaDeCadaBodega;
        this.precio = precio;
        this.varietal = varietal;
        this.bodega = bodega;
        this.resenas = resenas;
    }


    //OTROS METODOS

    public boolean tieneResena(LocalDate fechaDesde, LocalDate fechaHasta){

        AtomicBoolean tieneResena = new AtomicBoolean(false);

        resenas.stream().forEach(resena ->{
            if(resena.esDePeriodo(fechaDesde,fechaHasta) && resena.esPremium())
                tieneResena.set(true);
        });


        return tieneResena.get();
    }

    public void calcularPromedioCalif(LocalDate fechaDesde, LocalDate fechaHasta){


        double total = 0;
        for (Resena resena : this.resenas) {
            if(resena.esDePeriodo(fechaDesde,fechaHasta) && resena.esPremium())
                total += resena.getPuntaje();
        }
        if (!this.resenas.isEmpty())
            promedioCalificacion = total / this.resenas.size();
        else
            promedioCalificacion = 0;
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
