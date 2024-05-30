import Boundary.InterfazExcel;
import Boundary.PantallaRankingVinos;
import Control.GestorRankingVinos;
import Entity.Pais;
import Entity.Vino;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;

import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import jxl.write.WriteException;

public class Main {
    public static void main(String[] args) {

        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        String projectDir = System.getProperty("user.dir");
        String jsonVinos = projectDir + File.separator + "src/JSON/vinos.json";
        String jsonPaises = projectDir + File.separator + "src/JSON/paises.json";

        try{

            //Se inicializan los objetos necesarios para probar el CU
            List<Vino> listaVinos = mapper.readValue(new File(jsonVinos), new TypeReference<List<Vino>>() {});
            List<Pais> listapaises = mapper.readValue(new File(jsonPaises), new TypeReference<List<Pais>>() {});

            GestorRankingVinos gestorRankingVinos = new GestorRankingVinos();

            PantallaRankingVinos pantallaRankingVinos = new PantallaRankingVinos();

            InterfazExcel interfazExcel = new InterfazExcel();




            //SE APRETA EL BOTON PARA INICIAR EL CU

            pantallaRankingVinos.opGenerarRankingDeVinos(gestorRankingVinos);

            //SE INGRESAN POR PANTALLA LAS FECHAS DESDE Y HASTA

            LocalDate fechaDesde = LocalDate.of(2020, 1, 1); //Esto hay que cargarlo desde el input
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

            pantallaRankingVinos.tomarConfPGReporte(confirmacionGeneracion, gestorRankingVinos, listaVinos, listapaises, interfazExcel);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (WriteException e) {
            throw new RuntimeException(e);
        }

    }
}