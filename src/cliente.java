import javax.swing.*;
import java.io.Serializable;
import java.util.ArrayList;

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
