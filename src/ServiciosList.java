import java.util.ArrayList;

public class ServiciosList {
    private static ArrayList serviciosList = new ArrayList();

    public static ArrayList getServiciosList() {
        if (serviciosList.size()==0){
            serviciosList.add(new Servicio("Consulta Odontologica",200.0));
            serviciosList.add(new Servicio("Profilaxis",19.80*16.22));
            serviciosList.add(new Servicio("Obturacion Temporal",19.80*12.42));
            serviciosList.add(new Servicio("Rest. Ionomero vidrio",19.80*12.42));
            serviciosList.add(new Servicio("Resina foto. curado simple",19.80*12.42));
            serviciosList.add(new Servicio("Resina foto. compuesta",19.80*12.42));
            serviciosList.add(new Servicio("Resina foto. compleja",19.80*12.42));
            serviciosList.add(new Servicio("Carilla estetica directa",19.80*12.42));
            serviciosList.add(new Servicio("Amalgama simple y compuesta",19.80*12.42));
            serviciosList.add(new Servicio("Amalgama compleja",19.80*12.42));
            serviciosList.add(new Servicio("RX Periapical",19.80*12.42));
            serviciosList.add(new Servicio("Corona Ceromero",19.80*12.42));
            serviciosList.add(new Servicio("Ortodoncia ROTH",19.80*743.39));
            serviciosList.add(new Servicio("Ortodoncia Autoligado",19.80*796.41));

        }
        return serviciosList;
    }

    public void setServiciosList(ArrayList serviciosList) {
        this.serviciosList = serviciosList;
    }
}
