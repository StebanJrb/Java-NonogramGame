package Controllers;

import Model.LoadNono;
import Model.Nonograma;

public class Controller{
     private Nonograma nonograma;
     private LoadNono loadNono;

     public Controller(){
         nonograma = new Nonograma();
         loadNono = new LoadNono(); 
         readNono();
     }
     public void readNono() { loadNono.readNono("nonogramas/nono0.in");}
     public String[][] getRows(){ return loadNono.getRows(); }
     public String[][] getCols(){ return loadNono.getCols(); }

     public boolean clickCompare(int x, int y, boolean z){//To control the mouse Event
         return (z)? nonograma.compare(x,y,"0",loadNono) : nonograma.compare(x,y,"X", loadNono);
     }
}
