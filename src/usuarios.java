import java.util.ArrayList;
import java.util.Arrays;

public class usuarios {
    private static ArrayList<usuarios> listUsers= new ArrayList<usuarios>(Arrays.asList(new usuarios("Administrador","1234"),new usuarios("Secretaria","4321")));
    private String accType;
    private String password;

    public usuarios(String accType, String password) {
        this.setAccType(accType);
        this.setPassword(password);
    }

    @Override
    public String toString() {
        return getAccType();
    }

    public static ArrayList<usuarios> getListUsers() {
        return listUsers;
    }

    public static void setListUsers(ArrayList<usuarios> listUsers) {
        usuarios.listUsers = listUsers;
    }

    public String getAccType() {
        return accType;
    }

    public void setAccType(String accType) {
        this.accType = accType;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
