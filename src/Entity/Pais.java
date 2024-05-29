package Entity;

import java.util.List;

public class Pais {

    //ATRIBUTOS
    private String nombre;
    private List<Provincia> provincias;

    //GETTER AND SETTERS

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Provincia> getProvincias() {
        return provincias;
    }

    public void setProvincias(List<Provincia> provincias) {
        this.provincias = provincias;
    }

    //CONSTRUCTOR

    public Pais() {
    }
}
