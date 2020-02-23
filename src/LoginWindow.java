import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LoginWindow extends JFrame {
    private JPanel mainPanel;
    private JButton login;
    private JLabel usuarioLabel;
    private JLabel passLabel;
    private JTextField usuarioField;
    private JPasswordField passField;

    public LoginWindow() {
        iniciarLogin();
    }

    private void iniciarLogin() {
        setMinimumSize(new Dimension(400,600));
        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel,BoxLayout.Y_AXIS));
        setContentPane(mainPanel);
        login = new JButton("Iniciar Sesion");
        usuarioLabel = new JLabel("Usuario");
        usuarioField = new JTextField();
        passLabel = new JLabel("Contraseña");
        passField = new JPasswordField();

        mainPanel.add(usuarioLabel);
        mainPanel.add(usuarioField);
        mainPanel.add(passLabel);
        mainPanel.add(passField);
        mainPanel.add(login);

        login.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try{
                    validarLogin();
                }catch (Exception error){
                }
            }
        });
        setTitle("Iniciar Sesión");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    public void iniciar(){
        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        try {
            this.setLocationByPlatform(true);
        } catch (Throwable ignoreAndContinue) {
        }
        setVisible(true);

    }
    public void validarLogin(){
        SwingUtilities.invokeLater(new MainWindow()::iniciar);
        this.dispose();
    }

}
