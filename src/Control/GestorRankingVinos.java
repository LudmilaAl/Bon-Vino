package Control;

import Boundary.PantallaRankingVinos;
import DTO.DTOReporte;
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
    private List<DTOReporte> listaTopDiezVinos;

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

    public List<DTOReporte> getListaTopDiezVinos() {
        return listaTopDiezVinos;
    }

    public void setListaTopDiezVinos(List<DTOReporte> listaTopDiezVinos) {
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
    public void tomarConfPGReporte(boolean confirmacion, List<Vino> vinos) {
        setConfirmacionReporte(confirmacion);
        buscarVinosConResenasSommeliers(vinos);
    }
    public void buscarVinosConResenasSommeliers(List<Vino> vinos) {

        listaVinosConSommelier = new ArrayList<>();

        vinos.stream().forEach(vino ->{
            if(vino.tieneResena(fechaDesde,fechaHasta)){
                listaVinosConSommelier.add(vino);
            }
        });

        listaVinosConSommelier.stream().forEach(vino ->{
            vino.calcularPromedioCalif(fechaDesde,fechaHasta);
        });

        ordenarVinosSegunCalificación();
    }
    public void ordenarVinosSegunCalificación() {
        listaVinosConSommelier.sort(Comparator.comparing(Vino::getPromedioCalificacion).reversed());
        obtenerDatosTop10();
    }

    public void obtenerDatosTop10(){ //ESTE METODO NO ESTÁ EN EL DIAGRAMA DE SECUENCIA, SE LLAMA ARRIBA

        listaTopDiezVinos = new ArrayList<>();

        for(int i = 0; i < 10; i++){
            Vino vino = listaVinosConSommelier.get(i);

            DTOReporte datosVino = new DTOReporte();

            datosVino.setNombreVino(vino.getNombre());
            datosVino.setPrecioVino(vino.getPrecio());
            datosVino.setCalificacionVino(vino.getPromedioCalificacion());
            datosVino.setCalificacionGeneral(i+1);
            datosVino.setNombreBodega(vino.obtenerNombreBodega());
            datosVino.setVarietal(vino.obtenerDescripcionVarietal());
            datosVino.setNombreRegion(vino.obtenerNombreRegionVitinicola());
            //datosVino.setNombrePais(vino.obtenerUbicacion()); FALTA TRAER LOS PAISES

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
