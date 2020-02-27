import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class MainWindow extends JFrame {
    private JPanel mainPanel;
    private JPanel contentPanel;
    private JPanel leftPanel;
    private GridBagConstraints leftLimit;
    private GridBagConstraints rightLimit;
    private String accType;

    //todo Valida todo GRACIAS
    /*TODO Saber que clientes ha atendido cada uno (Panel de personal?)
    *Cuanto ha trabajado para reportes de ganancias
     * Sueldos?
     * Tratamientos largos?
    * */
    public MainWindow(String accType) {
        this.accType = accType;
        iniciarUI();
    }
    private void iniciarUI(){
        Image icon = new ImageIcon("src/Resource/dental-ico2.png").getImage();
        setIconImage(icon);
        setMinimumSize(new Dimension(1000,600));
        setResizable(false);
        mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());

        leftLimit = new GridBagConstraints();
        leftLimit.fill = GridBagConstraints.BOTH;
        leftLimit.weighty = 100;
        leftLimit.gridwidth=1;
        leftLimit.weightx = 0;
        leftLimit.ipadx=10;
        rightLimit = new GridBagConstraints();
        rightLimit.fill = GridBagConstraints.BOTH;
        rightLimit.gridx = 1;
        rightLimit.weighty =100;
        rightLimit.gridwidth=3;
        rightLimit.weightx = 100;
        rightLimit.insets = new Insets(1,1,1,1);

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
//        try {
//
//            this.setLocationByPlatform(true);
//        } catch (Throwable ignoreAndContinue) {
//        }
        setLocationRelativeTo(null);
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
