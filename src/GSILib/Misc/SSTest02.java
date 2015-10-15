/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GSILib.Misc;

import java.io.File;
import java.io.IOException;
import javax.swing.table.DefaultTableModel;
import org.jopendocument.dom.OOUtils;
import org.jopendocument.dom.spreadsheet.Sheet;
import org.jopendocument.dom.spreadsheet.SpreadSheet;

/**
 *
 * @author labora1
 */
public class SSTest02 {
    
    public static void main(String[] args) throws IOException {
        
        //Array bidimensional con los valores a almacenar en la tabla
        int[][] valores = new int[][] {{7,4,7,5,19,5},{4,7,6,18,1,6},{3,11,6,15,8,9},{9,8,7,22,7,13}};
        
        DefaultTableModel table = new DefaultTableModel(9,9);       
        final File file = new File("test02.ods");
        try{
            SpreadSheet.createEmpty(table);
            SpreadSheet.createEmpty(table).saveAs(file);
        }
        catch (IOException e){
            System.out.println("An error with the IO system appear");
        }
        
        Sheet sheet;
        sheet = SpreadSheet.createFromFile(file).getSheet(0);
        
        int cont = 1;
        // Rellenamos el array bidimensional con valores numericos
        // para ello uso una variable int contador que ira aumentado
        // cada vez que inserte un numero en la matriz
        for(int i=5;i<9;i++){
            for(int j=3;j<9;j++){
                sheet.setValueAt(valores[i-5][j-3], j, i);
                cont++;
            }
        }
        // Elimino los nombres de las columnas
        for(int i=0;i<9;i++){
            sheet.setValueAt(null, i, 0);
        }
        
        // Guardo la nueva tabla en el fichero file y lo abro
        OOUtils.open(sheet.getSpreadSheet().saveAs(file));
        
    }
    
    
}
