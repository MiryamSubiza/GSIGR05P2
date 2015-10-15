/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GSILib.Misc;

import java.awt.Color;
import java.io.File;
import java.io.IOException;
import javax.swing.table.DefaultTableModel;
import org.jopendocument.dom.OOUtils;
import org.jopendocument.dom.spreadsheet.MutableCell;
import org.jopendocument.dom.spreadsheet.Sheet;
import org.jopendocument.dom.spreadsheet.SpreadSheet;

/**
 *
 * @author labora1
 */
public class SSTest03 {
    
    public static void main(String[] args) throws IOException {
        
        //Array bidimensional para almacenar los datos del excel
        java.math.BigDecimal[][] valores = new java.math.BigDecimal[4][6];

        final File file = new File("test02.ods");
                
        Sheet sheet;
        sheet = SpreadSheet.createFromFile(file).getSheet(0);
        
        for (int i = 5; i < 9; i++) {
            for (int j = 3; j < 9; j++) {
                valores[i-5][j-3] = (java.math.BigDecimal)sheet.getCellAt(j, i).getValue();
                System.out.print(valores[i-5][j-3] + " ");
            }
            System.out.println();
        }

    }
    
}
