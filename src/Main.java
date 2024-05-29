import Boundary.PantallaRankingVinos;
import Control.GestorRankingVinos;
import Entity.Vino;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {

        GestorRankingVinos gestorRankingVinos = new GestorRankingVinos();

        PantallaRankingVinos pantallaRankingVinos = new PantallaRankingVinos();

        List<Vino> vinos = new ArrayList<>();

        //SE APRETA EL BOTON PARA INICIAR EL CU

        pantallaRankingVinos.opGenerarRankingDeVinos(gestorRankingVinos);

        //SE INGRESAN POR PANTALLA LAS FECHAS DESDE Y HASTA

        LocalDate fechaDesde = LocalDate.now(); //Esto hay que cargarlo desde el input
        LocalDate fechaHasta = LocalDate.now(); //Esto hay que cargarlo desde el input

        pantallaRankingVinos.tomarFechaDesde(fechaDesde);
        pantallaRankingVinos.tomarFechaHasta(fechaHasta, gestorRankingVinos);

        //SE INGRESA EL TIPO DE RESEÑA

        String tipoResena = "Reseñas de Sommelier";

        pantallaRankingVinos.tomarTipoResena(tipoResena,gestorRankingVinos);

        //SE INGRESA EL TIPO DE VISUALIZACION

        String tipoVisualizacion = "Excel";

        pantallaRankingVinos.tomarFormaDeVisualiz(tipoVisualizacion,gestorRankingVinos);

        //SE CONFIRMA LA GENERACION DEL REPORTE

        Boolean confirmacionGeneracion = true;

        pantallaRankingVinos.tomarConfPGReporte(confirmacionGeneracion, gestorRankingVinos, vinos);














        System.out.println("Hello world!");




    }
}