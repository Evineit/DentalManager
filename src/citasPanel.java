import javax.swing.*;
import java.util.ArrayList;
import java.util.Date;

public class citasPanel extends JPanel {
    private JLabel nCita = new JLabel("Nueva cita");
    private JLabel labelSrchCliente = new JLabel("Cliente");
    private JTextField fieldSrchCliente = new JTextField("Buscar cliente");
    private JLabel labelnCliente = new JLabel("Nuevo cliente");
    private JList listClientes = new JList();
    private CustomListModel listModel = new CustomListModel();
    private JLabel labelServicio;
    private JComboBox comboServicio;
    private JLabel labelInicio;
    private Date hInicio;
    private JLabel labelRepe;
    private JToggleButton boolRepe;
    private JComboBox comboRepe;
    private JLabel labelRepeCada;
    private JTextField fieldSesiones;
    private JLabel labelSesiones;
    private JComboBox comboProvider;
    private JLabel labelProvider;
    private JButton saveCita = new JButton("Guardar");
    private JButton cancelCita = new JButton("Borrar");
    //TODO: Make the appointment dialog.
    public citasPanel() {
        add(nCita);
        add(labelSrchCliente);
        add(fieldSrchCliente);
        add(labelSrchCliente);
        add(labelnCliente);
        listClientes.setModel(listModel);
        add(listClientes);

    }
}
class CustomListModel extends AbstractListModel{
    private ArrayList lista = clientes.getArrayClientes();
    @Override
    public int getSize() {
        return lista.size();
    }

    @Override
    public Object getElementAt(int index) {
        cliente clie = (cliente) lista.get(index);
        return clie.getName() + " "+clie.getLastName();
    }
    public void addCliente(cliente clie){
        lista.add(clie);
        this.fireIntervalAdded(this,getSize(),getSize()+1);
    }
    public cliente getPersona(int index){
        return (cliente) lista.get(index);
    }

}
