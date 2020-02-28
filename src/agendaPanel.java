import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.util.ArrayList;

public class agendaPanel extends JPanel {
    JScrollPane scrollAgenda;
    JTable tabla;
    CustomTableModel model;
    //Todo cuando sales de la crecion de cita que regreses al calendario no al inicio
    public agendaPanel(especialista espec) {
        setLayout(new BorderLayout());
        model = new CustomTableModel(espec);
        tabla = new JTable(model);
        tabla.setDragEnabled(false);
        tabla.getTableHeader().setReorderingAllowed(false);
        scrollAgenda = new JScrollPane(tabla);
        add(scrollAgenda);
    }

}
class CustomTableModel extends AbstractTableModel{
    private ArrayList<Cita> citasList;

    public CustomTableModel(especialista especialista) {
        citasList = (ArrayList<Cita>) CitasList.getCitasList().clone();
        citasList.removeIf(cita -> !cita.getProveedor().equals(especialista));
    }
    public CustomTableModel(cliente cliente) {
        citasList = (ArrayList<Cita>) CitasList.getCitasList().clone();
        citasList.removeIf(cita -> !cita.getCliente().equals(cliente));
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0: return "Cliente";
            case 1: return "Fecha";
            case 2: return "Hora";
            case 3: return "Servicio";
        }
        return null;
    }

    @Override
    public int getRowCount() {
        return citasList.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Cita cita = citasList.get(rowIndex);
        switch (columnIndex) {
            case 0: return cita.getCliente().getName();
            case 1: return cita.getFecha();
            case 2: return cita.getHora();
            case 3: return cita.getServicio();
        }
        return null;
    }
    public void add(Cita cita){
        citasList.add(cita);
        int row = citasList.indexOf(cita);
        fireTableRowsInserted(row,row);
    }
    public void remove(Cita cita){
        if (citasList.contains(cita)) {
            int row = citasList.indexOf(cita);
            citasList.remove(row);
            fireTableRowsDeleted(row, row);
        }
    }

}
