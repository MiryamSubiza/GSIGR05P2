/*
 * Gestion de Sistemas de Informacion
 * Universidad Publica de Navarra
 * First semester of the Academic Year 2015-2016
 */

package GSILib.Misc;

import GSILabs.BModel.*;
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
    private static Artist[] artists = new Artist[3];    
    private static Location[] locations = new Location[3];
    private static Concert[] concerts = new Concert[3];
    private static Festival festival;
    
    public static void main(String[] args) throws IOException {
        
        bSystem = new BussinessSystem();
        
        // Creo las instancias de los artistas
        artists[0] = new Artist("Bob Dylan", "Músico estadounidense", "www.bobdylan.com/es");
        artists[1] = new Artist("Alex Turner", "Cantante del grupo Arctic Monkeys");
        artists[2] = new Artist("Michael Jackson", "Rey del pop", "www.MJ.com");
        
        // Creo las instacias de las localizaciones
        locations[0] = new Location("Palau Sant Jordi", 24000, "Barcelona", "www.palausantjordi.cat/es");
        locations[1] = new Location("Madrid Arena", 12000, "Madrid");
        locations[2] = new Location("Estadio de Mestalla", 55000, "Valencia");
        
        // Creo las instacias de los conciertos
        concerts[0] = new Concert("Concierto uno", artists[0], new FechaCompleta("01/02/2016", "22:00"),
            new FechaCompleta("01/02/2016", "22:00"), new FechaCompleta("01/02/2016", "21:00"),
            new FechaCompleta("01/02/2016", "23:45"), locations[0]);
        concerts[1] = new Concert("Concierto dos", artists[1], new FechaCompleta("14/11/2015", "20:30"),
            new FechaCompleta("14/11/2015", "20:30"), new FechaCompleta("14/11/2015", "20:00"),
            new FechaCompleta("14/11/2015", "23:30"), locations[1]);
        concerts[2] = new Concert("Concierto tres", artists[2], new FechaCompleta("02/02/2016", "21:00"),
            new FechaCompleta("02/02/2016", "21:00"), new FechaCompleta("02/02/2016", "20:30"),
            new FechaCompleta("02/02/2016", "23:00"), locations[2]);
        
        // Creo la instancia de los festivales
        festival = new Festival("MJ Experiencie", concerts[0], new FechaCompleta("25/01/1994","22:00"),
            new FechaCompleta("25/01/1994","23:45"), new FechaCompleta("25/01/1994","21:00"),
            new FechaCompleta("25/01/1994","23:45"));
        
        // Creo la tabla donde voy a almacenar las instacias de los conciertos
        DefaultTableModel table = new DefaultTableModel(3,7);
        final File file = new File("test03.ods");     
        SpreadSheet spreadSheet = null;
        
        try{
            //SpreadSheet.createEmpty(table);
            //SpreadSheet.createEmpty(table).saveAs(file);
            spreadSheet = SpreadSheet.createEmpty(table);
            spreadSheet.saveAs(file);
        }
        catch (IOException e){
            System.out.println("An error with the IO system appeared");
        }
        
        // Creo las hojas de Concierto, Festival y Exhibicion de mi hoja de calculo
        //spreadSheet.addSheet(0,"Concert");
        spreadSheet.getFirstSheet().setName("Concert");
        
        // Configuro la hoja de festivales para que pueda almacenarlos
        spreadSheet.addSheet(1,"Festival");
        spreadSheet.getSheet(1).setRowCount(1);
        spreadSheet.getSheet(1).setColumnCount(6);
        
        // Configuro la hoja de exhibiciones para que pueda almacenarlos
        spreadSheet.addSheet(2,"Exhibition");
        
        // Relleno las hojas de mi hoja de calculo
        
        //Sheet sheet[] = new Sheet[3];
        //sheet[0] = SpreadSheet.createFromFile(file).getSheet(0);
        //sheet.getSpreadSheet().addSheet(1, "Concert");
        
        /* Almacenar en el fichero test03.ods una matriz strings con la informacion
        * sacada de los conciertos de los cuales hemos hecho una instancia
        */
        for (int i=0; i<3; i++) {
            
            spreadSheet.getSheet(0).setValueAt(concerts[i].getName(), 0, i);
            spreadSheet.getSheet(0).setValueAt(concerts[i].getPerformer().getName(), 1, i);
            spreadSheet.getSheet(0).setValueAt(((FechaCompleta)concerts[i].getStartDate()).fechaToString(), 2, i);
            spreadSheet.getSheet(0).setValueAt(((FechaCompleta)concerts[i].getStartTimeConcert()).horaToString(), 3, i);
            spreadSheet.getSheet(0).setValueAt(((FechaCompleta)concerts[i].getDoorOpeningTimeConcert()).horaToString(), 4, i);
            spreadSheet.getSheet(0).setValueAt(((FechaCompleta)concerts[i].getClosingTimeConcert()).horaToString(), 5, i);
            spreadSheet.getSheet(0).setValueAt(concerts[i].getLocation().getName(), 6, i);
            
        }
        
        // Almaceno la informacion de festivales en su hoja correspondiente
        spreadSheet.getSheet(1).setValueAt(festival.getName(), 0, 0);
        spreadSheet.getSheet(1).setValueAt(festival.getConcerts().iterator().next(), 1, 0);
        spreadSheet.getSheet(1).setValueAt(((FechaCompleta)festival.getStartDate()).fechaToString(), 2, 0);
        spreadSheet.getSheet(1).setValueAt(((FechaCompleta)festival.getEndingDate()).fechaToString(), 3, 0);
        spreadSheet.getSheet(1).setValueAt(((FechaCompleta)festival.getStartTimeFestival()).horaToString(), 4, 0);
        spreadSheet.getSheet(1).setValueAt(((FechaCompleta)festival.getClosingTimeFestival()).horaToString(), 5, 0);    
        
        //Guardar la nueva tabla en el fichero file (test03.ods) y abrirlo
        OOUtils.open(spreadSheet.saveAs(file));

    }
    
    
}
