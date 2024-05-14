package View;
import java.awt.*;

import javax.swing.*;

import Controllers.Controller;
import Utils.Util;

public class MainGui extends JFrame {
    private final PanelGrid  pnlGrid;
    private final PanelClues pnlRows;
    private final PanelClues pnlCols;
    private final PanelLifes pnlLifes;
    private final JMenuBar mbrOptions;
    private final JMenu mnuAbout;
    private final JMenuItem mitAbout;
    public MainGui(Controller ctrl) {
        setTitle( "Nonogram" );
        getContentPane( ).setLayout( null );

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

        setSize( 480, 460);
        setResizable( false );
        setDefaultCloseOperation(EXIT_ON_CLOSE);
      
        Util.centerWindow( this );
    }
    public static void main( String [] args) {
        MainGui frmMain = new MainGui( new Controller() );
        frmMain.setVisible( true );
    }
}