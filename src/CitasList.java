import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class CitasList {
    private static ArrayList<Cita> citasList= new ArrayList();
    
    public static ArrayList<Cita> getCitasList() {
        if (citasList.size() == 0) {
            loadCitas();
            return citasList;
        }
        return citasList;
    }

    public void setcitasList(ArrayList array) {
        citasList = array;
    }

    void addCita(Cita cita) {
        citasList.add(cita);
    }

    static void saveCitas() {
        try (FileOutputStream fos = new FileOutputStream("Citas.txt");
                ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(citasList);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getMessage());
        }
    }

    static void loadCitas() {
        ObjectInputStream ois;
        try {
            ois = new ObjectInputStream(new FileInputStream("Citas.txt"));
            citasList = (ArrayList) ois.readObject();
        } catch (Exception e) {
            if (e instanceof FileNotFoundException) {
                saveCitas();
            } else {
                e.printStackTrace();
            }

        }
    }
}
