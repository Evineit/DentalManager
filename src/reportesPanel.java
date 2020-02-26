import javax.swing.*;
import java.awt.*;
import java.util.Calendar;

public class reportesPanel extends JPanel {
    String[] monthName = {"Enero", "Febrero",
            "Marzo", "Abril", "Mayo", "Junio", "Julio",
            "Agosto", "Septiembre", "Octubre", "Noviembre",
            "Diciembre"};
    private JLabel month;
    private JList repoLista;
    public reportesPanel() {
        Calendar cal = Calendar.getInstance();
        month = new JLabel(monthName[cal.get(Calendar.MONTH)]);
        add(month, BorderLayout.NORTH);
        repoLista = new JList();
        add(repoLista);


    }
}
