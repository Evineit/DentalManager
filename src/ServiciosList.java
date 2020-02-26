import java.util.ArrayList;

public class ServiciosList {
    private static ArrayList serviciosList = new ArrayList();

    public static ArrayList getServiciosList() {
        if (serviciosList.size()==0){
            serviciosList.add(new Servicio("Consulta Odontologica",200.0));
        }
        return serviciosList;
    }

    public void setServiciosList(ArrayList serviciosList) {
        this.serviciosList = serviciosList;
    }
}
