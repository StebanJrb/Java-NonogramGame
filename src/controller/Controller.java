package controller;

import interfaz.PanelGrid;
import mundo.LoadNono;
import mundo.Nonograma;
public class Controller {
     private PanelGrid pnlGrid;
     private int win;
     private Nonograma nonograma;
     private LoadNono loadNono;

     public Controller() {
         nonograma = new Nonograma();
         loadNono = new LoadNono(); 
         readNono();
         win = 100;
     }
     public void connect(PanelGrid pnlGrid) { this.pnlGrid = pnlGrid;}
     public void readNono() { loadNono.readNono("nonogramas/nono0.in");}
     public String[][] getRows(){ return loadNono.getRows(); }
     public String[][] getCols(){ return loadNono.getCols(); }
  
     public boolean clickCompare(int x, int y, boolean z){//To control the mouse Event
         boolean ctrl = z;
         if(ctrl == true){
            ctrl = nonograma.compare(x, y, "0", loadNono);
         }
         else if(ctrl == false){
            ctrl = nonograma.compare(x, y, "X", loadNono);
         }
         return ctrl;
     }
    
     
}
