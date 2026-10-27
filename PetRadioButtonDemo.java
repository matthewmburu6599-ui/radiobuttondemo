import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class PetRadioButtonDemo extends JFrame implements ActionListener {

    private JRadioButton birdButton, catButton, dogButton, rabbitButton, pigButton;
    private ButtonGroup group;
    private JLabel imageLabel;

    public PetRadioButtonDemo() {

        setTitle("RadioButtonDemo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));


        birdButton = new JRadioButton("Bird");
        catButton = new JRadioButton("Cat");
        dogButton = new JRadioButton("Dog");
        rabbitButton = new JRadioButton("Rabbit");
        pigButton = new JRadioButton("Pig");


        group = new ButtonGroup();
        group.add(birdButton);
        group.add(catButton);
        group.add(dogButton);
        group.add(rabbitButton);
        group.add(pigButton);


        birdButton.addActionListener(this);
        catButton.addActionListener(this);
        dogButton.addActionListener(this);
        rabbitButton.addActionListener(this);
        pigButton.addActionListener(this);


        JPanel radioPanel = new JPanel();
        radioPanel.setLayout(new BoxLayout(radioPanel, BoxLayout.Y_AXIS));
        radioPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        radioPanel.add(birdButton);
        radioPanel.add(catButton);
        radioPanel.add(dogButton);
        radioPanel.add(rabbitButton);
        radioPanel.add(pigButton);


        imageLabel = new JLabel();
        imageLabel.setHorizontalAlignment(JLabel.CENTER);
        imageLabel.setPreferredSize(new Dimension(250, 200));


        add(radioPanel, BorderLayout.WEST);
        add(imageLabel, BorderLayout.CENTER);


        pack();
        setLocationRelativeTo(null); // Center on screen
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String petName = "";
        String imageName = "";


        if (e.getSource() == birdButton) {
            petName = "Bird";
            imageName = "bird.png";
        } else if (e.getSource() == catButton) {
            petName = "Cat";
            imageName = "cat.png";
        } else if (e.getSource() == dogButton) {
            petName = "Dog";
            imageName = "dog.png";
        } else if (e.getSource() == rabbitButton) {
            petName = "Rabbit";
            imageName = "rabbit.png";
        } else if (e.getSource() == pigButton) {
            petName = "Pig";
            imageName = "pig.png";
        }


        updateImage(imageName);


        JOptionPane.showMessageDialog(this, "You selected: " + petName, "Pet Selection", JOptionPane.INFORMATION_MESSAGE);
    }

    private void updateImage(String filename) {

        URL imgURL = getClass().getResource("/images/" + filename);
        if (imgURL != null) {
            ImageIcon icon = new ImageIcon(imgURL);

            Image img = icon.getImage().getScaledInstance(200, 180, Image.SCALE_SMOOTH);
            imageLabel.setIcon(new ImageIcon(img));
        } else {
            imageLabel.setText("[ Image not found: " + filename + " ]");
            imageLabel.setIcon(null);
        }
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> new PetRadioButtonDemo());
    }
}