import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    private JPanel mainPanel;
    private JPanel contentPanel;
    private JPanel leftPanel;
    private GridBagConstraints leftLimit;
    private GridBagConstraints rightLimit;
    private String accType;

    /*TODO Saber que clientes ha atendido cada uno (Panel de personal?)
    *Cuanto ha trabajado para reportes de ganancias
    * Cobtros
     * Abonos, liquidaciones
     * Suelos?
     * Tratamientos largos?
    * */
    public MainWindow(String accType) {
        this.accType = accType;
        iniciarUI();
    }
    private void iniciarUI(){
        setMinimumSize(new Dimension(1000,600));
        setResizable(false);
        mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());
        leftLimit = new GridBagConstraints();
        leftLimit.gridwidth=1;
        leftLimit.fill = GridBagConstraints.BOTH;
        leftLimit.weighty = 100;
        leftLimit.weightx = 1;
        rightLimit = new GridBagConstraints();
        rightLimit.gridx = 1;
        rightLimit.gridwidth=3;
        rightLimit.fill = GridBagConstraints.BOTH;
        rightLimit.weightx = 3;
        rightLimit.weighty =100;

        leftPanel = new leftPanel(this,accType);
        mainPanel.add(leftPanel,leftLimit);
        contentPanel = new ContentPanel();

        addContent(contentPanel);
        setTitle("Consultorio dental");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setContentPane(mainPanel);
        setVisible(true);
    }
    public void iniciar(){
        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        try {
            this.setLocationByPlatform(true);
        } catch (Throwable ignoreAndContinue) {
        }
        setVisible(true);
    }

    public JPanel getContentPanel() {
        return contentPanel;
    }
    public void addContent(JPanel contentPanel){
        this.contentPanel = contentPanel;
        mainPanel.add(this.contentPanel,rightLimit);
    }
}
