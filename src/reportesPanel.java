import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Calendar;

public class reportesPanel extends JPanel {
    String[] monthName = {"Enero", "Febrero",
            "Marzo", "Abril", "Mayo", "Junio", "Julio",
            "Agosto", "Septiembre", "Octubre", "Noviembre",
            "Diciembre"};

    private JLabel labelMonth;
    private JList repoLista;
    private java.time.Month Month;
    public reportesPanel() {
        setLayout(new GridBagLayout());
        GridBagConstraints limites = new GridBagConstraints();
        limites.anchor = GridBagConstraints.NORTH;
        limites.ipadx=30;
        limites.gridx=0;
        limites.fill=GridBagConstraints.HORIZONTAL;
        limites.insets = new Insets(30,10,10,30);
        Calendar cal = Calendar.getInstance();
//        Month = cal.get(Calendar.MONTH);
        Month = LocalDate.now().getMonth();
        labelMonth = new JLabel(monthName[cal.get(Calendar.MONTH)].toUpperCase(),SwingConstants.CENTER);
        labelMonth.setFont(labelMonth.getFont().deriveFont(16f));
        limites.gridwidth=2;
        add(labelMonth, limites);
        limites.gridwidth=1;
//        repoLista = new JList();
//        add(repoLista);
        final Double[] gananciasActual = {0.0};
        final Double[] gananciasPrev={0.0};
        ArrayList<Cita> citasList = (ArrayList<Cita>) CitasList.getCitasList().clone();
        citasList.removeIf(cita -> !(cita.getFecha().getMonth().equals(Month)));
        citasList.forEach(cita -> gananciasActual[0] +=cita.getServicio().getPrice());
        citasList = (ArrayList<Cita>) CitasList.getCitasList().clone();
        citasList.removeIf(cita -> !(cita.getFecha().getMonth().equals(Month.minus(1))));
        citasList.forEach(cita -> gananciasPrev[0] +=cita.getServicio().getPrice());
        add(new JLabel("Ganancias en citas mes previo "),limites);
        add(new JLabel("Ganancias en citas mes actual "),limites);
        Double cambioNeto = gananciasActual[0]-gananciasPrev[0];
        JLabel labelCambioTexto = new JLabel("Cambio neto ");
        JLabel labelCambio =new JLabel("$"+cambioNeto.toString());
        if (cambioNeto<0){
            labelCambio.setForeground(Color.red);
        }else if (cambioNeto>0){
            labelCambio.setForeground(Color.decode("#47BA51"));
        }
        add(labelCambioTexto,limites);
        add(new JLabel("Citas atendidas este mes:"),limites);
        add(new JLabel("Salarios pagados"),limites);
        limites.gridx=1;
        limites.gridy=1;
        add(new JLabel("$"+gananciasPrev[0].toString()),limites);
        limites.gridy=GridBagConstraints.RELATIVE;
        add(new JLabel("$"+gananciasActual[0].toString()),limites);
        add(labelCambio,limites);
        citasList=CitasList.getCitasInMonth(Month);
        add(new JLabel(String.valueOf(citasList.size())),limites);

        ArrayList<especialista> lista = personal.getPersonalList();
        Double[] salarios = {0.0};
        lista.forEach(especialista -> salarios[0]+=especialista.getSalario());
        add(new JLabel("$"+salarios[0]),limites);

//        limites.weightx=1;
        limites.weighty=1;
        limites.gridy=5;
//        limites.gridy=GridBagConstraints.REMAINDER;
        add(new JLabel(""),limites);
        //



    }
}
