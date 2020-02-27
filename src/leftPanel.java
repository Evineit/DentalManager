import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.security.cert.Certificate;

public class leftPanel extends JPanel {
    private MainWindow mainWindow;
    JLabel logoJL = new JLabel("Dental Manager");
    JLabel inicioJL = new JLabel("Inicio");
    JLabel calendarioJL = new JLabel("Calendario");
    JLabel clientesJL = new JLabel("Clientes");
    JLabel reportesJL = new JLabel("Reportes");
    JLabel personalJL = new JLabel("Personal");
    leftPanel myself;


    public leftPanel(MainWindow mainWindow, String accType) {
        this.mainWindow = mainWindow;
        this.myself=this;
        BoxLayout layout = new BoxLayout(this,BoxLayout.Y_AXIS);
//        setPreferredSize(new Dimension(250,600));
        setLayout(layout);

        setBackground(new Color(56, 71, 102));
        setOpaque(true);
        JLabel logoJL = new JLabel("Dental Manager");
        logoJL.setFont(new Font("Segoe UI",Font.BOLD,24));
        logoJL.setForeground(Color.white);
        logoJL.setAlignmentX(0.1f);
        inicioJL.setFont(new Font("Segoe UI Semibold",Font.PLAIN,24));
        inicioJL.setForeground(Color.white);
        inicioJL.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        calendarioJL.setFont(new Font("Segoe UI",Font.PLAIN,24));
        calendarioJL.setForeground(Color.white);
        calendarioJL.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        clientesJL.setFont(new Font("Segoe UI",Font.PLAIN,24));
        clientesJL.setForeground(Color.white);
        clientesJL.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        reportesJL.setFont(new Font("Segoe UI",Font.PLAIN,24));
        reportesJL.setForeground(Color.white);
        reportesJL.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        personalJL.setFont(new Font("Segoe UI",Font.PLAIN,24));
        personalJL.setForeground(Color.white);
        personalJL.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        add(logoJL);
        add(inicioJL);
        add(calendarioJL);
        add(clientesJL);
        if (accType.equals("Administrador")){
            //TODO Reportes
            add(reportesJL);
            add(personalJL);
        }

        inicioJL.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                mainWindow.getContentPanel().removeAll();
                resetFonts();
                inicioJL.setFont(new Font("Segoe UI Semibold",Font.PLAIN,24));
                mainWindow.getContentPanel().repaint();
                mainWindow.getContentPanel().revalidate();
            }
        });
        calendarioJL.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                changeContent(new calendarioPanel(mainWindow,myself));
                resetFonts();
                calendarioJL.setFont(new Font("Segoe UI Semibold",Font.PLAIN,24));
            }
        });
        clientesJL.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                changeContent(new clientesPanel());
                resetFonts();
                clientesJL.setFont(new Font("Segoe UI Semibold",Font.PLAIN,24));
            }
        });
        reportesJL.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                changeContent(new reportesPanel());
                resetFonts();
                reportesJL.setFont(new Font("Segoe UI Semibold",Font.PLAIN,24));
            }
        });
        personalJL.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                changeContent(new PanelPersonal());
                resetFonts();
                personalJL.setFont(new Font("Segoe UI Semibold",Font.PLAIN,24));
            }
        });
    }
    public void changeToHome(){
        mainWindow.getContentPanel().removeAll();
        resetFonts();
        inicioJL.setFont(new Font("Segoe UI Semibold",Font.PLAIN,24));
        mainWindow.getContentPanel().repaint();
        mainWindow.getContentPanel().revalidate();
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
    private void resetFonts(){
        inicioJL.setFont(new Font("Segoe UI",Font.PLAIN,24));
        calendarioJL.setFont(new Font("Segoe UI",Font.PLAIN,24));
        clientesJL.setFont(new Font("Segoe UI",Font.PLAIN,24));
        reportesJL.setFont(new Font("Segoe UI",Font.PLAIN,24));
        personalJL.setFont(new Font("Segoe UI",Font.PLAIN,24));
    }
}
