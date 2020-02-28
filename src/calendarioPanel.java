import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class calendarioPanel extends JPanel {
    private MainWindow mainWindow;
    private JPanel topPane = new JPanel(new FlowLayout(FlowLayout.LEFT));
    private agendaPanel agendaPanel;
    private JButton nuevaCita = new JButton("Nueva cita");
    private JLabel fecha = new JLabel("FEB 20 - FEB 30");
    private JLabel botonIzq = new JLabel("<");
    private JLabel botonDer = new JLabel(">");

    private JComboBox<especialista> topMenu;
    private ArrayList<especialista> espeList = new ArrayList<>();
    private leftPanel leftPanel;
    public calendarioPanel(MainWindow mainWindow,leftPanel leftPanel) {
        this.leftPanel=leftPanel;
        this.mainWindow =mainWindow;
        setLayout(new BorderLayout());
        espeList = personal.getPersonalList();
        topMenu = new JComboBox<especialista>();
        for (especialista esp: espeList){
            topMenu.addItem(esp);
        }
        topPane.add(new JLabel("Citas del especialista: "));
        topPane.add(topMenu);
        topPane.add(nuevaCita);
//        topPane.add(fecha);
//        topPane.add(botonIzq);
//        topPane.add(botonDer);
        add(topPane, BorderLayout.NORTH);
        agendaPanel = new agendaPanel((especialista) topMenu.getSelectedItem());
        add(agendaPanel);

        nuevaCita.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                changeContent(new citasPanel(topMenu.getSelectedItem(),leftPanel));
            }
        });
        topMenu.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                remove(agendaPanel);
                repaint();
                revalidate();
                agendaPanel = new agendaPanel((especialista) topMenu.getSelectedItem());
                add(agendaPanel);
                repaint();
                revalidate();
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
