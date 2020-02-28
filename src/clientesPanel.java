import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.util.regex.Pattern;

public class clientesPanel extends JPanel {
    JButton nClienteB = new JButton("Nuevo cliente");
//    JLabel ordenar = new JLabel("Ordenar por:");
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
    GridBagConstraints limiteInfo;
    JTextField clieName;
    JTextField clieLastName;
    JTextField cliePhone;
    final Pattern patronNumero = Pattern.compile("(\\(\\d{3}\\)[.-]?|\\d{3}[.-]?)?\\d{3}[.-]?\\d{4}");
    JButton saveClie;
    JPanel clienteCitas;
    GridBagConstraints limiteCitas;
    JPanel clientePagos;
    GridBagConstraints limitePagos;
    JButton buttonCobro =new JButton("Efectuar Pago");
    JButton buttonLiqui =new JButton("Liquidar adeudo");

    public clientesPanel() {
        setLayout(new BorderLayout());
        topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
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
        clienteInfo.setLayout(new GridBagLayout());
        limiteInfo = new GridBagConstraints();
        clieName = new JTextField();
        clieLastName = new JTextField();
        cliePhone = new JTextField();
        saveClie =  new JButton("Guardar");
        clienteCitas = new JPanel();
        clienteCitas.setLayout(new BorderLayout());
        clientePagos=new JPanel();
        limitePagos = new GridBagConstraints();
        infoClientes.addTab("Informacion",clienteInfo);
        infoClientes.addTab("Citas",clienteCitas);
        infoClientes.addTab("Pagos",clientePagos);
        botPanel.add(infoClientes);
        add(botPanel);
//        infoClientes.addChangeListener(new ChangeListener() {
//            @Override
//            public void stateChanged(ChangeEvent e) {
//                updateCitaCli();
//                updatePagosCli();
//            }
//        });
        nClienteB.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                listModel.addCliente(new cliente("Nuevo","Cliente","618-000-0000"));
                listaClientes.setSelectedIndex(listModel.getSize()-1);
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
                if (clie.getName()==null||clie.getName().isEmpty()){
                    JOptionPane.showMessageDialog(null,"Ingrese un nombre");
                    return;
                }
                if (clie.getLastName()==null||clie.getLastName().isEmpty()){
                    JOptionPane.showMessageDialog(null,"Ingrese un apellido");
                    return;
                }
                if (clie.getPhone()==null||clie.getPhone().isEmpty()){
                    JOptionPane.showMessageDialog(null,"Ingrese un telefono");
                    return;
                }
                if (!patronNumero.matcher(clie.getPhone()).matches()){
                    JOptionPane.showMessageDialog(null,"Ingrese un teléfono valido","Error",JOptionPane.ERROR_MESSAGE);
                    return;
                }


                clientes.saveClientes();
                repaint();
                revalidate();
                JOptionPane.showMessageDialog(null,"Se ha guardado el cliente","Informacion",JOptionPane.INFORMATION_MESSAGE
                );
            }
        });
        buttonCobro.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                cliente clie = listModel.getPersona(selectList);
                double money=0;
                try {
                    money = Double.parseDouble(JOptionPane.showInputDialog(null,"Ingrese cantidad por pagar","Pago",JOptionPane.QUESTION_MESSAGE));
                }catch (Exception error){
                    error.printStackTrace();
                    JOptionPane.showMessageDialog(null,"Ingresa un monto valido","Error de monto",JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (money>clie.getAdeudo()){
                    JOptionPane.showMessageDialog(null,"El monto es mayor que el adeudo del cliente","Error de monto",JOptionPane.WARNING_MESSAGE);
                    return;
                }
                clie.setCobrado(money+clie.getCobrado());
                clientes.saveClientes();
                updatePagosCli();
            }
        });
        buttonLiqui.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                cliente clie = listModel.getPersona(selectList);
                int decision = JOptionPane.showConfirmDialog(null,"Esta seguro de que desea liquidar el adeudo de: "+clie.getAdeudo(),"Confirmar pago",JOptionPane.WARNING_MESSAGE);
                if (decision==JOptionPane.YES_OPTION){
                    clie.setCobrado(clie.getAdeudo()+clie.getCobrado());
                    clientes.saveClientes();
                    updatePagosCli();
                }
