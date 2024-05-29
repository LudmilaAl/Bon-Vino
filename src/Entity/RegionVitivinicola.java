package Entity;

import java.util.List;

public class RegionVitivinicola {
    private String descripcion;
    private String nombre;

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String obtenerNombrePais(List<Pais> paises){
        for (Pais pais: paises) {
            for (Provincia provincia: pais.getProvincias()) {
                for (RegionVitivinicola region: provincia.getRegionVitivinicolas()) {
                    if (region.getNombre().equals(this.nombre))
                            return provincia.obtenerNombrePais(paises);
                }
            }
        }
        return "País no encontrado.";
    }
}
