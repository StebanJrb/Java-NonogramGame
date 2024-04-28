package interfaz;
import java.awt.*;

import javax.swing.*;

import controller.Controller;
import util.Util;

public class mainGUI extends JFrame {
    private PanelGrid pnlGrid;
    private PanelClues pnlRows, pnlCols;
    private PanelLifes pnlLifes;
    private Controller ctrl;
    private JMenuBar mbrOptions;
    private JMenu mnuAbout;
    private JMenuItem mitAbout;
    public mainGUI(Controller ctrl ) {
        setTitle( "Nonogram" );
        getContentPane( ).setLayout( null );

        this.ctrl = ctrl;

        mbrOptions = new JMenuBar( );

        mnuAbout = new JMenu( );
        mnuAbout.setMnemonic( 'A' );
        mnuAbout.setText( "About" );

        mitAbout = new JMenuItem();
        mitAbout.setMnemonic( 'S' );
        mitAbout.setText( "Author: Steban Ruiz" );
      
        mnuAbout.add(mitAbout);
        mbrOptions.add(mnuAbout);
                 
        setJMenuBar(mbrOptions);

        this.getContentPane().setBackground(Color.WHITE);

        pnlLifes = new PanelLifes();
        pnlLifes.setBounds( 195, 0, 110, 100  );
        pnlLifes.life();
              
        pnlRows = new PanelClues(5, 10);
        pnlRows.setBounds( 150, 65, 200, 100  );
      
        pnlCols = new PanelClues(10, 5);
        pnlCols.setBounds( 34, 170, 110, 200  );

        pnlGrid = new PanelGrid( ctrl, this, pnlLifes);
        pnlGrid.setBounds( 150, 170, 200, 200  );

        pnlRows.viewPistas(ctrl.getRows());
        pnlCols.viewPistas(ctrl.getCols());

        getContentPane( ).add(pnlGrid);
        getContentPane( ).add( pnlRows );
        getContentPane( ).add( pnlCols );
        getContentPane( ).add(pnlLifes);

        ctrl.connect(pnlGrid);
      
        setSize( 480, 460);
        setResizable( false );
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
      
        Util.centerWindow( this );
    }
    public static void main( String args[] ) {
        mainGUI frmMain = new mainGUI( new Controller() );
        frmMain.setVisible( true );
    }    
	
    public void paint( Graphics g )
    { super.paint( g );  // Llamar al método paint de la Superclase
 
      g.setColor( Color.red );
      g.drawLine( 154, 315, 351, 315 ); // Horizontal
      g.drawLine( 252, 215, 252, 413 ); // Vertical
    }        
}