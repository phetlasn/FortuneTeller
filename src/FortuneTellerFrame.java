import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Random;

public class FortuneTellerFrame extends JFrame {

    JPanel displayPanel;
    JPanel mainPanel;
    JPanel controlPanel;
    JPanel iconPanel;
    JTextArea fortuneText;
    JScrollPane scroll;
    ImageIcon fortuneIcon;
    JLabel iconLabel;

    JButton quitButton;
    JButton fortuneButton;

    ArrayList<String> fortuneT = new ArrayList<>();

    int f = -1;
    int randomIndex;

    public FortuneTellerFrame() {
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        setTitle("Fortune Teller");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(mainPanel);
        mainPanel.setBackground(new Color(50,120,150));

        createIconPanel();
        mainPanel.add(iconPanel, BorderLayout.NORTH);

        createDisplayPanel();
        mainPanel.add(displayPanel,BorderLayout.CENTER);

        createControlPanel();
        mainPanel.add(controlPanel, BorderLayout.SOUTH);

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;
        setSize(3*(screenWidth / 4), 3*(screenHeight / 4));
        setLocationRelativeTo(null);
    }

    private void createDisplayPanel() {
        displayPanel = new JPanel();
        fortuneText = new JTextArea(12, 36);
        fortuneText.setEditable(false);
        scroll = new JScrollPane(fortuneText);
        displayPanel.setFont(new Font("Dialog", Font.PLAIN, 12));
        displayPanel.add(scroll);
    }

    private void createControlPanel() {
        controlPanel = new JPanel();
        controlPanel.setLayout(new GridLayout(1,2));

        fortuneButton = new JButton("Read My Fortune");
        quitButton = new JButton("Quit");

        controlPanel.add(fortuneButton);
        controlPanel.add(quitButton);

        fortuneT.add("I see money in your future...it is not yours though.");
        fortuneT.add("You aren't as good looking as your mom says you are.");
        fortuneT.add("An alien of some sort will be appearing to you shortly!");
        fortuneT.add("404 Fortune Not Found.");
        fortuneT.add("Stop procrastinating, staring tomorrow.");
        fortuneT.add("College is not it, drop out and go to trade school.");
        fortuneT.add("A dog will come and let you pet it.");
        fortuneT.add("A homeless man on Shortvine will growl at you.");
        fortuneT.add("Fortunes don't mean anything, stop wasting your time.");
        fortuneT.add("Your friend, [Google], won't help you on your homework.");
        fortuneT.add("You'll spill something on your white t-shirt.");
        fortuneT.add("You'll slip on a banana peel.");

        fortuneButton.addActionListener((ActionEvent ae) -> {
            Random rdm = new Random();

            do {
                randomIndex = rdm.nextInt(12);
            } while (randomIndex == 1);
            String fortune = fortuneT.get(randomIndex);
            f = randomIndex;
            fortuneText.append("Your Fortune: " + fortune + "\n");

        });
        quitButton.addActionListener((ActionEvent ae) -> System.exit(0));
        controlPanel.setFont(new Font("SansSerif", Font.BOLD, 12));
    }

    private void createIconPanel() {
        iconPanel = new JPanel();
        fortuneIcon = new ImageIcon("src/Fortune Teller.jpg");

        Image image = fortuneIcon.getImage().getScaledInstance(150,150,Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(image);
        iconLabel = new JLabel("Fortune Teller", scaledIcon, JLabel.CENTER);
        iconLabel.setFont(new Font("Monospaced", Font.BOLD, 48));

        iconLabel.setVerticalTextPosition(JLabel.BOTTOM);
        iconLabel.setHorizontalTextPosition(JLabel.CENTER);
        iconLabel.setForeground(new Color(0, 255, 255));

        iconPanel.add(iconLabel);

    }


}
