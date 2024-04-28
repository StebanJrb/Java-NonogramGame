package util;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JDialog;

public class Util {
    public static void centerWindow(JFrame ventana){
        Dimension dPantalla = Toolkit.getDefaultToolkit( ).getScreenSize( );
        Dimension dVentana = ventana.getSize( );
        int xEsquina = ( dPantalla.width / 2 ) - ( dVentana.width / 2 );
        int yEsquina = ( dPantalla.height / 2 ) - ( dVentana.height / 2 );
        ventana.setLocation( xEsquina, yEsquina );
    }
    public static void centerWindow(JDialog ventana){
        Dimension dPantalla = Toolkit.getDefaultToolkit( ).getScreenSize( );
        Dimension dVentana = ventana.getSize( );
        int xEsquina = ( dPantalla.width / 2 ) - ( dVentana.width / 2 );
        int yEsquina = ( dPantalla.height / 2 ) - ( dVentana.height / 2 );
        ventana.setLocation( xEsquina, yEsquina );
    }
}    