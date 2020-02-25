import javax.swing.*;
import java.awt.*;

public class App extends JFrame {
    public App() {
    }

    public static void main(String[] args) {
        if (args.length > 0) {
            if (args[0].equals("-debug")) {
                try {
                    SwingUtilities.invokeLater(new MainWindow(true)::iniciar);
                } catch (Exception e) {
                    // TODO: handle exception
                }
            }
        } else {
            try {
                SwingUtilities.invokeLater(new LoginWindow()::iniciar);
            } catch (Exception e) {
                System.err.println(e.getMessage());
                System.exit(1);
            }
        }
    }
}
