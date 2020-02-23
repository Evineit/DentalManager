import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    private JPanel mainPanel;
    private JPanel contentPanel;
    private JPanel leftPanel;
    private GridBagConstraints leftLimit;
    private GridBagConstraints rightLimit;

    public MainWindow() {
        iniciarUI();
    }
    private void iniciarUI(){
        setMinimumSize(new Dimension(800,600));
        mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());
        leftLimit = new GridBagConstraints();
        leftLimit.weightx = 1;
        rightLimit = new GridBagConstraints();
        rightLimit.gridx = 1;
        rightLimit.weightx = 3;

        leftPanel = new JPanel();
        leftPanel.setBackground(Color.blue);
        leftPanel.setOpaque(true);
//        leftPanel.setBorder(new Border);
//        leftPanel.setSize(200, 400);
        mainPanel.add(leftPanel,leftLimit);
        contentPanel = new JPanel();
//        contentPanel.setMinimumSize(new Dimension(600,500));
        mainPanel.add(contentPanel,rightLimit);
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
}
