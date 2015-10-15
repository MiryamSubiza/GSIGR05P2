/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GSILib.Misc;

import java.io.File;
import java.io.IOException;
import javax.swing.table.*;
import org.jopendocument.dom.OOUtils;
import org.jopendocument.dom.spreadsheet.Sheet;
import org.jopendocument.dom.spreadsheet.SpreadSheet;

/**
 *
 * @author Alex
 */
public class SSTest01 {
    
    public static void main(String[] args) throws IOException{
        
        DefaultTableModel table = new DefaultTableModel(4,6);       
        final File file = new File("test01.ods");
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
        for(int i=0;i<4;i++){
            for(int j=0;j<6;j++){
                sheet.setValueAt(cont, j, i);
                cont++;
            }
        }
        
        OOUtils.open(sheet.getSpreadSheet().saveAs(file));

    }
    
}
