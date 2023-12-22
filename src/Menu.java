import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.Flow;
import javax.swing.*;

public class Menu implements ActionListener {
    private final JButton bubbleSortButton;
    private final JButton insertionSortButton;
    private final JButton quickSortButton;
    private final JButton mergeSort;
    private final JButton shuffleButton;

    public Menu() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new GridBagLayout());
        JLabel menuLabel = new JLabel();

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 15));
        buttonPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        bubbleSortButton = new JButton();
        insertionSortButton = new JButton();
        quickSortButton = new JButton();
        mergeSort = new JButton();
        shuffleButton = new JButton();

        bubbleSortButton.setPreferredSize(new Dimension(100, 70));
        insertionSortButton.setPreferredSize(new Dimension(100, 70));
        quickSortButton.setPreferredSize(new Dimension(100, 70));
        mergeSort.setPreferredSize(new Dimension(100, 70));
        shuffleButton.setPreferredSize(new Dimension(100, 70));

        buttonPanel.add(bubbleSortButton);
        buttonPanel.add(insertionSortButton);
        buttonPanel.add(quickSortButton);
        buttonPanel.add(mergeSort);
        buttonPanel.add(shuffleButton);
        menuLabel.setForeground(Color.BLACK);
        ImageIcon menuLogo = new ImageIcon("images/menu1.jpg");
        menuLabel.setIcon(new ImageIcon(menuLogo.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT)));


        bubbleSortButton.addActionListener(this);
        insertionSortButton.addActionListener(this);
        quickSortButton.addActionListener(this);
        mergeSort.addActionListener(this);
        shuffleButton.addActionListener(this);


        bubbleSortButton.setText("<html><br>Bubble sort</html>");
        insertionSortButton.setText("<html><br>Insertion sort</html>");
        quickSortButton.setText("<html><br>Quick sort</html>");
        mergeSort.setText("<html><br>Merge sort</html>");
        shuffleButton.setText("<html><br>Shuffle</html>");



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
        buttonPanel.setPreferredSize(new Dimension(800, 150));
        buttonPanel.setBorder(BorderFactory.createTitledBorder("Pick one of these sorting algorithms"));
        frame.getContentPane().add(buttonPanel, gbc);
        frame.setSize(1280, 720);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }

    public void actionPerformed(ActionEvent e) {
        SortingVisualisation sortingVisualisation = new SortingVisualisation();
        if (e.getSource() == bubbleSortButton) {
            new Thread(sortingVisualisation::startSorting1).start();
        } else if (e.getSource() == insertionSortButton) {
            new Thread(sortingVisualisation::startSorting2).start();
        } else if (e.getSource() == quickSortButton) {
            new Thread(sortingVisualisation::startSorting3).start();
        }
        sortingVisualisation.repaint();
    }
}
