package interfaz;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class PanelClues extends JPanel {
    private JLabel lblClues[][];
    private int row, col;
    public PanelClues(int rows, int cols) {
    // ..............................................( T, L, B, R ).............................................
       //setBorder( new CompoundBorder( new EmptyBorder( 0, 0, 0, 0 ), new TitledBorder( "" ) ) );
       setLayout( new GridLayout(rows, cols) );
       this.setBackground(Color.WHITE);
       
       this.row = rows; this.col = cols;

       lblClues = new JLabel[row][col];

       Font font = new Font("SansSerif", Font.BOLD, 10);
       
       for(int i=0;i<row;i++) {
           for (int j = 0; j < col; j++) {
               lblClues[i][j] = new JLabel("");
               lblClues[i][j].setHorizontalAlignment(JLabel.CENTER);
               lblClues[i][j].setVerticalAlignment(JLabel.CENTER);
               lblClues[i][j].setForeground(Color.BLACK);
               lblClues[i][j].setFont(font);
               add(lblClues[i][j]);
           }
       }
    }
    public void viewPistas(String clues[][]) {
        for(int i=0;i<row;i=i+1){
            for(int j=0;j<col;j=j+1) {
                if (!clues[i][j].equals("0"))
                    lblClues[i][j].setText(clues[i][j]);
            }
        }
    }    
}