package interfaz;

import java.awt.*;
import java.awt.event.*;
import java.awt.GridLayout;
import javax.swing.*;
import javax.swing.border.*;
import controller.Controller;

public class PanelGrid extends JPanel {
    private static final String BLOCK = "data/Block.gif";
    private JLabel lblgrid[][];
    private ImageIcon imgCell;
    private Controller controller;
    private PanelLifes pnlLifes;
    public PanelGrid(Controller controller, mainGUI mainGUI, PanelLifes pnlLifes ) {
    // ..............................................( T, L, B, R ).............................................
       //setBorder( new CompoundBorder( new EmptyBorder( 0, 0, 0, 0 ), new TitledBorder( "" ) ) );
       setLayout( new GridLayout(10, 10) );
       this.setBackground(Color.WHITE);
       this.imgCell = new ImageIcon( BLOCK );
    // Links each Panel
       this.controller = controller;
       this.pnlLifes = pnlLifes;

       lblgrid = new JLabel[10][10];
    // Initialize grid
       for(int i=0;i<10;i++)
    	for(int j=0;j<10;j++) {
            lblgrid[i][j] = new JLabel( "" );
    	    lblgrid[i][j].setBorder( new CompoundBorder( new EmptyBorder( 0, 0, 0, 0 ), new TitledBorder( "" ) ) );
    	    lblgrid[i][j].setHorizontalAlignment( JLabel.CENTER );
    	    lblgrid[i][j].setVerticalAlignment( JLabel.CENTER );
    	    lblgrid[i][j].setEnabled( true );
    	    lblgrid[i][j].addMouseListener( new LabelClicMouse( i, j, lblgrid[i][j], controller, this, pnlLifes, mainGUI ) );
    	    add(lblgrid[i][j]);
        }       
    }
    public void paint(String grid[][]) {
        for(int i=0;i<10;i=i+1) {
            for (int j = 0; j < 10; j = j + 1) {
                if (grid[i][j] == "C")
                    lblgrid[i][j].setIcon(imgCell);
                else
                    lblgrid[i][j].setIcon(null);
            }
        }
    }
    //
   public void update(boolean verify, int i, int j, boolean type) {
        if (!verify && type) {
            Toolkit.getDefaultToolkit().beep();
            lblgrid[i][j].setIcon( null );
            lblgrid[i][j].setText("X");
        }else
            if (!verify && !type) {
                Toolkit.getDefaultToolkit().beep();
                lblgrid[i][j].setText("");
                lblgrid[i][j].setIcon( imgCell );
     }  
   }
}
//Mouse Events
class LabelClicMouse extends MouseAdapter {
   private static final String BLOCK = "data/Block.gif";
   private JLabel label;
   private Controller ctrl;
   private int x, y;
   private ImageIcon imgCell;
   private PanelGrid pnlGrid;
   private PanelLifes pnlLifes;
   private mainGUI mainGUI;
           
   public LabelClicMouse(int x, int y, JLabel label, Controller ctrl, PanelGrid pnlGrilla, PanelLifes pnlVidas, mainGUI mainGUI ) {
       this.label = label;
        this.ctrl = ctrl;
        this.x = x; this.y = y;
        this.imgCell = new ImageIcon( BLOCK );
        this.pnlGrid = pnlGrilla;
        this.pnlLifes = pnlVidas;
        this.mainGUI = mainGUI;
   }
   public void mouseClicked(MouseEvent event) {
       if (pnlLifes.getLifes() >= 0 ) {
           if(event.isShiftDown()) {
               if(event.isMetaDown()){// Shift+Btn right
               }else{// Shift+Btn Left
                }
           }else{
               if (event.isMetaDown()) {
                   // Btn Left of mouse
                   if ((label.getText()).equals( "" ) && label.getIcon() == null) {
                        if(ctrl.clickCompare(x, y, false) == false){
                            pnlGrid.update(ctrl.clickCompare(x, y, false), x, y, true);
                        }else{
                            pnlGrid.update(!ctrl.clickCompare(x, y, false), x, y, false);
                            pnlLifes.upDate();
                        }
                   }
                   mainGUI.repaint();
               }else{
                   if( event.isAltDown()) {
                       // Middle BTN mouse
                    }else{
                       // Btn Right
                        if ((label.getText()).equals( "" )) {
                            //System.out.println("Botón izquierdo del mouse");
                            if(ctrl.clickCompare(x, y, true) == false){
                                pnlGrid.update(ctrl.clickCompare(x, y, true), x, y, false);
                            }else{
                                pnlGrid.update(!ctrl.clickCompare(x, y, true), x, y, true);
                                pnlLifes.upDate();
                            }
                        }
                    mainGUI.repaint();
                    }
               }
           }
       }else {
           JOptionPane.showMessageDialog(null, "You WON!.", "Nonogram", JOptionPane.WARNING_MESSAGE);
       
       }
   }
}