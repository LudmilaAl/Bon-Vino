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

    private List<Resena> resenasPremiumPeriodo;

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


    public Vino() {
    }

    //OTROS METODOS

    public boolean tieneResena(LocalDate fechaDesde, LocalDate fechaHasta){

        resenasPremiumPeriodo = new ArrayList<>();

        AtomicBoolean tieneResena = new AtomicBoolean(false);

        resenas.stream().forEach(resena ->{
            if(resena.esDePeriodo(fechaDesde,fechaHasta) && resena.getEsPremium()){
                tieneResena.set(true);
                resenasPremiumPeriodo.add(resena);
            }
        });


        return tieneResena.get();
    }

    public void calcularPromedioCalif(LocalDate fechaDesde, LocalDate fechaHasta){


        double total = 0;
        for (Resena resena : resenasPremiumPeriodo) {
            total += resena.getPuntaje();
        }
        if (!resenasPremiumPeriodo.isEmpty())
            promedioCalificacion =  Math.round((total / resenasPremiumPeriodo.size())* 100.0) / 100.0;
        else
            promedioCalificacion = 0;
    }

    public String obtenerNombreBodega(){
        return this.bodega.getNombre();
    }

    public String obtenerDescripcionVarietal(){
        String descripcionVarietal = "";
        for (Varietal var : varietal) {
            descripcionVarietal += var.getDescripcion() + " ";
        }
        return descripcionVarietal;
    }

    public String obtenerUbicacion(List<Pais> paises){
        return this.bodega.obtenerNombrePais(paises);
    }

    public String obtenerNombreRegionVitinicola(){
        return bodega.obtenerNombreRegionVitivinicola();
    }


}
