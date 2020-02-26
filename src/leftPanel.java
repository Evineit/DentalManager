import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class leftPanel extends JPanel {
    private MainWindow mainWindow;

    public leftPanel(MainWindow mainWindow,String accType) {
        this.mainWindow = mainWindow;
        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        setBackground(new Color(56, 71, 102));
        setOpaque(true);
        JLabel logoJL = new JLabel("Dental Manager");
        logoJL.setFont(new Font("Serif",Font.BOLD,24));
        logoJL.setForeground(Color.white);
        logoJL.setAlignmentX(0.1f);
        JLabel inicioJL = new JLabel("Inicio");
        inicioJL.setFont(new Font("Serif",Font.PLAIN,24));
        inicioJL.setForeground(Color.white);
        JLabel calendarioJL = new JLabel("Calendario");
        calendarioJL.setFont(new Font("Serif",Font.PLAIN,24));
        calendarioJL.setForeground(Color.white);
        JLabel clientesJL = new JLabel("Clientes");
        clientesJL.setFont(new Font("Serif",Font.PLAIN,24));
        clientesJL.setForeground(Color.white);
        JLabel reportesJL = new JLabel("Reportes");
        reportesJL.setFont(new Font("Serif",Font.PLAIN,24));
        reportesJL.setForeground(Color.white);
        JLabel personalJL = new JLabel("Personal");
        personalJL.setFont(new Font("Serif",Font.PLAIN,24));
        personalJL.setForeground(Color.white);
        add(logoJL);
        add(inicioJL);
        add(calendarioJL);
        add(clientesJL);
        if (accType.equals("Administrador")){
            add(reportesJL);
            add(personalJL);
        }

        inicioJL.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                mainWindow.getContentPanel().removeAll();
                mainWindow.getContentPanel().repaint();
                mainWindow.getContentPanel().revalidate();
            }
        });
        calendarioJL.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                changeContent(new calendarioPanel(mainWindow));
            }
        });
        clientesJL.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                changeContent(new clientesPanel());
            }
        });
        reportesJL.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                changeContent(new reportesPanel());
            }
        });
    }

    private void changeContent(JPanel content){
        mainWindow.remove(mainWindow.getContentPanel());
        mainWindow.repaint();
        mainWindow.revalidate();
        mainWindow.addContent(content);
        mainWindow.repaint();
        mainWindow.pack();
        mainWindow.revalidate();
    }
}
