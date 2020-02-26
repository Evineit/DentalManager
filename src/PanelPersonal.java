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
        listaPersonal.setModel(listModel);
        JScrollPane JScroll = new JScrollPane(listaPersonal);
        JScroll.setMinimumSize(new Dimension(100,100));

        add(JScroll);
        infoPersonal = new JTabbedPane();
        espeInfo = new JPanel();
        espeInfo.setLayout(new BoxLayout(espeInfo,BoxLayout.Y_AXIS));
        espeName = new JTextField();
        espeType = new JTextField();
        espePagos=new JPanel();
        infoPersonal.addTab("Información",espeInfo);
        infoPersonal.addTab("Pagos",espePagos);
        add(infoPersonal);
        listaPersonal.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                selectList = listaPersonal.getSelectedIndex();
                if (selectList!=-1){
                    especialista espe = listModel.getPersona(selectList);
                    espeInfo.removeAll();
                    espeInfo.repaint();
                    espeInfo.revalidate();
                    espeInfo.add(new JLabel("Nombre:"));
                    espeName.setText(espe.getName());
                    espeName.setEditable(false);
                    espeInfo.add(espeName);
                    espeInfo.add(new JLabel("Especialidad:"));
                    espeType.setText(espe.getEspecialidad());
                    espeType.setEditable(false);
                    espeInfo.add(espeType);
                    espeInfo.repaint();
//                    updatePagosCli();
                }
            }
        });

    }
    //    JButton saveClie;
}
