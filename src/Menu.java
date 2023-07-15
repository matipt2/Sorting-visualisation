import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Menu implements ActionListener {
    private JButton button1;
    private JButton button2;
    private JButton button3;

    public Menu() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new GridBagLayout());
        JLabel menuLabel = new JLabel();

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 100, 50));
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();
        ImageIcon buttonLogo = new ImageIcon("images/image3.jpg");
        button1.setPreferredSize(new Dimension(150, 150));
        button2.setPreferredSize(new Dimension(150, 150));
        button3.setPreferredSize(new Dimension(150, 150));

        buttonPanel.add(button1);
        buttonPanel.add(button2);
        buttonPanel.add(button3);

        menuLabel.setForeground(Color.BLACK);
        ImageIcon menuLogo = new ImageIcon("images/menu1.jpg");
        menuLabel.setIcon(new ImageIcon(menuLogo.getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT)));
        button1.setIcon(new ImageIcon(buttonLogo.getImage().getScaledInstance(90, 90, Image.SCALE_DEFAULT)));
        button2.setIcon(new ImageIcon(buttonLogo.getImage().getScaledInstance(90, 90, Image.SCALE_DEFAULT)));
        button3.setIcon(new ImageIcon(buttonLogo.getImage().getScaledInstance(90, 90, Image.SCALE_DEFAULT)));

        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);

        button1.setText("<html><br>(Bubble sort)</html>");
        button2.setText("<html><br>(Insertion sort)</html>");
        button3.setText("<html><br>(Quick sort)</html>");

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.NONE;

        frame.getContentPane().add(menuLabel, gbc);
        gbc.gridy = 1;
        gbc.weighty = 1.0;
        buttonPanel.setPreferredSize(new Dimension(800, 300));
        buttonPanel.setBorder(BorderFactory.createTitledBorder("Pick one of these sorting algorithms"));
        frame.getContentPane().add(buttonPanel, gbc);
        frame.setSize(1280, 720);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }

    public void actionPerformed(ActionEvent e) {
        SortingVisualisation sortingVisualisation = new SortingVisualisation();
        if (e.getSource() == button1) {
            new Thread(sortingVisualisation::startSorting1).start();
        } else if (e.getSource() == button2) {
            new Thread(sortingVisualisation::startSorting2).start();
        } else if (e.getSource() == button3) {
            new Thread(sortingVisualisation::startSorting3).start();
        }
        sortingVisualisation.repaint();
    }




}
