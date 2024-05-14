package Model;

public class Nonograma{
     public boolean compare(int x, int y, String valuePanel, LoadNono p){
        return p.getNono(x,y).equalsIgnoreCase(valuePanel) ? false: true;
     }
}
