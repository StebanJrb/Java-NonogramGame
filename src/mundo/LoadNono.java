
package mundo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LoadNono {
   private String rows[][], cols[][];
   private String nono[][];
   
   public LoadNono() {
       rows = new String[5][];cols = new String[10][];
        nono = new String[10][];
   }
   public String[][] getRows() { return rows; }
   public String[][] getCols() { return cols; }
   public String getNono(int x, int y) { 
        String valor = nono[x][y];    
        return valor;
   }

   public void readNono(String fileIn) {
       BufferedReader buffer = null;
       String line;
       try {
           buffer = new BufferedReader( new FileReader( fileIn ) );
       }catch(FileNotFoundException e){
           e.printStackTrace();
       }

       try {
           for (int i=0; i<5; i++) {
                // Read clues of Rows
                line = buffer.readLine( );
                rows[i] = line.split(" ");
           }

           for (int i=0; i<10; i++){
                // Read clues of Cols
                line = buffer.readLine( );
                cols[i] = line.split(" ");
           }

           for (int i=0; i<10; i++){
               line = buffer.readLine( );
               nono[i] = line.split(" ");
           }
           buffer.close( );
       }catch(IOException e) {
           e.printStackTrace();
       }
   }
}
