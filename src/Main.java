import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SortingVisualisation sortingVisualisation = new SortingVisualisation();
        });
    }
}