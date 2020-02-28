import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;

public class agendaPanel extends JPanel {
    JScrollPane scrollAgenda;
    JTable tabla;
    CustomTableModel model;
    public agendaPanel(especialista espec) {
        setLayout(new BorderLayout());
        LocalDate now = LocalDate.now();
        model = new CustomTableModel(espec,now);
        tabla = new JTable(model);
        tabla.setDragEnabled(false);
        tabla.getTableHeader().setReorderingAllowed(false);
        model.resizeColumnWidth(tabla);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        tabla.getColumnModel().getColumn(0).setCellRenderer( centerRenderer );
        tabla.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        tabla.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        tabla.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
        tabla.setAutoCreateRowSorter(true);
//        TableRowSorter sorter = new TableRowSorter(model);
//        tabla.setRowSorter(sorter);
//        sorter.sort();
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
    public CustomTableModel(especialista especialista, LocalDate date) {
        citasList = (ArrayList<Cita>) CitasList.getCitasList().clone();
        citasList.removeIf(cita -> !cita.getProveedor().equals(especialista));
        citasList.removeIf(cita -> cita.getFecha().isBefore(date));
    }
    public CustomTableModel(cliente cliente) {
        citasList = (ArrayList<Cita>) CitasList.getCitasList().clone();
        citasList.removeIf(cita -> !cita.getCliente().equals(cliente));
    }
    public void resizeColumnWidth(JTable table) {
        final TableColumnModel columnModel = table.getColumnModel();
        for (int column = 0; column < table.getColumnCount(); column++) {
            int width = 15;
            for (int row = 0; row < table.getRowCount(); row++) {
                TableCellRenderer renderer = table.getCellRenderer(row, column);
                Component comp = table.prepareRenderer(renderer, row, column);
                width = Math.max(comp.getPreferredSize().width +1 , width);
            }
            if(width > 300)
                width=300;
            columnModel.getColumn(column).setPreferredWidth(width);
        }
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
