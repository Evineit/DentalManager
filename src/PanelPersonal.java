import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.util.ArrayList;

public class PanelPersonal extends JPanel {
    JList listaPersonal = new JList();
    CustomEspeList listModel = new CustomEspeList();
    CustomTableModel model;
    private int selectList;
    JTabbedPane infoPersonal;
    JPanel espeInfo;
    JTextField espeName;
    JTextField espeType;
    JTextField espeSalary;
    JTextField espePhone;
    JTextField espeDireccion;
    JPanel espeReportes;

    public PanelPersonal() {
        setLayout(new BoxLayout(this,BoxLayout.X_AXIS));
        GridBagConstraints limites = new GridBagConstraints();
        listaPersonal.setModel(listModel);
        JScrollPane JScroll = new JScrollPane(listaPersonal);
        JScroll.setMinimumSize(new Dimension(100,100));

        add(JScroll);
        infoPersonal = new JTabbedPane();
        espeInfo = new JPanel();
        espeInfo.setLayout(new GridBagLayout());
        espeName = new JTextField();
        espeType = new JTextField();
        espeSalary = new JTextField();
        espePhone = new JTextField();
        espeDireccion = new JTextField();
        espeReportes =new JPanel();
        infoPersonal.addTab("Información",espeInfo);
        //TODO PAGOS
        //TODO Añadir el uso del salario
        //TODO Mostrar en los reportes

        infoPersonal.addTab("Reportes", espeReportes);
        add(infoPersonal);
        listaPersonal.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                selectList = listaPersonal.getSelectedIndex();
                if (selectList!=-1){
                    especialista espe = listModel.getPersona(selectList);
                    limites.anchor = GridBagConstraints.NORTH;
                    limites.fill = GridBagConstraints.HORIZONTAL;
                    limites.ipadx=30;
                    limites.weighty=0;
                    limites.weightx=1;
                    limites.gridheight=1;
                    limites.gridx=0;
                    limites.insets = new Insets(10,10,10,10);
                    espeInfo.removeAll();
                    espeInfo.repaint();
                    espeInfo.revalidate();
                    espeInfo.add(new JLabel("Nombre:"),limites);
                    espeName.setText(espe.getName());
                    espeName.setEditable(false);
                    espeInfo.add(espeName,limites);
                    espeInfo.add(new JLabel("Especialidad:"),limites);
                    espeType.setText(espe.getEspecialidad());
                    espeType.setEditable(false);
                    espeInfo.add(espeType,limites);
                    espeInfo.add(new JLabel("Sueldo: "),limites);
                    espeSalary.setEditable(false);
                    espeSalary.setText(String.valueOf(espe.getSalario()));
                    espeInfo.add(espeSalary,limites);
                    espeInfo.add(new JLabel("Telefono:"),limites);
                    espePhone.setEditable(false);
                    espePhone.setText(espe.getPhone());
                    espeInfo.add(espePhone,limites);
                    espeInfo.add(new JLabel("Direccion:"),limites);
                    espeDireccion.setEditable(false);
                    espeDireccion.setText(espe.getDireccion());
                    espeInfo.add(espeDireccion,limites);
                    limites.weightx=100;
                    limites.weighty=100;
                    espeInfo.add(new JLabel(""),limites);

                    updateReportes(espe);
                    espeInfo.repaint();
                }
            }
        });


    }

    private void updateReportes(especialista espe) {
        ArrayList<Cita> citasList = (ArrayList<Cita>) CitasList.getCitasList().clone();
        citasList.removeIf(cita -> !cita.getProveedor().equals(espe));
//        int numCitas;
        espeReportes.removeAll();
        espeReportes.repaint();
        espeReportes.revalidate();
        espeReportes.add(new JLabel("Numero de citas: "+ citasList.size()));
    }
}
