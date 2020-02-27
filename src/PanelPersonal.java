import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;

public class PanelPersonal extends JPanel {
    JList listaPersonal = new JList();
    CustomEspeList listModel = new CustomEspeList();
    CustomTableModel model;
    private int selectList;
    JTabbedPane infoPersonal;
    JPanel espeInfo;
    JTextField espeName;
    JTextField espeType;
    JPanel espePagos;

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
        espePagos=new JPanel();
        infoPersonal.addTab("Información",espeInfo);
        //TODO PAGOS
//        infoPersonal.addTab("Pagos",espePagos);
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
                    limites.weightx=100;
                    limites.weighty=100;
                    espeInfo.add(new JLabel(""),limites);
                    espeInfo.repaint();
//                    updatePagosCli();
                }
            }
        });

    }
    //    JButton saveClie;
}
