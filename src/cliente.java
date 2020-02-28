import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class cliente implements Serializable {
    private String name;
    private String lastname;
    private String telefono;
    private double adeudo = 0;
    private double cobrado = 0;
    public cliente(String name,String lastname,String telefono) {
        this.name = name;
        this.lastname = lastname;
        this.telefono = telefono;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public double getAdeudo() {
        ArrayList<Cita> citasList = (ArrayList<Cita>) CitasList.getCitasList().clone();
        citasList.removeIf(cita -> !cita.getCliente().equals(this));
        double due=0.0;
        for (Cita cita :
                citasList) {
            due+=cita.getServicio().getPrice();
        }
        if (due -getCobrado()<0){
            setCobrado(0);
            setAdeudo(0);
            return adeudo;
        }
        setAdeudo(due-getCobrado());
        return adeudo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        cliente cliente = (cliente) o;
        return getName().equals(cliente.getName()) &&
                getLastname().equals(cliente.getLastname());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getLastname());
    }

    public void setAdeudo(double adeudo) {
        this.adeudo = adeudo;
    }

    public double getCobrado() {
        return cobrado;
    }

    public void setCobrado(double cobrado) {
        this.cobrado = cobrado;
    }

    public String getFullName(){
        return name +" "+lastname;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastname;
    }

    public void setLastName(String lastname) {
        this.lastname = lastname;
    }

    public String getPhone() {
        return telefono;
    }

    public void setPhone(String telefono) {
        this.telefono = telefono;
    }
}
