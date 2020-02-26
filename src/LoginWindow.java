import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LoginWindow extends JFrame {
    private JPanel mainPanel;
    private JButton login;
    private JComboBox<usuarios> usersCombo = new JComboBox();
    private JLabel passLabel;
    private JPasswordField passField;

    public LoginWindow() {
        iniciarLogin();
    }

    private void iniciarLogin() {
        setMinimumSize(new Dimension(400,600));
        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel,BoxLayout.Y_AXIS));
        setContentPane(mainPanel);
        login = new JButton("Iniciar Sesión");
        for (usuarios user: usuarios.getListUsers()){
            usersCombo.addItem(user);
        }
        passLabel = new JLabel("Contraseña");
        passField = new JPasswordField();

        mainPanel.add(usersCombo);
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
        usuarios selected = (usuarios) usersCombo.getSelectedItem();
        char[] pass = passField.getPassword();
        if (selected.getPassword().equals(new String(pass))){
            SwingUtilities.invokeLater(new MainWindow(selected.getAccType())::iniciar);
            this.dispose();
        }else{
            JOptionPane.showMessageDialog(null,"Contraseña incorrecta",
                    "Error",JOptionPane.ERROR_MESSAGE);
            passField.setText("");
        }


    }

}
