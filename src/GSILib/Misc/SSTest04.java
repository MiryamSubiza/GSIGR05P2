/*
 * Gestion de Sistemas de Informacion
 * Universidad Publica de Navarra
 * First semester of the Academic Year 2015-2016
 */

package GSILib.Misc;

import GSILabs.BModel.Artist;
import GSILabs.BModel.Concert;
import GSILabs.BModel.FechasHoras;
import GSILabs.BModel.Location;
import GSILabs.BSystem.BussinessSystem;
import java.io.File;
import java.io.IOException;
import javax.swing.table.DefaultTableModel;
import org.jopendocument.dom.OOUtils;
import org.jopendocument.dom.spreadsheet.Sheet;
import org.jopendocument.dom.spreadsheet.SpreadSheet;

/**
 * Almacenar instancias de las clases que implementen Event en un fichero ODS.
 * @author subiza.79082
 * @author izu.78236
 * @version 18/10/2015
 */

public class SSTest04 {
    
    private static BussinessSystem bSystem;
    
    private static Artist a1;
    private static Artist a2;
    
    private static Location l1;
    private static Location l2;
    private static Location l3;
    
    public static void main(String[] args) throws IOException {
        
        bSystem = new BussinessSystem();
        
        a1 = new Artist("Bob Dylan", "Músico estadounidense", "www.bobdylan.com/es");
        a2 = new Artist("Alex Turner", "Cantante del grupo Arctic Monkeys");
        
        l1 = new Location("Palau Sant Jordi", 24000, "Barcelona", "www.palausantjordi.cat/es");
        l2 = new Location("Madrid Arena", 12000, "Madrid");
        l3 = new Location("Estadio de Mestalla", 55000, "Valencia");
        /*
        con1 = new Concert("Concierto uno", col1, new FechasHoras("01/02/2016", "22:00"),
            new FechasHoras("01/02/2016", "22:00"), new FechasHoras("01/02/2016", "21:00"),
            new FechasHoras("01/02/2016", "23:45"), l6);
        */
        DefaultTableModel table = new DefaultTableModel(4,6);       
        final File file = new File("test03.ods");
        try{
            SpreadSheet.createEmpty(table);
            SpreadSheet.createEmpty(table).saveAs(file);
        }
        catch (IOException e){
            System.out.println("An error with the IO system appeared");
        }
        
        Sheet sheet;
        sheet = SpreadSheet.createFromFile(file).getSheet(0);
        sheet.getSpreadSheet().addSheet(1, "Concert");
        
        int cont = 1;
        /* Almacenar en el fichero test01.ods una matriz de números enteros
        * utilizando una variable contador que aumentará cada vez que se
        * inserte un número en la matriz.
        */
        for (int i=0; i<4; i++) {
            for (int j=0; j<6; j++) {
                sheet.setValueAt(cont, j, i);
                cont++;
            }
        }
        
        //Guardar la nueva tabla en el fichero file (test01.ods) y abrirlo
        OOUtils.open(sheet.getSpreadSheet().saveAs(file));

    }
    
    
}
