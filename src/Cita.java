import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

public class Cita  implements Serializable {
    private LocalDate fecha;
    private LocalTime hora;
    private Servicio servicio;
    private cliente cliente;
    private especialista proveedor;

    public Cita(LocalDate fecha, LocalTime hora, Servicio servicio, cliente cliente, especialista proveedor) {
        this.fecha = fecha;
        this.hora = hora;
        this.servicio = servicio;
        this.cliente = cliente;
        this.proveedor = proveedor;
    }


    public cliente getCliente() {
        return cliente;
    }

    public void setCliente(cliente cliente) {
        this.cliente = cliente;
    }

    public especialista getProveedor() {
        return proveedor;
    }

    public void setProveedor(especialista proveedor) {
        this.proveedor = proveedor;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }
}
