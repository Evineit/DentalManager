import javax.swing.*;
import java.awt.*;

public class App extends JFrame {
    public App(){
    }
    public static void main(String[] args) {
        if (args[0].equals("-debug")){
            SwingUtilities.invokeLater(new MainWindow(true)::iniciar);
        }else{
            try{
                SwingUtilities.invokeLater(new LoginWindow()::iniciar);
            }catch (Exception e){
                System.err.println(e.getMessage());
                System.exit(1);
            }
        }
    }
}
