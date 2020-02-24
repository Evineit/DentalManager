import javax.swing.*;
import java.awt.*;
import java.security.PrivateKey;

public class MainWindow extends JFrame {
    private JPanel mainPanel;
    private JPanel contentPanel;
    private JPanel leftPanel;
    private GridBagConstraints leftLimit;
    private GridBagConstraints rightLimit;
    private boolean boss;

    public MainWindow(boolean boss) {
        this.boss =boss;
        iniciarUI();
    }
    private void iniciarUI(){
        setMinimumSize(new Dimension(800,600));
        mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());
        leftLimit = new GridBagConstraints();
        leftLimit.gridwidth=1;
        leftLimit.fill =leftLimit.BOTH;
        leftLimit.weighty = 100;
        leftLimit.weightx = 1;
        rightLimit = new GridBagConstraints();
        rightLimit.gridx = 1;
        rightLimit.gridwidth=3;
        rightLimit.fill = rightLimit.BOTH;
        rightLimit.weightx = 3;
        rightLimit.weighty =100;

        leftPanel = new leftPanel(this,boss);
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

    public void setContentPanel(JPanel contentPanel) {
        this.contentPanel = contentPanel;
    }

    public JPanel getContentPanel() {
        return contentPanel;
    }
    public void addContent(JPanel contentPanel){
        mainPanel.add(contentPanel,rightLimit);
    }
}
