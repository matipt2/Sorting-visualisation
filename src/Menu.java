import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.JOptionPane;

public class Menu extends JPanel implements ActionListener {
    private SortingVisualisation sortingVisualisation;

    public Menu(SortingVisualisation sortingVisualisation) {
        this.sortingVisualisation = sortingVisualisation;

        setLayout(new FlowLayout(FlowLayout.CENTER, 15, 15));

        JButton bubbleSortButton = new JButton("Bubble sort");
        JButton insertionSortButton = new JButton("Insertion sort");
        JButton quickSortButton = new JButton("Quick sort");
        JButton mergeSortButton = new JButton("Merge sort");
        JButton shuffleButton = new JButton("Shuffle");

        bubbleSortButton.addActionListener(this);
        insertionSortButton.addActionListener(this);
        quickSortButton.addActionListener(this);
        mergeSortButton.addActionListener(this);
        shuffleButton.addActionListener(this);

        add(bubbleSortButton);
        add(insertionSortButton);
        add(quickSortButton);
        add(mergeSortButton);
        add(shuffleButton);
    }




    @Override
    public void actionPerformed(ActionEvent e) {
        sortingVisualisation.fillArray();

        long startTime = System.currentTimeMillis();

        if (e.getActionCommand().equals("Bubble sort")) {
            new Thread(() -> {
                sortingVisualisation.doBubbleSort();
                long endTime = System.currentTimeMillis();
                long elapsedTime = endTime - startTime;
                System.out.println("Bubble Sort Time: " + elapsedTime + " milliseconds");
                JOptionPane.showMessageDialog(null, "Bubble Sort Time: " + elapsedTime + " milliseconds");
            }).start();
        } else if (e.getActionCommand().equals("Insertion sort")) {
            new Thread(() -> {
                sortingVisualisation.doInsertionSort();
                long endTime = System.currentTimeMillis();
                long elapsedTime = endTime - startTime;
                System.out.println("Insertion Sort Time: " + elapsedTime + " milliseconds");
                JOptionPane.showMessageDialog(null, "Insertion Sort Time: " + elapsedTime + " milliseconds");
            }).start();
        } else if (e.getActionCommand().equals("Quick sort")) {
            new Thread(() -> {
                sortingVisualisation.doQuickSort();
                long endTime = System.currentTimeMillis();
                long elapsedTime = endTime - startTime;
                System.out.println("Quick Sort Time: " + elapsedTime + " milliseconds");
                JOptionPane.showMessageDialog(null, "Quick Sort Time: " + elapsedTime + " milliseconds");
            }).start();
        } else if (e.getActionCommand().equals("Merge sort")) {
            new Thread(() -> {
                sortingVisualisation.doMergeSort();
                long endTime = System.currentTimeMillis();
                long elapsedTime = endTime - startTime;
                System.out.println("Merge Sort Time: " + elapsedTime + " milliseconds");
                JOptionPane.showMessageDialog(null, "Merge Sort Time: " + elapsedTime + " milliseconds");
            }).start();
        }
    }

}