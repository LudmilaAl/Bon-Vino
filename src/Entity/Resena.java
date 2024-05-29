package Entity;

import java.time.LocalDate;

public class Resena {
    private String comentario;
    private boolean esPremium;
    private LocalDate fechaReserva;


    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public boolean isEsPremium() {
        return esPremium;
    }

    public void setEsPremium(boolean esPremium) {
        this.esPremium = esPremium;
    }

    public LocalDate getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(LocalDate fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public boolean esPremium(){
        if(esPremium)
            return true;
        else
            return false;
    }

    public boolean esDePeriodo(LocalDate fechaDesde, LocalDate fechaHasta){

        return true;
    }
}
