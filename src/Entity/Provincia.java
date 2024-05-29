package Entity;

import java.util.List;

public class Provincia {
    private String nombre;
    private List<RegionVitivinicola> regionVitivinicolas;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<RegionVitivinicola> getRegionVitivinicolas() {
        return regionVitivinicolas;
    }

    public void setRegionVitivinicolas(List<RegionVitivinicola> regionVitivinicolas) {
        this.regionVitivinicolas = regionVitivinicolas;
    }

    public String obtenerNombrePais(List<Pais> paises){
        for (Pais pais: paises) {
            for (Provincia provincia: pais.getProvincias()) {
                if (provincia.getNombre().equals(this.nombre))
                    return pais.getNombre();
            }
        }
        return "País no encontrado.";
    }
}
