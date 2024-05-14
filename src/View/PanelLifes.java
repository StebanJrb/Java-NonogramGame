package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class PanelLifes extends JPanel {
    private JLabel lblLifes[];
    private ImageIcon imgLife, imgDie;
    private int lifes = 2;
    private static final String LIVE = "data/live.png";
    private static final String DIE = "data/die.png";

    public PanelLifes( ) {
    // ..............................................( T, L, B, R ).............................................
       //setBorder( new CompoundBorder( new EmptyBorder( 0, 0, 0, 0 ), new TitledBorder( "" ) ) );
       setLayout( new GridLayout(1, 10) );
    
       this.imgLife = new ImageIcon( LIVE );
       this.imgDie = new ImageIcon( DIE );
       this.setBackground(Color.WHITE);

       lblLifes = new JLabel[3];

       Font font = new Font("SansSerif", Font.BOLD, 10);
       
       for(int i=0;i<3;i++){
            lblLifes[i] = new JLabel( "" );
            lblLifes[i].setHorizontalAlignment( JLabel.CENTER );
    	    lblLifes[i].setVerticalAlignment( JLabel.CENTER );
            lblLifes[i].setForeground(Color.BLACK);
            lblLifes[i].setFont(font);
            add(lblLifes[i]);
       }
    }
    
    public void life() {
        for(int j=0;j<3;j=j+1){
            lblLifes[j].setIcon(imgLife);
        }
    }
    
    public void upDate(){
        lblLifes[lifes].setIcon( null );
        lblLifes[lifes].setIcon( imgDie );
        lifes--;
        if (lifes < 0) JOptionPane.showMessageDialog(null, "Game over.", "Nonogram", JOptionPane.WARNING_MESSAGE);
    }
    public int getLifes() { return lifes; }
}