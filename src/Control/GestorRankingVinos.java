package Control;

import Boundary.PantallaRankingVinos;
import Entity.Pais;
import Entity.Vino;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class GestorRankingVinos {
    private LocalDate fechaDesde;
    private LocalDate fechaHasta;
    private String tipoResenaSeleccionada;
    private String tipoVisualizacionReporteSeleccionado;
    private Boolean confirmacionReporte;
    private List<Vino> listaVinosConSommelier;
    private String[][] listaTopDiezVinos;

    //GETTER AND SETTER
    public LocalDate getFechaDesde() {
        return fechaDesde;
    }

    public void setFechaDesde(LocalDate fechaDesde) {
        this.fechaDesde = fechaDesde;
    }

    public LocalDate getFechaHasta() {
        return fechaHasta;
    }

    public void setFechaHasta(LocalDate fechaHasta) {
        this.fechaHasta = fechaHasta;
    }

    public String getTipoResenaSeleccionada() {
        return tipoResenaSeleccionada;
    }

    public void setTipoResenaSeleccionada(String tipoResenaSeleccionada) {
        this.tipoResenaSeleccionada = tipoResenaSeleccionada;
    }

    public String getTipoVisualizacionReporteSeleccionado() {

        return tipoVisualizacionReporteSeleccionado;
    }

    public void setTipoVisualizacionReporteSeleccionado(String tipoVisualizacionReporteSeleccionado) {
        this.tipoVisualizacionReporteSeleccionado = tipoVisualizacionReporteSeleccionado;
    }

    public Boolean getConfirmacionReporte() {
        return confirmacionReporte;
    }

    public void setConfirmacionReporte(Boolean confirmacionReporte) {
        this.confirmacionReporte = confirmacionReporte;
    }

    public List<Vino> getListaVinosConSommelier() {
        return listaVinosConSommelier;
    }

    public void setListaVinosConSommelier(List<Vino> listaVinosConSommelier) {
        this.listaVinosConSommelier = listaVinosConSommelier;
    }

    public String[][] getListaTopDiezVinos() {
        return listaTopDiezVinos;
    }

    public void setListaTopDiezVinos(String[][] listaTopDiezVinos) {
        this.listaTopDiezVinos = listaTopDiezVinos;
    }

    //CONSTRUCTOR
    public GestorRankingVinos() {
    }

    //OTROS METODOS
    public void opGenerarRankingDeVinos(PantallaRankingVinos pantalla) {
        pantalla.solicitarFechaDesdeYHasta();
    }
    public void tomarFechasDesdeHasta(LocalDate fechaDesde, LocalDate fechaHasta, PantallaRankingVinos pantalla) {
        setFechaDesde(fechaDesde);
        setFechaHasta(fechaHasta);
        pantalla.solicitarTipoResena();
    }
    public void tomarTipoResena(String tipoResena, PantallaRankingVinos pantalla) {
        setTipoResenaSeleccionada(tipoResena);
        pantalla.mostrarFormasDeVisualizPSeleccion();
    }
    public void tomarFormaDeVisualiz(String formaVisualizacion, PantallaRankingVinos pantalla) {
        setTipoVisualizacionReporteSeleccionado(formaVisualizacion);
        pantalla.solicitarConfPGReporte();
    }
    public void tomarConfPGReporte(boolean confirmacion, List<Vino> vinos, List<Pais> listaPaises) {
        setConfirmacionReporte(confirmacion);
        if(tipoResenaSeleccionada.equals("Reseñas de Sommelier")){
            buscarVinosConResenasSommeliers(vinos, listaPaises);
        } else if(tipoResenaSeleccionada.equals("Reseñas normales")){
            //Fuera del CU
        } else if(tipoResenaSeleccionada.equals("Reseñas de Amigos")){
            //Fuera del CU
        }

    }
    public void buscarVinosConResenasSommeliers(List<Vino> vinos, List<Pais> listaPaises) {

        listaVinosConSommelier = new ArrayList<>();

        vinos.stream().forEach(vino ->{
            if(vino.tieneResena(fechaDesde,fechaHasta)){
                listaVinosConSommelier.add(vino);
            }
        });

        listaVinosConSommelier.stream().forEach(vino ->{
            vino.calcularPromedioCalif(fechaDesde,fechaHasta);
        });

        ordenarVinosSegunCalificación(listaPaises);
    }
    public void ordenarVinosSegunCalificación(List<Pais> listaPaises) {
        listaVinosConSommelier.sort(Comparator.comparing(Vino::getPromedioCalificacion).reversed());
        obtenerDatosTop10(listaPaises);
    }

    public void obtenerDatosTop10(List<Pais> listaPaises){ //ESTE METODO NO ESTÁ EN EL DIAGRAMA DE SECUENCIA, SE LLAMA ARRIBA



        int cantidadVinos = listaVinosConSommelier.size() > 10 ? 10 : listaVinosConSommelier.size();

        if(cantidadVinos > 0){
            listaTopDiezVinos = new String[cantidadVinos][7];
        }

        for(int i = 0; i < cantidadVinos; i++){
            Vino vino = listaVinosConSommelier.get(i);

            listaTopDiezVinos[i][0]=vino.getNombre();
            listaTopDiezVinos[i][1]=String.valueOf(vino.getPrecio());
            listaTopDiezVinos[i][2]=String.valueOf(vino.getPromedioCalificacion());
            listaTopDiezVinos[i][3]=vino.obtenerNombreBodega();
            listaTopDiezVinos[i][4]=vino.obtenerDescripcionVarietal();
            listaTopDiezVinos[i][5]=vino.obtenerNombreRegionVitinicola();
            listaTopDiezVinos[i][6]=vino.obtenerUbicacion(listaPaises);
        }
        for (int i = 0; i < cantidadVinos; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.println(listaTopDiezVinos[i][j] + " ");
            }
        }

    }

    public Double obtenerCalificacionSommelier() {
        return null;
    }
    public Double obtenerCalificacionGeneral() {
        return null;
    }
    public void generarArchivoExcel() {}
    public void finCU() {}

}
