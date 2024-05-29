package Control;

import Entity.Vino;

import java.time.LocalDate;
import java.util.List;

public class GestorRankingVinos {
    private LocalDate fechaDesde;
    private LocalDate fechaHasta;
    private String tipoResenaSeleccionada;
    private String tipoVisualizacionReporteSeleccionado;
    private Boolean confirmacionReporte;
    private List<Vino> listaVinosConSommelier;
    private List<Vino> listaTopDiezVinos;

    private void opGenerarRankingDeVinos() {}
    private void tomarFechasDesdeHasta(LocalDate fechaDesde, LocalDate fechaHasta) {
        this.fechaDesde = fechaDesde;
        this.fechaHasta = fechaHasta;
    }
    private void tomarTipoResena(String tipoResena) {
        this.tipoResenaSeleccionada = tipoResena;
    }
    private void tomarFormaDeVisualiz(String formaVisualiz) {
        this.tipoVisualizacionReporteSeleccionado = formaVisualiz;
    }
    private void tomarConfPGReporte(boolean isConfirmed) {
        this.confirmacionReporte = isConfirmed;
    }
    private List<Vino> buscarVinosConResenasSommeliers(String sommelier) {
        return null;
    }
    private List<Vino> ordenarVinosSegunCalificación() {
        return null;
    }
    private Double obtenerCalificacionSommelier() {
        return null;
    }
    private Double obtenerCalificacionGeneral() {
        return null;
    }
    private void generarArchivoExcel() {}
    private void finCU() {}

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

    public List<Vino> getListaTopDiezVinos() {
        return listaTopDiezVinos;
    }

    public void setListaTopDiezVinos(List<Vino> listaTopDiezVinos) {
        this.listaTopDiezVinos = listaTopDiezVinos;
    }
}
