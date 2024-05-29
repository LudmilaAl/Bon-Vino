package DTO;

public class DTOReporte {

    //ATRIBUTOS
    private String nombreVino;
    private double precioVino;
    private double calificacionVino;
    private int calificacionGeneral;
    private String nombreBodega;
    private String varietal;
    private String nombreRegion;
    private String nombrePais;

    //CONSTRUCTOR
    public DTOReporte() {
    }

    //GETTERS AND SETTERS

    public String getNombreVino() {
        return nombreVino;
    }

    public void setNombreVino(String nombreVino) {
        this.nombreVino = nombreVino;
    }

    public double getPrecioVino() {
        return precioVino;
    }

    public void setPrecioVino(double precioVino) {
        this.precioVino = precioVino;
    }

    public double getCalificacionVino() {
        return calificacionVino;
    }

    public void setCalificacionVino(double calificacionVino) {
        this.calificacionVino = calificacionVino;
    }

    public int getCalificacionGeneral() {
        return calificacionGeneral;
    }

    public void setCalificacionGeneral(int calificacionGeneral) {
        this.calificacionGeneral = calificacionGeneral;
    }

    public String getNombreBodega() {
        return nombreBodega;
    }

    public void setNombreBodega(String nombreBodega) {
        this.nombreBodega = nombreBodega;
    }

    public String getVarietal() {
        return varietal;
    }

    public void setVarietal(String varietal) {
        this.varietal = varietal;
    }

    public String getNombreRegion() {
        return nombreRegion;
    }

    public void setNombreRegion(String nombreRegion) {
        this.nombreRegion = nombreRegion;
    }

    public String getNombrePais() {
        return nombrePais;
    }

    public void setNombrePais(String nombrePais) {
        this.nombrePais = nombrePais;
    }
}
