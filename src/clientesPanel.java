import javax.swing.*;
import java.awt.*;

public class clientesPanel extends JPanel {
    JButton nClienteB = new JButton("Nuevo cliente");
    JLabel ordenar = new JLabel("Ordenar por:");
    JList listaClientes = new JList();
    JPanel topPanel;
    JPanel infoClientes;
    public clientesPanel() {
        setLayout(new BorderLayout());
        topPanel = new JPanel();
        topPanel.add(nClienteB);
        add(topPanel,BorderLayout.NORTH);
        add(listaClientes,BorderLayout.WEST);
        infoClientes = new JPanel();
        add(infoClientes);
    }
}
