import javax.swing.*;
import java.awt.*;

public class calendarioPanel extends JPanel {
    private JPanel topPane = new JPanel();
    private JTable agendaT = new JTable();
    private String[] titulosAgenda= {"Fecha","Hora","Servicio","Estado"};

    private JButton nuevaCita = new JButton("Nueva cita");
    private JLabel fecha = new JLabel("FEB 20 - FEB 30");
    private JLabel botonIzq = new JLabel("<");
    private JLabel botonDer = new JLabel(">");

    private JComboBox topMenu;
    private String[] especialistas = {"Espe1","Espe2","Espe3",};
    public calendarioPanel() {
        setLayout(new BorderLayout());
        topMenu = new JComboBox(especialistas);
        topPane.add(topMenu);
        topPane.add(nuevaCita);
        topPane.add(fecha);
        topPane.add(botonIzq);
        topPane.add(botonDer);
        add(topPane, BorderLayout.NORTH);
        add(agendaT);

    }
}