//                return;
            }
        });


    }
    private void updateInfoCli(){
        cliente clie = listModel.getPersona(selectList);
        clienteInfo.removeAll();
        clienteInfo.repaint();
        clienteInfo.revalidate();
        limiteInfo.anchor = GridBagConstraints.NORTH;
        limiteInfo.fill=GridBagConstraints.HORIZONTAL;
        limiteInfo.ipadx=30;
        limiteInfo.gridy=0;
        limiteInfo.weighty = 0;
        limiteInfo.weightx=1;
        limiteInfo.gridheight=1;
        limiteInfo.insets = new Insets(50,100,10,100);
        clienteInfo.add(new JLabel("Nombre:"),limiteInfo);
        limiteInfo.insets = new Insets(10,100,10,100);
        clieName.setText(clie.getName());
        limiteInfo.gridy =1;
        clienteInfo.add(clieName,limiteInfo);
        limiteInfo.gridy =2;
        clienteInfo.add(new JLabel("Apellidos:"),limiteInfo);
        clieLastName.setText(clie.getLastName());
        limiteInfo.gridy =3;
        clienteInfo.add(clieLastName,limiteInfo);
        limiteInfo.gridy =4;
        clienteInfo.add(new JLabel("Telefono:"),limiteInfo);
        cliePhone.setText(clie.getPhone());
        limiteInfo.gridy =5;
        clienteInfo.add(cliePhone,limiteInfo);
        limiteInfo.gridy =6;
        clienteInfo.add(saveClie,limiteInfo);
        limiteInfo.gridheight = GridBagConstraints.REMAINDER;
        limiteInfo.weighty = 1;
        limiteInfo.weightx=2;
        limiteInfo.gridy =7;
        clienteInfo.add(new JLabel(""),limiteInfo);
        clienteInfo.repaint();
    }
    private void updateCitaCli(){
        cliente clie = listModel.getPersona(selectList);
        clienteCitas.removeAll();
        clienteCitas.repaint();
        clienteCitas.revalidate();
        model = new CustomTableModel(clie);
        tablaCitas = new JTable(model);
        tablaCitas.setDragEnabled(false);
        tablaCitas.getTableHeader().setReorderingAllowed(false);
        tablaCitas.removeColumn(tablaCitas.getColumn("Cliente"));
        model.resizeColumnWidth(tablaCitas);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        tablaCitas.getColumnModel().getColumn(0).setCellRenderer( centerRenderer );
        tablaCitas.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        tablaCitas.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
//        tablaCitas.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);

        citasScroll = new JScrollPane(tablaCitas);
        clienteCitas.add(citasScroll);
        clienteCitas.repaint();
        clienteCitas.revalidate();

    }
    private void updatePagosCli(){
        cliente clie = listModel.getPersona(listaClientes.getSelectedIndex());
        clientePagos.removeAll();
        clientePagos.repaint();
        clientePagos.revalidate();
        clientePagos.setLayout(new GridBagLayout());
        GridBagConstraints limites = new GridBagConstraints();
        limites.gridx=0;
        limites.fill = GridBagConstraints.HORIZONTAL;
        limites.ipadx=30;
        limites.weighty=0;
        limites.weightx=0;
        limites.gridheight=1;
        limites.insets = new Insets(40,10,10,10);

        clientePagos.add(new JLabel("Adeudo: $"+ clie.getAdeudo()),limites);
//        clientePagos.add(new JLabel("Cobrado: "+ clie.getCobrado()));
        if (clie.getAdeudo()>0){
            clientePagos.add(buttonCobro,limites);
            clientePagos.add(buttonLiqui,limites);
        }
        limites.weighty=1;
        clientePagos.add(new JLabel(""),limites);
        clientePagos.repaint();
        clientePagos.revalidate();

    }
}
