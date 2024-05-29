package Control;

import Boundary.InterfazExcel;
import Boundary.PantallaRankingVinos;
import Entity.Pais;
import Entity.Vino;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.io.IOException;

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
    public void tomarConfPGReporte(boolean confirmacion, List<Vino> vinos, List<Pais> listaPaises, InterfazExcel interfazExcel) throws IOException, WriteException {
        setConfirmacionReporte(confirmacion);
        if(tipoResenaSeleccionada.equals("Reseñas de Sommelier")){
            buscarVinosConResenasSommeliers(vinos, listaPaises, interfazExcel);
        } else if(tipoResenaSeleccionada.equals("Reseñas normales")){
            //Fuera del CU
        } else if(tipoResenaSeleccionada.equals("Reseñas de Amigos")){
            //Fuera del CU
        }

    }
    public void buscarVinosConResenasSommeliers(List<Vino> vinos, List<Pais> listaPaises, InterfazExcel interfazExcel) throws IOException, WriteException {

        listaVinosConSommelier = new ArrayList<>();

        vinos.stream().forEach(vino ->{
            if(vino.tieneResena(fechaDesde,fechaHasta)){
                listaVinosConSommelier.add(vino);
            }
        });

        listaVinosConSommelier.stream().forEach(vino ->{
            vino.calcularPromedioCalif(fechaDesde,fechaHasta);
        });

        ordenarVinosSegunCalificación(listaPaises, interfazExcel);
    }
    public void ordenarVinosSegunCalificación(List<Pais> listaPaises, InterfazExcel interfazExcel) throws IOException, WriteException {
        listaVinosConSommelier.sort(Comparator.comparing(Vino::getPromedioCalificacion).reversed());
        obtenerDatosTop10(listaPaises, interfazExcel);
    }

    public void obtenerDatosTop10(List<Pais> listaPaises, InterfazExcel interfazExcel) throws IOException, WriteException { //ESTE METODO NO ESTÁ EN EL DIAGRAMA DE SECUENCIA, SE LLAMA ARRIBA

        int cantidadVinos = listaVinosConSommelier.size() > 10 ? 10 : listaVinosConSommelier.size();

        if(cantidadVinos > 0){
            listaTopDiezVinos = new String[cantidadVinos][8];
        }

        int posicionGeneral = 0;

        while(posicionGeneral < cantidadVinos){
            posicionGeneral = obtenerCalificacionGeneral(posicionGeneral);
            Vino vino = listaVinosConSommelier.get(posicionGeneral-1);

            listaTopDiezVinos[posicionGeneral-1][0]= String.valueOf(posicionGeneral);
            listaTopDiezVinos[posicionGeneral-1][1]=vino.getNombre();
            listaTopDiezVinos[posicionGeneral-1][2]=String.valueOf(vino.getPrecio());
            listaTopDiezVinos[posicionGeneral-1][3]=String.valueOf(vino.getPromedioCalificacion()); //ESTO ESTA COMO UN LOOP EN E GESTOR
            listaTopDiezVinos[posicionGeneral-1][4]=vino.obtenerNombreBodega();
            listaTopDiezVinos[posicionGeneral-1][5]=vino.obtenerDescripcionVarietal();
            listaTopDiezVinos[posicionGeneral-1][6]=vino.obtenerNombreRegionVitinicola();
            listaTopDiezVinos[posicionGeneral-1][7]=vino.obtenerUbicacion(listaPaises);
        }
        generarArchivoExcel(interfazExcel);

    }

    public Double obtenerCalificacionSommelier() { // ESTE METODO ESTA MAL, ESE DATO LO TIENE GUARDADO EL VINO. ES UN GET.
        return null;
    }
    public int obtenerCalificacionGeneral(int posicionGeneral) {
        return posicionGeneral + 1;
    }
    public void generarArchivoExcel(InterfazExcel interfazExcel) throws IOException, WriteException {
        String nombreArchivo = "C:\\Users\\Usuario\\Ranking de Vinos.xls";
        WritableWorkbook  workbook = Workbook.createWorkbook(new File(nombreArchivo));
        WritableSheet sheet = workbook.createSheet("Ranking",0);

        sheet.addCell(new Label(0,0,"Posición general"));
        sheet.addCell(new Label(1,0,"Nombre Vino"));
        sheet.addCell(new Label(2,0,"Precio Vino"));
        sheet.addCell(new Label(3,0,"Calificacion Sommelier"));
        sheet.addCell(new Label(4,0,"Nombre Bodega"));
        sheet.addCell(new Label(5,0,"Descripcion Varietal"));
        sheet.addCell(new Label(6,0,"Nombre Región Vitivinicola"));
        sheet.addCell(new Label(7,0,"Pais"));

        for (int i = 1; i <= listaTopDiezVinos.length; i++) {

            sheet.addCell(new Label(0,i,listaTopDiezVinos[i-1][0]));
            sheet.addCell(new Label(1,i,listaTopDiezVinos[i-1][1]));
            sheet.addCell(new Label(2,i,listaTopDiezVinos[i-1][2]));
            sheet.addCell(new Label(3,i,listaTopDiezVinos[i-1][3]));
            sheet.addCell(new Label(4,i,listaTopDiezVinos[i-1][4]));
            sheet.addCell(new Label(5,i,listaTopDiezVinos[i-1][5]));
            sheet.addCell(new Label(6,i,listaTopDiezVinos[i-1][6]));
            sheet.addCell(new Label(7,i,listaTopDiezVinos[i-1][7]));
        }
        workbook.write();
        workbook.close();

        interfazExcel.exportarExcel();
    }
    public void finCU() {
        System.out.println("Fin del CU");
    }

}
