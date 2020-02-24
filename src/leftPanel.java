import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class leftPanel extends JPanel {
    private MainWindow mainWindow;
    private final JLabel  logoJL = new JLabel("DENTALMANA");
    private final JLabel  inicioJL = new JLabel("Inicio");
    private final JLabel  calendarioJL = new JLabel("Calendario");
    private final JLabel  clientesJL = new JLabel("Clientes");
    private final JLabel  reportesJL = new JLabel("Reportes");
    private final JLabel  personalJL = new JLabel("Personal");
    public leftPanel(MainWindow mainWindow,boolean boss) {
        this.mainWindow = mainWindow;
        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        setBackground(new Color(56, 71, 102));
        setOpaque(true);
        logoJL.setFont(new Font("Serif",Font.BOLD,24));
        logoJL.setForeground(Color.white);
        logoJL.setAlignmentX(0.1f);
        inicioJL.setFont(new Font("Serif",Font.PLAIN,24));
        inicioJL.setForeground(Color.white);
        calendarioJL.setFont(new Font("Serif",Font.PLAIN,24));
        calendarioJL.setForeground(Color.white);
        clientesJL.setFont(new Font("Serif",Font.PLAIN,24));
        clientesJL.setForeground(Color.white);
        reportesJL.setFont(new Font("Serif",Font.PLAIN,24));
        reportesJL.setForeground(Color.white);
        personalJL.setFont(new Font("Serif",Font.PLAIN,24));
        personalJL.setForeground(Color.white);
        add(logoJL);
        add(inicioJL);
        add(calendarioJL);
        add(clientesJL);
        if (boss){
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
                changeContent(new calendarioPanel());
            }
        });
        clientesJL.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                changeContent(new clientesPanel());
            }
        });
    }

    private void changeContent(JPanel content){

        mainWindow.getContentPanel().removeAll();
        mainWindow.getContentPanel().repaint();
        mainWindow.getContentPanel().revalidate();
        mainWindow.getContentPanel().add(content);
        mainWindow.getContentPanel().repaint();
        mainWindow.pack();
        mainWindow.getContentPanel().revalidate();
    }
}
