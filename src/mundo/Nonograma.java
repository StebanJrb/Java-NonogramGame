package mundo;

public class Nonograma {
     private LoadNono loadNono;
    public Nonograma(){}
     public boolean compare(int x, int y, String ValorPanel, LoadNono p){
         boolean ctrl;
         if(  p.getNono(x, y).equalsIgnoreCase(ValorPanel)){    
            ctrl = false;
             //System.out.println("Bullseye");
         }
         else{
            ctrl = true;
             //System.out.println("Error");
         }    
         return ctrl;
     }
  
}
