package sample;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;
import javax.swing.border.Border;

final class SudokuGrid extends JPanel {

    private static final Font FONT = new Font("Calibri", Font.CENTER_BASELINE, 20);

    private final JTextField[][] grid;
    private final Map<JTextField, Point> coords = new HashMap<>();

    private final JPanel gridPanel;
    private final JPanel buttonPanel;
    private final JButton finishButton;
    private final JButton quitButton;
    private final JPanel[][] squarePanels;

    SudokuGrid(int dimension) {
        this.grid = new JTextField[dimension][dimension];

        for (int j = 0; j< dimension; j++) {
            for (int i = 0; i < dimension; i++) {
                JTextField field = new JTextField();
                coords.put(field, new Point(i, j));
                grid[i][j] = field;
            }
        }
        this.gridPanel   = new JPanel();
        this.buttonPanel = new JPanel();

        Border border = BorderFactory.createLineBorder(Color.BLACK, 2);
        Dimension boxDimension = new Dimension(30, 30);

        class PopupMenuListener implements ActionListener {
            private final JTextField field;
            private final int number;

            PopupMenuListener(JTextField field, int number) {
                this.field  = field;
                this.number = number;
            }

            @Override
            public void actionPerformed(ActionEvent e) {
                field.setText("" + number);
            }
        }
        for (int i= 0; i < dimension;i++) {
            for (int j = 0; j < dimension; j++) {
                JTextField field = grid[j][i];
                field.setBorder(border);
                field.setFont(FONT);
                field.setHorizontalAlignment(JTextField.CENTER);
                field.setPreferredSize(boxDimension);

                JPopupMenu menu = new JPopupMenu();

                for (int k = 0; k <= dimension; k++) {
                    JMenuItem item = new JMenuItem("" + k);
                    menu.add(item);
                    item.addActionListener(new PopupMenuListener(field, k));
                }

                field.add(menu);
                field.setComponentPopupMenu(menu);
            }
        }

        int squareDimension= (int) Math.sqrt(dimension);
        this.gridPanel.setLayout(new GridLayout(squareDimension,
                squareDimension));

        this.squarePanels = new JPanel[squareDimension]
                [squareDimension];

        Border boxBorder = BorderFactory.createLineBorder(Color.BLACK, 1);

        for (int y = 0; y < squareDimension; ++y) {
            for (int x = 0; x < squareDimension; ++x) {
                JPanel panel = new JPanel();
                panel.setLayout(new GridLayout(squareDimension, squareDimension));
                panel.setBorder(boxBorder);
                squarePanels[y][x] = panel;
                gridPanel.add(panel);
            }
        }

        for (int y = 0; y < dimension; ++y) {
            for (int x = 0; x < dimension; ++x) {
                int boxX = x / squareDimension;
                int boxY = y / squareDimension;

                squarePanels[boxY][boxX].add(grid[y][x]);
            }
        }
        this.gridPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
        this.quitButton = new JButton("Quit");
        this.finishButton = new JButton("Finish");

        this.buttonPanel.setLayout(new BorderLayout());
        this.buttonPanel.add(quitButton, BorderLayout.WEST);
        this.buttonPanel.add(finishButton, BorderLayout.EAST);

        this.setLayout(new BorderLayout());
        this.add(gridPanel,   BorderLayout.NORTH);
        this.add(buttonPanel, BorderLayout.SOUTH);
    }
}
