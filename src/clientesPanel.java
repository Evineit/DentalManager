import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class clientesPanel extends JPanel {
    JButton nClienteB = new JButton("Nuevo cliente");
    JLabel ordenar = new JLabel("Ordenar por:");
    JList listaClientes = new JList();
    CustomListModel listModel = new CustomListModel();
    CustomTableModel model;
    JTable tablaCitas;
    JScrollPane citasScroll;
    private int selectList;

    JPanel topPanel;
    JPanel botPanel;
    JTabbedPane infoClientes;
    JPanel clienteInfo;
    JTextField clieName;
    JTextField clieLastName;
    JTextField cliePhone;
    JButton saveClie;

    JPanel clienteCitas;
    JPanel clientePagos;
    public clientesPanel() {
        setLayout(new BorderLayout());
        topPanel = new JPanel();
        topPanel.add(nClienteB);
        add(topPanel,BorderLayout.NORTH);
        listaClientes.setModel(listModel);
        JScrollPane JScroll = new JScrollPane(listaClientes);
        JScroll.setMinimumSize(new Dimension(100,100));

        botPanel = new JPanel();
        botPanel.setLayout(new BoxLayout(botPanel,BoxLayout.X_AXIS));
        botPanel.add(JScroll);
        infoClientes = new JTabbedPane();
        infoClientes.setMinimumSize(new Dimension(300,200));
        clienteInfo = new JPanel();
        clienteInfo.setLayout(new BoxLayout(clienteInfo,BoxLayout.Y_AXIS));
        clieName = new JTextField();
        clieLastName = new JTextField();
        cliePhone = new JTextField();
        saveClie =  new JButton("Guardar");
        clienteCitas = new JPanel();
        clienteCitas.setLayout(new BorderLayout());
        clientePagos=new JPanel();
        infoClientes.addTab("Informacion",clienteInfo);
        infoClientes.addTab("Citas",clienteCitas);
        infoClientes.addTab("Pagos",clientePagos);
        botPanel.add(infoClientes);
        add(botPanel);
        infoClientes.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                updateCitaCli();
                updatePagosCli();
            }
        });
        nClienteB.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                listModel.addCliente(new cliente("Nuevo","Cliente","618-000-0000"));
                listaClientes.setSelectedIndex(0);
            }
        });
        listaClientes.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                selectList = listaClientes.getSelectedIndex();
                if (selectList!=-1){
                    updateInfoCli();
                    updateCitaCli();
                    updatePagosCli();
                }
            }
        });
        saveClie.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                cliente clie = listModel.getPersona(listaClientes.getSelectedIndex());
                clie.setName(clieName.getText());
                clie.setLastName(clieLastName.getText());
                clie.setPhone(cliePhone.getText());
                clientes.saveClientes();
                repaint();
                revalidate();
                JOptionPane.showMessageDialog(null,"Se ha guardado el cliente","Informacion",JOptionPane.INFORMATION_MESSAGE
                );
            }
        });


    }
    private void updateInfoCli(){
        cliente clie = listModel.getPersona(selectList);
        clienteInfo.removeAll();
        clienteInfo.repaint();
        clienteInfo.revalidate();
        clienteInfo.add(new JLabel("Nombre:"));
        clieName.setText(clie.getName());
        clienteInfo.add(clieName);
        clienteInfo.add(new JLabel("Apellidos:"));
        clieLastName.setText(clie.getLastName());
        clienteInfo.add(clieLastName);
        clienteInfo.add(new JLabel("Telefono:"));
        cliePhone.setText(clie.getPhone());
        clienteInfo.add(cliePhone);
        clienteInfo.add(saveClie);
        clienteInfo.repaint();
    }
    private void updateCitaCli(){
        cliente clie = listModel.getPersona(selectList);
        clienteCitas.removeAll();
        clienteCitas.repaint();
        clienteCitas.revalidate();
        model = new CustomTableModel(clie);
        tablaCitas = new JTable(model);
        citasScroll = new JScrollPane(tablaCitas);
        clienteCitas.add(citasScroll);
        clienteCitas.repaint();
        clienteCitas.revalidate();

    }
    private void updatePagosCli(){
        cliente clie = listModel.getPersona(selectList);
        clientePagos.removeAll();
        clientePagos.repaint();
        clientePagos.revalidate();
        clientePagos.add(new JLabel("Adeudo: "+ clie.getAdeudo()));
        clientePagos.add(new JLabel("Cobrado: "+ clie.getCobrado()));
        if (clie.getAdeudo()>0){
            clientePagos.add(new Button("Efectuar Pago"));
        }
        clientePagos.repaint();
        clientePagos.revalidate();
    }
}
