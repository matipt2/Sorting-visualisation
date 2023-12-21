import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.Random;

public class SortingVisualisation extends JPanel {
    private int[] array;
    private boolean sortingInProgress;

    public SortingVisualisation() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1280, 720);
        frame.getContentPane().add(this);
        frame.setVisible(true);
        fillArray();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.clearRect(0, 0, getWidth(), getHeight());
        drawArray(g);
    }

    public void fillArray() {
        array = new int[100];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100);
        }
    }

    private void drawArray(Graphics g) {
        int barWidth = getWidth() / array.length;
        int maxValue = Arrays.stream(array).max().orElse(0);
        for (int i = 0; i < array.length; i++) {
            int barHeight = (int) ((double) array[i] / maxValue * getHeight());
            int x = i * barWidth;
            int y = getHeight() - barHeight;
            g.fillRect(x, y, barWidth, barHeight);
        }
    }

    public void startSorting1() {
        sortingInProgress = true;
        bubbleSort();
        sortingInProgress = false;
    }

    public void startSorting2() {
        sortingInProgress = true;
        insertionSort();
        sortingInProgress = false;
    }

    public void startSorting3() {
        sortingInProgress = true;
        quickSort(0, array.length - 1);
        sortingInProgress = false;
    }

    private void bubbleSort() {
        boolean swapped;
        int n = array.length;
        do {
            swapped = false;
            for (int i = 0; i < n - 1; i++) {
                if (array[i] > array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    swapped = true;
                    try {
                        Thread.sleep(5);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    repaint();
                }
            }
            n--;
        } while (swapped);
        repaint();
    }


    public void insertionSort() {
        int i = 1;
        int x = 0;
        int j = 0;
        while (i < array.length) {
            x = array[i];
            j = i - 1;
            while (j >= 0 && array[j] > x) {
                array[j + 1] = array[j];
                j--;
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                repaint();
            }

            array[j + 1] = x;
            i++;
            repaint();
        }
    }

    public void quickSort(int low, int high) {
        if (low < high) {
            int pivotIndex = partition(low, high);
            quickSort(low, pivotIndex - 1);
            quickSort(pivotIndex + 1, high);
        }
    }

    private int partition(int low, int high) {
        int pivot = array[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) {
                i++;
                swap(i, j);
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                repaint();
            }
        }
        swap(i + 1, high);
        return i + 1;
    }

    private void swap(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public int mergeSort(){
        return 0;
    }

}
