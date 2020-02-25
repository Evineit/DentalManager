import java.io.*;
import java.util.ArrayList;

public class clientes {
    private static ArrayList arrayClientes = new ArrayList();

    public static ArrayList getArrayClientes() {
        if (arrayClientes.size() == 0) {
            loadClientes();
            return arrayClientes;
        }
        return arrayClientes;
    }

    public void setArrayClientes(ArrayList array) {
        arrayClientes = array;
    }

    void addCliente(cliente clie) {
        arrayClientes.add(clie);
    }

    static void saveClientes() {
        try (FileOutputStream fos = new FileOutputStream("Clientes.txt");
                ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(arrayClientes);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    static void loadClientes() {
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("Clientes.txt"));
            arrayClientes = (ArrayList) ois.readObject();
        } catch (Exception e) {
            if (e instanceof FileNotFoundException){
                saveClientes();
            }else{
                e.printStackTrace();
            }

        }
    }
}
