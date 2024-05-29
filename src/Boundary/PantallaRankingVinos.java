package Boundary;

import Control.GestorRankingVinos;
import Entity.Pais;
import Entity.Vino;
import jxl.write.WriteException;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class PantallaRankingVinos {
    //ATRIBUTOS
    private String botonGenerarRankingBtn;
    private String fechaDesdeLbl;
    private String fechaDesdeInput;
    private LocalDate fechaDesdeTxt;
    private String fechaHastaLbl;
    private String fechaHastaInput;
    private LocalDate fechaHastaTxt;
    private String tiposResenaCombo;
    private String tipoResenaSeleccionada;
    private String formasVisualizacionReporte;
    private String tipoVisualizacionReporteSeleccionado;
    private String botonConfirmacionBtn;
    private boolean confirmacionGeneracionReporte;

    //GETTERS AND SETTERS

    public String getBotonGenerarRankingBtn() {
        return botonGenerarRankingBtn;
    }

    public void setBotonGenerarRankingBtn(String botonGenerarRankingBtn) {
        this.botonGenerarRankingBtn = botonGenerarRankingBtn;
    }

    public String getFechaDesdeLbl() {
        return fechaDesdeLbl;
    }

    public void setFechaDesdeLbl(String fechaDesdeLbl) {
        this.fechaDesdeLbl = fechaDesdeLbl;
    }

    public String getFechaDesdeInput() {
        return fechaDesdeInput;
    }

    public void setFechaDesdeInput(String fechaDesdeInput) {
        this.fechaDesdeInput = fechaDesdeInput;
    }

    public LocalDate getFechaDesdeTxt() {
        return fechaDesdeTxt;
    }

    public void setFechaDesdeTxt(LocalDate fechaDesdeTxt) {
        this.fechaDesdeTxt = fechaDesdeTxt;
    }

    public String getFechaHastaLbl() {
        return fechaHastaLbl;
    }

    public void setFechaHastaLbl(String fechaHastaLbl) {
        this.fechaHastaLbl = fechaHastaLbl;
    }

    public String getFechaHastaInput() {
        return fechaHastaInput;
    }

    public void setFechaHastaInput(String fechaHastaInput) {
        this.fechaHastaInput = fechaHastaInput;
    }

    public LocalDate getFechaHastaTxt() {
        return fechaHastaTxt;
    }

    public void setFechaHastaTxt(LocalDate fechaHastaTxt) {
        this.fechaHastaTxt = fechaHastaTxt;
    }

    public String getTiposResenaCombo() {
        return tiposResenaCombo;
    }

    public void setTiposResenaCombo(String tiposResenaCombo) {
        this.tiposResenaCombo = tiposResenaCombo;
    }

    public String getTipoResenaSeleccionada() {
        return tipoResenaSeleccionada;
    }

    public void setTipoResenaSeleccionada(String tipoResenaSeleccionada) {
        this.tipoResenaSeleccionada = tipoResenaSeleccionada;
    }

    public String getFormasVisualizacionReporte() {
        return formasVisualizacionReporte;
    }

    public void setFormasVisualizacionReporte(String formasVisualizacionReporte) {
        this.formasVisualizacionReporte = formasVisualizacionReporte;
    }

    public String getTipoVisualizacionReporteSeleccionado() {
        return tipoVisualizacionReporteSeleccionado;
    }

    public void setTipoVisualizacionReporteSeleccionado(String tipoVisualizacionReporteSeleccionado) {
        this.tipoVisualizacionReporteSeleccionado = tipoVisualizacionReporteSeleccionado;
    }

    public String getBotonConfirmacionBtn() {
        return botonConfirmacionBtn;
    }

    public void setBotonConfirmacionBtn(String botonConfirmacionBtn) {
        this.botonConfirmacionBtn = botonConfirmacionBtn;
    }

    public boolean isConfirmacionGeneracionReporte() {
        return confirmacionGeneracionReporte;
    }

    public void setConfirmacionGeneracionReporte(boolean confirmacionGeneracionReporte) {
        this.confirmacionGeneracionReporte = confirmacionGeneracionReporte;
    }

    //CONSTRUCTOR
    public PantallaRankingVinos() {
    }



    //OTROS METODOS
    public void opGenerarRankingDeVinos(GestorRankingVinos gestor) {
        habilitarPantalla();
        gestor.opGenerarRankingDeVinos(this);
    }
    public void habilitarPantalla() {
        //Va con la pantalla
    }
    public void solicitarFechaDesdeYHasta() {
        //Va con la pantalla
    }
    public void tomarFechaDesde(LocalDate fechaDesde) {
        setFechaDesdeTxt(fechaDesde);
    }
    public void tomarFechaHasta(LocalDate fechaHasta, GestorRankingVinos gestor) {
        setFechaHastaTxt(fechaHasta);
        if(validarFechasDesdeHasta()){
            gestor.tomarFechasDesdeHasta(fechaDesdeTxt,fechaHastaTxt, this);
        }
    }
    public boolean validarFechasDesdeHasta() {
        return fechaDesdeTxt.isBefore(fechaHastaTxt) || fechaDesdeTxt.isEqual(fechaHastaTxt);
    }
    public void solicitarTipoResena() {
        //Va con la pantalla
    }
    public void tomarTipoResena(String resenaSeleccionada, GestorRankingVinos gestor) {
        setTipoResenaSeleccionada(resenaSeleccionada);
        gestor.tomarTipoResena(resenaSeleccionada, this);

    }
    public void mostrarFormasDeVisualizPSeleccion() {
        //Va con la pantalla
    }
    public void tomarFormaDeVisualiz(String formaVisualizacion, GestorRankingVinos gestor) {
        setTipoVisualizacionReporteSeleccionado(formaVisualizacion);
        gestor.tomarFormaDeVisualiz(formaVisualizacion, this);
    }
    public void solicitarConfPGReporte() {
        //Va con la pantalla
    }
    public void tomarConfPGReporte(boolean confirmacionReporte, GestorRankingVinos gestor, List<Vino> vinos, List<Pais> listaPaises, InterfazExcel interfazExcel) throws IOException, WriteException {
        setConfirmacionGeneracionReporte(confirmacionReporte);
        gestor.tomarConfPGReporte(confirmacionReporte, vinos, listaPaises, interfazExcel);
    }
    public void informarGeneracionExitosa() {
        //Va con la pantalla
    }
}
