import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import com.github.lgooddatepicker.components.DatePicker;
import com.github.lgooddatepicker.components.TimePicker;
import jdk.nashorn.internal.scripts.JO;


public class citasPanel extends JPanel {
    private JLabel nCita = new JLabel("Nueva cita");
    private JLabel labelSrchCliente = new JLabel("Clientes");
    private JTextField fieldSrchCliente = new JTextField("Buscar cliente");
    private JLabel labelnCliente = new JLabel("Nuevo cliente");
    private JList listClientes = new JList();
    private CustomListModel listModel = new CustomListModel();
    private int selected;
    private JButton selecCliente = new JButton("Seleccionar");
    private JScrollPane ScrollList;

    private JLabel labelServicio;
    private JComboBox comboServicio;
    private ArrayList arrayServicios;
    private JLabel labelFecha;
    private LocalDate fecha;
    private JLabel labelInicio;
    private LocalTime horaInicio;
    DatePicker datePicker;
    TimePicker timePicker;

    private JLabel labelRepe;
    private JCheckBox boolRepe;
    private JLabel labelRepeCada;
    private JComboBox comboRepe;
    private JLabel labelSesiones;
    private JTextField fieldSesiones;
    private ArrayList arrayProvider= new ArrayList();
    private JComboBox comboProvider;
    private JLabel labelProvider;
    private JButton saveCita = new JButton("Guardar");
    private JButton cancelCita = new JButton("Cancelar");
    //TODO: Make the appointment panel;

    public citasPanel(Object selectedItem) {
        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        add(nCita);
        add(labelSrchCliente);
//        fieldSrchCliente.setMaximumSize(new Dimension(100,30));
//        add(fieldSrchCliente);
//        add(labelnCliente);
        listClientes.setModel(listModel);
        ScrollList = new JScrollPane(listClientes);
        add(ScrollList);
        add(selecCliente);

        labelServicio = new JLabel("Seleccione un servicio");
        comboServicio = new JComboBox<Servicio>();
        arrayServicios = ServiciosList.getServiciosList();
        for (Object servi: arrayServicios){
            comboServicio.addItem(servi);
        }
        labelFecha = new JLabel("Fecha");
        labelInicio = new JLabel("Hora de inicio");
        labelRepe = new JLabel("Se repite");
        boolRepe = new JCheckBox("",false);
        labelRepeCada = new JLabel("Se repite cada");
        comboRepe = new JComboBox();
        comboRepe.addItem("");
        labelSesiones = new JLabel("Sesiones");
        fieldSesiones = new JTextField();
        labelProvider = new JLabel("Especialista");
        comboProvider = new JComboBox();
        arrayProvider = personal.getPersonalList();
        for (Object esp: arrayProvider){
            comboProvider.addItem(esp);
        }

//        listClientes.addListSelectionListener(new ListSelectionListener() {
//            @Override
//            public void valueChanged(ListSelectionEvent e) {
//                selected = listClientes.getSelectedIndex();
////                if (selected!=-1){
////
////                }
//            }
//        });
        selecCliente.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (listClientes.getSelectedIndex()!=-1){
                    removeAll();
                    repaint();
                    revalidate();
                    add(nCita);
                    add(labelServicio);
                    add(comboServicio);
                    add(labelProvider);
                    add(comboProvider);
                    add(labelFecha);
                    datePicker = new DatePicker();
                    add(datePicker);
                    add(labelInicio);
                    timePicker = new TimePicker();
                    add(timePicker);
//                add(labelRepe);
//                add(boolRepe);
                    add(saveCita);
                    add(cancelCita);
                }else {
                    JOptionPane.showMessageDialog(null,"Seleccione un usuario","Informacion",JOptionPane.INFORMATION_MESSAGE);
                }
                int select = listClientes.getSelectedIndex();
            }
        });
//        boolRepe.addChangeListener(new ChangeListener() {
//            @Override
//            public void stateChanged(ChangeEvent e) {
//                if (boolRepe.isSelected()){
//                    remove(saveCita);
//                    remove(saveCita);
//                    add(labelRepeCada);
//                    add(comboRepe);
//                    add(labelSesiones);
//                    add(fieldSesiones);
//                    add(labelProvider);
//                    add(comboProvider);
//
//                }else if (!boolRepe.isSelected()) {
//                    remove(labelRepeCada);
//                    remove(comboRepe);
//                    remove(labelSesiones);
//                    remove(fieldSesiones);
//                    remove(labelProvider);
//                    remove(comboProvider);
//                }
//                add(saveCita);
//                add(cancelCita);
//                repaint();
//                revalidate();
//            }
//        });
        saveCita.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                fecha = datePicker.getDate();
                horaInicio = timePicker.getTime();
                Cita cita = new Cita(fecha,horaInicio,(Servicio) comboServicio.getSelectedItem(),
                        (cliente) clientes.getArrayClientes().get(listClientes.getSelectedIndex()),
                        (especialista) comboProvider.getSelectedItem());
                CitasList.getCitasList().add(cita);
                CitasList.saveCitas();
                JOptionPane.showMessageDialog(null,"Cita añadida exitosamente.",
                        "Informacion",JOptionPane.INFORMATION_MESSAGE);
            }
        });
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
