package Entity;

import java.time.LocalDate;

public class Bodega {
    private String coordenadasUbicacion;
    private  String descripcion;
    private String historia;
    private  String nombre;
    private LocalDate periodoActualizacion;

    public String getCoordenadasUbicacion() {
        return coordenadasUbicacion;
    }

    public void setCoordenadasUbicacion(String coordenadasUbicacion) {
        this.coordenadasUbicacion = coordenadasUbicacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getHistoria() {
        return historia;
    }

    public void setHistoria(String historia) {
        this.historia = historia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getPeriodoActualizacion() {
        return periodoActualizacion;
    }

    public void setPeriodoActualizacion(LocalDate periodoActualizacion) {
        this.periodoActualizacion = periodoActualizacion;
    }

    public String obtenerNombreRegionVitivinicola(){

        return "String";
    }

    public String obtenerNombrePais(){
        return "String";
    }
}
