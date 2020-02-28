import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class personal implements Serializable {
    private static ArrayList<especialista> personalList = new ArrayList();

    public static ArrayList<especialista> getPersonalList() {
        if (personalList.size()==0){
//            personalList.add(new especialista("Pedro","Maxilofacial"));
//            personalList.add(new especialista("Pedro","Ortodoncista"));
//            personalList.add(new especialista("Pedro","Endodoncista"));
            personalList.add(new especialista("Pedro","Maxilofacial",12000.0,"618320000","Direccion generica No. 155 Av. Sion"));
            personalList.add(new especialista("Pedro","Ortodoncista",12000.0,"618320000","Direccion generica No. 155 Av. Sion"));
            personalList.add(new especialista("Pedro","Endodoncista",12000.0,"618320000","Direccion generica No. 155 Av. Sion"));
        }
        return personalList;
    }

    public void setPersonalList(ArrayList personalList) {
        this.personalList = personalList;
    }
}
class especialista implements Serializable{
    private String name;
    private String especialidad;
    private double salario;
    private String phone;
    private String direccion;


    public especialista(String name, String especialidad) {
        this.name = name;
        this.especialidad = especialidad;
    }

    public especialista(String name, String especialidad, double salario, String phone, String direccion) {
        this.name = name;
        this.especialidad = especialidad;
        this.salario = salario;
        this.phone = phone;
        this.direccion = direccion;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        especialista that = (especialista) o;
        return name.equals(that.name) &&
                especialidad.equals(that.especialidad);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, especialidad);
    }

    @Override
    public String toString() {
        return getName() + " - "+getEspecialidad();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
}
