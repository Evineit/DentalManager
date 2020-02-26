import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class calendarioPanel extends JPanel {
    private MainWindow mainWindow;
    private JPanel topPane = new JPanel();
    private agendaPanel agendaPanel;
    private JButton nuevaCita = new JButton("Nueva cita");
    private JLabel fecha = new JLabel("FEB 20 - FEB 30");
    private JLabel botonIzq = new JLabel("<");
    private JLabel botonDer = new JLabel(">");

    private JComboBox topMenu;
    private ArrayList espeList = new ArrayList();

    public calendarioPanel(MainWindow mainWindow) {
        this.mainWindow =mainWindow;
        setLayout(new BorderLayout());
        espeList = personal.getPersonalList();
        topMenu = new JComboBox<especialista>();
        for (Object esp: espeList){
            topMenu.addItem(esp);
        }
        topPane.add(topMenu);
        topPane.add(nuevaCita);
//        topPane.add(fecha);
//        topPane.add(botonIzq);
//        topPane.add(botonDer);
        add(topPane, BorderLayout.NORTH);
        agendaPanel = new agendaPanel();
        add(agendaPanel);

        nuevaCita.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                changeContent(new citasPanel(topMenu.getSelectedItem()));
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
